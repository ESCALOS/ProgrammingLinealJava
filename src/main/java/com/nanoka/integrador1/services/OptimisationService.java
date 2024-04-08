package com.nanoka.integrador1.services;

import com.nanoka.integrador1.models.HumanResource;
import com.nanoka.integrador1.models.Material;
import com.nanoka.integrador1.models.Supply;
import java.util.List;
import org.ojalgo.netio.BasicLogger;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation;
import org.ojalgo.optimisation.Variable;

public class OptimisationService {
    public Optimisation.Result optimize(Material materialA, Material materialB, List<Supply> supplies, HumanResource humanResource, boolean isMax) {
        ExpressionsBasedModel model = new ExpressionsBasedModel();

        Variable X = model.addVariable(materialA.getName()).weight(materialA.getProfitability());
        if(materialA.isInteger()) {
          X.integer();
        }
        Variable Y = model.addVariable(materialB.getName()).weight(materialB.getProfitability());
        if(materialB.isInteger()) {
            Y.integer();
        }

        for (Supply supply : supplies) {
            model.addExpression(supply.getName())
                   .upper(supply.getAvailable())
                   .lower(0)
                   .set(X, supply.getQuantityMaterialA())
                   .set(Y, supply.getQuantityMaterialB());
        }
        
        model.addExpression(humanResource.getName())
                .upper(humanResource.getAvailable())
                .lower(0)
                .set(X, humanResource.getQuantityMaterialA())
                .set(Y, humanResource.getQuantityMaterialB());
        
        model.addExpression("Mínimo de material A")
                .lower(0)
                .set(X, 1);
        model.addExpression("Mínimo de material B")
                .lower(0)
                .set(Y, 1);
        
        
        BasicLogger.debug(model);
        if(isMax) {
            return model.maximise();
        }else {
            return model.minimise();
        }
    }
}

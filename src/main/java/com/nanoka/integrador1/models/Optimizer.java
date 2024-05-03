package com.nanoka.integrador1.models;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation;
import org.ojalgo.optimisation.Variable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Optimizer {
    private ArrayList<Material> materials;
    private ArrayList<AvailableQuantity> availableSupplies;
    private AvailableQuantity availableHR;
    
    public Optimisation.Result optimize() {
        ExpressionsBasedModel model = new ExpressionsBasedModel();

        Variable X = model.addVariable(materials.get(0).getName()).weight(materials.get(0).getProfitability());
        if(materials.get(0).isInteger()) {
          X.integer();
        }
        Variable Y = model.addVariable(materials.get(1).getName()).weight(materials.get(1).getProfitability());
        if(materials.get(1).isInteger()) {
            Y.integer();
        }
        int counterSupplies = 0;
        for (AvailableQuantity availableSupply: availableSupplies) {
            model.addExpression(availableSupply.getName())
                   .upper(availableSupply.getAvailable())
                   .lower(0)
                   .set(X, materials.get(0).getSupplies().get(counterSupplies))
                   .set(Y, materials.get(1).getSupplies().get(counterSupplies));
            
            counterSupplies++;
        }
        
        model.addExpression(availableHR.getName())
                .upper(availableHR.getAvailable())
                .lower(0)
                .set(X, materials.get(0).getHumanResource())
                .set(Y, materials.get(1).getHumanResource());
        
        model.addExpression("Mínimo de material A")
                .lower(0)
                .set(X, 1);
        model.addExpression("Mínimo de material B")
                .lower(0)
                .set(Y, 1);
        return model.maximise();
    }
}

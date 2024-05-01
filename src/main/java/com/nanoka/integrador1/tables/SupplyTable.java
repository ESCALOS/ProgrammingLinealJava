package com.nanoka.integrador1.tables;

import com.nanoka.integrador1.models.AvailableQuantity;
import com.nanoka.integrador1.models.Material;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class SupplyTable extends AbstractTableModel{
    private final String[] columnNames = {"Nombre", "Cantidad Material A", "Cantidad Material B", "Disponible"};
    private final ArrayList<Material> materials;
    private final ArrayList<AvailableQuantity> availableQuantities;
    
    public SupplyTable(ArrayList<Material> materials, ArrayList<AvailableQuantity> availableQuantities) {
        this.materials = materials;
        this.availableQuantities = availableQuantities;
    }
    
    @Override
    public int getRowCount() {
        return availableQuantities.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AvailableQuantity availableQuantity = availableQuantities.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> availableQuantity.getName();
            case 1 -> materials.get(0).getSupplies().get(rowIndex);
            case 2 -> materials.get(1).getSupplies().get(rowIndex);
            case 3 -> availableQuantity.getAvailable();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void addRow(ArrayList<Double> suppliesByMaterial, AvailableQuantity availableQuantity) {
        materials.get(0).getSupplies().add(suppliesByMaterial.get(0));
        materials.get(1).getSupplies().add(suppliesByMaterial.get(1));
        availableQuantities.add(availableQuantity);
        fireTableRowsInserted(availableQuantities.size() - 1, availableQuantities.size() - 1);
    }
    
    public void updateRow(int row, ArrayList<Double> suppliesByMaterial, AvailableQuantity availableQuantity) {
        materials.get(0).getSupplies().set(row,suppliesByMaterial.get(0));
        materials.get(1).getSupplies().set(row,suppliesByMaterial.get(1));
        availableQuantities.set(row, availableQuantity);
        fireTableRowsUpdated(row, row);
    }

    public void removeRow(int row) {
        materials.get(0).getSupplies().remove(row);
        materials.get(1).getSupplies().remove(row);
        availableQuantities.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public AvailableQuantity getRow(int row) {
        return availableQuantities.get(row);
    }
}

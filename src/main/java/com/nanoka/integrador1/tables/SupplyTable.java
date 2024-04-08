package com.nanoka.integrador1.tables;

import com.nanoka.integrador1.models.Supply;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SupplyTable extends AbstractTableModel{
    private final String[] columnNames = {"Nombre", "Cantidad Material A", "Cantidad Material B", "Disponible"};
    private final List<Supply> supplies;
    
    public SupplyTable(List<Supply> supplies) {
        this.supplies = supplies;
    }
    
    @Override
    public int getRowCount() {
        return supplies.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Supply supply = supplies.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> supply.getName();
            case 1 -> supply.getQuantityMaterialA();
            case 2 -> supply.getQuantityMaterialB();
            case 3 -> supply.getAvailable();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void addRow(Supply supply) {
        supplies.add(supply);
        fireTableRowsInserted(supplies.size() - 1, supplies.size() - 1);
    }
    
    public void updateRow(int row, Supply supply) {
        supplies.set(row, supply);
        fireTableRowsUpdated(row, row);
    }

    public void removeRow(int row) {
        supplies.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public Supply getRow(int row) {
        return supplies.get(row);
    }
}

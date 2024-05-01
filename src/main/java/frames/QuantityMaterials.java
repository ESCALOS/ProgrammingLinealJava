package frames;

import com.nanoka.integrador1.models.AvailableQuantity;
import com.nanoka.integrador1.models.Material;
import com.nanoka.integrador1.models.Optimizer;
import java.util.ArrayList;
import com.nanoka.integrador1.tables.SupplyTable;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.ojalgo.optimisation.Optimisation;

/**
 *
 * @author nanoka
 */
public class QuantityMaterials extends javax.swing.JFrame {

        private final ArrayList<Material> materials = new ArrayList<>();
        private final ArrayList<AvailableQuantity> availableSupplies = new ArrayList<>();
        public final SupplyTable supplyTable = new SupplyTable(materials,availableSupplies);
    
    /**
     * Creates new form QuantityMaterials
     */
    public QuantityMaterials() {
        initComponents();
        setLocationRelativeTo(null);
        //Inicializando los materiales
        materials.add(new Material("",false,0.0,0.0,new ArrayList<>()));
        materials.add(new Material("",false,0.0,0.0,new ArrayList<>()));
        tb_supplies.setModel(supplyTable);
        btn_calcular.setEnabled(false);
        this.addTextFieldValidators();
        
    }
    
    public void addSupply(ArrayList<Double> supplies, AvailableQuantity availableQuantity) {
        
        this.supplyTable.addRow(supplies,availableQuantity);
    }
    
    public void updateSupply(ArrayList<Double> supplies, AvailableQuantity availableQuantity) {
        this.supplyTable.updateRow(tb_supplies.getSelectedRow(),supplies,availableQuantity);
    }
    
    private void addTextFieldValidators() {
        addValidator(txt_name_a);
        addValidator(txt_name_b);
        addValidator(txt_profitability_a);
        addValidator(txt_profitability_b);
        addValidator(txt_hr_a);
        addValidator(txt_hr_b);
        addValidator(txt_hr_available);
    }
    
    private void addValidator(JTextField textField) {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateInputs();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateInputs();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateInputs();
            }

        });
    }
    
    public void validateInputs() {
        boolean isValid = !txt_name_a.getText().isBlank() &&
                                    !txt_name_b.getText().isBlank() &&
                                    !txt_profitability_a.getText().isBlank() &&
                                    !txt_profitability_b.getText().isBlank() &&
                                    !txt_hr_a.getText().isBlank() &&
                                    !txt_hr_b.getText().isBlank() &&
                                    !txt_hr_available.getText().isBlank() &&
                                    !this.availableSupplies.isEmpty();
        btn_calcular.setEnabled(isValid);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txt_name_a = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_profitability_a = new javax.swing.JTextField();
        check_integer_a = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txt_name_b = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_profitability_b = new javax.swing.JTextField();
        check_integer_b = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_supplies = new javax.swing.JTable();
        btn_add_supply = new javax.swing.JButton();
        btn_edit_supply = new javax.swing.JButton();
        btn_delete_supply = new javax.swing.JButton();
        btn_calcular = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_hr_a = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_hr_available = new javax.swing.JTextField();
        txt_hr_b = new javax.swing.JTextField();
        lbl_hr_b = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OPTIMIZACIÓN");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Optimizar Cantidad de Materiales");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Material A");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Rentabilidad: ");

        txt_profitability_a.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_profitability_aKeyTyped(evt);
            }
        });

        check_integer_a.setText("¿Es entero?");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(check_integer_a)
                                .addGap(0, 94, Short.MAX_VALUE))
                            .addComponent(txt_name_a)
                            .addComponent(txt_profitability_a))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_name_a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_integer_a)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_profitability_a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Material B");

        jLabel6.setText("Nombre:");

        jLabel7.setText("Rentabilidad: ");

        txt_profitability_b.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_profitability_bKeyTyped(evt);
            }
        });

        check_integer_b.setText("¿Es entero?");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(check_integer_b)
                                .addGap(0, 94, Short.MAX_VALUE))
                            .addComponent(txt_name_b)
                            .addComponent(txt_profitability_b))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_name_b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_integer_b)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_profitability_b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Insumos");

        tb_supplies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Cantidad A", "Cantidad B", "Disponible"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_supplies);
        if (tb_supplies.getColumnModel().getColumnCount() > 0) {
            tb_supplies.getColumnModel().getColumn(0).setResizable(false);
            tb_supplies.getColumnModel().getColumn(1).setResizable(false);
            tb_supplies.getColumnModel().getColumn(2).setResizable(false);
            tb_supplies.getColumnModel().getColumn(3).setResizable(false);
        }

        btn_add_supply.setBackground(new java.awt.Color(0, 153, 0));
        btn_add_supply.setForeground(new java.awt.Color(255, 255, 255));
        btn_add_supply.setText("Agregar Insumo");
        btn_add_supply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_supplyActionPerformed(evt);
            }
        });

        btn_edit_supply.setBackground(new java.awt.Color(255, 255, 0));
        btn_edit_supply.setText("Editar Insumo");
        btn_edit_supply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_supplyActionPerformed(evt);
            }
        });

        btn_delete_supply.setBackground(new java.awt.Color(255, 0, 0));
        btn_delete_supply.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete_supply.setText("Eliminar Insumo");
        btn_delete_supply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_supplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_add_supply, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_edit_supply, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete_supply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add_supply)
                    .addComponent(btn_edit_supply)
                    .addComponent(btn_delete_supply))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_calcular.setText("Calcular");
        btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Recursos Humanos (horas)");

        jLabel10.setText("Material A: ");

        txt_hr_a.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_hr_aKeyTyped(evt);
            }
        });

        jLabel11.setText("Disponible");

        txt_hr_available.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_hr_availableKeyTyped(evt);
            }
        });

        txt_hr_b.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_hr_bKeyTyped(evt);
            }
        });

        lbl_hr_b.setText("Material B: ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hr_a, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_hr_b)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hr_b, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hr_available, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txt_hr_available, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txt_hr_a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_hr_b)
                        .addComponent(txt_hr_b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_calcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_calcular)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add_supplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_supplyActionPerformed
        SupplyForm supplyForm = new SupplyForm(this,true);
        supplyForm.setVisible(true);
    }//GEN-LAST:event_btn_add_supplyActionPerformed

    private void btn_delete_supplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_supplyActionPerformed
        this.supplyTable.removeRow(tb_supplies.getSelectedRow());
        this.validateInputs();
    }//GEN-LAST:event_btn_delete_supplyActionPerformed

    private void btn_edit_supplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_supplyActionPerformed
       int selectedRow = tb_supplies.getSelectedRow();
       String name =  tb_supplies.getValueAt(selectedRow, 0).toString();
       Double available = Double.valueOf(tb_supplies.getValueAt(selectedRow, 3).toString());
       AvailableQuantity availableSupply = new AvailableQuantity(name, available);
       ArrayList<Double> supplyByMaterial = new ArrayList<>();
       supplyByMaterial.add(Double.valueOf(tb_supplies.getValueAt(selectedRow, 1).toString()));
       supplyByMaterial.add(Double.valueOf(tb_supplies.getValueAt(selectedRow, 2).toString()));
       
       if(selectedRow != -1) {
            SupplyForm supplyForm = new SupplyForm(this, true, selectedRow, supplyByMaterial, availableSupply);
            supplyForm.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Por favor, selecciona una fila para editar");
        }
    }//GEN-LAST:event_btn_edit_supplyActionPerformed

    private void btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularActionPerformed
       // Material A
        materials.get(0).setName(txt_name_a.getText());
        materials.get(0).setInteger(check_integer_a.isSelected());
        materials.get(0).setProfitability(Double.valueOf(txt_profitability_a.getText()));
        materials.get(0).setHumanResource(Double.valueOf(txt_hr_a.getText()));
        
        // Material B
        materials.get(1).setName(txt_name_b.getText());
        materials.get(1).setInteger(check_integer_b.isSelected());
        materials.get(1).setProfitability(Double.valueOf(txt_profitability_b.getText()));
        materials.get(1).setHumanResource(Double.valueOf(txt_hr_b.getText()));

        // Restricciones
        AvailableQuantity availableHR = new AvailableQuantity("Recursos Humanos", Double.valueOf(txt_hr_available.getText()));
        
        //Optimizar
        Optimizer optimizer = new Optimizer(materials, availableSupplies, availableHR, true);
        Optimisation.Result result = optimizer.optimize();
        
        String message;
        switch (result.getState()) {
            case OPTIMAL -> message = String.format("La rentabilidad óptima es %.2f con %.2f de %s y %.2f de %s", 
                                result.getValue(), result.get(0), txt_name_a.getText(), result.get(1), txt_name_b.getText());
            case UNBOUNDED -> message = "Infinitas soluciones. Faltan restricciones";
            case FAILED -> message = "El proceso ha fallado, verifique los datos";
            default -> message = "Error desconocido";
        }
        
        JOptionPane.showMessageDialog(rootPane, message);
    }//GEN-LAST:event_btn_calcularActionPerformed

    private void txt_profitability_aKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_profitability_aKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '.' && c != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_txt_profitability_aKeyTyped

    private void txt_profitability_bKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_profitability_bKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '.' && c != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_txt_profitability_bKeyTyped

    private void txt_hr_aKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hr_aKeyTyped
       char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '.' && c != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_txt_hr_aKeyTyped

    private void txt_hr_bKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hr_bKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '.' && c != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_txt_hr_bKeyTyped

    private void txt_hr_availableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hr_availableKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '.' && c != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_txt_hr_availableKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuantityMaterials.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuantityMaterials.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuantityMaterials.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuantityMaterials.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuantityMaterials().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_supply;
    private javax.swing.JButton btn_calcular;
    private javax.swing.JButton btn_delete_supply;
    private javax.swing.JButton btn_edit_supply;
    private javax.swing.JCheckBox check_integer_a;
    private javax.swing.JCheckBox check_integer_b;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_hr_b;
    private javax.swing.JTable tb_supplies;
    private javax.swing.JTextField txt_hr_a;
    private javax.swing.JTextField txt_hr_available;
    private javax.swing.JTextField txt_hr_b;
    private javax.swing.JTextField txt_name_a;
    private javax.swing.JTextField txt_name_b;
    private javax.swing.JTextField txt_profitability_a;
    private javax.swing.JTextField txt_profitability_b;
    // End of variables declaration//GEN-END:variables
}

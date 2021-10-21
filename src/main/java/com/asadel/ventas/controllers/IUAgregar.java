package com.asadel.ventas.controllers;

import com.asadel.ventas.services.Articulo;
import com.asadel.ventas.services.Control;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IUAgregar extends JInternalFrame {

    @Autowired
    public IUAgregar agregar;
    @Autowired
    private Control control;

    public IUAgregar() {
        initComponents();
        this.purchaseDateInput.setDate(new Date());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        idInput = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        typeInput = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionInput = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        purchasePriceInput = new javax.swing.JSpinner();
        salePriceInput = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        purchaseStoreInput = new javax.swing.JTextField();
        purchaseDateInput = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        saleItemsInput = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        packagePriceInput = new javax.swing.JSpinner();
        packageQuantityInput = new javax.swing.JSpinner();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Agregar producto");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/addarticulo2.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(700, 760));
        setPreferredSize(new java.awt.Dimension(700, 760));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameDeactivated(evt);
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre del producto");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Precio de venta");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Descripción");

        createButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        createButton.setForeground(new java.awt.Color(0, 153, 51));
        createButton.setText("Agregar producto");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });
        createButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                createButtonKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tipo");

        typeInput.setModel(new javax.swing.DefaultComboBoxModel(IUArticulos.TIPO));
        typeInput.setNextFocusableComponent(idInput);
        typeInput.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typeInputItemStateChanged(evt);
            }
        });

        descriptionInput.setColumns(20);
        descriptionInput.setRows(5);
        descriptionInput.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(descriptionInput);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Precio de compra");

        purchasePriceInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        purchasePriceInput.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.5d, null, 0.5d));
        purchasePriceInput.setMinimumSize(new java.awt.Dimension(300, 20));

        salePriceInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        salePriceInput.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.5d, null, 0.5d));
        salePriceInput.setMinimumSize(new java.awt.Dimension(300, 20));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Tienda de compra");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Fecha de compra");

        purchaseStoreInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseStoreInputActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Cantidad en inventario");

        saleItemsInput.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));
        saleItemsInput.setMinimumSize(new java.awt.Dimension(300, 20));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Precio paquete ");

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Piezas paquete ");

        packagePriceInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        packagePriceInput.setModel(new javax.swing.SpinnerNumberModel(1.0d, 1.0d, null, 0.5d));
        packagePriceInput.setPreferredSize(new java.awt.Dimension(300, 20));
        packagePriceInput.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                packagePriceInputStateChanged(evt);
            }
        });

        packageQuantityInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        packageQuantityInput.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        packageQuantityInput.setMinimumSize(new java.awt.Dimension(300, 20));
        packageQuantityInput.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                packageQuantityInputStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(nameInput)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(typeInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idInput)
                    .addComponent(createButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(packagePriceInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(purchaseStoreInput)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(purchasePriceInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saleItemsInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                            .addComponent(purchaseDateInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salePriceInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(packageQuantityInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(packagePriceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(packageQuantityInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(purchasePriceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salePriceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(purchaseStoreInput)
                    .addComponent(purchaseDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saleItemsInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // Cerrar Ventana 
    }//GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // Ventana Activada
        if (typeInput.getSelectedIndex() == 0) {
            idInput.setEnabled(false);
            nameInput.setEnabled(false);
            packagePriceInput.setEnabled(false);
            packageQuantityInput.setEnabled(false);
            packagePriceInput.setEnabled(false);
            packageQuantityInput.setEnabled(false);
            purchasePriceInput.setEnabled(false);
            salePriceInput.setEnabled(false);
            purchaseStoreInput.setEnabled(false);
            purchaseDateInput.setEnabled(false);
            saleItemsInput.setEnabled(false);
            descriptionInput.setEnabled(false);
            createButton.setEnabled(false);
        }
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeactivated
        // Ventana Desactivada
    }//GEN-LAST:event_formInternalFrameDeactivated

    private void typeInputItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_typeInputItemStateChanged
    {//GEN-HEADEREND:event_typeInputItemStateChanged
        // Seleccion de Articulo
        if (typeInput.getSelectedIndex() == 0) {
            idInput.setEnabled(false);
            nameInput.setEnabled(false);
            packagePriceInput.setEnabled(false);
            packageQuantityInput.setEnabled(false);
            purchasePriceInput.setEnabled(false);
            salePriceInput.setEnabled(false);
            purchaseStoreInput.setEnabled(false);
            purchaseDateInput.setEnabled(false);
            saleItemsInput.setEnabled(false);
            descriptionInput.setEnabled(false);
            createButton.setEnabled(false);
        } else if (typeInput.getSelectedItem() == "Monografia" || typeInput.getSelectedItem() == "Biografia"
                || typeInput.getSelectedItem() == "Mapa Carta" || typeInput.getSelectedItem() == "Mapa Mural"
                || typeInput.getSelectedItem() == "Mapa MediaCartulina" || typeInput.getSelectedItem() == "MiniMapa"
                || typeInput.getSelectedItem() == "Relieve" || typeInput.getSelectedItem() == "Esquema") {
            idInput.setEnabled(true);
            nameInput.setEnabled(true);
            packagePriceInput.setEnabled(false);
            packageQuantityInput.setEnabled(false);
            purchasePriceInput.setEnabled(false);
            salePriceInput.setEnabled(false);
            purchaseStoreInput.setEnabled(false);
            purchaseDateInput.setEnabled(false);
            saleItemsInput.setEnabled(false);
            descriptionInput.setEnabled(true);
            createButton.setEnabled(true);
        } else {
            idInput.setEnabled(false);
            nameInput.setEnabled(true);
            packagePriceInput.setEnabled(true);
            packageQuantityInput.setEnabled(true);
            packagePriceInput.setEnabled(true);
            packageQuantityInput.setEnabled(true);
            purchasePriceInput.setEnabled(true);
            salePriceInput.setEnabled(true);
            purchaseStoreInput.setEnabled(true);
            purchaseDateInput.setEnabled(true);
            saleItemsInput.setEnabled(true);
            descriptionInput.setEnabled(true);
            createButton.setEnabled(true);
        }
    }//GEN-LAST:event_typeInputItemStateChanged

    private void createButtonKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_createButtonKeyPressed
    {//GEN-HEADEREND:event_createButtonKeyPressed
        // Agregar a la BD
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (createItem()) {
                idInput.setText(null);
                nameInput.setText(null);
                purchaseStoreInput.setText(null);
                descriptionInput.setText(null);
                typeInput.setSelectedIndex(0);
                this.doDefaultCloseAction();
            }
        }
    }//GEN-LAST:event_createButtonKeyPressed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_createButtonActionPerformed
    {//GEN-HEADEREND:event_createButtonActionPerformed
        // Agregar a la BD
        if (createItem()) {
            idInput.setText(null);
            nameInput.setText(null);
            purchaseStoreInput.setText(null);
            descriptionInput.setText(null);
            typeInput.setSelectedIndex(0);
            this.doDefaultCloseAction();
        }
    }//GEN-LAST:event_createButtonActionPerformed

    private void purchaseStoreInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseStoreInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseStoreInputActionPerformed

    private void packagePriceInputStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_packagePriceInputStateChanged
        // TODO add your handling code here:
        updatePrices();
    }//GEN-LAST:event_packagePriceInputStateChanged

    private void packageQuantityInputStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_packageQuantityInputStateChanged
        // TODO add your handling code here:
        updatePrices();
    }//GEN-LAST:event_packageQuantityInputStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createButton;
    private javax.swing.JTextArea descriptionInput;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameInput;
    private javax.swing.JSpinner packagePriceInput;
    private javax.swing.JSpinner packageQuantityInput;
    private com.toedter.calendar.JDateChooser purchaseDateInput;
    private javax.swing.JSpinner purchasePriceInput;
    private javax.swing.JTextField purchaseStoreInput;
    private javax.swing.JSpinner saleItemsInput;
    private javax.swing.JSpinner salePriceInput;
    private javax.swing.JComboBox typeInput;
    // End of variables declaration//GEN-END:variables

    public boolean createItem() {
        var success = false;
        var article = new Articulo();

        if (typeInput.getSelectedItem() == "Monografia" || typeInput.getSelectedItem() == "Biografia"
                || typeInput.getSelectedItem() == "Mapa Carta" || typeInput.getSelectedItem() == "Mapa Mural"
                || typeInput.getSelectedItem() == "Mapa MediaCartulina" || typeInput.getSelectedItem() == "MiniMapa"
                || typeInput.getSelectedItem() == "Relieve" || typeInput.getSelectedItem() == "Esquema") {
            if (!(idInput.getText().isEmpty() || nameInput.getText().isEmpty())) {
                article.setId(idInput.getText());
                article.setTipo(typeInput.getSelectedItem().toString());
                article.setNombre(nameInput.getText());
                article.setInfo(descriptionInput.getText());

                success = true;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Campos sin llenar", "Error", 2);
            }
        } else {
            if (!nameInput.getText().isEmpty()) {
                article.setId(idInput.getText());
                article.setTipo(typeInput.getSelectedItem().toString());
                article.setNombre(nameInput.getText());

                article.setPrecioCompra(BigDecimal.valueOf(Double.parseDouble(purchasePriceInput.getValue().toString())));
                article.setPrecioVenta(BigDecimal.valueOf(Double.parseDouble(salePriceInput.getValue().toString())));
                article.setInfo(descriptionInput.getText());
                article.setTiendaCompra(purchaseStoreInput.getText());

                article.setInventarioCompra(Integer.parseInt(packageQuantityInput.getValue().toString()));
                article.setInventarioVenta(Integer.parseInt(saleItemsInput.getValue().toString()));

                if (purchaseDateInput.getDate() != null) {
                    article.setFechaCompra(new java.sql.Date(purchaseDateInput.getDate().getTime()));
                }

                success = true;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Campos sin llenar", "Error", 2);
            }
        }

        if (success) {
            switch (typeInput.getSelectedItem().toString()) {
                case "Biografia" ->
                    control.insertBiografia(article);
                case "Esquema" ->
                    control.insertEsquema(article);
                case "Mapa Carta", "Mapa MediaCartulina", "Mapa Mural", "MiniMapa" ->
                    control.insertMapa(article);
                case "Monografia" ->
                    control.insertMonografia(article);
                case "Relieve" ->
                    control.insertRelieve(article);

                default ->
                    control.insertPrecioArticulo(article);
            }
        }

        return success;
    }

    private void updatePrices() {
        var packagePrice = new BigDecimal(packagePriceInput.getValue().toString());
        var packageItems = new BigDecimal(packageQuantityInput.getValue().toString());

        var priceItem = packagePrice.divide(packageItems, RoundingMode.CEILING);
        var salePriceItem = priceItem.multiply(BigDecimal.valueOf(1.5));

        purchasePriceInput.setValue(priceItem.doubleValue());
        salePriceInput.setValue(salePriceItem.doubleValue());
    }
}

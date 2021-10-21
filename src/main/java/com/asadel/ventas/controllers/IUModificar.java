package com.asadel.ventas.controllers;

import com.asadel.ventas.services.Articulo;
import com.asadel.ventas.services.Control;
import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import javax.swing.JOptionPane;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IUModificar extends javax.swing.JInternalFrame {

    @Autowired
    public IUModificar editar;
    @Autowired
    private Control control;

    private Articulo oldArticulo;

    public IUModificar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        nameInput = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        typeInput = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionInput = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        packagePriceInput = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        purchaseStoreInput = new javax.swing.JTextField();
        purchaseDateInput = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        packageQuantityInput = new javax.swing.JSpinner();
        saleItemsInput = new javax.swing.JSpinner();
        salePriceInput = new javax.swing.JSpinner();
        updateButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        purchasePriceInput = new javax.swing.JSpinner();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Modificar producto");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit2.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(700, 760));
        setPreferredSize(new java.awt.Dimension(700, 760));
        setRequestFocusEnabled(false);
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

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ID");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nombre del producto");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Precio de venta");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Descripción");

        idInput.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        idInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idInputKeyReleased(evt);
            }
        });

        nameInput.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        nameInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameInputKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setLabelFor(typeInput);
        jLabel10.setText("Tipo");

        typeInput.setModel(new javax.swing.DefaultComboBoxModel(IUArticulos.TIPO));
        typeInput.setNextFocusableComponent(idInput);
        typeInput.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typeInputItemStateChanged(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        descriptionInput.setColumns(20);
        descriptionInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        descriptionInput.setRows(5);
        jScrollPane1.setViewportView(descriptionInput);

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Piezas paquete");

        packagePriceInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        packagePriceInput.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.5d));
        packagePriceInput.setToolTipText("Precio de compra");
        packagePriceInput.setMinimumSize(new java.awt.Dimension(300, 20));
        packagePriceInput.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                packagePriceInputStateChanged(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Tienda de compra");

        purchaseStoreInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                purchaseStoreInputKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Fecha de compra");

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Precio paquete");

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Cantidad en inventario");

        packageQuantityInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        packageQuantityInput.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        packageQuantityInput.setToolTipText("Precio de compra");
        packageQuantityInput.setMinimumSize(new java.awt.Dimension(300, 20));
        packageQuantityInput.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                packageQuantityInputStateChanged(evt);
            }
        });

        saleItemsInput.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        saleItemsInput.setToolTipText("Precio de compra");
        saleItemsInput.setMinimumSize(new java.awt.Dimension(300, 20));

        salePriceInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        salePriceInput.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
        salePriceInput.setToolTipText("Precio de compra");
        salePriceInput.setFocusTraversalPolicyProvider(true);
        salePriceInput.setMinimumSize(new java.awt.Dimension(300, 20));

        updateButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        updateButton.setForeground(new java.awt.Color(0, 153, 51));
        updateButton.setText("Actualizar");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        updateButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                updateButtonKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Precio de compra");

        purchasePriceInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        purchasePriceInput.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.5d));
        purchasePriceInput.setToolTipText("Precio de compra");
        purchasePriceInput.setMinimumSize(new java.awt.Dimension(300, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameInput)
                    .addComponent(idInput)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(typeInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(purchasePriceInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(packagePriceInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                            .addComponent(purchaseStoreInput))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saleItemsInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                            .addComponent(purchaseDateInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(packageQuantityInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                            .addComponent(salePriceInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(packagePriceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(packageQuantityInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(purchasePriceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salePriceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(purchaseDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(purchaseStoreInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saleItemsInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void packagePriceInputStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_packagePriceInputStateChanged
        // TODO add your handling code here:
        updatePrices();
    }//GEN-LAST:event_packagePriceInputStateChanged

    private void packageQuantityInputStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_packageQuantityInputStateChanged
        // TODO add your handling code here:
        updatePrices();
    }//GEN-LAST:event_packageQuantityInputStateChanged

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {// GEN-FIRST:event_formInternalFrameClosed
        // Ventana Cerrada
        oldArticulo = null;
    }// GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {// GEN-FIRST:event_formInternalFrameActivated
        // Ventana Activa
        //jPanel2.setBackground(Asadel.ACTIVE_COLOR);

        if (typeInput.getSelectedIndex() == 0) {
            idInput.setEnabled(false);
            nameInput.setEnabled(false);
            salePriceInput.setEnabled(false);
            descriptionInput.setEnabled(false);
            updateButton.setEnabled(false);
        } else {
            updateButton.setEnabled(true);
        }
    }// GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {// GEN-FIRST:event_formInternalFrameDeactivated
        // Ventana Desactivada
        jPanel2.setBackground(Color.getColor(System.getProperty("Panel.background")));
    }// GEN-LAST:event_formInternalFrameDeactivated

    private void purchaseStoreInputKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextField8KeyReleased
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField8KeyReleased

    private void typeInputItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_jComboBox2ItemStateChanged
        // Seleccion de Articulo
        if (typeInput.getSelectedIndex() == 0) {
            idInput.setEnabled(false);
            nameInput.setEnabled(false);
            salePriceInput.setEnabled(false);
            descriptionInput.setEnabled(false);
            updateButton.setEnabled(false);
        } else {
            idInput.setEnabled(true);
            nameInput.setEnabled(true);
            salePriceInput.setEnabled(true);
            descriptionInput.setEnabled(true);
            updateButton.setEnabled(true);
        }
    }// GEN-LAST:event_jComboBox2ItemStateChanged

    private void updateButtonKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jButton5KeyPressed
        // Aceptar
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            editarArticulo();
        }
    }// GEN-LAST:event_jButton5KeyPressed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
        // Aceptar
        editarArticulo();
    }// GEN-LAST:event_jButton5ActionPerformed

    private void nameInputKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextField6KeyReleased
        // Tabulador
        if (evt.getKeyChar() == KeyEvent.VK_TAB) {
            salePriceInput.requestFocus();
        }
    }// GEN-LAST:event_jTextField6KeyReleased

    private void idInputKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextField5KeyReleased
        // Tabulador
        if (evt.getKeyChar() == KeyEvent.VK_TAB) {
            nameInput.requestFocus();
            nameInput.getCaret().moveDot(0);
        }
    }// GEN-LAST:event_jTextField5KeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descriptionInput;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameInput;
    private javax.swing.JSpinner packagePriceInput;
    private javax.swing.JSpinner packageQuantityInput;
    private com.toedter.calendar.JDateChooser purchaseDateInput;
    private javax.swing.JSpinner purchasePriceInput;
    private javax.swing.JTextField purchaseStoreInput;
    private javax.swing.JSpinner saleItemsInput;
    private javax.swing.JSpinner salePriceInput;
    protected javax.swing.JComboBox typeInput;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    public void loadArticle(Articulo articulo) {
        switch (articulo.getTipo()) {
            case "Biografia","Mapa Carta", "Mapa MediaCartulina", "Mapa Mural", "MiniMapa","Monografia","Relieve" -> {
                articulo.setTiendaCompra("");
                articulo.setPrecioCompra(BigDecimal.ZERO);
            }
            default -> {
                articulo = control.getInfo(articulo);
            }
        }

        oldArticulo = articulo;
        idInput.setText(articulo.getId());
        nameInput.setText(articulo.getNombre());

        if (articulo.getPrecioCompra() != null) {
            packagePriceInput.setValue(articulo.getPrecioCompra().doubleValue());
            purchasePriceInput.setValue(articulo.getPrecioCompra().doubleValue());
        }

        if (articulo.getInventarioCompra() == 0) {
            packageQuantityInput.setValue(1);
        } else {
            packageQuantityInput.setValue(articulo.getInventarioCompra());
        }

        if (articulo.getInventarioCompra() == 0) {
            packageQuantityInput.setValue(1);
        } else {
            packageQuantityInput.setValue(articulo.getInventarioCompra());
        }

        salePriceInput.setValue(articulo.getPrecioVenta().doubleValue());
        purchaseStoreInput.setText(articulo.getTiendaCompra());
        purchaseDateInput.setDate(articulo.getFechaCompra());
        descriptionInput.setText(articulo.getInfo());
        typeInput.setSelectedItem(articulo.getTipo());
        saleItemsInput.setValue(articulo.getInventarioVenta());
    }

    public void editarArticulo() {
        if (typeInput.getSelectedIndex() == 0) {
            JOptionPane.showInternalMessageDialog(this, "Seleccionte un Tipo", "Error", 2);
        } else {
            if (typeInput.getSelectedItem() == "Monografia" || typeInput.getSelectedItem() == "Biografia"
                    || typeInput.getSelectedItem() == "Mapa Carta" || typeInput.getSelectedItem() == "Mapa Mural"
                    || typeInput.getSelectedItem() == "Mapa MediaCartulina"
                    || typeInput.getSelectedItem() == "MiniMapa" || typeInput.getSelectedItem() == "Relieve") {
                if (!(idInput.getText().isEmpty() || nameInput.getText().isEmpty())) {

                    String id = idInput.getText();
                    String nombre = nameInput.getText();
                    BigDecimal precio = BigDecimal.valueOf(Double.parseDouble(salePriceInput.getValue().toString()));
                    String info = descriptionInput.getText();
                    String tipo = (String) typeInput.getSelectedItem();

                    var newArticulo = new Articulo(id, nombre, precio, info, tipo);
                    updateArticulo(newArticulo);

                    this.doDefaultCloseAction();
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Campos sin llenar", "Error", 2);
                }
            } else {
                if (!(idInput.getText().isEmpty() || nameInput.getText().isEmpty()
                        || descriptionInput.getText().isEmpty())) {
                    String id = idInput.getText();
                    String nombre = nameInput.getText();
                    BigDecimal precio = BigDecimal.valueOf(Double.parseDouble(salePriceInput.getValue().toString()));
                    String info = descriptionInput.getText();
                    String tipo = (String) typeInput.getSelectedItem();
                    BigDecimal descuento = precio
                            .multiply(control.getDescuentoGlobal().divide(new BigDecimal("100.00"))).setScale(2);

                    var newArticulo = new Articulo(id, nombre, precio, info, tipo);
                    newArticulo.setDescuento(descuento);
                    newArticulo.setTiendaCompra(purchaseStoreInput.getText());

                    if (packagePriceInput.getValue() != null) {
                        newArticulo.setPrecioCompra(BigDecimal.valueOf(Double.parseDouble(packagePriceInput.getValue().toString())));
                    }
                    if (purchaseDateInput.getDate() != null) {
                        newArticulo.setFechaCompra(new java.sql.Date(purchaseDateInput.getDate().getTime()));
                    }
                    if (packageQuantityInput != null) {
                        newArticulo.setInventarioCompra(Integer.parseInt(packageQuantityInput.getValue().toString()));
                    }
                    if (saleItemsInput != null) {
                        newArticulo.setInventarioVenta(Integer.parseInt(saleItemsInput.getValue().toString()));
                    }

                    updateArticulo(newArticulo);

                    this.doDefaultCloseAction();
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Campos sin llenar", "Modificar producto", 2);
                }
            }
        }
    }

    public void updateArticulo(final Articulo newArticulo) {
        switch (newArticulo.getTipo()) {
            case "Biografia" ->
                control.updateBiografia(oldArticulo, newArticulo);
            case "Esquema" ->
                control.updateEsquema(oldArticulo, newArticulo);
            case "Mapa Carta", "Mapa MediaCartulina", "Mapa Mural", "MiniMapa" ->
                control.updateMapa(oldArticulo, newArticulo);
            case "Monografia" ->
                control.updateMonografia(oldArticulo, newArticulo);
            case "Relieve" ->
                control.updateRelieve(oldArticulo, newArticulo);

            default -> {
                control.updatePrecioArticulo(oldArticulo, newArticulo);
            }
        }
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

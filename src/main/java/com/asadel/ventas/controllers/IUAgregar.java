package com.asadel.ventas.controllers;

import com.asadel.ventas.Asadel;
import com.asadel.ventas.services.Articulo;
import com.asadel.ventas.services.Control;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IUAgregar extends JInternalFrame {

    @Autowired
    public IUAgregar agregar;
    @Autowired
    private Control control;

    private static IUAgregar ventana;
    private Articulo articulo;

    private IUAgregar() {
        initComponents();
    }

    public static IUAgregar getInstance() {
        if (ventana == null) {
            return ventana = new IUAgregar();
        } else {
            return ventana;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setTitle("Agregar articulo");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/addarticulo2.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(459, 500));
        try
        {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1)
        {
            e1.printStackTrace();
        }
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener()
        {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt)
            {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt)
            {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt)
            {
                formInternalFrameDeactivated(evt);
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt)
            {
            }
        });

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jTextArea2.setEditable(false);
        jTextArea2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTextArea2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(jTextArea2);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 2, true));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 2, true));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Precio");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 2, true));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Informacion");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 2, true));

        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setText("Agregar");
        jButton1.setNextFocusableComponent(jButton2);
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jButton1KeyPressed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setNextFocusableComponent(jButton3);
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jButton2KeyPressed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton3.setText("Confirmar");
        jButton3.setNextFocusableComponent(jButton4);
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jButton3KeyPressed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton4.setText("Cancelar");
        jButton4.setNextFocusableComponent(jComboBox1);
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jButton4KeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tipo");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 2, true));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(IUArticulos.TIPO));
        jComboBox1.setNextFocusableComponent(jTextField1);
        jComboBox1.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
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
        jPanel1.setBackground(Asadel.ACTIVE_COLOR);

        if (jComboBox1.getSelectedIndex() == 0) {
            jTextField1.setEnabled(false);
            jTextField2.setEnabled(false);
            jTextField3.setEnabled(false);
            jTextArea1.setEnabled(false);
        }
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeactivated
        // Ventana Desactivada
        jPanel1.setBackground(Color.getColor(System.getProperty("Panel.background")));
    }//GEN-LAST:event_formInternalFrameDeactivated

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_jComboBox1ItemStateChanged
    {//GEN-HEADEREND:event_jComboBox1ItemStateChanged
        // Seleccion de Articulo
        if (jComboBox1.getSelectedIndex() == 0) {
            jTextField1.setEnabled(false);
            jTextField2.setEnabled(false);
            jTextField3.setEnabled(false);
            jTextArea1.setEnabled(false);
        } else if (jComboBox1.getSelectedItem() == "Monografia" || jComboBox1.getSelectedItem() == "Biografia"
                || jComboBox1.getSelectedItem() == "Mapa Carta" || jComboBox1.getSelectedItem() == "Mapa Mural"
                || jComboBox1.getSelectedItem() == "Mapa MediaCartulina" || jComboBox1.getSelectedItem() == "MiniMapa"
                || jComboBox1.getSelectedItem() == "Relieve" || jComboBox1.getSelectedItem() == "Esquema") {
            jTextField1.setEnabled(true);
            jTextField2.setEnabled(true);
            jTextField3.setEnabled(false);
            jTextArea1.setEnabled(true);
        } else {
            jTextField1.setEnabled(true);
            jTextField2.setEnabled(true);
            jTextField3.setEnabled(true);
            jTextArea1.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jButton4KeyPressed
    {//GEN-HEADEREND:event_jButton4KeyPressed
        // Cancelar Insertar a la BD
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (articulo == null) {
                this.doDefaultCloseAction();
            }

            jTextArea2.setText(null);
            articulo = null;
            System.gc();
        }
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
    {//GEN-HEADEREND:event_jButton4ActionPerformed
        // Cancelar Insertar a la BD
        if (articulo == null) {
            this.doDefaultCloseAction();
        }

        jTextArea2.setText(null);
        articulo = null;
        System.gc();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jButton3KeyPressed
    {//GEN-HEADEREND:event_jButton3KeyPressed
        // Agregar a la BD
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            addItem();

            jTextField1.setText(null);
            jTextField2.setText(null);
            jTextField3.setText(null);
            jTextArea1.setText(null);
            jTextArea2.setText(null);
            jComboBox1.setSelectedIndex(0);
            articulo = null;
            System.gc();
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        // Agregar a la BD
        if (addItem()) {
            jTextField1.setText(null);
            jTextField2.setText(null);
            jTextField3.setText(null);
            jTextArea1.setText(null);
            jTextArea2.setText(null);
            jComboBox1.setSelectedIndex(0);
            articulo = null;
            System.gc();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jButton2KeyPressed
    {//GEN-HEADEREND:event_jButton2KeyPressed
        // Cancelar Crear Articulo
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            jTextField1.setText(null);
            jTextField2.setText(null);
            jTextField3.setText(null);
            jTextArea1.setText(null);
            jTextArea2.setText(null);
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        // Cancerlar Creacion Articulo
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextArea1.setText(null);
        jTextArea2.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jButton1KeyPressed
    {//GEN-HEADEREND:event_jButton1KeyPressed
        // Crear item
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            createItem();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        // Crear Item
        jTextArea2.setText("");
        createItem();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    public boolean addItem() {
        if (articulo == null) {
            JOptionPane.showInternalMessageDialog(this, "No se ha introducido ningun articulo", "Error", 2);
            return false;
        } else {
            switch ((String) jComboBox1.getSelectedItem()) {
                case "Biografia":
                    control.insertBiografia(articulo);
                    break;

                case "Esquema":
                    control.insertEsquema(articulo);
                    break;

                case "Mapa Carta":
                case "Mapa MediaCartulina":
                case "Mapa Mural":
                case "MiniMapa":
                    control.insertMapa(articulo);
                    break;

                case "Monografia":
                    control.insertMonografia(articulo);
                    break;

                case "Relieve":
                    control.insertRelieve(articulo);
                    break;

                default:
                    control.insertPrecioArt(articulo);
            }
        }

        return true;
    }

    public void createItem() {
        if (jComboBox1.getSelectedItem() == "Monografia" || jComboBox1.getSelectedItem() == "Biografia"
                || jComboBox1.getSelectedItem() == "Mapa Carta" || jComboBox1.getSelectedItem() == "Mapa Mural"
                || jComboBox1.getSelectedItem() == "Mapa MediaCartulina" || jComboBox1.getSelectedItem() == "MiniMapa"
                || jComboBox1.getSelectedItem() == "Relieve" || jComboBox1.getSelectedItem() == "Esquema") {
            if (!(jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty())) {
                String id = jTextField1.getText();
                String nombre = jTextField2.getText();
                BigDecimal precio = null;

                String info = jTextField2.getText();
                if (!jTextArea1.getText().isEmpty()) {
                    info = jTextArea1.getText();
                }

                String tipo = (String) jComboBox1.getSelectedItem();

                switch (tipo) {
                    case "Monografia":
                        precio = control.getPreciosVar(tipo);
                        break;

                    case "Biografia":
                        precio = control.getPreciosVar(tipo);
                        break;

                    case "Mapa Carta":
                        precio = control.getPreciosVar(tipo);
                        break;

                    case "MiniMapa":
                        precio = control.getPreciosVar(tipo);
                        break;

                    case "Relieve":
                        precio = control.getPreciosVar(tipo);
                        break;

                    case "Esquema":
                        precio = control.getPreciosVar(tipo);
                        break;

                    case "Mapa Mural":
                        precio = control.getPreciosVar(tipo);
                        break;

                    case "Mapa MediaCartulina":
                        precio = control.getPreciosVar(tipo);
                        break;
                }

                articulo = new Articulo(id, nombre, precio, info, tipo);
                jTextArea2.append("Articulo\nID: " + articulo.getId());
                jTextArea2.append("\nNombre: " + articulo.getNombre());
                jTextArea2.append("\nPrecio: " + articulo.getPrecio());
                jTextArea2.append("\nInformacion: " + articulo.getInfo());
                jTextArea2.append("\nTipo: " + articulo.getTipo());
            } else {
                JOptionPane.showInternalMessageDialog(this, "Campos sin llenar", "Error", 2);
            }
        } else {
            if (!(jTextField2.getText().isEmpty() || jTextField3.getText().isEmpty() || jTextArea1.getText().isEmpty())) {
                String id = jTextField1.getText();
                String nombre = jTextField2.getText();
                BigDecimal precio = BigDecimal.valueOf(Double.parseDouble(jTextField3.getText()));
                String info = jTextArea1.getText();
                String tipo = (String) jComboBox1.getSelectedItem();
                BigDecimal descuento = precio.multiply(control.getDescuentoGlobal().divide(new BigDecimal("100.00"))).setScale(2);

                if (precio.signum() == -1) {
                    JOptionPane.showInternalMessageDialog(this, "Solo Dinero Real");
                    jTextField3.setText(null);
                } else {
                    articulo = new Articulo(id, nombre, precio, info, tipo);
                    articulo.setDescuento(descuento);
                    jTextArea2.append("Articulo\n");
                    jTextArea2.append("ID: " + (!id.isEmpty() ? articulo.getId() : "Default"));
                    jTextArea2.append("\nNombre: " + articulo.getNombre());
                    jTextArea2.append("\nPrecio: " + articulo.getPrecio());
                    jTextArea2.append("\nDescuento: " + articulo.getDescuento());
                    jTextArea2.append("\nInformacion: " + articulo.getInfo());
                    jTextArea2.append("\nTipo: " + articulo.getTipo());
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Campos sin llenar", "Error", 2);
            }
        }
    }
}

package com.asadel.ventas.controllers;

import com.asadel.ventas.Asadel;
import com.asadel.ventas.services.Articulo;
import com.asadel.ventas.services.ArticulosTableModel;
import com.asadel.ventas.services.Control;
import com.asadel.ventas.services.Reporte;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IUVentas extends javax.swing.JInternalFrame {

    @Autowired
    private ArticulosTableModel ventas;
    @Autowired
    private Control control;
    @Autowired
    private IUPago pago;
    @Autowired
    private Reporte reporte;

    private Articulo item;
    private int filaSeleccionada;

    public IUVentas() {
        super();
    }

    @PostConstruct
    public void init() {
        filaSeleccionada = -1;
        
        try {
            ventas.init(Control.SELECTLISTA);
            initComponents();
            showTotal();
            setColumnas();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Error 4\n" + sqlex.getMessage(), "Error en la Base de Datos", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jMenuItem1.setText("Agregar Item");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Eliminar Item");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem5.setText("Remover Item");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem5);

        jMenuItem3.setText("Cancelar venta");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);
        jPopupMenu1.add(jSeparator1);

        jMenuItem4.setText("Realizar Venta");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem4);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Productos en venta");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cart2.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(700, 760));
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
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jScrollPane1.setMinimumSize(new java.awt.Dimension(0, 0));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(ventas);
        jTable1.setNextFocusableComponent(jButton6);
        jTable1.setRowHeight(23);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        String solve = "Solve";
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        jTable1.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, solve);

        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mas.png"))); // NOI18N
        jButton1.setText("Item");
        jButton1.setMinimumSize(new java.awt.Dimension(0, 0));
        jButton1.setRequestFocusEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menos.png"))); // NOI18N
        jButton2.setText("Item");
        jButton2.setMinimumSize(new java.awt.Dimension(0, 0));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 0, 0));
        jButton3.setText("Cancelar venta");
        jButton3.setToolTipText("Cancelar Venta");
        jButton3.setMinimumSize(new java.awt.Dimension(0, 0));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 40)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total: $");
        jLabel1.setMinimumSize(new java.awt.Dimension(0, 0));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 56)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("0.00");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 153, 102));
        jButton6.setText("Realizar Venta");
        jButton6.setToolTipText("Realizar Venta");
        jButton6.setMinimumSize(new java.awt.Dimension(0, 0));
        jButton6.setNextFocusableComponent(jTable1);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton6KeyPressed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jButton7.setText("Remover item");
        jButton7.setMinimumSize(new java.awt.Dimension(0, 0));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Articulo");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Precio");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cantidad");
        jLabel5.setToolTipText("");

        jTextField1.setNextFocusableComponent(jTextField2);

        jTextField2.setNextFocusableComponent(jSpinner1);

        jSpinner1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSpinner1.setNextFocusableComponent(jTextArea1);
        jSpinner1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jSpinner1FocusGained(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton4.setText("Agregar");
        jButton4.setNextFocusableComponent(jButton5);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton4KeyPressed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton5.setText("Cancelar");
        jButton5.setNextFocusableComponent(jTable1);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Descripcion");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setNextFocusableComponent(jButton4);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(jTextField2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // Popup - Agregar a la Lsita
        addItem(item);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // Popup - Eliminar Item
        if (filaSeleccionada >= 0 && ventas.getRowCount() != 0) {
            removeItem();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Seleccione un registro");
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // Popup - Limpiar Tabla
        control.clearArticulosLista();
        filaSeleccionada = -1;
        refresh(filaSeleccionada);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // Popup - RealizarVenta
        if (ventas.getRowCount() != 0) {
            if (!control.getEstadoCajaDia()) {
                JOptionPane.showInternalMessageDialog(this, "Se debe Abrir la Caja para vender", "Caja Cerrada", JOptionPane.WARNING_MESSAGE);
            } else {
                BigDecimal total = control.getTotalVenta();
                pago.init(true, total, false);

//                    if (jTButton.isSelected())
//                    {
//                        //pago = new IUPago((Frame)IUDesktop.desktop.getParent().getParent().getParent().getParent(), true, total, true);
//                        pago.init(true, total, true);
//                        //pago.invoke(total, true);
//                    } else
//                    {
//                        //pago = new IUPago((Frame)IUDesktop.desktop.getParent().getParent().getParent().getParent(), true, total, false);
//                        //pago.invoke(total, false);
//
//                        pago.init(true, total, false);
//                    }
                java.awt.EventQueue.invokeLater(()
                        -> {
                    pago.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            dispose();
                            System.gc();
                        }
                    });

                    pago.setVisible(true);
                });
            }

            refresh(filaSeleccionada);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Agregar Articulo externo a la Venta
//        if (jTButton.isSelected())
//        {
//            jTButton.setSelected(false);
//            sellItemExt();
//            jTButton.setSelected(true);
//        } else
//        {
//            sellItemExt();
//        }

        sellItemExt();
        jTable1.requestFocus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Cancelar Articulo Personalizado
        item = null;
        jTextField1.setText(null);
        jTextField2.setText(null);
        jSpinner1.getModel().setValue(1);
        jTable1.requestFocus();
        jTextArea1.setText(null);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // Popup - Remover Item
        if (filaSeleccionada >= 0 && ventas.getRowCount() != 0) {
            deleteArticulo();
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // Ventana Abierta
        showTotal();
    }//GEN-LAST:event_formInternalFrameOpened

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
        // Agregar Articulo externo a la Venta
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            sellItemExt();
        }
    }//GEN-LAST:event_jButton4KeyPressed

    private void jSpinner1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jSpinner1FocusGained
        // Spinner Cantidad
        ((JFormattedTextField) jSpinner1.getEditor().getComponents()[0]).selectAll();
    }//GEN-LAST:event_jSpinner1FocusGained

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // Ventana Activada
        //jPanel1.setBackground(Asadel.ACTIVE_COLOR);
        jButton6.requestFocus();
        refresh(filaSeleccionada);
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeactivated
        // Ventana Desactivada
        jPanel1.setBackground(Color.getColor(System.getProperty("Panel.background")));
    }//GEN-LAST:event_formInternalFrameDeactivated

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton7ActionPerformed
    {//GEN-HEADEREND:event_jButton7ActionPerformed
        // Remover Item
        if (filaSeleccionada >= 0 && ventas.getRowCount() != 0) {
            deleteArticulo();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Seleccione un Registro");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6KeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jButton6KeyPressed
    {//GEN-HEADEREND:event_jButton6KeyPressed
        // Realizar Venta Teclado
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (ventas.getRowCount() == 0) {
                JOptionPane.showInternalMessageDialog(this, "No hay productos que vender");
            } else {
                if (!control.getEstadoCajaDia()) {
                    JOptionPane.showInternalMessageDialog(this, "Se debe Abrir la Caja para vender", "Caja Cerrada", JOptionPane.WARNING_MESSAGE);
                } else {
                    BigDecimal total = control.getTotalVenta();
                    pago.init(true, total, false);

//                    if (jTButton.isSelected())
//                    {
//                        //pago = new IUPago((Frame) IUDesktop.desktop.getParent().getParent().getParent().getParent(), true, total, true);
//                        //pago.invoke(total, true);
//                        pago.init(true, total, true);
//                    } else
//                    {
//                        //pago = new IUPago((Frame) IUDesktop.desktop.getParent().getParent().getParent().getParent(), true, total, false);
//                        //pago.invoke(total, false);
//                        pago.init(true, total, false);
//                    }
                    java.awt.EventQueue.invokeLater(()
                            -> {
                        pago.addWindowListener(new java.awt.event.WindowAdapter() {
                            @Override
                            public void windowClosing(java.awt.event.WindowEvent e) {
                                dispose();
                                System.gc();
                            }
                        });

                        pago.setVisible(true);
                    });
                }

                refresh(filaSeleccionada);
            }
        }
    }//GEN-LAST:event_jButton6KeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton6ActionPerformed
    {//GEN-HEADEREND:event_jButton6ActionPerformed
        // Realizar Venta
        if (ventas.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(this, "No hay productos que vender");
        } else {
            if (!control.getEstadoCajaDia()) {
                JOptionPane.showInternalMessageDialog(this, "Se debe Abrir la Caja para vender", "Caja Cerrada", JOptionPane.WARNING_MESSAGE);
            } else {
                pago.clear();
                BigDecimal total = control.getTotalVenta();
                pago.init(true, total, false);

//                if (jTButton.isSelected())
//                {
//                    //pago = new IUPago((Frame) IUDesktop.desktop.getParent().getParent().getParent().getParent(), true, total, true);
//                    //pago.invoke(total, true);
//                    pago.init(true, total, true);
//                } else
//                {
//                    //pago = new IUPago((Frame) IUDesktop.desktop.getParent().getParent().getParent().getParent(), true, total, false);
//                    //pago.invoke(total, false);
//                    pago.init(true, total, false);
//                }
                java.awt.EventQueue.invokeLater(()
                        -> {
                    pago.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            dispose();
                        }
                    });

                    pago.setVisible(true);
                });
            }

            refresh(filaSeleccionada);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        // Limpiar Tabla
        control.clearArticulosLista();
        reporte.clearFactura();
        filaSeleccionada = -1;
        refresh(filaSeleccionada);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        // Eliminar
        if (filaSeleccionada >= 0 && ventas.getRowCount() != 0) {
            removeItem();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Seleccione un registro");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        // Agregar
        if (filaSeleccionada >= 0 && ventas.getRowCount() != 0) {
            item = getItem(filaSeleccionada);
            addItem(item);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Seleccione un Registro");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTable1KeyPressed
    {//GEN-HEADEREND:event_jTable1KeyPressed
        // Tabla - KeyTyped
        filaSeleccionada = jTable1.getSelectedRow();

        if (evt.getKeyChar() == KeyEvent.VK_ENTER && !jTable1.isEditing()) {
            if (ventas.getRowCount() == 0) {
                JOptionPane.showInternalMessageDialog(this, "No hay productos que vender");
            } else {
                if (!control.getEstadoCajaDia()) {
                    JOptionPane.showInternalMessageDialog(this, "Se debe Abrir la Caja para vender", "Caja Cerrada", JOptionPane.WARNING_MESSAGE);
                } else {
                    BigDecimal total = control.getTotalVenta();
                    pago.init(true, total, false);

//                        if (jTButton.isSelected())
//                        {
//                            //pago = new IUPago((Frame) IUDesktop.desktop.getParent().getParent().getParent().getParent(), true, total, true);
//                            //pago.invoke(total, true);
//                            pago.init(true, total, true);
//                        } else
//                        {
//                            //pago = new IUPago((Frame) IUDesktop.desktop.getParent().getParent().getParent().getParent(), true, total, false);
//                            //.invoke(total, false);
//                            pago.init(true, total, false);
//                        }
                    java.awt.EventQueue.invokeLater(()
                            -> {
                        pago.addWindowListener(new java.awt.event.WindowAdapter() {
                            @Override
                            public void windowClosing(java.awt.event.WindowEvent e) {
                                dispose();
                                System.gc();
                            }
                        });

                        pago.setVisible(true);
                    });
                }

                refresh(filaSeleccionada);
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_PLUS) {
            if (filaSeleccionada >= 0 && ventas.getRowCount() != 0) {
                item = getItem(filaSeleccionada);
                this.addItem(item);
            } else {
                JOptionPane.showInternalMessageDialog(this, "Seleccione un registro");
            }
        }
        if (evt.getKeyChar() == KeyEvent.VK_MINUS) {
            if (filaSeleccionada >= 0 && ventas.getRowCount() != 0) {
                removeItem();
            } else {
                JOptionPane.showInternalMessageDialog(this, "Seleccione un registro");
            }
        }
        if (evt.getKeyChar() == KeyEvent.VK_DELETE) {
            if (filaSeleccionada >= 0 && ventas.getRowCount() != 0) {
                deleteArticulo();
            } else {
                JOptionPane.showInternalMessageDialog(this, "Seleccione un registro");
            }
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTable1MouseClicked
    {//GEN-HEADEREND:event_jTable1MouseClicked
        // ClickTabla
        int fila = jTable1.rowAtPoint(evt.getPoint());
        int columna = jTable1.columnAtPoint(evt.getPoint());

        if ((fila > -1) && (columna > -1)) {
            filaSeleccionada = fila;

            if (evt.getButton() == MouseEvent.BUTTON3) {
                item = getItem(filaSeleccionada);
                jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
                jTable1.setRowSelectionInterval(fila, fila);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    protected javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    public CellEditorListener Cell() {
        CellEditorListener celda = new CellEditorListener() {
            @Override
            public void editingStopped(ChangeEvent e) {
                String num;

                if (jTable1.getCellEditor(filaSeleccionada, 2).getCellEditorValue().toString().isEmpty()) {
                    return;
                } else {
                    num = jTable1.getCellEditor(filaSeleccionada, 2).getCellEditorValue().toString();
                }

                item = getItem(filaSeleccionada);
                Integer cantidad = null;

                try {
                    cantidad = Integer.parseInt(num);
                } catch (NumberFormatException ne) {
                    cantidad = item.getCantidad();
                }

                if (cantidad == 0) {
                    cantidad = 1;
                }

                item.setCantidad(cantidad);
                control.updateArticuloLista(item, 2);
                refresh(filaSeleccionada);
            }

            @Override
            public void editingCanceled(ChangeEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }
        };

        return celda;
    }

    public Articulo getItem(int row) {
        Object[] values = new Object[ventas.getColumnCount()];

        for (int i = 0;
                i < values.length;
                i++) {
            values[i] = jTable1.getValueAt(row, i);
        }

        String id = (String) values[0];
        String nombre = (String) values[1];
        int cantidad = Integer.parseInt(values[2].toString());
        BigDecimal precio = (BigDecimal) values[3];
        BigDecimal subtotal = (BigDecimal) values[4];

        return item = new Articulo(id, nombre, precio, "", "", cantidad, subtotal);
    }

    public void refresh(int fila) {
        try {
            ventas.doQuery(Control.SELECTLISTA);
            ventas.fireTableDataChanged();
            ventas.fireTableStructureChanged();
            showTotal();
            setColumnas();

            if (fila >= 0) {
                if (ventas.getRowCount() > 0) {
                    try {
                        jTable1.setRowSelectionInterval(fila, fila);
                    } catch (IllegalArgumentException e) {
                    }
                }
            }

        } catch (SQLException sqlex2) {
            JOptionPane.showInternalMessageDialog(this, sqlex2.getMessage(), "Error en la Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setColumnas() {
        int anchoColumna = 0;
        TableColumnModel modeloColumna = jTable1.getColumnModel();
        TableColumn columnaTabla;
        CellRender render = new CellRender();

        for (int i = 0;
                i < jTable1.getColumnCount();
                i++) {
            columnaTabla = modeloColumna.getColumn(i);

            switch (i) {
                case 0:
                    anchoColumna = 100;
                    columnaTabla.setMinWidth(100);
                    columnaTabla.setMaxWidth(100);
                    break;
                case 1:
                    anchoColumna = 240;
                    columnaTabla.setMinWidth(100);
                    break;
                case 2:
                    anchoColumna = 60;
                    columnaTabla.setMinWidth(55);
                    columnaTabla.setMaxWidth(70);
                    jTable1.getColumnModel().getColumn(2).setCellEditor(new EditorText());
                    jTable1.getCellEditor(0, 2).addCellEditorListener(Cell());
                    break;
                case 3:
                    anchoColumna = 60;
                    columnaTabla.setMinWidth(55);
                    columnaTabla.setMaxWidth(70);
                    break;
                case 4:
                    anchoColumna = 60;
                    columnaTabla.setMinWidth(55);
                    columnaTabla.setMaxWidth(80);
                    columnaTabla.setCellRenderer(render);
                    break;
            }

            columnaTabla.setPreferredWidth(anchoColumna);
        }
    }

    private void sellItemExt() {
        if (jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this, "Campos sin Llenar", "Error", 2);
        } else {
            Random num = new Random();
            int id = num.nextInt(9999);
            String nombre = jTextField1.getText();
            BigDecimal precio = BigDecimal.ZERO;
            int cantidad = 1;
            String descripcion = jTextArea1.getText();

            try {
                precio = new BigDecimal(jTextField2.getText());
                cantidad = Integer.parseInt(jSpinner1.getValue().toString());

            } catch (NumberFormatException e) {
                JOptionPane.showInternalMessageDialog(this, "Ingresa un precio correcto", "Caracter invalido", JOptionPane.ERROR_MESSAGE);
                jTextField2.setText("");
                return;
            }

            BigDecimal subtotal = precio.multiply(new BigDecimal(cantidad));
            item = new Articulo(id + "-AE", nombre, precio, descripcion, "Otros", cantidad, subtotal);
            addItem(item);

            item = null;
            jTextField1.setText(null);
            jTextField2.setText(null);
            jTextArea1.setText(null);
            jSpinner1.getModel().setValue(1);
            jTable1.requestFocus();
        }
    }

    public void addItem(Articulo item) {
        if (control.getEstadoLista()) {
            control.insertArticuloLista(item);
        } else {
            control.openLista();
            control.insertArticuloLista(item);
        }

        refresh(filaSeleccionada);
    }

    public void removeItem() {
        item = getItem(filaSeleccionada);

        if (control.updateArticuloLista(item, 0)) {
            filaSeleccionada = -1;
        }

        refresh(filaSeleccionada);
    }

    public void deleteArticulo() {
        item = getItem(filaSeleccionada);
        control.deleteArticuloLista(item);
        filaSeleccionada = -1;
        refresh(filaSeleccionada);
    }

    private void showTotal() {
        jLabel2.setText(control.getTotalVenta().toString());
    }
}

class CellRender extends DefaultTableCellRenderer implements TableCellRenderer {
    //DefaultTableCellRenderer editor = new DefaultTableCellRenderer();

    @Override
    public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value != null) {
            setText(" " + value.toString());
        }

        setFont(new java.awt.Font("Calibri", 0, 18));
//        setForeground(Color.black);
        setOpaque(false);

        if (isSelected) {

            setFont(new java.awt.Font("Calibri", 1, 19));
            setBackground(Color.getColor(System.getProperty("Table.selectionBackground")));
//            setForeground(Color.black);
        } else {
            setFont(new java.awt.Font("Calibri", 0, 18));
            //setBackground(Color.getColor(System.getProperty("Table.backgorund")));    
        }

        return this;
    }
}

class EditorText extends DefaultCellEditor {

    public EditorText() {
        super(new JTextField());
        ((JTextField) editorComponent).setBorder(null);
        ((JTextField) editorComponent).setFont(new java.awt.Font("Calibri", 0, 16));
        ((JTextField) editorComponent).setForeground(Color.black);
        ((JTextField) editorComponent).addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    //System.out.println("Ok");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        ((JTextField) editorComponent).addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //System.out.println("Ok");
                ((JTextField) e.getSource()).getCaret().moveDot(0);
                ((JTextField) e.getSource()).setHorizontalAlignment(JTextField.CENTER);
            }

            @Override
            public void focusLost(FocusEvent e) {
                //System.out.println("Out");
            }
        });
    }
}

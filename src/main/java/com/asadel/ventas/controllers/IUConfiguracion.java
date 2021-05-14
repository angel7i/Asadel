package com.asadel.ventas.controllers;

import com.asadel.ventas.Asadel;
import com.asadel.ventas.services.ArticulosTableModel;
import com.asadel.ventas.services.Control;
import com.asadel.ventas.services.PropiedadesService;
import com.asadel.ventas.services.Reporte;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.EventObject;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.PostConstruct;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pushingpixels.substance.api.SubstanceCortex;

@Slf4j
@org.springframework.stereotype.Component
@RequiredArgsConstructor
public class IUConfiguracion extends javax.swing.JInternalFrame {

    private final Control control;
    private final ArticulosTableModel descuento;
    private final Reporte reporte;
    private final PropiedadesService propiedades;

    private TableRowSorter< TableModel> sorter;

    @PostConstruct
    public void init() {
        try {
            descuento.init(Control.SELECTDESCUENTO);
            sorter = new TableRowSorter<>(descuento);
            initComponents();
            setColumnas();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Error 4\n" + sqlex.getMessage(), "Error en la Base de Datos", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton12 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Configuracion");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/config.png"))); // NOI18N
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

        jTabbedPane1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setText("Activar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton2.setText("Actualizar");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jList1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Biografia", "Esquema", "Mapa Carta", "Mapa MediaCartulina", "Mapa Mural", "MiniMapa", "Monografia", "Relieve" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setSelectedIndex(0);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Precios");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Tema");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AutumnSkin", "BusinessBlackSteelSkin", "BusinessBlueSteelSkin", "BusinessSkin", "CeruleanSkin", "CremeCoffeeSkin", "CremeSkin", "DustCoffeeSkin", "DustSkin", "GeminiSkin", "GraphiteAquaSkin", "GraphiteGlassSkin", "GraphiteChalkSkin", "GraphiteElectricSkin", "GraphiteSkin", "MagellanSkin", "MarinerSkin", "MistAquaSkin", "MistSilverSkin", "ModerateSkin", "NebulaSkin", "NebulaAmethystSkin", "NebulaBrickWallSkin", "NightShadeSkin", "RavenSkin", "SaharaSkin", "SentinelSkin", "TwilightSkin" }));

        jButton12.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton12.setText("Cambiar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton15.setText("Crear respaldo");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setText("Crear respaldo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))
                            .addComponent(jTextField1))
                        .addGap(0, 164, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton12)
                            .addComponent(jComboBox1, 0, 170, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton12)
                .addGap(28, 28, 28)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Preferencias", null, jPanel1, "Precios");

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Descuento aplicado a Lista Escolares");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField2.setNextFocusableComponent(jButton3);

        jButton3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton3.setText("Activar");
        jButton3.setNextFocusableComponent(jButton4);
        jButton3.setPreferredSize(new java.awt.Dimension(73, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton4.setText("Actualizar");
        jButton4.setEnabled(false);
        jButton4.setPreferredSize(new java.awt.Dimension(89, 30));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTable1.setModel(descuento);
        jTable1.setRowHeight(20);
        jTable1.setRowSorter(sorter);
        jTable1.setSelectionBackground(SystemColor.textHighlight.darker());
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowHorizontalLines(true);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh2.png"))); // NOI18N
        jButton5.setToolTipText("Actualizar Tabla");
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Buscar");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setNextFocusableComponent(jTable1);
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Descuento", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // Cerrar Ventana
        jButton2.setEnabled(false);
        jButton1.setText("Activar");
    }//GEN-LAST:event_formInternalFrameClosed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Cambiar Precio
        if (!jButton2.isEnabled()) {
            jButton2.setEnabled(true);
            jTextField1.setEditable(true);
            jButton1.setText("Bloquear");
        } else {
            jButton2.setEnabled(false);
            jTextField1.setEditable(false);
            jButton1.setText("Activar");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Actualizar Precio
        if (!jTextField1.getText().isEmpty()) {
            control.setPrecioVar(jList1.getSelectedValue().toString(), new BigDecimal(jTextField1.getText()));
            jButton2.setEnabled(false);
            jTextField1.setEditable(false);
            jButton1.setText("Activar");
        } else {
            jButton2.setEnabled(false);
            jButton1.setText("Activar");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Cambiar Descuento
        if (!jButton4.isEnabled()) {
            jButton4.setEnabled(true);
            jTextField2.setEditable(true);
            jButton3.setText("Bloquear");
        } else {
            jButton4.setEnabled(false);
            jTextField2.setEditable(false);
            jButton3.setText("Activar");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Actualizar Descuento
        if (!jTextField2.getText().isEmpty()) {
            control.setDescuentoGlobal(Integer.parseInt(jTextField2.getText()));
            control.updateDescuentosGlobalArt();
            jButton4.setEnabled(false);
            jTextField2.setEditable(false);
            jButton3.setText("Activar");
            refresh();
        } else {
            jButton4.setEnabled(false);
            jButton3.setText("Activar");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // Cambio de Paneles
        if (control != null) {
            switch (jTabbedPane1.getSelectedIndex()) {
                case 0:
                    jTextField1.setText(control.getPreciosVar(jList1.getSelectedValue().toString()).toString());
                    break;
                case 1:
                    jTextField3.requestFocus();
                    jTextField2.setText(new BigDecimal("100.00").subtract(control.getDescuentoGlobal()).setScale(0) + "");
                    break;
                default:
                    break;
            }
        }

    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Actualizar Tabla
        refresh();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // Seleccionar Lista
        jTextField1.setText(control.getPreciosVar(jList1.getSelectedValue().toString()).toString());
    }//GEN-LAST:event_jList1ValueChanged

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // Buscar
        filtro();
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        // Filtro - Boton ESC
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            jTextField3.requestFocus();
            jTextField3.setText(null);
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // Tabla - Teclado
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            jTextField3.requestFocus();
            jTextField3.setText(null);
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // Ventana Activa
        jPanel1.setBackground(Asadel.ACTIVE_COLOR);
        jPanel2.setBackground(Asadel.ACTIVE_COLOR);
        jTextField1.setText(control.getPreciosVar(jList1.getSelectedValue().toString()).toString());
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeactivated
        // Ventana Desactivada
        jPanel1.setBackground(Color.getColor(System.getProperty("Panel.background")));
        jPanel2.setBackground(Color.getColor(System.getProperty("Panel.background")));
    }//GEN-LAST:event_formInternalFrameDeactivated

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton12ActionPerformed
    {//GEN-HEADEREND:event_jButton12ActionPerformed
        // Cambiar tema
        //SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin." + jComboBox1.getSelectedItem());
        SubstanceCortex.GlobalScope.setSkin("org.pushingpixels.substance.api.skin." + jComboBox1.getSelectedItem());
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        log.debug("Crear respaldo...");
        backup();
    }//GEN-LAST:event_jButton15ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    private void backup() {
        Calendar c = Calendar.getInstance(Locale.getDefault());
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd'_'HH-mm-a");
        String fecha = date.format(c.getTime());
        String mysql = propiedades.getDBHome();
        Path dump = Paths.get(mysql, "bin", "mysqldump.exe");
        String user = propiedades.getDBUser();
        String pwd = propiedades.getDBSecret();
        String command = dump + " -u " + user + " -p" + pwd + " papeleria --databases ";
        log.info("Exec: {}", command);
        var backupDirectory = propiedades.getBackupDirectory();
        Path fileToSave = Paths.get(backupDirectory, "PapeleriaBackup_" + fecha + ".sql");
        log.info("Save backup in: {}", fileToSave);

        new Thread(()
                -> {
            BufferedReader reader = null;
            BufferedWriter writer = null;

            try {
                Process runtimeProcess = Runtime.getRuntime().exec(command);
                reader = new BufferedReader(new InputStreamReader(new DataInputStream(runtimeProcess.getInputStream())));
                writer = new BufferedWriter(new FileWriter(fileToSave.toFile()));
                String line = null;

                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }

                SwingUtilities.invokeLater(()
                        -> {
                    try {
                        if (runtimeProcess.waitFor() == 0) {
                            JOptionPane.showInternalMessageDialog(rootPane, "Respaldo creado");
                        } else {
                            JOptionPane.showInternalMessageDialog(rootPane, "Error al respaldar la base de datos");
                        }
                    } catch (InterruptedException ex) {
                        JOptionPane.showInternalMessageDialog(rootPane, ex.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
                    }
                });
            } catch (IOException ex) {
                JOptionPane.showInternalMessageDialog(rootPane, ex.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException ex) {
                    }
                }
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException ex) {
                    }
                }
            }
        }).start();

    }

    private void filtro() {
        String texto = jTextField3.getText();
        Pattern p = Pattern.compile("^[+*-/¡!¿?()]");
        Matcher m = p.matcher(texto);

        if (m.find()) {
            jTextField3.setText(null);
        } else {
            RowFilter<Object, Object> wordFilter = RowFilter.regexFilter(Pattern.compile("(?i)" + texto).toString());

            if (texto.isEmpty()) {
                sorter.setRowFilter(null);
            } else if (texto.length() != 0) {
                try {
                    sorter.setRowFilter(wordFilter);
                    setColumnas();
                } catch (PatternSyntaxException ex) {
                    JOptionPane.showInternalMessageDialog(this, "Busqueda Incorrecta");
                }
            }
        }
    }

    public CellEditorListener Cell() {
        CellEditorListener celda = new CellEditorListener() {
            @Override
            public void editingStopped(ChangeEvent e) {
                int fila = jTable1.getSelectedRow();

                if (fila >= 0) {
                    String num;

                    if (jTable1.getCellEditor(fila, 4).getCellEditorValue().toString().isEmpty()) {
                        return;
                    } else {
                        num = jTable1.getCellEditor(fila, 4).getCellEditorValue().toString();
                    }

                    int porciento = Integer.parseInt(num);
                    String id = jTable1.getValueAt(fila, 0).toString();
                    setDescuento(true, id, porciento);
                }
            }

            @Override
            public void editingCanceled(ChangeEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        return celda;
    }

    public void setDescuento(boolean estado, String id, int porciento) {
        if (estado) {
            if (porciento > 0 && porciento <= 100) {
                control.setDescuentoArticulo(id, true, porciento);
            } else if (porciento == 0) {
                control.setDescuentoArticulo(id, false, porciento);
            }
        } else {
            control.removeDescuentoArticulo(id);
        }

        refresh();
    }

    private void setColumnas() {
        int anchoColumna = 0;
        TableColumnModel modeloColumna = jTable1.getColumnModel();
        TableColumn columnaTabla;

        for (int i = 0;
                i < jTable1.getColumnCount();
                i++) {
            columnaTabla = modeloColumna.getColumn(i);

            switch (i) {
                case 0:
                    anchoColumna = 50;
                    columnaTabla.setMaxWidth(80);
                    columnaTabla.setMinWidth(50);
                    break;
                case 1:
                    anchoColumna = 290;
                    columnaTabla.setMinWidth(200);
                    break;
                case 2:
                    anchoColumna = 60;
                    columnaTabla.setMaxWidth(75);
                    columnaTabla.setMinWidth(60);
                    break;
                case 3:
                    anchoColumna = 75;
                    columnaTabla.setMaxWidth(80);
                    columnaTabla.setMinWidth(75);
                    break;
                case 4:
                    anchoColumna = 75;
                    columnaTabla.setMaxWidth(80);
                    columnaTabla.setMinWidth(75);
                    jTable1.getColumnModel().getColumn(4).setCellEditor(new EditorText());
                    jTable1.getCellEditor(0, 4).addCellEditorListener(Cell());
                    break;
                case 5:
                    anchoColumna = 95;
                    columnaTabla.setMaxWidth(120);
                    columnaTabla.setMinWidth(95);
                    columnaTabla.setCellEditor(new EditorBox());
                    columnaTabla.setCellRenderer(new RenderBox());
                    JCheckBox box = (JCheckBox) columnaTabla.getCellEditor();
                    box.addItemListener((ItemEvent e)
                            -> {
                        int fila = jTable1.getSelectedRow();

                        if (fila >= 0) {
                            boolean estado = ((JCheckBox) e.getItem()).isSelected();
                            String id = jTable1.getValueAt(fila, 0).toString();
                            int porcentaje = Integer.parseInt(jTable1.getValueAt(fila, 4).toString());
                            setDescuento(estado, id, porcentaje);
                        }
                    });
                    break;
            }
            columnaTabla.setPreferredWidth(anchoColumna);
        }
    }

    public void refreshData() {
        try {
            descuento.Consulta(Control.SELECTDESCUENTO);
            descuento.fireTableDataChanged();
            setColumnas();
        } catch (SQLException sqlex2) {
            JOptionPane.showInternalMessageDialog(this, sqlex2.getMessage(), "Error en la Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void refresh() {
        try {
            descuento.Consulta(Control.SELECTDESCUENTO);
            descuento.fireTableDataChanged();
            descuento.fireTableStructureChanged();
            setColumnas();
        } catch (SQLException sqlex2) {
            JOptionPane.showInternalMessageDialog(this, sqlex2.getMessage(), "Error en la Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }
}

class EditorBox extends JCheckBox implements TableCellEditor {

    public EditorBox() {
        //super("Descuento");
        setEnabled(true);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        boolean estado = false;

        if ("1".equals(value.toString())) {
            estado = true;
        }

        setSelected(estado);

        return this;
    }

    @Override
    public Object getCellEditorValue() {
        return isSelected();
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        return true;
    }

    @Override
    public void cancelCellEditing() {
        //cancelCellEditing();
    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {
        //this.addCellEditorListener(l);
    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {
        //
    }
}

class RenderBox extends JCheckBox implements TableCellRenderer {

    public RenderBox() {
        //super("Descuento");
        setOpaque(false);
        setEnabled(true);
        super.setForeground(Color.black);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        boolean estado = false;

        if ("1".equals(value.toString())) {
            estado = true;
        }

        setSelected(estado);
        setEnabled(true);
        super.setForeground(Color.gray);

        if (isSelected) {
            super.setBackground(SystemColor.textHighlight.darker());
            super.setForeground(Color.white);
        } else {
            super.setBackground((row % 2 == 0) ? Color.white : Color.getColor("Table.light"));
        }

        return this;
    }
}

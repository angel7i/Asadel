package com.asadel.ventas.controllers;

import com.asadel.ventas.services.Articulo;
import com.asadel.ventas.services.ArticulosTableModel;
import com.asadel.ventas.services.Control;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IUArticulos extends javax.swing.JInternalFrame {

    @Autowired
    private Control control;
    @Autowired
    private ArticulosTableModel tablabase;
    @Autowired
    private IUVentas ventas;
    @Autowired
    private IUModificar editar;
    @Autowired
    private IUDesktop desktop;

    private int filaSeleccionada;
    private Articulo item;
    private TableRowSorter<TableModel> sorter;
    private String productsType;

    public final static Object[] TIPO = new Object[]{
        "Todo",
        "Papeleria",
        "Informatica",
        "Monografia",
        "Biografia",
        "Relieve",
        "Mapa Carta",
        "Esquema",
        "Mapa MediaCartulina",
        "Mapa Mural",
        "MiniMapa",
        "Juguetes",
        "Cosmeticos",
        "Regalos",
        "Merceria",
        "Dulceria",
        "Otros"
    };

    @PostConstruct
    public void init() {
        log.trace("SELECT: {}", Control.SELECTALLARTICULOS);
        filaSeleccionada = -1;
        productsType = "";

        try {
            tablabase.init(Control.SELECTALLARTICULOS);
            sorter = new TableRowSorter<>(tablabase);
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
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        Cortar = new javax.swing.JMenuItem();
        Copiar = new javax.swing.JMenuItem();
        Pegar = new javax.swing.JMenuItem();
        SeleccionarTodo = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jPopupMenu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem8.setText("Agregar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem8);

        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem7.setText("Modificar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem7);

        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem5.setText("Eliminar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem5);
        jPopupMenu1.add(jSeparator1);

        jMenuItem9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem9.setText("Agregar a la Lista");
        jMenuItem9.setToolTipText("");
        jMenuItem9.setActionCommand("");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem9);

        Cortar.setText("Cortar");
        Cortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CortarActionPerformed(evt);
            }
        });
        jPopupMenu2.add(Cortar);

        Copiar.setText("Copiar");
        Copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarActionPerformed(evt);
            }
        });
        jPopupMenu2.add(Copiar);

        Pegar.setText("Pegar");
        Pegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PegarActionPerformed(evt);
            }
        });
        jPopupMenu2.add(Pegar);

        SeleccionarTodo.setText("Seleccionar Todo");
        SeleccionarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarTodoActionPerformed(evt);
            }
        });
        jPopupMenu2.add(SeleccionarTodo);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Articulos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/articulo2.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(800, 2147483647));
        setMinimumSize(new java.awt.Dimension(670, 340));
        setNormalBounds(new java.awt.Rectangle(0, 0, 690, 760));
        setPreferredSize(new java.awt.Dimension(690, 760));
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

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel3.setPreferredSize(new java.awt.Dimension(674, 760));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable.setModel(tablabase);
        jTable.setMaximumSize(new java.awt.Dimension(720, 0));
        jTable.setNextFocusableComponent(jTextField2);
        jTable.setRowSorter(sorter);
        jTable.setSelectionBackground(SystemColor.textHighlight.darker());
        jTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable.setShowHorizontalLines(true);
        jTable.setShowVerticalLines(true);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTableKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);
        String solve = "Solve";
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        jTable.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, solve);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setDragEnabled(true);
        jTextField2.setNextFocusableComponent(jTable);
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Calibri", 0, 42)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Caja: $0.00");

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/allitems.png"))); // NOI18N
        jToggleButton1.setSelected(true);
        jToggleButton1.setToolTipText("Todo");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/papel.png"))); // NOI18N
        jToggleButton2.setToolTipText("Papeleria");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/informatica.png"))); // NOI18N
        jToggleButton3.setToolTipText("Informatica");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/monografia.png"))); // NOI18N
        jToggleButton4.setToolTipText("Monografias");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jToggleButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/biografias.png"))); // NOI18N
        jToggleButton5.setToolTipText("Biografias");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jToggleButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/relieves.png"))); // NOI18N
        jToggleButton6.setToolTipText("Relieves");
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });

        jToggleButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/maps.png"))); // NOI18N
        jToggleButton7.setToolTipText("Mapas");
        jToggleButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton7ActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jTextArea1.setRows(3);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addComponent(jToggleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jToggleButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jToggleButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jToggleButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jToggleButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // Tabla - ClickTabla
        int fila = jTable.rowAtPoint(evt.getPoint());

        if (fila > -1) {
            filaSeleccionada = fila;
            item = getItem(filaSeleccionada);
            String msg = "Precio: $" + item.getPrecioVenta() + (item.getInfo() == null ? "" : "\n Info: " + item.getInfo());
            this.jTextArea1.setText(msg);

            if (evt.getButton() == MouseEvent.BUTTON3) {
                jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
                jTable.setRowSelectionInterval(fila, fila);
            }
            if (evt.getClickCount() == 2 && evt.getButton() != MouseEvent.BUTTON3) {
                desktop.showVentas(false);
                ventas.addItem(item);
            }
            if (evt.getClickCount() == 1 && evt.getButton() != MouseEvent.BUTTON3) {

            }
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void jTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableKeyPressed
        // Tabla - Teclado
        if (jTable.getSelectedRow() >= 0) {
            filaSeleccionada = jTable.getSelectedRow();
            item = getItem(filaSeleccionada);

            if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
                desktop.showVentas(false);
                ventas.addItem(item);
            }
            if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
                jTextField2.requestFocus();
                jTextField2.setText(null);
            }
            if (evt.getKeyChar() == KeyEvent.VK_DELETE) {
                deleteItem();
            }
            if (evt.getKeyChar() == KeyEvent.VK_5) {
                refresh();
            }
        }
    }//GEN-LAST:event_jTableKeyPressed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        // PopupText
        if (evt.getButton() == MouseEvent.BUTTON3) {
            jPopupMenu2.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // Busqueda
        //filtro();
        filter();
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // Filtro - Boton ESC
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            jTextField2.requestFocus();
            jTextField2.setText(null);
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // PopupTabla - Agregar Articulo
        ventas.addItem(item);
        desktop.showAgregar();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // PopupTabla - Update/Editar
        desktop.showModificar();
        editar.loadArticle(item);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // PopupTabla - Eliminar
        deleteItem();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        //PopupTabla - Agregar a la Lista de Ventas
        desktop.showVentas(false);
        ventas.addItem(item);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void CortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CortarActionPerformed
        // Cortar Texto
        jTextField2.cut();
    }//GEN-LAST:event_CortarActionPerformed

    private void CopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarActionPerformed
        // Copia Texto
        jTextField2.copy();
    }//GEN-LAST:event_CopiarActionPerformed

    private void PegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PegarActionPerformed
        // Pegar Texto
        jTextField2.paste();
    }//GEN-LAST:event_PegarActionPerformed

    private void SeleccionarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarTodoActionPerformed
        // SeleccionarTodo
        jTextField2.selectAll();
    }//GEN-LAST:event_SeleccionarTodoActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        //this.doDefaultCloseAction();
    }//GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // Ventana Activa
        //jPanel3.setBackground(Asadel.ACTIVE_COLOR);//[0,153,255]
        refresh();
        jTextField2.requestFocus();
        jTextField2.getCaret().moveDot(0);
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeactivated
        // Ventana Desactivada
        jPanel3.setBackground(Color.getColor(System.getProperty("Panel.background")));
    }//GEN-LAST:event_formInternalFrameDeactivated

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton1ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        jToggleButton1.setSelected(true);

        if (jToggleButton1.isSelected()) {
            productsType = TIPO[0].toString();
            jToggleButton1.setSelected(true);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton2ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        jToggleButton2.setSelected(true);

        if (jToggleButton2.isSelected()) {
            productsType = TIPO[1].toString();
            jToggleButton1.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton3ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
        jToggleButton3.setSelected(true);

        if (jToggleButton3.isSelected()) {
            productsType = TIPO[2].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton4ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:
        jToggleButton4.setSelected(true);

        if (jToggleButton4.isSelected()) {
            productsType = TIPO[3].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton5ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton5ActionPerformed
        // TODO add your handling code here:
        jToggleButton5.setSelected(true);

        if (jToggleButton5.isSelected()) {
            productsType = TIPO[4].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton6ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton6ActionPerformed
        // TODO add your handling code here:
        jToggleButton6.setSelected(true);

        if (jToggleButton6.isSelected()) {
            productsType = TIPO[5].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton7.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton7ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton7ActionPerformed
        // TODO add your handling code here:
        jToggleButton7.setSelected(true);

        if (jToggleButton7.isSelected()) {
            productsType = TIPO[6].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton7ActionPerformed

    private void jTableKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTableKeyReleased
    {//GEN-HEADEREND:event_jTableKeyReleased
        // TODO add your handling code here:
        if (jTable.getSelectedRow() >= 0) {
            filaSeleccionada = jTable.getSelectedRow();
            item = getItem(filaSeleccionada);
            String msg = "Precio: $" + item.getPrecioVenta() + (item.getInfo() == null ? "" : "\n Info: " + item.getInfo());
            this.jTextArea1.setText(msg);
        }
    }//GEN-LAST:event_jTableKeyReleased

    private void jTableKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTableKeyTyped
    {//GEN-HEADEREND:event_jTableKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jTableKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Copiar;
    private javax.swing.JMenuItem Cortar;
    private javax.swing.JMenuItem Pegar;
    private javax.swing.JMenuItem SeleccionarTodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    // End of variables declaration//GEN-END:variables

    private void setColumnas() {
        int anchoColumna = 0;
        TableColumnModel modeloColumna = jTable.getColumnModel();
        TableColumn columnaTabla;

        for (int i = 0;
                i < jTable.getColumnCount();
                i++) {
            columnaTabla = modeloColumna.getColumn(i);

            switch (i) {
                case 0 -> {
                    anchoColumna = 120;
                    columnaTabla.setMaxWidth(130);
                    columnaTabla.setMinWidth(anchoColumna);
                }
                case 1 -> {
                    anchoColumna = 290;
                    columnaTabla.setMinWidth(200);
                }
                case 2 -> {
                    anchoColumna = 100;
                    columnaTabla.setMaxWidth(anchoColumna);
                    columnaTabla.setMinWidth(90);
                }
                case 3 -> {
                    columnaTabla.setMaxWidth(0);
                    columnaTabla.setMinWidth(0);
                    jTable.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
                    jTable.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
                }
                case 4 -> {
                    columnaTabla.setMaxWidth(0);
                    columnaTabla.setMinWidth(0);
                    jTable.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
                    jTable.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
                }
            }

            columnaTabla.setPreferredWidth(anchoColumna);
        }
    }

    public void showTotal() {
        if (control.getEstadoCajaDia()) {
            jLabel1.setText("Caja:$ " + control.getRecaudadoCajaDia());
        } else {
            jLabel1.setText("Caja Cerrada");
        }
    }

    private void filter() {
        String texto = jTextField2.getText();
        Pattern p = Pattern.compile("^[+*-/¡!¿?()]");
        Matcher m = p.matcher(texto);

        if (m.find()) {
            jTextField2.setText(null);
        } else {
            ArrayList<RowFilter<Object, Object>> andFilters = new ArrayList<>();
            RowFilter<Object, Object> columnFilter = RowFilter.regexFilter(productsType, 4);
            RowFilter<Object, Object> wordFilter = RowFilter.regexFilter(Pattern.compile("(?i)" + texto).toString());

            andFilters.add(columnFilter);
            andFilters.add(wordFilter);

            if (texto.isEmpty() && productsType.equals(TIPO[0].toString())) {
                sorter.setRowFilter(null);
            } else {
                if (texto.isEmpty() && !productsType.equals(TIPO[0].toString())) {
                    try {
                        sorter.setRowFilter(columnFilter);
                        setColumnas();
                    } catch (PatternSyntaxException ex) {
                        JOptionPane.showInternalMessageDialog(this, "Patron de exp incorrecto");
                    }
                } else {
                    if (texto.length() != 0 && productsType.equals(TIPO[0].toString())) {
                        try {
                            sorter.setRowFilter(wordFilter);
                            setColumnas();
                        } catch (PatternSyntaxException ex) {
                            JOptionPane.showInternalMessageDialog(this, "Patron de exp incorrecto");
                        }
                    } else {
                        if (texto.length() != 0 && !productsType.equals(TIPO[0].toString())) {
                            try {
                                sorter.setRowFilter(RowFilter.andFilter(andFilters));
                                setColumnas();
                            } catch (PatternSyntaxException ex) {
                                JOptionPane.showInternalMessageDialog(this, "Patron de exp incorrecto");
                            }
                        }
                    }
                }
            }
        }
    }

    public void refresh() {
        try {
            tablabase.doQuery(Control.SELECTALLARTICULOS);
            tablabase.fireTableDataChanged();
            tablabase.fireTableStructureChanged();
            setColumnas();
        } catch (SQLException sqlex2) {
            JOptionPane.showInternalMessageDialog(this, sqlex2.getMessage(), "Error en la Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void refreshData() {
        try {
            tablabase.doQuery(Control.SELECTALLARTICULOS);
            tablabase.fireTableDataChanged();
            setColumnas();
        } catch (SQLException sqlex2) {
            JOptionPane.showInternalMessageDialog(this, sqlex2.getMessage(), "Error en la Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Articulo getItem(final int row) {
        if (row >= 0) {
            Object[] values = new Object[tablabase.getColumnCount()];

            for (int i = 0;
                    i < values.length;
                    i++) {
                values[i] = jTable.getValueAt(row, i);
            }

            String id = String.valueOf(values[0]);
            String nombre = (String) values[1];
            String info = (String) values[3];
            String tipo = (String) values[4];
            BigDecimal precio = (BigDecimal) (switch ((String) values[4]) {
                case "Monografia", "Biografia", "Mapa Carta", "MiniMapa", "Relieve", "Mapa Mural", "Mapa MediaCartulina" ->
                    control.getPreciosVar(tipo);
                default ->
                    values[2];
            });

            item = new Articulo(id, nombre, precio, info, tipo, 1, precio);
        } else {
            item = new Articulo();
        }

        return item;
    }

    public void deleteItem() {
        item = getItem(filaSeleccionada);
        String info = "Eliminar \nID: " + item.getId() + "\nNombre: " + item.getNombre() + "\nInfo: " + item.getInfo() + "\n";
        String fila = "Fila: " + (filaSeleccionada + 1);

        int action = JOptionPane.showInternalConfirmDialog(this, info + fila, "Eliminar", JOptionPane.YES_NO_OPTION);

        if (action == JOptionPane.YES_OPTION) {
            if (filaSeleccionada >= 0) {
                switch (item.getTipo()) {
                    case "Biografia" ->
                        control.deleteBiografia(item);

                    case "Esquema" ->
                        control.deleteEsquema(item);

                    case "Mapa Carta", "Mapa MediaCartulina", "Mapa Mural", "MiniMapa" ->
                        control.deleteMapa(item);
                    case "Monografia" ->
                        control.deleteMonografia(item);
                    case "Relieve" ->
                        control.deleteRelieve(item);
                    default -> {
                        control.deleteArticulo(item);
                        control.deletePrecioArt(item);
                    }
                }

                filaSeleccionada = -1;
                refreshData();
            } else {
                JOptionPane.showInternalMessageDialog(this, "Seleccione un registro");
            }
        } else {
            refreshData();
        }
    }
}

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IUArticulos extends javax.swing.JInternalFrame
{

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
    private String tipo;

    public final static Object[] TIPO = new Object[]
    {
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

    private IUArticulos()
    {
        filaSeleccionada = -1;
        tipo = "";
    }

    @PostConstruct
    public void init()
    {
        try
        {
            tablabase.init(Control.SELECTALLARTICULOS);
            sorter = new TableRowSorter<>(tablabase);
            initComponents();
            showTotal();
            setColumnas();
        } catch (SQLException sqlex)
        {
            JOptionPane.showMessageDialog(null, "Error 4\n" + sqlex.getMessage(), "Error en la Base de Datos", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
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
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton8 = new javax.swing.JToggleButton();
        jToggleButton9 = new javax.swing.JToggleButton();
        jToggleButton10 = new javax.swing.JToggleButton();
        jToggleButton11 = new javax.swing.JToggleButton();
        jToggleButton12 = new javax.swing.JToggleButton();
        jToggleButton13 = new javax.swing.JToggleButton();
        jToggleButton14 = new javax.swing.JToggleButton();
        jToggleButton15 = new javax.swing.JToggleButton();
        jToggleButton16 = new javax.swing.JToggleButton();
        jToggleButton17 = new javax.swing.JToggleButton();

        jMenuItem8.setText("Agregar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem8);

        jMenuItem7.setText("Modificar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem7);

        jMenuItem5.setText("Eliminar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem5);

        jMenuItem6.setText("Venta Personalizada");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem6);
        jPopupMenu1.add(jSeparator1);

        jMenuItem9.setText("Agregar a la Lista");
        jMenuItem9.setToolTipText("");
        jMenuItem9.setActionCommand("");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem9);

        Cortar.setText("Cortar");
        Cortar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CortarActionPerformed(evt);
            }
        });
        jPopupMenu2.add(Cortar);

        Copiar.setText("Copiar");
        Copiar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CopiarActionPerformed(evt);
            }
        });
        jPopupMenu2.add(Copiar);

        Pegar.setText("Pegar");
        Pegar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                PegarActionPerformed(evt);
            }
        });
        jPopupMenu2.add(Pegar);

        SeleccionarTodo.setText("Seleccionar Todo");
        SeleccionarTodo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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
        setNormalBounds(new java.awt.Rectangle(0, 0, 690, 690));
        setPreferredSize(new java.awt.Dimension(690, 690));
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

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable.setModel(tablabase);
        jTable.setMaximumSize(new java.awt.Dimension(720, 0));
        jTable.setNextFocusableComponent(jTextField2);
        jTable.setRowSorter(sorter);
        jTable.setSelectionBackground(SystemColor.textHighlight.darker());
        jTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable.setShowHorizontalLines(true);
        jTable.setShowVerticalLines(true);
        jTable.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTableMouseClicked(evt);
            }
        });
        jTable.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);
        String solve = "Solve";
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        jTable.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, solve);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Buscar");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 2, true));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setDragEnabled(true);
        jTextField2.setNextFocusableComponent(jTable);
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jTextField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Calibri", 0, 42)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Caja: $0.00");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 2, true));

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/allitems.png"))); // NOI18N
        jToggleButton1.setSelected(true);
        jToggleButton1.setToolTipText("Todo");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/papel.png"))); // NOI18N
        jToggleButton2.setToolTipText("Papeleria");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/informatica.png"))); // NOI18N
        jToggleButton3.setToolTipText("Informatica");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/maps.png"))); // NOI18N
        jToggleButton4.setToolTipText("Monografia");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jToggleButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/maps.png"))); // NOI18N
        jToggleButton5.setToolTipText("Biografia");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jToggleButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/maps.png"))); // NOI18N
        jToggleButton6.setToolTipText("Relieve");
        jToggleButton6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton6ActionPerformed(evt);
            }
        });

        jToggleButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/maps.png"))); // NOI18N
        jToggleButton7.setToolTipText("Mapa Carta");
        jToggleButton7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton7ActionPerformed(evt);
            }
        });

        jToggleButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/maps.png"))); // NOI18N
        jToggleButton8.setToolTipText("Esquema");
        jToggleButton8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton8ActionPerformed(evt);
            }
        });

        jToggleButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/maps.png"))); // NOI18N
        jToggleButton9.setToolTipText("Mapa Media Cartulina");
        jToggleButton9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton9ActionPerformed(evt);
            }
        });

        jToggleButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/maps.png"))); // NOI18N
        jToggleButton10.setToolTipText("Mapa Mural");
        jToggleButton10.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton10ActionPerformed(evt);
            }
        });

        jToggleButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/maps.png"))); // NOI18N
        jToggleButton11.setToolTipText("Mini Mapa");
        jToggleButton11.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton11ActionPerformed(evt);
            }
        });

        jToggleButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/juguete.png"))); // NOI18N
        jToggleButton12.setToolTipText("Juguetes");
        jToggleButton12.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton12ActionPerformed(evt);
            }
        });

        jToggleButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cosme.png"))); // NOI18N
        jToggleButton13.setToolTipText("Cosmeticos");
        jToggleButton13.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton13ActionPerformed(evt);
            }
        });

        jToggleButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/regalo.png"))); // NOI18N
        jToggleButton14.setToolTipText("Regalos");
        jToggleButton14.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton14ActionPerformed(evt);
            }
        });

        jToggleButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/merceria.png"))); // NOI18N
        jToggleButton15.setToolTipText("Merceria");
        jToggleButton15.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton15ActionPerformed(evt);
            }
        });

        jToggleButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dulce.png"))); // NOI18N
        jToggleButton16.setToolTipText("Dulces");
        jToggleButton16.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton16ActionPerformed(evt);
            }
        });

        jToggleButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/otros.png"))); // NOI18N
        jToggleButton17.setToolTipText("Otros");
        jToggleButton17.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jToggleButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2))
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
                                .addComponent(jToggleButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addComponent(jToggleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addComponent(jToggleButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addComponent(jToggleButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addComponent(jToggleButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addComponent(jToggleButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jToggleButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addComponent(jToggleButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addComponent(jToggleButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addComponent(jToggleButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addComponent(jToggleButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                    .addComponent(jToggleButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // Tabla - ClickTabla
        int fila = jTable.rowAtPoint(evt.getPoint());
        int columna = jTable.columnAtPoint(evt.getPoint());

        if ((fila > -1) && (columna > -1))
        {
            filaSeleccionada = fila;

            if (evt.getButton() == MouseEvent.BUTTON3)
            {
                item = getItem(filaSeleccionada);
                jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
                jTable.setRowSelectionInterval(fila, fila);
            }
            if (evt.getClickCount() == 2 && evt.getButton() != MouseEvent.BUTTON3)
            {
                item = getItem(filaSeleccionada);
                desktop.showVentas(false);
                ventas.addItem(item);
            }

            if (columna == 3 && evt.getButton() != MouseEvent.BUTTON3)
            {
                item = getItem(filaSeleccionada);
                String msg = "ID: " + item.getId()
                        + "\nNombre: " + item.getNombre()
                        + "\nDescripción: " + item.getInfo()
                        + "\nPrecio: $" + item.getPrecio();
                JOptionPane.showInternalMessageDialog(this, msg, item.getNombre(), JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void jTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableKeyPressed
        // Tabla - Teclado
        filaSeleccionada = jTable.getSelectedRow();

        if (evt.getKeyChar() == KeyEvent.VK_ENTER)
        {
            if (filaSeleccionada >= 0)
            {
                item = getItem(filaSeleccionada);
                //IUDesktop.showVentas(false);
                ventas.addItem(item);
            } else
            {
                JOptionPane.showInternalMessageDialog(this, "Seleccione un registro");
            }
        }
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE)
        {
            jTextField2.requestFocus();
            jTextField2.setText(null);
        }
        if (evt.getKeyChar() == KeyEvent.VK_DELETE)
        {
            if (filaSeleccionada >= 0)
            {
                deleteItem();
            }
        }
        if (evt.getKeyChar() == KeyEvent.VK_5)
        {
            refresh();
        }
    }//GEN-LAST:event_jTableKeyPressed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        // PopupText
        if (evt.getButton() == MouseEvent.BUTTON3)
        {
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
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE)
        {
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
        editar.setUpdatePane(item);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // PopupTabla - Eliminar
        deleteItem();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // PopupTabla - Venta Personalizada

    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
        jPanel3.setBackground(new Color(255, 153, 0));//[255,153,0]
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

        if (jToggleButton1.isSelected())
        {
            tipo = TIPO[0].toString();
            jToggleButton1.setSelected(true);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            jToggleButton8.setSelected(false);
            jToggleButton9.setSelected(false);
            jToggleButton10.setSelected(false);
            jToggleButton11.setSelected(false);
            jToggleButton12.setSelected(false);
            jToggleButton13.setSelected(false);
            jToggleButton14.setSelected(false);
            jToggleButton15.setSelected(false);
            jToggleButton16.setSelected(false);
            jToggleButton17.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton2ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        jToggleButton2.setSelected(true);

        if (jToggleButton2.isSelected())
        {
            tipo = TIPO[1].toString();
            jToggleButton1.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            jToggleButton8.setSelected(false);
            jToggleButton9.setSelected(false);
            jToggleButton10.setSelected(false);
            jToggleButton11.setSelected(false);
            jToggleButton12.setSelected(false);
            jToggleButton13.setSelected(false);
            jToggleButton14.setSelected(false);
            jToggleButton15.setSelected(false);
            jToggleButton16.setSelected(false);
            jToggleButton17.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton3ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
        jToggleButton3.setSelected(true);

        if (jToggleButton3.isSelected())
        {
            tipo = TIPO[2].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            jToggleButton8.setSelected(false);
            jToggleButton9.setSelected(false);
            jToggleButton10.setSelected(false);
            jToggleButton11.setSelected(false);
            jToggleButton12.setSelected(false);
            jToggleButton13.setSelected(false);
            jToggleButton14.setSelected(false);
            jToggleButton15.setSelected(false);
            jToggleButton16.setSelected(false);
            jToggleButton17.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton4ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:
        jToggleButton4.setSelected(true);

        if (jToggleButton4.isSelected())
        {
            tipo = TIPO[3].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            jToggleButton8.setSelected(false);
            jToggleButton9.setSelected(false);
            jToggleButton10.setSelected(false);
            jToggleButton11.setSelected(false);
            jToggleButton12.setSelected(false);
            jToggleButton13.setSelected(false);
            jToggleButton14.setSelected(false);
            jToggleButton15.setSelected(false);
            jToggleButton16.setSelected(false);
            jToggleButton17.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton5ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton5ActionPerformed
        // TODO add your handling code here:
        jToggleButton5.setSelected(true);

        if (jToggleButton5.isSelected())
        {
            tipo = TIPO[4].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            jToggleButton8.setSelected(false);
            jToggleButton9.setSelected(false);
            jToggleButton10.setSelected(false);
            jToggleButton11.setSelected(false);
            jToggleButton12.setSelected(false);
            jToggleButton13.setSelected(false);
            jToggleButton14.setSelected(false);
            jToggleButton15.setSelected(false);
            jToggleButton16.setSelected(false);
            jToggleButton17.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton6ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton6ActionPerformed
        // TODO add your handling code here:
        jToggleButton6.setSelected(true);

        if (jToggleButton6.isSelected())
        {
            tipo = TIPO[5].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton7.setSelected(false);
            jToggleButton8.setSelected(false);
            jToggleButton9.setSelected(false);
            jToggleButton10.setSelected(false);
            jToggleButton11.setSelected(false);
            jToggleButton12.setSelected(false);
            jToggleButton13.setSelected(false);
            jToggleButton14.setSelected(false);
            jToggleButton15.setSelected(false);
            jToggleButton16.setSelected(false);
            jToggleButton17.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton7ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton7ActionPerformed
        // TODO add your handling code here:
        jToggleButton7.setSelected(true);

        if (jToggleButton7.isSelected())
        {
            tipo = TIPO[6].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton8.setSelected(false);
            jToggleButton9.setSelected(false);
            jToggleButton10.setSelected(false);
            jToggleButton11.setSelected(false);
            jToggleButton12.setSelected(false);
            jToggleButton13.setSelected(false);
            jToggleButton14.setSelected(false);
            jToggleButton15.setSelected(false);
            jToggleButton16.setSelected(false);
            jToggleButton17.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton7ActionPerformed

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton8ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton8ActionPerformed
        // TODO add your handling code here:
        jToggleButton8.setSelected(true);

        if (jToggleButton8.isSelected())
        {
            tipo = TIPO[7].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            jToggleButton9.setSelected(false);
            jToggleButton10.setSelected(false);
            jToggleButton11.setSelected(false);
            jToggleButton12.setSelected(false);
            jToggleButton13.setSelected(false);
            jToggleButton14.setSelected(false);
            jToggleButton15.setSelected(false);
            jToggleButton16.setSelected(false);
            jToggleButton17.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton8ActionPerformed

    private void jToggleButton9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton9ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton9ActionPerformed
        // TODO add your handling code here:
        jToggleButton9.setSelected(true);

        if (jToggleButton9.isSelected())
        {
            tipo = TIPO[8].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            jToggleButton8.setSelected(false);
            jToggleButton10.setSelected(false);
            jToggleButton11.setSelected(false);
            jToggleButton12.setSelected(false);
            jToggleButton13.setSelected(false);
            jToggleButton14.setSelected(false);
            jToggleButton15.setSelected(false);
            jToggleButton16.setSelected(false);
            jToggleButton17.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton9ActionPerformed

    private void jToggleButton10ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton10ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton10ActionPerformed
        // TODO add your handling code here:
        jToggleButton10.setSelected(true);

        if (jToggleButton10.isSelected())
        {
            tipo = TIPO[9].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            jToggleButton8.setSelected(false);
            jToggleButton9.setSelected(false);
            jToggleButton11.setSelected(false);
            jToggleButton12.setSelected(false);
            jToggleButton13.setSelected(false);
            jToggleButton14.setSelected(false);
            jToggleButton15.setSelected(false);
            jToggleButton16.setSelected(false);
            jToggleButton17.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton10ActionPerformed

    private void jToggleButton11ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton11ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton11ActionPerformed
        // TODO add your handling code here:
        jToggleButton11.setSelected(true);

        if (jToggleButton11.isSelected())
        {
            tipo = TIPO[10].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            jToggleButton8.setSelected(false);
            jToggleButton9.setSelected(false);
            jToggleButton10.setSelected(false);
            jToggleButton12.setSelected(false);
            jToggleButton13.setSelected(false);
            jToggleButton14.setSelected(false);
            jToggleButton15.setSelected(false);
            jToggleButton16.setSelected(false);
            jToggleButton17.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton11ActionPerformed

    private void jToggleButton12ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton12ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton12ActionPerformed
        // TODO add your handling code here:
        jToggleButton12.setSelected(true);

        if (jToggleButton12.isSelected())
        {
            tipo = TIPO[11].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            jToggleButton8.setSelected(false);
            jToggleButton9.setSelected(false);
            jToggleButton10.setSelected(false);
            jToggleButton11.setSelected(false);
            jToggleButton13.setSelected(false);
            jToggleButton14.setSelected(false);
            jToggleButton15.setSelected(false);
            jToggleButton16.setSelected(false);
            jToggleButton17.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton12ActionPerformed

    private void jToggleButton13ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton13ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton13ActionPerformed
        // TODO add your handling code here:
        jToggleButton13.setSelected(true);

        if (jToggleButton13.isSelected())
        {
            tipo = TIPO[12].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            jToggleButton8.setSelected(false);
            jToggleButton9.setSelected(false);
            jToggleButton10.setSelected(false);
            jToggleButton11.setSelected(false);
            jToggleButton12.setSelected(false);
            jToggleButton14.setSelected(false);
            jToggleButton15.setSelected(false);
            jToggleButton16.setSelected(false);
            jToggleButton17.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton13ActionPerformed

    private void jToggleButton14ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton14ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton14ActionPerformed
        // TODO add your handling code here:
        jToggleButton14.setSelected(true);

        if (jToggleButton14.isSelected())
        {
            tipo = TIPO[13].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            jToggleButton8.setSelected(false);
            jToggleButton9.setSelected(false);
            jToggleButton10.setSelected(false);
            jToggleButton11.setSelected(false);
            jToggleButton12.setSelected(false);
            jToggleButton13.setSelected(false);
            jToggleButton15.setSelected(false);
            jToggleButton16.setSelected(false);
            jToggleButton17.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton14ActionPerformed

    private void jToggleButton15ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton15ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton15ActionPerformed
        // TODO add your handling code here:
        jToggleButton15.setSelected(true);

        if (jToggleButton15.isSelected())
        {
            tipo = TIPO[14].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            jToggleButton8.setSelected(false);
            jToggleButton9.setSelected(false);
            jToggleButton10.setSelected(false);
            jToggleButton11.setSelected(false);
            jToggleButton12.setSelected(false);
            jToggleButton13.setSelected(false);
            jToggleButton14.setSelected(false);
            jToggleButton16.setSelected(false);
            jToggleButton17.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton15ActionPerformed

    private void jToggleButton16ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton16ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton16ActionPerformed
        // TODO add your handling code here:
        jToggleButton16.setSelected(true);

        if (jToggleButton16.isSelected())
        {
            tipo = TIPO[15].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            jToggleButton8.setSelected(false);
            jToggleButton9.setSelected(false);
            jToggleButton10.setSelected(false);
            jToggleButton11.setSelected(false);
            jToggleButton12.setSelected(false);
            jToggleButton13.setSelected(false);
            jToggleButton14.setSelected(false);
            jToggleButton15.setSelected(false);
            jToggleButton17.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton16ActionPerformed

    private void jToggleButton17ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButton17ActionPerformed
    {//GEN-HEADEREND:event_jToggleButton17ActionPerformed
        // TODO add your handling code here:
        jToggleButton17.setSelected(true);

        if (jToggleButton17.isSelected())
        {
            tipo = TIPO[16].toString();
            jToggleButton1.setSelected(false);
            jToggleButton2.setSelected(false);
            jToggleButton3.setSelected(false);
            jToggleButton4.setSelected(false);
            jToggleButton5.setSelected(false);
            jToggleButton6.setSelected(false);
            jToggleButton7.setSelected(false);
            jToggleButton8.setSelected(false);
            jToggleButton9.setSelected(false);
            jToggleButton10.setSelected(false);
            jToggleButton11.setSelected(false);
            jToggleButton12.setSelected(false);
            jToggleButton13.setSelected(false);
            jToggleButton14.setSelected(false);
            jToggleButton15.setSelected(false);
            jToggleButton16.setSelected(false);
            filter();
        }
    }//GEN-LAST:event_jToggleButton17ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Copiar;
    private javax.swing.JMenuItem Cortar;
    private javax.swing.JMenuItem Pegar;
    private javax.swing.JMenuItem SeleccionarTodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton10;
    private javax.swing.JToggleButton jToggleButton11;
    private javax.swing.JToggleButton jToggleButton12;
    private javax.swing.JToggleButton jToggleButton13;
    private javax.swing.JToggleButton jToggleButton14;
    private javax.swing.JToggleButton jToggleButton15;
    private javax.swing.JToggleButton jToggleButton16;
    private javax.swing.JToggleButton jToggleButton17;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JToggleButton jToggleButton9;
    // End of variables declaration//GEN-END:variables

    private void setColumnas()
    {
        int anchoColumna = 0;
        TableColumnModel modeloColumna = jTable.getColumnModel();
        TableColumn columnaTabla;

        for (int i = 0; i < jTable.getColumnCount(); i++)
        {
            columnaTabla = modeloColumna.getColumn(i);

            switch (i)
            {
                case 0:
                    anchoColumna = 90;
                    columnaTabla.setMaxWidth(120);
                    columnaTabla.setMinWidth(90);
                    break;
                case 1:
                    anchoColumna = 290;
                    columnaTabla.setMinWidth(200);
                    break;
                case 2:
                    anchoColumna = 60;
                    columnaTabla.setMaxWidth(60);
                    columnaTabla.setMinWidth(55);
                    break;
                case 3:
                    anchoColumna = 255;
                    columnaTabla.setMinWidth(100);
                    break;
                case 4:
                    columnaTabla.setMaxWidth(0);
                    columnaTabla.setMinWidth(0);
                    jTable.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
                    jTable.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
                    break;
            }

            columnaTabla.setPreferredWidth(anchoColumna);
        }
    }

    public void showTotal()
    {
        if (control.getEstadoCajaDia())
        {
            jLabel1.setText("Caja:$ " + control.getRecaudadoCajaDia());
        } else
        {
            jLabel1.setText("Caja Cerrada");
        }
    }

    private void filter()
    {
        String texto = jTextField2.getText();
        Pattern p = Pattern.compile("^[+*-/¡!¿?()]");
        Matcher m = p.matcher(texto);

        if (m.find())
        {
            jTextField2.setText(null);
        } else
        {
            ArrayList<RowFilter<Object, Object>> andFilters = new ArrayList<>();
            RowFilter<Object, Object> columnFilter = RowFilter.regexFilter(tipo, 4);
            RowFilter<Object, Object> wordFilter = RowFilter.regexFilter(Pattern.compile("(?i)" + texto).toString());

            andFilters.add(columnFilter);
            andFilters.add(wordFilter);

            if (texto.isEmpty() && tipo.equals(TIPO[0].toString()))
            {
                sorter.setRowFilter(null);
            } else if (texto.isEmpty() && !tipo.equals(TIPO[0].toString()))
            {
                try
                {
                    sorter.setRowFilter(columnFilter);
                    setColumnas();
                } catch (PatternSyntaxException ex)
                {
                    JOptionPane.showInternalMessageDialog(this, "Patron de exp incorrecto");
                }
            } else if (texto.length() != 0 && tipo.equals(TIPO[0].toString()))
            {
                try
                {
                    sorter.setRowFilter(wordFilter);
                    setColumnas();
                } catch (PatternSyntaxException ex)
                {
                    JOptionPane.showInternalMessageDialog(this, "Patron de exp incorrecto");
                }
            } else if (texto.length() != 0 && !tipo.equals(TIPO[0].toString()))
            {
                try
                {
                    sorter.setRowFilter(RowFilter.andFilter(andFilters));
                    setColumnas();
                } catch (PatternSyntaxException ex)
                {
                    JOptionPane.showInternalMessageDialog(this, "Patron de exp incorrecto");
                }
            }
        }
    }

    public void refresh()
    {
        try
        {
            tablabase.Consulta(Control.SELECTALLARTICULOS);
            tablabase.fireTableDataChanged();
            tablabase.fireTableStructureChanged();
            setColumnas();
        } catch (SQLException sqlex2)
        {
            JOptionPane.showInternalMessageDialog(this, sqlex2.getMessage(), "Error en la Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void refreshData()
    {
        try
        {
            tablabase.Consulta(Control.SELECTALLARTICULOS);
            tablabase.fireTableDataChanged();
            setColumnas();
        } catch (SQLException sqlex2)
        {
            JOptionPane.showInternalMessageDialog(this, sqlex2.getMessage(), "Error en la Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Articulo getItem(int row)
    {
        Object[] values = new Object[tablabase.getColumnCount()];

        for (int i = 0; i < values.length; i++)
        {
            values[i] = jTable.getValueAt(row, i);
        }

        String id = (String) values[0];
        String nombre = (String) values[1];
        String info = (String) values[3];
        String tipo = (String) values[4];
        BigDecimal precio = null;

//        if (ventas.jTButton.isSelected())
//        {
//            switch ((String) values[4])
//            {
//                case "Monografia":
//                case "Biografia":
//                case "Mapa Carta":
//                case "MiniMapa":
//                case "Relieve":
//                case "Mapa Mural":
//                case "Mapa MediaCartulina":
//                    precio = control.getPreciosVar(tipo);
//                    break;
//
//                default:
//                    precio = control.getPrecioDescuento(id);
//            }
//        } else
//        {
//            switch ((String) values[4])
//            {
//                case "Monografia":
//                case "Biografia":
//                case "Mapa Carta":
//                case "MiniMapa":
//                case "Relieve":
//                case "Mapa Mural":
//                case "Mapa MediaCartulina":
//                    precio = control.getPreciosVar(tipo);
//                    break;
//
//                default:
//                    precio = (BigDecimal) values[2];
//            }
//        }
        switch ((String) values[4])
        {
            case "Monografia":
            case "Biografia":
            case "Mapa Carta":
            case "MiniMapa":
            case "Relieve":
            case "Mapa Mural":
            case "Mapa MediaCartulina":
                precio = control.getPreciosVar(tipo);
                break;

            default:
                precio = (BigDecimal) values[2];
        }

        return item = new Articulo(id, nombre, precio, info, tipo, 1, precio);
    }

    public void deleteItem()
    {
        item = getItem(filaSeleccionada);
        String info = "Eliminar \nID: " + item.getId() + "\nNombre: " + item.getNombre() + "\nInfo: " + item.getInfo() + "\n";
        String fila = "Fila: " + (filaSeleccionada + 1);

        int action = JOptionPane.showInternalConfirmDialog(this, info + fila, "Eliminar", JOptionPane.YES_NO_OPTION);

        if (action == JOptionPane.YES_OPTION)
        {
            if (filaSeleccionada >= 0)
            {
                switch (item.getTipo())
                {
                    case "Biografia":
                        control.deleteBiografia(item);
                        break;

                    case "Esquema":
                        control.deleteEsquema(item);
                        break;

                    case "Mapa Carta":
                    case "Mapa MediaCartulina":
                    case "Mapa Mural":
                    case "MiniMapa":
                        control.deleteMapa(item);
                        break;

                    case "Monografia":
                        control.deleteMonografia(item);
                        break;

                    case "Relieve":
                        control.deleteRelieve(item);
                        break;

                    default:
                        control.deleteArticulo(item);
                        control.deletePrecioArt(item);
                }

                filaSeleccionada = -1;
                refreshData();
            } else
            {
                JOptionPane.showInternalMessageDialog(this, "Seleccione un registro");
            }
        } else
        {
            refreshData();
        }
    }
}

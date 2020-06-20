package com.asadel.ventas.controllers;

import com.asadel.ventas.Asadel;
import com.asadel.ventas.services.Articulo;
import com.asadel.ventas.services.ArticulosTableModel;
import com.asadel.ventas.services.Control;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IUCancelar extends javax.swing.JInternalFrame
{

    @Autowired
    public IUArticulos articulos;
    @Autowired
    private Control control;

    private Articulo item;
    private String id;
    private ArticulosTableModel lista;
    private int filaSeleccionada;
    private String select;
    public boolean exist = true;

    public IUCancelar()
    {
        //id = l;

        select = "SELECT av.idArticuloVendido as ID, av.Nombre, av.Cantidad, av.Prec, av.Subtotal "
                + "FROM articuloVendido av "
                + "JOIN lista l "
                + "ON av.lista_idLista = l.idLista "
                + "WHERE idLista = '" + id + "'";

//        try
//        {
//            lista = new ArticulosTableModel(select);
//            filaSeleccionada = -1;
//            initComponents();            
//            setColumnas();
//            showTotal();
//            setLocation(200, 100);
//            
//            if (jTable1.getRowCount() == 0)
//            {
//                JOptionPane.showInternalMessageDialog(IUDesktop.desktop,"La lista no existe", "Error en la lista", 2);
//                exist = false;
//            }
//        }
//        catch (SQLException ex)
//        {
//            JOptionPane.showInternalMessageDialog(IUDesktop.desktop, ex.getMessage(), "Error en la lista", 2);
//            doDefaultCloseAction();
//        }
    }

    public void init(String l)
    {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Cancelar venta");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/addarticulo2.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(700, 400));
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
                formInternalFrameOpened(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menos.png"))); // NOI18N
        jButton3.setText("Item");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jButton4.setText("Remover item");
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/canceldocument1.png"))); // NOI18N
        jButton5.setText("Cancelar lista");
        jButton5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton5ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTable1.setModel(lista);
        jTable1.setRowHeight(23);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Total= $");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 2, true));

        jButton6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mas.png"))); // NOI18N
        jButton6.setText("Item");
        jButton6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
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

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt)//GEN-FIRST:event_formInternalFrameOpened
    {//GEN-HEADEREND:event_formInternalFrameOpened
        // Ventana abierta
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt)//GEN-FIRST:event_formInternalFrameActivated
    {//GEN-HEADEREND:event_formInternalFrameActivated
        // Ventana activada
        jPanel1.setBackground(Asadel.ACTIVE_COLOR);
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameDeactivated(javax.swing.event.InternalFrameEvent evt)//GEN-FIRST:event_formInternalFrameDeactivated
    {//GEN-HEADEREND:event_formInternalFrameDeactivated
        // Ventana desactivada
        jPanel1.setBackground(Color.getColor(System.getProperty("Panel.background")));
    }//GEN-LAST:event_formInternalFrameDeactivated

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt)//GEN-FIRST:event_formInternalFrameClosed
    {//GEN-HEADEREND:event_formInternalFrameClosed
        // Ventana cerrada

    }//GEN-LAST:event_formInternalFrameClosed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        // Quitar item
        if (filaSeleccionada >= 0 && lista.getRowCount() != 0)
        {
            removeItem();
        }
        else
        {
            JOptionPane.showInternalMessageDialog(this, "Seleccione un registro", "Error", 2);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
    {//GEN-HEADEREND:event_jButton4ActionPerformed
        // Remover item
        if (filaSeleccionada >= 0 && lista.getRowCount() != 0)
        {
            deleteItem();
        }
        else
        {
            JOptionPane.showInternalMessageDialog(this, "Seleccione un registro", "Error", 2);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton5ActionPerformed
    {//GEN-HEADEREND:event_jButton5ActionPerformed
        // Cancelar lista completa
        if (jTable1.getRowCount() != 0)
        {
            control.cancelarLista(id);
            refresh(filaSeleccionada);
            articulos.showTotal();
        }
        else
        {
            JOptionPane.showInternalMessageDialog(null, "No hay lista que cancelar", "Error", 2);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTable1KeyPressed
    {//GEN-HEADEREND:event_jTable1KeyPressed
        // Tabla - KeyPressed
        filaSeleccionada = jTable1.getSelectedRow();

        if (evt.getKeyCode() == KeyEvent.VK_PLUS)
        {
            if (filaSeleccionada >= 0 && lista.getRowCount() != 0)
            {
                addItem();
            }
            else
            {
                JOptionPane.showInternalMessageDialog(this, "Seleccione un registro");
            }
        }
        if (evt.getKeyChar() == KeyEvent.VK_MINUS)
        {
            if (filaSeleccionada >= 0 && lista.getRowCount() != 0)
            {
                removeItem();
            }
            else
            {
                JOptionPane.showInternalMessageDialog(this, "Seleccione un registro");
            }
        }
        if (evt.getKeyChar() == KeyEvent.VK_DELETE && lista.getRowCount() != 0)
        {
            if (filaSeleccionada >= 0)
            {
                item = getItem(filaSeleccionada);
                deleteItem();
            }
            else
            {
                JOptionPane.showInternalMessageDialog(this, "Seleccione un registro");
            }
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTable1MouseClicked
    {//GEN-HEADEREND:event_jTable1MouseClicked
        // Tabla - Click
        int fila = jTable1.rowAtPoint(evt.getPoint());
        int columna = jTable1.columnAtPoint(evt.getPoint());

        if ((fila > -1) && (columna > -1))
        {
            filaSeleccionada = fila;
            jTable1.setRowSelectionInterval(fila, fila);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton6ActionPerformed
    {//GEN-HEADEREND:event_jButton6ActionPerformed
        // Agregar item
        if (filaSeleccionada >= 0 && lista.getRowCount() != 0)
        {
            addItem();
        }
        else
        {
            JOptionPane.showInternalMessageDialog(this, "Seleccione un registro", "Error", 2);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void showTotal()
    {
        jLabel1.setText("Total= $ " + control.getTotalFactura(id) + "  ");
    }

    public CellEditorListener Cell()
    {
        CellEditorListener celda = new CellEditorListener()
        {
            @Override
            public void editingStopped(ChangeEvent e)
            {
                String num;

                if (jTable1.getCellEditor(filaSeleccionada, 2).getCellEditorValue().toString().isEmpty())
                {
                    return;
                }
                else
                {
                    num = jTable1.getCellEditor(filaSeleccionada, 2).getCellEditorValue().toString();
                }

                item = getItem(filaSeleccionada);
                int cantidad = Integer.parseInt(num);

                if (cantidad == 0)
                {
                    cantidad = 1;
                }

                item.setCantidad(cantidad);
                control.updateItemCancelacion(item, id, 2);
                refresh(filaSeleccionada);
                articulos.showTotal();
            }

            @Override
            public void editingCanceled(ChangeEvent e)
            {
                //throw new UnsupportedOperationException("Not supported yet.");
            }
        };

        return celda;
    }

    public Articulo getItem(int row)
    {
        Object[] values = new Object[lista.getColumnCount()];

        for (int i = 0;
                i < values.length;
                i++)
        {
            values[i] = jTable1.getValueAt(row, i);
        }

        String id = values[0].toString();
        String nombre = (String) values[1];
        int cantidad = Integer.parseInt(values[2].toString());
        BigDecimal precio = (BigDecimal) values[3];
        BigDecimal subtotal = (BigDecimal) values[4];

        return item = new Articulo(id, nombre, precio, "", "", cantidad, subtotal);
    }

    public void refresh(int fila)
    {
        try
        {
            lista.Consulta(select);
            lista.fireTableDataChanged();
            lista.fireTableStructureChanged();
            showTotal();
            setColumnas();

            if (fila >= 0)
            {
                try
                {
                    if (lista.getRowCount() > 0)
                    {
                        jTable1.setRowSelectionInterval(fila, fila);
                    }
                }
                catch (IllegalArgumentException e)
                {
                }
            }

        }
        catch (SQLException sqlex2)
        {
            JOptionPane.showInternalMessageDialog(this, sqlex2.getMessage(), "Error en la Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setColumnas()
    {
        int anchoColumna = 0;
        TableColumnModel modeloColumna = jTable1.getColumnModel();
        TableColumn columnaTabla;
        CellRender render = new CellRender();

        for (int i = 0;
                i < jTable1.getColumnCount();
                i++)
        {
            columnaTabla = modeloColumna.getColumn(i);

            switch (i)
            {
                case 0:
                    anchoColumna = 80;
                    columnaTabla.setMinWidth(80);
                    columnaTabla.setMaxWidth(200);
                    break;
                case 1:
                    anchoColumna = 240;
                    columnaTabla.setMinWidth(100);
                    columnaTabla.setMaxWidth(800);
                    break;
                case 2:
                    anchoColumna = 60;
                    columnaTabla.setMinWidth(55);
                    columnaTabla.setMaxWidth(80);
                    jTable1.getColumnModel().getColumn(2).setCellEditor(new EditorText());
                    jTable1.getCellEditor(0, 2).addCellEditorListener(Cell());
                    break;
                case 3:
                    anchoColumna = 60;
                    columnaTabla.setMinWidth(55);
                    columnaTabla.setMaxWidth(80);
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

    public void addItem()
    {
        item = getItem(filaSeleccionada);
        control.updateItemCancelacion(item, id, 1);
        refresh(filaSeleccionada);
        articulos.showTotal();
    }

    public void removeItem()
    {
        item = getItem(filaSeleccionada);
        control.updateItemCancelacion(item, id, 0);
        refresh(filaSeleccionada);
        articulos.showTotal();
    }

    public void deleteItem()
    {
        item = getItem(filaSeleccionada);
        control.deleteItemCancelacion(item, id);
        filaSeleccionada = -1;
        refresh(filaSeleccionada);
        articulos.showTotal();
    }
}

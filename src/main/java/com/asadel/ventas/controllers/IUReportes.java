package com.asadel.ventas.controllers;

import com.asadel.ventas.Asadel;
import com.asadel.ventas.services.Reporte;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import net.sf.jasperreports.swing.JRViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IUReportes extends javax.swing.JInternalFrame {

    @Autowired
    private IUFecha dialog;
    @Autowired
    public Reporte reporte;
    @Autowired
    public IUFecha fecha;
    @Autowired
    public IUFechaMes fechaMes;

    public JRViewer visor;

    public IUReportes() {
    }

    @PostConstruct
    public void config() {
        initComponents();
        visor = new JRViewer(reporte.generarReporteDiaVentas(), null);
        visor.setVisible(true);
        jPanel2.add(visor, BorderLayout.CENTER);
    }

    public void init(boolean fin) {
        visor.clear();
        visor = new JRViewer(reporte.generarReporteDiaVentas(), null);
        visor.setVisible(true);
        jPanel2.add(visor, BorderLayout.CENTER);

        if (fin) {
            visor.setZoomRatio(1.0f);
            jSplitPane1.setDividerLocation(1);
        } else {
            visor.setZoomRatio(0.70f);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();

        setClosable(true);
        setMaximizable(true);
        setTitle("Reportes");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reportes.png"))); // NOI18N
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

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setContinuousLayout(true);
        jSplitPane1.setOneTouchExpandable(true);

        jPanel1.setMaximumSize(new java.awt.Dimension(260, 32767));
        jPanel1.setMinimumSize(new java.awt.Dimension(230, 100));

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Ventas hoy", "Articulos vendidos hoy", "Ventas del mes", "Buscar ventas mensual", "Buscar ventas", "Buscar articulos", "Buscar factura" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setMinimumSize(new java.awt.Dimension(600, 100));
        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );

        jPanel2.setLayout(new java.awt.BorderLayout());

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // Ventana Cerrada
        //visor.clear();
    }//GEN-LAST:event_formInternalFrameClosed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // Seleccion Lista
        switch (jList1.getSelectedIndex()) {
            case 0:
                visor.clear();
                jPanel2.removeAll();
                visor = new JRViewer(reporte.generarReporteDiaVentas(), null);
                visor.setVisible(true);
                visor.setZoomRatio(0.70f);
                jPanel2.add(visor);
                jPanel2.updateUI();
                break;
            case 1:
                visor.clear();
                jPanel2.removeAll();
                visor = new JRViewer(reporte.generarReporteDiaArticulos(), null);
                visor.setVisible(true);
                visor.setZoomRatio(0.70f);
                jPanel2.add(visor, BorderLayout.CENTER);
                jPanel2.updateUI();
                break;
            case 2:
                visor.clear();
                jPanel2.removeAll();
                visor = new JRViewer(reporte.generarReporteMesVentas(), null);
                visor.setVisible(true);
                visor.setZoomRatio(0.70f);
                jPanel2.add(visor, BorderLayout.CENTER);
                jPanel2.updateUI();
                break;
            case 3:
                fechaMes.init(true);

                java.awt.EventQueue.invokeLater(()
                        -> {
                    fechaMes.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            fechaMes.reset();
                        }
                    });

                    fechaMes.setVisible(true);
                });
                break;
            case 4:
                if (fecha == null) {
//                    fecha = new IUFecha((Frame) IUDesktop.desktop.getParent().getParent().getParent().getParent(), true, 0);
//                    fecha.invoke(0);

                    java.awt.EventQueue.invokeLater(()
                            -> {
                        dialog.init(true, 0);
                        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                            @Override
                            public void windowClosing(java.awt.event.WindowEvent e) {
                                //IUDesktop.reportes.fecha = null;
                            }
                        });

                        dialog.setVisible(true);
                    });
                }
                break;
            case 5:
                if (fecha == null) {
//                    fecha = new IUFecha((Frame) IUDesktop.desktop.getParent().getParent().getParent().getParent(), true, 1);
//                    fecha.invoke(1);
                    java.awt.EventQueue.invokeLater(()
                            -> {
                        dialog.init(true, 1);
                        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                            @Override
                            public void windowClosing(java.awt.event.WindowEvent e) {
                                //IUDesktop.reportes.fecha = null;
                            }
                        });

                        dialog.setVisible(true);
                    });
                }
                break;
            case 6:
                String id = JOptionPane.showInternalInputDialog(this, "ID de la Factura: ", "Factura", JOptionPane.INFORMATION_MESSAGE);

                if (id == null || id.isEmpty()) {
                    return;
                }

                visor.clear();
                jPanel2.removeAll();
                visor = new JRViewer(reporte.searchFactura(id));
                visor.setVisible(true);
                visor.setZoomRatio(0.70f);
                jPanel2.add(visor, BorderLayout.CENTER);
                jPanel2.updateUI();
                break;
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // Ventana Activa
        jPanel1.setBackground(Asadel.ACTIVE_COLOR);
        jPanel2.setBackground(Asadel.ACTIVE_COLOR);
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeactivated
        // Ventana Desactivada
        jPanel1.setBackground(Color.getColor(System.getProperty("Panel.background")));
        jPanel2.setBackground(Color.getColor(System.getProperty("Panel.background")));
    }//GEN-LAST:event_formInternalFrameDeactivated

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    protected javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables

}

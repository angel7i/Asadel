package com.asadel.ventas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import net.sf.jasperreports.swing.JRViewer;

public class IUFecha extends javax.swing.JDialog
{
    private String inicio;
    private String fin;
    private BigDecimal total;
    private int opt;
    
    public IUFecha(java.awt.Frame parent, boolean modal, int opt) 
    {
        super(parent, modal);
        setDefaultLookAndFeelDecorated(true);
        initComponents();        
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                System.gc();
                dispose();
            }
        });
        
        setLocationRelativeTo(this);
        this.opt = opt;
        jDate1.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jDate1 = new com.toedter.calendar.JDateChooser(new Date());
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDate2 = new com.toedter.calendar.JDateChooser(new Date());
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowActivated(java.awt.event.WindowEvent evt)
            {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt)
            {
                formWindowClosed(evt);
            }
        });

        jDate1.getJCalendar().setNullDateButtonVisible(true);
        jDate1.getJCalendar().setTodayButtonVisible(true);
        jDate1.setNextFocusableComponent(jDate2);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fecha Inicial");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 255), 2, true));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Fecha Final");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 255), 2, true));

        jDate2.getJCalendar().setNullDateButtonVisible(true);
        jDate2.getJCalendar().setTodayButtonVisible(true);
        jDate2.setNextFocusableComponent(jButton1);

        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.setNextFocusableComponent(jButton2);
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setNextFocusableComponent(jDate1);
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDate2, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(jDate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDate1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDate2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // Ventana Activa
    }//GEN-LAST:event_formWindowActivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Buscar Reporte
        switch (opt)
        {
            case 0:
                getVentasFechas();
                break;
            case 1:
                getArticulosFechas();
                break;
        }
        
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Cancelar
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // Cerrar Ventana
        IUMain.reportes.fecha = null;
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDate1;
    private com.toedter.calendar.JDateChooser jDate2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    public void getVentasFechas()
    {
        if (jDate1.getDate() == null || jDate2.getDate() == null)
            dispose();
        else
        {
            SimpleDateFormat fecha = new SimpleDateFormat("yy/MM/dd");
            inicio = fecha.format(jDate1.getDate());
            fin = fecha.format(jDate2.getDate());
            total = IUMain.control.getSumaTotalReporte(inicio, fin);
            IUMain.reportes.visor.clear();
            IUMain.reportes.jPanel2.removeAll();
            IUMain.reportes.visor = new JRViewer(IUMain.reportes.reporte.generarReporteinFechasVentas(inicio, fin, total), null);
            IUMain.reportes.visor.setZoomRatio(0.70f);
            IUMain.reportes.jPanel2.add(IUMain.reportes.visor, BorderLayout.CENTER);
            IUMain.reportes.jPanel2.updateUI();
        }
    }
    
    public void getArticulosFechas()
    {
        if (jDate1.getDate() == null || jDate2.getDate() == null)
            dispose();
        else
        {
            SimpleDateFormat fecha = new SimpleDateFormat("yy/MM/dd");
            inicio = fecha.format(jDate1.getDate());
            fin = fecha.format(jDate2.getDate());
            total = IUMain.control.getSumaTotalReporte(inicio, fin);
            IUMain.reportes.visor.clear();
            IUMain.reportes.jPanel2.removeAll();
            IUMain.reportes.visor = new JRViewer(IUMain.reportes.reporte.generarReporteinFechasArticulos(inicio, fin, total), null);
            IUMain.reportes.visor.setZoomRatio(0.70f);
            IUMain.reportes.jPanel2.add(IUMain.reportes.visor, BorderLayout.CENTER);
            IUMain.reportes.jPanel2.updateUI();
        }
    }
    
    
    public void invoke(final int opt)
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            IUFecha dialog;
            @Override
            public void run() 
            {
                dialog = new IUFecha(new javax.swing.JFrame(), true, opt);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() 
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        IUMain.reportes.fecha = null;
                    }
                });
                
                dialog.setVisible(true);
            }
        });
    }
}

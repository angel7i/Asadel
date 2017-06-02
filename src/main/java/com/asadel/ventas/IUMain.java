package com.asadel.ventas;

import java.awt.Graphics;
import java.awt.Image;
import java.beans.PropertyVetoException;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;

public class IUMain extends javax.swing.JFrame 
{
    private int estado;
    
    protected static IUArticulos articulos;
    protected static IUAgregar agregar;
    protected static IUModificar editar;
    protected static IUVentas ventas;
    protected static IUNotePad notepad;
    protected static IUConfiguracion configuracion;
    protected static IUReportes reportes; 
    protected static Control control;
    
    public IUMain() 
    {
        initComponents();
        setLocationRelativeTo(null);
        
        
        
        control.closeCajaMes();
        articulos = IUArticulos.getInstance();
        ventas = IUVentas.getInstance();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        desktop = new Escritorio();//new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ventas - ");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Asadel.png")).getImage());
        setMinimumSize(new java.awt.Dimension(710, 730));
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
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        desktop.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        desktop.setDragMode(javax.swing.JDesktopPane.OUTLINE_DRAG_MODE);
        desktop.setOpaque(false);

        jToolBar1.setFloatable(false);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/articulo1.png"))); // NOI18N
        jButton3.setToolTipText("Articulos");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/notepad1.png"))); // NOI18N
        jButton2.setToolTipText("Bloc de Notas");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/addarticulo1.png"))); // NOI18N
        jButton5.setToolTipText("Agregar Articulo");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cart1.png"))); // NOI18N
        jButton4.setToolTipText("Lista de Ventas");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jMenuBar1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jMenu1.setText("Archivo    ");
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_BACK_SPACE, 0));
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/articulo2.png"))); // NOI18N
        jMenuItem12.setText("Articulos");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);
        jMenu1.add(jSeparator2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Salir                      ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Edicion    ");

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/notepad2.png"))); // NOI18N
        jMenuItem13.setText("Bloc de Notas");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Ventas    ");

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/opencaja.png"))); // NOI18N
        jMenuItem6.setText("Abrir Caja");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/closecaja.png"))); // NOI18N
        jMenuItem7.setText("Cerrar Caja");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Caja1.png"))); // NOI18N
        jMenuItem9.setText("Modificar venta");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cart2.png"))); // NOI18N
        jMenuItem11.setText("Lista de ventas");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reportes.png"))); // NOI18N
        jMenuItem8.setText("Consultar reportes");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Herramientas");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/addarticulo2.png"))); // NOI18N
        jMenuItem2.setText("Agregar articulo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);
        jMenu4.add(jSeparator1);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/config.png"))); // NOI18N
        jMenuItem5.setText("Configuracion");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Ayuda   ");
        jMenu5.setActionCommand("");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/help.png"))); // NOI18N
        jMenuItem3.setText("Acerca de");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktop)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // Main - Cerrar
        closeApp();
    }//GEN-LAST:event_formWindowClosed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // MenuBar - Agregar
        showAgregar();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // MenuBar - Salir
        estado = JOptionPane.showConfirmDialog(this, "Desea Salir?", "Confirmar Salida", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        closeApp();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // MenuBar - Acerca de
        new IUAcerca(this, true).invoke();
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Main - Cargar Ventana de showArticulos
        showArticulos();
        
        if (control != null)
        {
            setTitle("Ventas - " + control.getNameSystem("Nombre"));
        }
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // MenuBar - Venta
        showVentas(true);        
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Barra de Herramientas - Lista de Ventas
        showVentas(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Barra de Herramientas - Agregar Articulo
        showAgregar();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // Menu - showArticulos
        showArticulos();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Main - Cerrandose
        estado = JOptionPane.showConfirmDialog(this, "Desea Salir?", "Confirmar Salida", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        closeApp();
    }//GEN-LAST:event_formWindowClosing

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Barra de Herramientas - Bloc de Notas
        showNotepad();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // Menu Edicion - Bloc de Notas
        showNotepad();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Barra de Herramientas - Articulos
        showArticulos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // Configuracion de la Base de Datos
        showConfiguracion();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // Menu Ventas - Abrir Caja
        ControlCaja.openCaja();        
        articulos.showTotal();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // Menu Ventas - Cerrar Caja
        ControlCaja.closeCaja();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // Menu Ventas -Consultar Reportes
        showReportes(false);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // Menu Ventas - Cancelar venta
        cancelVenta();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // Ventana Activa
        ventas.refresh(-1);
    }//GEN-LAST:event_formWindowActivated

    public static void main(String args[]) 
    {
        setDefaultLookAndFeelDecorated(true);
        control = new Control();
                
        try 
        {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            UIManager.put(SubstanceLookAndFeel.BUTTON_NO_MIN_SIZE_PROPERTY, Boolean.TRUE);
        } 
        catch (UnsupportedLookAndFeelException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        java.awt.EventQueue.invokeLater(() -> 
        {         
            SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin." + control.getTheme());
            new IUMain().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JDesktopPane desktop;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
    
    public void closeApp()
    {
        if (estado == JOptionPane.YES_OPTION)
        {
            IUArticulos.tablabase.closeBD();
            control.closeControl();
            System.gc();
            System.exit(0);
        }
        else
            estado = -1;
    }
    
    private void cancelVenta()
    {
        IUCancelar cancelar = null;
        String fact = JOptionPane.showInternalInputDialog(desktop, "ID de la Lista: ", "Factura", JOptionPane.INFORMATION_MESSAGE);
           
        try
        {
            if (fact != null)
                Long.parseLong(fact);
            else if (fact == null)
                return;
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showInternalMessageDialog(desktop, "El ID es incorrecto", "Error", 2);
            fact = JOptionPane.showInternalInputDialog(desktop, "ID de la Lista: ", "Factura", JOptionPane.INFORMATION_MESSAGE);
            
            if (fact != null)
                Long.parseLong(fact);
            else if (fact == null)
                return;
        }
        
        cancelar = new IUCancelar(fact);
        
        if (cancelar.exist)
        {
            desktop.add(cancelar); 
            cancelar.show();
            cancelar.toFront();
        }
        else
            cancelar.dispose();
    }
    
    public void showArticulos()
    {
        if (!(articulos.isShowing() || articulos.isIcon()))
        {
            desktop.add(articulos);
            articulos.setBounds(0, 0, 690, 640);
            articulos.show();
            articulos.toFront();
            try
            {
                articulos.setSelected(true);
            }
            catch (PropertyVetoException e)
            {
            }
        }
        else
        {
            articulos.show();
            articulos.toFront();
            try
            {
                articulos.setIcon(false);
                articulos.setSelected(true);
            }
            catch (PropertyVetoException e)
            {
            }
        }
    }
    
    public static void showAgregar()
    {
        if (agregar == null)
        {
            agregar = IUAgregar.getInstance();
            
            if (!(agregar.isShowing() || agregar.isIcon()))
            {
                desktop.add(agregar);
                agregar.setBounds(690, desktop.getHeight()/16, 459, 521);
                agregar.show();
                agregar.toFront();
                try
                {
                    agregar.setSelected(true);
                }
                catch (PropertyVetoException e)
                {
                }
            }
            
        }
        else
        {
            agregar.show();
            agregar.toFront();
            try
            {
                agregar.setIcon(false);
                agregar.setSelected(true);
            }
            catch (PropertyVetoException e)
            {
            }
        }
    }
    
    public static void showModificar()
    {
        if (editar == null)
        {
            editar = IUModificar.getInstance();
            
            if (!editar.isShowing())
            {
                desktop.add(editar);
                editar.setBounds(690, desktop.getHeight()/4, 413, 420);//[411, 392]
                editar.show();
                editar.toFront();
                try
                {
                    editar.setSelected(true);
                }
                catch (PropertyVetoException e)
                {
                }
            }
        }
        else
        {
            editar.show();
            editar.toFront();
            try
            {
                editar.setSelected(true);
            }
            catch (PropertyVetoException e)
            {
            }
        }
    }
    
    public static void showVentas(boolean selected)
    {
        if (!(ventas.isShowing() || ventas.isIcon()))
        {
            desktop.add(ventas);
            //ventas.setBounds(jDesktopPane1.getWidth()/2+20, 0, 640, 640);
            ventas.setBounds(690, 0, 640, 640);
            ventas.show();
            ventas.toFront();
        }
        else
        {
            ventas.show();
            ventas.toFront();
            try
            {
                if (selected)
                {
                    ventas.setSelected(selected);
                    ventas.setIcon(false);
                }
                else
                    ventas.setIcon(false);
            }
            catch (PropertyVetoException e)
            {
            }
        }
    }
    
    public void showNotepad()
    {
        if (notepad == null)
        {
            notepad = IUNotePad.getInstance();
            
            if (!(notepad.isShowing() || notepad.isIcon()))
            {
                desktop.add(notepad);
                notepad.setBounds(desktop.getWidth()/2+100, 50, 520, 350);//[520, 350]
                notepad.show();
                try
                {
                    notepad.setSelected(true);
                }
                catch (PropertyVetoException e)
                {
                }
            }
        }
        else
        {
            notepad.show();
            notepad.toFront();
            try
            {
                notepad.setSelected(true);
                notepad.setIcon(false);
            }
            catch (PropertyVetoException e)
            {
            }
        }
    }
    
    public void showConfiguracion()
    {
        if (configuracion == null)
        {
            configuracion = new IUConfiguracion();
            
            if (!configuracion.isShowing())
            {
                configuracion.setVisible(true);
                desktop.add(configuracion);
                configuracion.setBounds(650, 0, 679, 481);
                configuracion.show();
                try
                {
                    configuracion.setSelected(true);
                }
                catch (PropertyVetoException e)
                {
                }
            }
        }
        else
        {
            configuracion.show();
            configuracion.toFront();
            try
            {
                configuracion.setSelected(true);
            }
            catch (PropertyVetoException e)
            {
            }
        }
    }
    
    public static void showReportes(boolean estado)
    {
        if (reportes == null)
        {
            reportes = new IUReportes(estado);
            
            if (!reportes.isShowing())
            {
                reportes.setVisible(true);
                desktop.add(reportes);
                reportes.setBounds(0, 0, 860, 610);
                reportes.show();
                try
                {
                    reportes.setSelected(true);
                }
                catch (PropertyVetoException e)
                {
                }
            }
        }
        else
        {
            reportes.show();
            reportes.toFront();
            try
            {
                reportes.setSelected(true);
            }
            catch (PropertyVetoException e)
            {
            }
        }
    }
}

class Escritorio extends JDesktopPane
{
    private Image wall;

    public Escritorio()
    {
        try
        {
            wall = new ImageIcon(getClass().getResource("/Imagenes/wallpaper.jpg")).getImage();
        }
        catch (NullPointerException ex)
        {
            wall = null;
        }
    }
    
    public void setImagen(String path) 
    {
        if (path != null) 
        {
            wall = new ImageIcon(getClass().getResource(path)).getImage();
        } 
        else 
        {
            wall = new ImageIcon(getClass().getResource("/Imagenes/wallpaper.jpg")).getImage();
        }
 
        repaint();
    }
    
    public void setImagen(Image imagen) 
    {
        wall = imagen;
        repaint();
    }
    
    @Override
    public void paintChildren(Graphics g) 
    {
        if (wall != null) 
        {
            g.drawImage(wall, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
        } 
        else
        {
            setOpaque(true);
        }
        
        super.paintChildren(g);
    }
}

package com.asadel.ventas.controllers;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.springframework.stereotype.Component;

@Component
public class IUNotePad extends javax.swing.JInternalFrame 
{
    private static IUNotePad ventana = null;
    private JFileChooser selector;
    private File archivo;
    
    public static IUNotePad getInstance()
    {
        if (ventana == null)
            return ventana = new IUNotePad();
        else
            return ventana;
    }
    
    private IUNotePad() 
    {
        initComponents();
        selector = new JFileChooser();
        archivo = null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        jMenuItem1.setText("Cortar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Copiar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setText("Pegar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        jMenuItem4.setText("Eliminar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem4);

        jMenuItem5.setText("Seleccionar Todo");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem5);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Bloc de Notas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/notepad2.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(370, 230));
        setPreferredSize(new java.awt.Dimension(520, 350));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener()
        {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt)
            {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt)
            {
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

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/newdocument1.png"))); // NOI18N
        jButton1.setToolTipText("Nuevo");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open1.png"))); // NOI18N
        jButton2.setToolTipText("Abrir");
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

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save1.png"))); // NOI18N
        jButton3.setToolTipText("Guardar Como...");
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

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save1.png"))); // NOI18N
        jButton5.setToolTipText("Guardar");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/canceldocument1.png"))); // NOI18N
        jButton4.setToolTipText("Cerrar Documento");
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

        jEditorPane1.setCaretColor(Color.black);
        jEditorPane1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jEditorPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Nuevo Documento
        System.gc();
        closeFile();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Abrir Documento
        if (!jEditorPane1.getText().isEmpty())
        {
            closeFile();
        }
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.txt","txt"); 
        selector.setFileFilter(filtro); 
        selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resultado = selector.showOpenDialog(this);

        if ( resultado == JFileChooser.CANCEL_OPTION )
            selector.cancelSelection();
        else
        {
            archivo = selector.getSelectedFile();

            if ((archivo == null ) || (archivo.getName().equals( "" ) ) )
            {
                JOptionPane.showInternalMessageDialog( this, "Nombre de archivo inválido","Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE );
                selector.cancelSelection();
            }

            getFile(archivo);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Guardar Documento
        saveFile();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // Cerrar Bloc de Notas
        closeFile();
        System.gc();
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Cerrar Documento
        if (!jEditorPane1.getText().isEmpty())
        {
            closeFile();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // Cortar
        jEditorPane1.cut();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // Copiar
        jEditorPane1.copy();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // Pegar
        jEditorPane1.paste();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // Eliminar
        jEditorPane1.setText(null);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // Seleccionar Todo
        jEditorPane1.selectAll();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Guardar
        if (archivo != null)
            savequickFile();
    }//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
    
    public void saveFile()
    {
        if (jEditorPane1.getText().isEmpty())
            JOptionPane.showInternalMessageDialog(this, "Documento Vacio");
        else
        {
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.txt","txt"); 
            selector.setFileFilter(filtro); 
            selector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int resultado = selector.showSaveDialog(this);

            if (resultado == JFileChooser.APPROVE_OPTION)
            {
                String ruta = selector.getSelectedFile().getAbsolutePath();
                setFile(ruta);
            }
        }
    }
    
    public void savequickFile()
    {
        String ruta = archivo.getAbsolutePath();
        setFile(ruta);
    }
    
    public void closeFile()
    {
        if (jEditorPane1.getText().isEmpty())
        {
            jEditorPane1.setText(null);
            this.setTitle("Bloc de Notas");
            //IUDesktop.notepad = null;
        }
        else
        {
            int opc = JOptionPane.showInternalConfirmDialog(this, "Guardar Documento?", "Nuevo Documento", JOptionPane.YES_NO_CANCEL_OPTION);
            
            if (opc == JOptionPane.YES_OPTION)
            {
                saveFile();
                //IUDesktop.notepad = null;
            }
            else if (opc == JOptionPane.NO_OPTION)
            {
                jEditorPane1.setText(null);
                //IUDesktop.notepad = null;
            }
            else
            {
                selector.cancelSelection();
                //IUDesktop.notepad = null;
            }
            
            this.setTitle("Bloc de Notas");
        }
    }
    
    public void getFile(File file)
    {
        String linea;
        String nota = "";
        FileReader read = null;
        BufferedReader buffer = null;
        
         String nombre = file.getName();
         this.setTitle("Bloc de Notas: "+nombre);
        
        try
        {
            read = new FileReader(file);
            buffer = new BufferedReader(read);
            
            while ((linea = buffer.readLine()) != null)
            {
                nota += (linea + "\n");
            }
            
            jEditorPane1.setText(nota);
        }
        catch (Exception ex)
        {
            JOptionPane.showInternalMessageDialog(this, "No se puede abrir archivo");
        }
        finally 
        {
            try
            {
                if (read != null && buffer != null) 
                {
                    read.close();
                    buffer.close();
                }
            } 
            catch (Exception ex) 
            {
                JOptionPane.showInternalMessageDialog(this, "Error");
            }
        }
    }
    
    public void setFile(String ruta)
    {
        File nota = new File(ruta);
        
        try 
        {
            PrintWriter writer = new PrintWriter(nota);
            writer.println(jEditorPane1.getText());
            writer.close();
            
            if(!(ruta.endsWith(".txt")))
            {
                File temp = new File(ruta+".txt");
                nota.renameTo(temp);
            }
        }
        catch (Exception ex) 
        {
            JOptionPane.showInternalMessageDialog(this, "Error Escribir");
        }
    }
}

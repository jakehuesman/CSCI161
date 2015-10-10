/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hom01;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 * Simple GUI for selecting a file.
 * @author Jacob Huesman
 */
public class GetFile extends javax.swing.JFrame {

    /**
     * Declare instance variables.
     */
    private final JFileChooser fc;
    private FilePath file;
    private Thread thread;
    
    /**
     * Creates new JFrame GetFile.
     */
    public GetFile(FilePath filePath, Thread thread) {
        /* Set the System look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GetFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GetFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GetFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GetFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        
        /**
         * Instantiate new JFileChooser. Add references of filePath and thread passed from the client.
         */
        fc = new JFileChooser();
        this.file = filePath;
        this.thread = thread;
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filePath = new javax.swing.JTextField();
        findFile = new javax.swing.JButton();
        returnFile = new javax.swing.JButton();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        filePath.setToolTipText("");

        findFile.setText("File");
        findFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findFileActionPerformed(evt);
            }
        });

        returnFile.setText("Import");
        returnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnFileActionPerformed(evt);
            }
        });

        label.setText("Enter file path or choose a file to import data from.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(filePath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(findFile, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(returnFile, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findFile)
                    .addComponent(returnFile))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Opens JFileChooser dialog and then displays and stores the path.
     * @param evt 
     */
    private void findFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findFileActionPerformed
        if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            file.setFilePath(fc.getSelectedFile().getAbsolutePath());
            filePath.setText(file.getFilePath());
        }
    }//GEN-LAST:event_findFileActionPerformed

    /**
     * Checks to that the path is actually pointing to a file. If it is the dialog closes. Otherwise the dialog continues prompting the user for a valid file.
     * @param evt 
     */
    private void returnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnFileActionPerformed
        if(file.getIsFilePath()){
            thread.interrupt();
            this.dispose();
        } else {
            label.setText("Please enter a valid file path.");
            label.setForeground(Color.red);
        }
    }//GEN-LAST:event_returnFileActionPerformed

    /**
     * On window close notify thread to stop executing. Then dispose of this Frame's resources.
     * @param evt 
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        thread.interrupt();
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField filePath;
    private javax.swing.JButton findFile;
    private javax.swing.JLabel label;
    private javax.swing.JButton returnFile;
    // End of variables declaration//GEN-END:variables
}

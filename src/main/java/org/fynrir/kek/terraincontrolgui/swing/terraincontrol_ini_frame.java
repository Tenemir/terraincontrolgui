/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fynrir.kek.terraincontrolgui.swing;

import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author cbg-fynrir
 */
public class terraincontrol_ini_frame extends javax.swing.JFrame {
    Operations operations = null;
    /**
     * Creates new form terraincontrol_ini_frame
     * @param operations
     */
    public terraincontrol_ini_frame(Operations operations) {
        
        initComponents();
        this.operations = operations;
        setInitialINISettingsOnLoad();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbboxSettingsMode = new javax.swing.JComboBox<>();
        cmbboxLogLevel = new javax.swing.JComboBox<>();
        cmbboxBiomeExtension = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonConfirmTCINISettings = new javax.swing.JButton();
        jButtonCancelTCINISettings = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtareaMessageBiomeConfigExtensionCMBBOX = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtareaMessageLogLevelCMBBOX = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtareaMessageSettingsModeCMBBOX = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editing TerrainControl.ini");

        cmbboxSettingsMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "WriteAll", "WriteWithoutComments", "WriteDisable" }));
        cmbboxSettingsMode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbboxSettingsModeItemStateChanged(evt);
            }
        });
        cmbboxSettingsMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbboxSettingsModeActionPerformed(evt);
            }
        });
        cmbboxSettingsMode.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbboxSettingsModePropertyChange(evt);
            }
        });

        cmbboxLogLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Off", "Quiet", "Standard", "Debug", "Trace" }));
        cmbboxLogLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbboxLogLevelActionPerformed(evt);
            }
        });

        cmbboxBiomeExtension.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".biome", ".bc", ".bc.ini", ".biome.ini" }));
        cmbboxBiomeExtension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbboxBiomeExtensionActionPerformed(evt);
            }
        });

        jLabel1.setText("SettingsMode");

        jLabel2.setText("BiomeConfigExtension");

        jLabel3.setText("LogLevel");

        jButtonConfirmTCINISettings.setText("Confirm");
        jButtonConfirmTCINISettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonConfirmTCINISettingsMousePressed(evt);
            }
        });

        jButtonCancelTCINISettings.setText("Cancel");
        jButtonCancelTCINISettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonCancelTCINISettingsMousePressed(evt);
            }
        });
        jButtonCancelTCINISettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelTCINISettingsActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("SettingsMode will determine how\nconfigs are treated. \n\nYou can select between WriteAll, \nWriteWithoutComments and WriteDisable.\n\nLogLevel decides how much is logged, and what is \nshown.\nYou can select between \nOff, Quiet, Standard, Debug and Trace.\n\n\nBiomeConfigExtension decides what extension will \nbe used for the Biomes you create. \nYou can select between \n.biome, .bc, .bc.ini and .biome.ini\n(Defaults to .bc)");
        jScrollPane1.setViewportView(jTextArea1);

        txtareaMessageBiomeConfigExtensionCMBBOX.setColumns(20);
        txtareaMessageBiomeConfigExtensionCMBBOX.setLineWrap(true);
        txtareaMessageBiomeConfigExtensionCMBBOX.setRows(5);
        jScrollPane2.setViewportView(txtareaMessageBiomeConfigExtensionCMBBOX);

        txtareaMessageLogLevelCMBBOX.setColumns(20);
        txtareaMessageLogLevelCMBBOX.setLineWrap(true);
        txtareaMessageLogLevelCMBBOX.setRows(5);
        jScrollPane3.setViewportView(txtareaMessageLogLevelCMBBOX);

        txtareaMessageSettingsModeCMBBOX.setColumns(20);
        txtareaMessageSettingsModeCMBBOX.setLineWrap(true);
        txtareaMessageSettingsModeCMBBOX.setRows(5);
        jScrollPane4.setViewportView(txtareaMessageSettingsModeCMBBOX);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbboxSettingsMode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane3)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbboxBiomeExtension, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonConfirmTCINISettings, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(jButtonCancelTCINISettings, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbboxLogLevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbboxSettingsMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbboxLogLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbboxBiomeExtension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonConfirmTCINISettings)
                            .addComponent(jButtonCancelTCINISettings))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelTCINISettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelTCINISettingsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelTCINISettingsActionPerformed

    private void cmbboxLogLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbboxLogLevelActionPerformed
        txtareaMessageLogLevelCMBBOX.repaint();
        System.out.println("I got triggered.");
        if ("comboBoxChanged".equals(evt.getActionCommand())) {
            System.out.println("If ComboBoxChanged got triggered.");
        
        
        if (cmbboxLogLevel.getSelectedItem() == "Off") {
            
            txtareaMessageLogLevelCMBBOX.setText("'Off' is selected, will only print FATAL and ERROR logs.");
            System.out.println("Off was triggered.");
            
            txtareaMessageLogLevelCMBBOX.repaint();
        } else if(cmbboxLogLevel.getSelectedItem() == "Quiet") {
            System.out.println("Quiet was triggered.");
            txtareaMessageLogLevelCMBBOX.setText("'Quiet' is selected, will print FATAL, ERROR and WARN logs.");
            
            txtareaMessageLogLevelCMBBOX.repaint();
        } else if(cmbboxLogLevel.getSelectedItem() == "Standard") {
            
            txtareaMessageLogLevelCMBBOX.setText("'Standard' is selected, As quiet option\n but with INFO logs too.");
            
            txtareaMessageLogLevelCMBBOX.repaint();
        } else if(cmbboxLogLevel.getSelectedItem() == "Debug") {
            
            txtareaMessageLogLevelCMBBOX.setText("'Debug' is selected, Like standard option, but DEBUG logs\n are added.");
            
            txtareaMessageLogLevelCMBBOX.repaint();
        } else if(cmbboxLogLevel.getSelectedItem() == "Trace") {
            
            txtareaMessageLogLevelCMBBOX.setText("'Trace' is selected, Like Debug option, but adds Trace logs (very messy, only use if you need to go really deep into the logs).");
            
            txtareaMessageLogLevelCMBBOX.repaint();
        }
        }
        txtareaMessageLogLevelCMBBOX.repaint();
        this.repaint();
    }//GEN-LAST:event_cmbboxLogLevelActionPerformed

    private void cmbboxSettingsModeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbboxSettingsModeItemStateChanged
        
    }//GEN-LAST:event_cmbboxSettingsModeItemStateChanged

    private void cmbboxSettingsModePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbboxSettingsModePropertyChange
       
    }//GEN-LAST:event_cmbboxSettingsModePropertyChange

    private void cmbboxSettingsModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbboxSettingsModeActionPerformed
        txtareaMessageSettingsModeCMBBOX.repaint();
        if (cmbboxSettingsMode.getSelectedItem() == "WriteAll") {
            
            txtareaMessageSettingsModeCMBBOX.setText("'WriteAll' is selected, will write to the config files + \nadd help comments.");
            txtareaMessageSettingsModeCMBBOX.repaint();
        } else if(cmbboxSettingsMode.getSelectedItem() == "WriteWithoutComments") {
            
            txtareaMessageSettingsModeCMBBOX.setText("'WriteWithoutComments' is selected, will write to the config \n files, no help comments.");
            txtareaMessageSettingsModeCMBBOX.repaint();
        } else if(cmbboxSettingsMode.getSelectedItem() == "WriteDisable") {
            
            txtareaMessageSettingsModeCMBBOX.setText("'WriteDisable' is selected, will only read from the config files, will not write to them!");
            txtareaMessageSettingsModeCMBBOX.repaint();
        }
        txtareaMessageSettingsModeCMBBOX.repaint();
        this.repaint();
    }//GEN-LAST:event_cmbboxSettingsModeActionPerformed

    private void cmbboxBiomeExtensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbboxBiomeExtensionActionPerformed
        txtareaMessageBiomeConfigExtensionCMBBOX.repaint();
        if (cmbboxBiomeExtension.getSelectedItem() == ".biome") {
            txtareaMessageBiomeConfigExtensionCMBBOX.setText("'.biome' is selected. Name your biome files like this:\n ExampleName.biome");
            txtareaMessageBiomeConfigExtensionCMBBOX.repaint();
            
        } else if (cmbboxBiomeExtension.getSelectedItem() == ".bc") {
            txtareaMessageBiomeConfigExtensionCMBBOX.setText("'.bc' is selected. Name your biome files like this:\n ExampleName.bc");
            txtareaMessageBiomeConfigExtensionCMBBOX.repaint();
            
        } else if (cmbboxBiomeExtension.getSelectedItem() == ".bc.ini") {
            txtareaMessageBiomeConfigExtensionCMBBOX.setText("'.bc.ini' is selected. Name your biome files like this:\n ExampleName.bc.ini");
            txtareaMessageBiomeConfigExtensionCMBBOX.repaint();
            
        } else if (cmbboxBiomeExtension.getSelectedItem() == ".biome.ini") {
            txtareaMessageBiomeConfigExtensionCMBBOX.setText("'.biome.ini' is selected. Name your biome files like this:\n ExampleName.biome.ini");
            txtareaMessageBiomeConfigExtensionCMBBOX.repaint();
            
        }
    }//GEN-LAST:event_cmbboxBiomeExtensionActionPerformed

    private void jButtonConfirmTCINISettingsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConfirmTCINISettingsMousePressed
        String SettingsMode = "SettingsMode: " + cmbboxSettingsMode.getSelectedItem();
        String LogLevel = "LogLevel: " + cmbboxLogLevel.getSelectedItem();
        String BiomeConfigExtension = "BiomeConfigExtension: " + cmbboxBiomeExtension.getSelectedItem();
        
        String success = operations.SaveTerrainControlIniToClassObject(SettingsMode, LogLevel, BiomeConfigExtension);
        if (success.equals("Success")) {
            String Message1 = "Successfully saved your settings into the program! In order to save your settings to the\n";
            String Message2 = "TerrainControl.ini file, please select 'Save All' from the 'File' Menu, or\n";
            String Message3 = "Continue working on your project. I'd recommend saving tough.";
            String MessageTotal = Message1 + Message2 + Message3;
            JOptionPane.showMessageDialog(rootPane, MessageTotal);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Something went terribly wrong while saving the TerrainControl.ini settings to the class object.");
        }
    }//GEN-LAST:event_jButtonConfirmTCINISettingsMousePressed

    private void jButtonCancelTCINISettingsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelTCINISettingsMousePressed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelTCINISettingsMousePressed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(terraincontrol_ini_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(terraincontrol_ini_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(terraincontrol_ini_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(terraincontrol_ini_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new terraincontrol_ini_frame().setVisible(true);
//            }
//        });
//    }

    public void setInitialINISettingsOnLoad() {
        HashMap SettingsKeyValueSettingsMode = operations.LoadTerrainControlInitoTCINIEditor();
        System.out.println(SettingsKeyValueSettingsMode.get("LogLevel"));
        if (null != SettingsKeyValueSettingsMode.get("SettingsMode").toString()) //Settings the initial settings for SettingsMode
        switch (SettingsKeyValueSettingsMode.get("SettingsMode").toString()) {
            case "WriteAll":
                this.cmbboxSettingsMode.setSelectedItem("WriteAll");
                this.cmbboxSettingsMode.setSelectedIndex(0);
                txtareaMessageSettingsModeCMBBOX.setText("'WriteAll' is selected, will write to the config files + \nadd help comments.");
                this.cmbboxSettingsMode.repaint();
                break;
            case "WriteWithoutComments":
                this.cmbboxSettingsMode.setSelectedItem("WriteWithoutComments");
                txtareaMessageSettingsModeCMBBOX.setText("'WriteWithoutComments' is selected, will write to the config \n files, no help comments.");
                this.cmbboxSettingsMode.setSelectedIndex(1);
                this.cmbboxSettingsMode.repaint();
                break;
            case "WriteDisable":
                this.cmbboxSettingsMode.setSelectedItem("WriteDisable");
                this.cmbboxSettingsMode.setSelectedIndex(2);
                txtareaMessageSettingsModeCMBBOX.setText("'WriteDisable' is selected, will only read from the config files, will not write to them!");
                this.cmbboxSettingsMode.repaint();
                break;
            default:
                break;
        }
        if (null != SettingsKeyValueSettingsMode.get("LogLevel").toString()) //Setting the initial settings for LogLevel
        switch (SettingsKeyValueSettingsMode.get("LogLevel").toString()) {
            case "Off":
                this.cmbboxLogLevel.setSelectedItem("Off");
                txtareaMessageLogLevelCMBBOX.setText("'Off' is selected, will only print FATAL and ERROR logs.");

                this.cmbboxLogLevel.setSelectedIndex(0);
                this.cmbboxLogLevel.repaint();
                break;
            case "Quiet":
                this.cmbboxLogLevel.setSelectedItem("Quiet");
                txtareaMessageLogLevelCMBBOX.setText("'Quiet' is selected, will print FATAL, ERROR and WARN logs.");

                this.cmbboxLogLevel.setSelectedIndex(1);
                this.cmbboxLogLevel.repaint();
                break;
            case "Standard":
                this.cmbboxLogLevel.setSelectedItem("Standard");
                this.cmbboxLogLevel.setSelectedIndex(2);
                txtareaMessageLogLevelCMBBOX.setText("'Standard' is selected, As quiet option, but with INFO logs too.");
            
                this.cmbboxLogLevel.repaint();
                break;
            case "Debug":
                this.cmbboxLogLevel.setSelectedItem("Debug");
                txtareaMessageLogLevelCMBBOX.setText("'Debug' is selected, Like standard option, but DEBUG logs\n are added.");

                this.cmbboxLogLevel.setSelectedIndex(3);
                this.cmbboxLogLevel.repaint();
                break;
            case "Trace":
                this.cmbboxLogLevel.setSelectedItem("Trace");
                txtareaMessageLogLevelCMBBOX.setText("'Trace' is selected, Like Debug option, but adds Trace logs (very messy, only use if you need to go really deep into the logs).");

                this.cmbboxLogLevel.setSelectedIndex(4);
                this.cmbboxLogLevel.repaint();
                break;
            default:
                break;
        }
        if (null != SettingsKeyValueSettingsMode.get("BiomeConfigExtension").toString()) //Setting the initial settings for BiomeConfigExtension
        switch (SettingsKeyValueSettingsMode.get("BiomeConfigExtension").toString()) {
            case ".biome":
                this.cmbboxBiomeExtension.setSelectedItem(".biome");
                txtareaMessageBiomeConfigExtensionCMBBOX.setText("'.biome' is selected. Name your biome files like this:\n ExampleName.biome");

                this.cmbboxBiomeExtension.setSelectedIndex(0);
                this.cmbboxBiomeExtension.repaint();
                break;
            case ".bc":
                this.cmbboxBiomeExtension.setSelectedItem(".bc");
                txtareaMessageBiomeConfigExtensionCMBBOX.setText("'.bc' is selected. Name your biome files like this:\n ExampleName.bc");

                this.cmbboxBiomeExtension.setSelectedIndex(1);
                this.cmbboxBiomeExtension.repaint();
                break;
            case ".bc.ini":
                this.cmbboxBiomeExtension.setSelectedItem(".bc.ini");
                txtareaMessageBiomeConfigExtensionCMBBOX.setText("'.bc.ini' is selected. Name your biome files like this:\n ExampleName.bc.ini");

                this.cmbboxBiomeExtension.setSelectedIndex(2);
                this.cmbboxBiomeExtension.repaint();
                break;
            case ".biome.ini":
                this.cmbboxBiomeExtension.setSelectedItem(".biome.ini");
                txtareaMessageBiomeConfigExtensionCMBBOX.setText("'.biome.ini' is selected. Name your biome files like this:\n ExampleName.biome.ini");

                this.cmbboxBiomeExtension.setSelectedIndex(3);
                this.cmbboxBiomeExtension.repaint();
                break;
            default:
                break;
        }
        
        
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbboxBiomeExtension;
    private javax.swing.JComboBox<String> cmbboxLogLevel;
    private javax.swing.JComboBox<String> cmbboxSettingsMode;
    private javax.swing.JButton jButtonCancelTCINISettings;
    private javax.swing.JButton jButtonConfirmTCINISettings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea txtareaMessageBiomeConfigExtensionCMBBOX;
    private javax.swing.JTextArea txtareaMessageLogLevelCMBBOX;
    private javax.swing.JTextArea txtareaMessageSettingsModeCMBBOX;
    // End of variables declaration//GEN-END:variables
}

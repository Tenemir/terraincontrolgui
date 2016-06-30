/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fynrir.kek.terraincontrolgui.swing;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.SplashScreen;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.SwingWorker;
import javax.sound.sampled.AudioInputStream;
    import javax.sound.sampled.AudioSystem;
    import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author cbg-fynrir
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    
    Operations operations = new Operations();
    
    private boolean ProjectLoaded;
    
    public MainWindow() {
        
        this.ProjectLoaded = false;
        
        initComponents();
        
        this.HideOpenFileFrame();
        Splash();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LayerPanel = new javax.swing.JLayeredPane();
        filechooserOpenTerrainControlFolder = new javax.swing.JFileChooser();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        menuFileOpenTerrainControlFolder = new javax.swing.JMenuItem();
        menuCloseProject = new javax.swing.JMenuItem();
        menuSaveAllSoFar = new javax.swing.JMenuItem();
        menuOpenSettings = new javax.swing.JMenuItem();
        menuExitProgram = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        menuAutoBackupp = new javax.swing.JCheckBoxMenuItem();
        Help = new javax.swing.JMenu();
        menuOpenHelp = new javax.swing.JMenuItem();
        menuOpenAbout = new javax.swing.JMenuItem();
        menuGoToTerrainControl = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        filechooserOpenTerrainControlFolder.setDialogTitle("Choose a TerrainControl Folder...");
        filechooserOpenTerrainControlFolder.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        filechooserOpenTerrainControlFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filechooserOpenTerrainControlFolderActionPerformed(evt);
            }
        });

        LayerPanel.setLayer(filechooserOpenTerrainControlFolder, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout LayerPanelLayout = new javax.swing.GroupLayout(LayerPanel);
        LayerPanel.setLayout(LayerPanelLayout);
        LayerPanelLayout.setHorizontalGroup(
            LayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LayerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filechooserOpenTerrainControlFolder, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE))
        );
        LayerPanelLayout.setVerticalGroup(
            LayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LayerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filechooserOpenTerrainControlFolder, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
        );

        File.setText("File");

        menuFileOpenTerrainControlFolder.setText("Open a TerrainControl Folder");
        menuFileOpenTerrainControlFolder.setToolTipText("<html>\nOpens a project.<br>\nSelect your TerrainControl Folder, it should contain GlobalBiomes,<br> GlobalObjects and TerrainControl.ini\n\nThis program is useless without a worlds folder and at the least 1 world in it,<br> so enable TerrainControl on a world\nbefore you use this tool<b>!</b>");
        menuFileOpenTerrainControlFolder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuFileOpenTerrainControlFolderMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuFileOpenTerrainControlFolderMouseClicked(evt);
            }
        });
        File.add(menuFileOpenTerrainControlFolder);

        menuCloseProject.setText("Close current project");
        menuCloseProject.setEnabled(false);
        menuCloseProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuCloseProjectMousePressed(evt);
            }
        });
        File.add(menuCloseProject);

        menuSaveAllSoFar.setText("Save All");
        menuSaveAllSoFar.setToolTipText("<html>\nThis will save all settings you have made to the TerrainControl Folder!<br>\nUsefull if you have made several changes in several files, and want to save all of them, <br>\ninstead of having to save all of them one-by-one.");
        File.add(menuSaveAllSoFar);

        menuOpenSettings.setText("Options");
        menuOpenSettings.setToolTipText("<html>\nThis will open the settings page, where you can set several options.<br>\nExample: Font sizes for forms where you need to enter text.");
        File.add(menuOpenSettings);

        menuExitProgram.setText("Exit");
        menuExitProgram.setToolTipText("Exit the program.");
        menuExitProgram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuExitProgramMousePressed(evt);
            }
        });
        File.add(menuExitProgram);

        jMenuBar1.add(File);

        Edit.setText("Edit");
        Edit.setEnabled(false);

        menuAutoBackupp.setSelected(true);
        menuAutoBackupp.setText("Auto Backupp");
        menuAutoBackupp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                menuAutoBackuppItemStateChanged(evt);
            }
        });
        Edit.add(menuAutoBackupp);

        jMenuBar1.add(Edit);

        Help.setText("Help");
        Help.setToolTipText("");

        menuOpenHelp.setText("How to use TC-GUI");
        Help.add(menuOpenHelp);

        menuOpenAbout.setText("About");
        menuOpenAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuOpenAboutMousePressed(evt);
            }
        });
        Help.add(menuOpenAbout);

        menuGoToTerrainControl.setText("TerrainControl Plugin (opens a webbrowser)");
        menuGoToTerrainControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuGoToTerrainControlMousePressed(evt);
            }
        });
        Help.add(menuGoToTerrainControl);

        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LayerPanel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LayerPanel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuFileOpenTerrainControlFolderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuFileOpenTerrainControlFolderMouseClicked
    
    }//GEN-LAST:event_menuFileOpenTerrainControlFolderMouseClicked

    private void filechooserOpenTerrainControlFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filechooserOpenTerrainControlFolderActionPerformed
        if (this.ProjectLoaded == true) {
            JOptionPane.showMessageDialog(null, "If you see this message, you are either a good hacker. or something is bugged. :D");
        } else {
            
        
        
        String command = evt.getActionCommand();
        if ("ApproveSelection".equals(command)) {
            if (!"TerrainControl".equals(filechooserOpenTerrainControlFolder.getSelectedFile().getName())) {
            JOptionPane.showMessageDialog(null, "The folder needs to be named 'TerrainControl'");
            } else {
            String[] Error = operations.LoadFromDirectory(filechooserOpenTerrainControlFolder.getSelectedFile().listFiles(),filechooserOpenTerrainControlFolder.getSelectedFile().getPath());
            
            if ("true".equals(Error[0])) {
               JOptionPane.showMessageDialog(rootPane, Error[1]);
            } else {
            this.ProjectLoaded = true;
            this.HideOpenFileFrame();
            menuFileOpenTerrainControlFolder.setEnabled(false);
            menuCloseProject.setEnabled(true);
            JOptionPane.showMessageDialog(rootPane, "Project was successfully loaded!");
            }
            
            }
            
        } else if ("CancelSelection".equals(command)) {
            this.HideOpenFileFrame();
        }
        }
        
    }//GEN-LAST:event_filechooserOpenTerrainControlFolderActionPerformed

    private void menuFileOpenTerrainControlFolderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuFileOpenTerrainControlFolderMousePressed
        if (this.ProjectLoaded == false) {
            JOptionPane.showMessageDialog(null, "You did indeed press the menu button!");
            filechooserOpenTerrainControlFolder.setEnabled(true);
            filechooserOpenTerrainControlFolder.setVisible(true);
        } 
        
        
        
    }//GEN-LAST:event_menuFileOpenTerrainControlFolderMousePressed

    private void menuExitProgramMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuExitProgramMousePressed
        String derp = "Are you really sure you want to exit the program? Make sure to run 'Save all' in the File meny first if you have made any changes to your TerrainControl folder!";
        int result = JOptionPane.showConfirmDialog(rootPane, derp);
        
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_menuExitProgramMousePressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void menuCloseProjectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCloseProjectMousePressed
        String derp = "Are you really sure you want to close the project? Make sure to run 'Save all' in the File meny first if you have made any changes to your TerrainControl folder!";
        int result = JOptionPane.showConfirmDialog(rootPane, derp);
        
        if (result == JOptionPane.YES_OPTION) {
            menuFileOpenTerrainControlFolder.setEnabled(true);
            menuCloseProject.setEnabled(false);
            operations.ResetMemory();
        }
    }//GEN-LAST:event_menuCloseProjectMousePressed

    private void menuGoToTerrainControlMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuGoToTerrainControlMousePressed
        if(Desktop.isDesktopSupported())
{
            try {
                Desktop.getDesktop().browse(new URI("https://www.spigotmc.org/resources/terraincontrol.2214/"));
            } catch (IOException | URISyntaxException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }//GEN-LAST:event_menuGoToTerrainControlMousePressed

    private void menuOpenAboutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuOpenAboutMousePressed
        JLabel background = new JLabel(new ImageIcon("src/main/resources/bootimage.png"));
       
       JFrame about = new javax.swing.JFrame();
       about.setUndecorated(true);
       about.add(background);
       
       about.setSize(724, 424);
        
      
    about.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
         
         about.setVisible(false);
         about.setEnabled(false);
         
         
     }
  });
    }//GEN-LAST:event_menuOpenAboutMousePressed

    private void menuAutoBackuppItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_menuAutoBackuppItemStateChanged
        if (menuAutoBackupp.isSelected() == true) {
            
        } else if (menuAutoBackupp.isSelected() == false) {
            
        }
    }//GEN-LAST:event_menuAutoBackuppItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                new MainWindow().setVisible(true);
               
            }
        });
    }
    
    public final void HideOpenFileFrame() {
        
        filechooserOpenTerrainControlFolder.setVisible(false);
        filechooserOpenTerrainControlFolder.setEnabled(false);
        }
    
   public final void Splash() {
       JLabel background = new JLabel(new ImageIcon("src/main/resources/bootimage.png"));
       
       JFrame splash = new javax.swing.JFrame();
       splash.setUndecorated(true);
       splash.add(background);
       
       splash.setSize(724, 424);
       
       Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
       splash.setAlwaysOnTop (true);
        splash.setLocationRelativeTo(null);
       
       splash.setVisible(true);
       
       splash.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
         
         splash.setVisible(false);
         splash.setEnabled(false);
     }
  });
        
   }
   
   public void Aboutmusic(boolean play) {
       
    

       
   }
   
  
   

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu File;
    private javax.swing.JMenu Help;
    private javax.swing.JLayeredPane LayerPanel;
    private javax.swing.JFileChooser filechooserOpenTerrainControlFolder;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JCheckBoxMenuItem menuAutoBackupp;
    private javax.swing.JMenuItem menuCloseProject;
    private javax.swing.JMenuItem menuExitProgram;
    private javax.swing.JMenuItem menuFileOpenTerrainControlFolder;
    private javax.swing.JMenuItem menuGoToTerrainControl;
    private javax.swing.JMenuItem menuOpenAbout;
    private javax.swing.JMenuItem menuOpenHelp;
    private javax.swing.JMenuItem menuOpenSettings;
    private javax.swing.JMenuItem menuSaveAllSoFar;
    // End of variables declaration//GEN-END:variables
}

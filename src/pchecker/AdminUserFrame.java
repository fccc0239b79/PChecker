/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pchecker;

/**
 *
 * @author Pawel
 */
public class AdminUserFrame extends javax.swing.JFrame {

    userAdminAccount currentUser;
    /**
     * Creates new form AdminUserFrame
     */
    public AdminUserFrame() {
        initComponents();
    }
    
    public AdminUserFrame(userAdminAccount user) {
        initComponents();
        
        currentUser = user;

        boolean userType = currentUser.getType();
        
        setLocationRelativeTo(null);

        if(userType){
            this.setTitle("Admin Menu"); 
            mainAdminPanel.setVisible(true);
        }else{
            this.setTitle("User Menu"); 
            mainUserPanel.setVisible(true);

        }
        
           
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainUserPanel = new javax.swing.JPanel();
        logoMain = new javax.swing.JLabel();
        menuLabel = new javax.swing.JLabel();
        profileBtn = new javax.swing.JButton();
        logOffBtn = new javax.swing.JButton();
        buildList = new javax.swing.JScrollPane();
        addBuildBtn = new javax.swing.JButton();
        profilePanel = new javax.swing.JPanel();
        profileLabel = new javax.swing.JLabel();
        backBtnProfile = new javax.swing.JButton();
        editBtnProfile = new javax.swing.JButton();
        settingsLabel = new javax.swing.JLabel();
        acceptBtnProfile = new javax.swing.JButton();
        mainAdminPanel = new javax.swing.JPanel();
        logoAdmin = new javax.swing.JLabel();
        createAccountAdminBtn = new javax.swing.JButton();
        editAccountAdminBtn = new javax.swing.JButton();
        viewAccountAdminBtn = new javax.swing.JButton();
        logOffAdminBtn = new javax.swing.JButton();
        profileAdminBtn = new javax.swing.JButton();
        newComponentAdminBtn = new javax.swing.JButton();
        editComponentAdminBtn = new javax.swing.JButton();
        viewComponentAdminBtn = new javax.swing.JButton();
        createBuildAdminBtn = new javax.swing.JButton();
        editBuildAdminBtn = new javax.swing.JButton();
        viewBuildAdminBtn = new javax.swing.JButton();
        adminMenuLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(null);

        mainUserPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainUserPanel.setMaximumSize(new java.awt.Dimension(900, 600));
        mainUserPanel.setMinimumSize(new java.awt.Dimension(900, 600));
        mainUserPanel.setLayout(null);

        logoMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
        mainUserPanel.add(logoMain);
        logoMain.setBounds(148, 70, 602, 119);

        menuLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        menuLabel.setText("MENU");
        mainUserPanel.add(menuLabel);
        menuLabel.setBounds(394, 215, 109, 44);

        profileBtn.setText("Profile");
        mainUserPanel.add(profileBtn);
        profileBtn.setBounds(740, 11, 84, 43);

        logOffBtn.setText("Log Off");
        logOffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOffBtnActionPerformed(evt);
            }
        });
        mainUserPanel.add(logOffBtn);
        logOffBtn.setBounds(809, 11, 91, 43);
        mainUserPanel.add(buildList);
        buildList.setBounds(206, 277, 491, 172);

        addBuildBtn.setText("Add Build");
        mainUserPanel.add(addBuildBtn);
        addBuildBtn.setBounds(407, 467, 95, 43);

        getContentPane().add(mainUserPanel);
        mainUserPanel.setBounds(0, 0, 900, 600);

        profilePanel.setBackground(new java.awt.Color(255, 255, 255));
        profilePanel.setMaximumSize(new java.awt.Dimension(900, 600));
        profilePanel.setMinimumSize(new java.awt.Dimension(900, 600));
        profilePanel.setLayout(null);

        profileLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        profileLabel.setText("PROFILE");
        profilePanel.add(profileLabel);
        profileLabel.setBounds(387, 70, 159, 44);

        backBtnProfile.setText("Back");
        profilePanel.add(backBtnProfile);
        backBtnProfile.setBounds(827, 11, 63, 41);

        editBtnProfile.setText("Edit Profile");
        profilePanel.add(editBtnProfile);
        editBtnProfile.setBounds(564, 73, 112, 41);

        settingsLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        settingsLabel.setText("SETTINGS");
        profilePanel.add(settingsLabel);
        settingsLabel.setBounds(375, 314, 184, 44);

        acceptBtnProfile.setText("Accept");
        acceptBtnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtnProfileActionPerformed(evt);
            }
        });
        profilePanel.add(acceptBtnProfile);
        acceptBtnProfile.setBounds(752, 11, 87, 41);

        getContentPane().add(profilePanel);
        profilePanel.setBounds(0, 0, 910, 600);

        mainAdminPanel.setBackground(new java.awt.Color(204, 255, 204));
        mainAdminPanel.setMaximumSize(new java.awt.Dimension(900, 600));
        mainAdminPanel.setMinimumSize(new java.awt.Dimension(900, 600));
        mainAdminPanel.setLayout(null);

        logoAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
        mainAdminPanel.add(logoAdmin);
        logoAdmin.setBounds(150, 80, 602, 119);

        createAccountAdminBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        createAccountAdminBtn.setText("Create Account");
        createAccountAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountAdminBtnActionPerformed(evt);
            }
        });
        mainAdminPanel.add(createAccountAdminBtn);
        createAccountAdminBtn.setBounds(200, 290, 160, 80);

        editAccountAdminBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editAccountAdminBtn.setText("Edit Account");
        mainAdminPanel.add(editAccountAdminBtn);
        editAccountAdminBtn.setBounds(200, 380, 160, 80);

        viewAccountAdminBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewAccountAdminBtn.setText("View Account");
        viewAccountAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAccountAdminBtnActionPerformed(evt);
            }
        });
        mainAdminPanel.add(viewAccountAdminBtn);
        viewAccountAdminBtn.setBounds(200, 470, 160, 80);

        logOffAdminBtn.setText("Log Off");
        logOffAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOffAdminBtnActionPerformed(evt);
            }
        });
        mainAdminPanel.add(logOffAdminBtn);
        logOffAdminBtn.setBounds(809, 11, 91, 43);

        profileAdminBtn.setText("Profile");
        mainAdminPanel.add(profileAdminBtn);
        profileAdminBtn.setBounds(740, 11, 84, 43);

        newComponentAdminBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        newComponentAdminBtn.setText("New Component");
        newComponentAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newComponentAdminBtnActionPerformed(evt);
            }
        });
        mainAdminPanel.add(newComponentAdminBtn);
        newComponentAdminBtn.setBounds(370, 290, 160, 80);

        editComponentAdminBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editComponentAdminBtn.setText("Edit Component");
        mainAdminPanel.add(editComponentAdminBtn);
        editComponentAdminBtn.setBounds(370, 380, 160, 80);

        viewComponentAdminBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewComponentAdminBtn.setText("View Components");
        mainAdminPanel.add(viewComponentAdminBtn);
        viewComponentAdminBtn.setBounds(370, 470, 160, 80);

        createBuildAdminBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        createBuildAdminBtn.setText("Create Build");
        mainAdminPanel.add(createBuildAdminBtn);
        createBuildAdminBtn.setBounds(540, 290, 160, 80);

        editBuildAdminBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editBuildAdminBtn.setText("Edit Build");
        mainAdminPanel.add(editBuildAdminBtn);
        editBuildAdminBtn.setBounds(540, 380, 160, 80);

        viewBuildAdminBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewBuildAdminBtn.setText("View Build");
        mainAdminPanel.add(viewBuildAdminBtn);
        viewBuildAdminBtn.setBounds(540, 470, 160, 80);

        adminMenuLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        adminMenuLabel.setText("Admin Menu");
        mainAdminPanel.add(adminMenuLabel);
        adminMenuLabel.setBounds(370, 220, 160, 40);

        getContentPane().add(mainAdminPanel);
        mainAdminPanel.setBounds(0, 0, 900, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOffBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logOffBtnActionPerformed

    private void acceptBtnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnProfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acceptBtnProfileActionPerformed

    private void logOffAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOffAdminBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logOffAdminBtnActionPerformed

    private void viewAccountAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAccountAdminBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewAccountAdminBtnActionPerformed

    private void createAccountAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountAdminBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createAccountAdminBtnActionPerformed

    private void newComponentAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newComponentAdminBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newComponentAdminBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AdminUserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUserFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptBtnProfile;
    private javax.swing.JButton addBuildBtn;
    private javax.swing.JLabel adminMenuLabel;
    private javax.swing.JButton backBtnProfile;
    private javax.swing.JScrollPane buildList;
    private javax.swing.JButton createAccountAdminBtn;
    private javax.swing.JButton createBuildAdminBtn;
    private javax.swing.JButton editAccountAdminBtn;
    private javax.swing.JButton editBtnProfile;
    private javax.swing.JButton editBuildAdminBtn;
    private javax.swing.JButton editComponentAdminBtn;
    private javax.swing.JButton logOffAdminBtn;
    private javax.swing.JButton logOffBtn;
    private javax.swing.JLabel logoAdmin;
    private javax.swing.JLabel logoMain;
    private javax.swing.JPanel mainAdminPanel;
    private javax.swing.JPanel mainUserPanel;
    private javax.swing.JLabel menuLabel;
    private javax.swing.JButton newComponentAdminBtn;
    private javax.swing.JButton profileAdminBtn;
    private javax.swing.JButton profileBtn;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JLabel settingsLabel;
    private javax.swing.JButton viewAccountAdminBtn;
    private javax.swing.JButton viewBuildAdminBtn;
    private javax.swing.JButton viewComponentAdminBtn;
    // End of variables declaration//GEN-END:variables
}

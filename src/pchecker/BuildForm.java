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
public class BuildForm extends javax.swing.JFrame {

    /**
     * Creates new form BuildForm
     */
    public BuildForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editPanel = new javax.swing.JPanel();
        logoE = new javax.swing.JLabel();
        cancelBtnE = new javax.swing.JButton();
        acceptBtnE = new javax.swing.JButton();
        componentsListE = new javax.swing.JScrollPane();
        editLabelE = new javax.swing.JLabel();
        buildPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cancelBtnB = new javax.swing.JButton();
        acceptBtnB = new javax.swing.JButton();
        logoB = new javax.swing.JLabel();
        buildNameLabelB = new javax.swing.JLabel();
        buildNameFieldB = new javax.swing.JTextField();
        motherboardBtn = new javax.swing.JButton();
        processorBtn = new javax.swing.JButton();
        ramBtn = new javax.swing.JButton();
        graphicsBtn = new javax.swing.JButton();
        hddBtn = new javax.swing.JButton();
        caseBtn = new javax.swing.JButton();
        supplyBtn = new javax.swing.JButton();
        coolingBtn = new javax.swing.JButton();
        accessoriesBtn = new javax.swing.JButton();
        motherboardPanel = new javax.swing.JPanel();
        cpuPanel = new javax.swing.JPanel();
        ramPanel = new javax.swing.JPanel();
        coolingPanel = new javax.swing.JPanel();
        gpuPanel = new javax.swing.JPanel();
        hddPanel = new javax.swing.JPanel();
        accessoriesPanel = new javax.swing.JPanel();
        casePanel = new javax.swing.JPanel();
        powerPanel = new javax.swing.JPanel();
        createAccount = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        viewAccount = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setName("buildFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        editPanel.setBackground(new java.awt.Color(255, 255, 255));
        editPanel.setMaximumSize(new java.awt.Dimension(900, 600));
        editPanel.setMinimumSize(new java.awt.Dimension(900, 600));
        editPanel.setLayout(null);

        logoE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
        editPanel.add(logoE);
        logoE.setBounds(147, 59, 602, 119);

        cancelBtnE.setText("Cancel");
        editPanel.add(cancelBtnE);
        cancelBtnE.setBounds(825, 11, 65, 42);

        acceptBtnE.setText("Accept");
        editPanel.add(acceptBtnE);
        acceptBtnE.setBounds(754, 11, 65, 42);

        componentsListE.setBackground(new java.awt.Color(255, 255, 255));
        editPanel.add(componentsListE);
        componentsListE.setBounds(147, 258, 602, 282);

        editLabelE.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        editLabelE.setText("EDIT BUILD:");
        editPanel.add(editLabelE);
        editLabelE.setBounds(342, 196, 229, 44);

        getContentPane().add(editPanel);
        editPanel.setBounds(0, 0, 900, 600);

        buildPanel.setBackground(new java.awt.Color(255, 255, 255));
        buildPanel.setMaximumSize(new java.awt.Dimension(900, 600));
        buildPanel.setMinimumSize(new java.awt.Dimension(900, 600));
        buildPanel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("NEW BUILD");
        buildPanel.add(jLabel1);
        jLabel1.setBounds(345, 201, 215, 44);

        cancelBtnB.setText("Cancel");
        buildPanel.add(cancelBtnB);
        cancelBtnB.setBounds(825, 11, 65, 42);

        acceptBtnB.setText("Accept");
        buildPanel.add(acceptBtnB);
        acceptBtnB.setBounds(754, 11, 65, 42);

        logoB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
        buildPanel.add(logoB);
        logoB.setBounds(145, 64, 602, 119);

        buildNameLabelB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buildNameLabelB.setText("Build Name:");
        buildPanel.add(buildNameLabelB);
        buildNameLabelB.setBounds(263, 288, 115, 36);

        buildNameFieldB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildNameFieldBActionPerformed(evt);
            }
        });
        buildPanel.add(buildNameFieldB);
        buildNameFieldB.setBounds(384, 288, 246, 36);

        motherboardBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        motherboardBtn.setText("MOTHERBOARD");
        buildPanel.add(motherboardBtn);
        motherboardBtn.setBounds(259, 342, 119, 62);

        processorBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        processorBtn.setText("PROCESSOR");
        buildPanel.add(processorBtn);
        processorBtn.setBounds(384, 342, 125, 62);

        ramBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ramBtn.setText("RAM");
        buildPanel.add(ramBtn);
        ramBtn.setBounds(515, 342, 115, 62);

        graphicsBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        graphicsBtn.setText("GRAPHICS CARD");
        buildPanel.add(graphicsBtn);
        graphicsBtn.setBounds(384, 410, 125, 60);

        hddBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        hddBtn.setText("HDD");
        buildPanel.add(hddBtn);
        hddBtn.setBounds(259, 410, 119, 60);

        caseBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        caseBtn.setText("CASE");
        buildPanel.add(caseBtn);
        caseBtn.setBounds(515, 410, 115, 60);

        supplyBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        supplyBtn.setText("POWER SUPPLY");
        buildPanel.add(supplyBtn);
        supplyBtn.setBounds(259, 476, 119, 60);

        coolingBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        coolingBtn.setText("COOLING");
        buildPanel.add(coolingBtn);
        coolingBtn.setBounds(384, 476, 125, 60);

        accessoriesBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        accessoriesBtn.setText("ACCESSORIES");
        accessoriesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accessoriesBtnActionPerformed(evt);
            }
        });
        buildPanel.add(accessoriesBtn);
        accessoriesBtn.setBounds(515, 476, 115, 60);

        getContentPane().add(buildPanel);
        buildPanel.setBounds(0, 0, 900, 600);

        javax.swing.GroupLayout motherboardPanelLayout = new javax.swing.GroupLayout(motherboardPanel);
        motherboardPanel.setLayout(motherboardPanelLayout);
        motherboardPanelLayout.setHorizontalGroup(
            motherboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        motherboardPanelLayout.setVerticalGroup(
            motherboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(motherboardPanel);
        motherboardPanel.setBounds(0, 0, 100, 100);

        javax.swing.GroupLayout cpuPanelLayout = new javax.swing.GroupLayout(cpuPanel);
        cpuPanel.setLayout(cpuPanelLayout);
        cpuPanelLayout.setHorizontalGroup(
            cpuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        cpuPanelLayout.setVerticalGroup(
            cpuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(cpuPanel);
        cpuPanel.setBounds(0, 0, 100, 100);

        javax.swing.GroupLayout ramPanelLayout = new javax.swing.GroupLayout(ramPanel);
        ramPanel.setLayout(ramPanelLayout);
        ramPanelLayout.setHorizontalGroup(
            ramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        ramPanelLayout.setVerticalGroup(
            ramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(ramPanel);
        ramPanel.setBounds(0, 0, 100, 100);

        javax.swing.GroupLayout coolingPanelLayout = new javax.swing.GroupLayout(coolingPanel);
        coolingPanel.setLayout(coolingPanelLayout);
        coolingPanelLayout.setHorizontalGroup(
            coolingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        coolingPanelLayout.setVerticalGroup(
            coolingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(coolingPanel);
        coolingPanel.setBounds(0, 0, 100, 100);

        javax.swing.GroupLayout gpuPanelLayout = new javax.swing.GroupLayout(gpuPanel);
        gpuPanel.setLayout(gpuPanelLayout);
        gpuPanelLayout.setHorizontalGroup(
            gpuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        gpuPanelLayout.setVerticalGroup(
            gpuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(gpuPanel);
        gpuPanel.setBounds(0, 0, 100, 100);

        javax.swing.GroupLayout hddPanelLayout = new javax.swing.GroupLayout(hddPanel);
        hddPanel.setLayout(hddPanelLayout);
        hddPanelLayout.setHorizontalGroup(
            hddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        hddPanelLayout.setVerticalGroup(
            hddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(hddPanel);
        hddPanel.setBounds(0, 0, 100, 100);

        javax.swing.GroupLayout accessoriesPanelLayout = new javax.swing.GroupLayout(accessoriesPanel);
        accessoriesPanel.setLayout(accessoriesPanelLayout);
        accessoriesPanelLayout.setHorizontalGroup(
            accessoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        accessoriesPanelLayout.setVerticalGroup(
            accessoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(accessoriesPanel);
        accessoriesPanel.setBounds(0, 0, 100, 100);

        javax.swing.GroupLayout casePanelLayout = new javax.swing.GroupLayout(casePanel);
        casePanel.setLayout(casePanelLayout);
        casePanelLayout.setHorizontalGroup(
            casePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        casePanelLayout.setVerticalGroup(
            casePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(casePanel);
        casePanel.setBounds(0, 0, 100, 100);

        javax.swing.GroupLayout powerPanelLayout = new javax.swing.GroupLayout(powerPanel);
        powerPanel.setLayout(powerPanelLayout);
        powerPanelLayout.setHorizontalGroup(
            powerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        powerPanelLayout.setVerticalGroup(
            powerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(powerPanel);
        powerPanel.setBounds(0, 0, 100, 100);

        createAccount.setBackground(new java.awt.Color(255, 255, 204));
        createAccount.setMaximumSize(new java.awt.Dimension(900, 600));
        createAccount.setMinimumSize(new java.awt.Dimension(900, 600));
        createAccount.setPreferredSize(new java.awt.Dimension(900, 600));
        createAccount.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
        createAccount.add(jLabel2);
        jLabel2.setBounds(150, 80, 602, 119);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Create Account:");
        createAccount.add(jLabel3);
        jLabel3.setBounds(350, 230, 210, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Account type:");
        createAccount.add(jLabel4);
        jLabel4.setBounds(300, 290, 100, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Username:");
        createAccount.add(jLabel5);
        jLabel5.setBounds(300, 320, 110, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Password:");
        createAccount.add(jLabel6);
        jLabel6.setBounds(300, 350, 110, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Confirm Password:");
        createAccount.add(jLabel7);
        jLabel7.setBounds(300, 380, 130, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Forename:");
        createAccount.add(jLabel8);
        jLabel8.setBounds(300, 410, 120, 17);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Surname:");
        createAccount.add(jLabel9);
        jLabel9.setBounds(300, 440, 90, 17);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Cancel");
        createAccount.add(jButton1);
        jButton1.setBounds(140, 530, 130, 60);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Create Account");
        createAccount.add(jButton2);
        jButton2.setBounds(750, 530, 130, 60);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General User", "Admin" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        createAccount.add(jComboBox1);
        jComboBox1.setBounds(440, 290, 220, 20);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        createAccount.add(jTextField1);
        jTextField1.setBounds(440, 320, 220, 20);
        createAccount.add(jTextField2);
        jTextField2.setBounds(440, 350, 220, 20);
        createAccount.add(jTextField3);
        jTextField3.setBounds(440, 380, 220, 20);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        createAccount.add(jTextField4);
        jTextField4.setBounds(440, 410, 220, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("email:");
        createAccount.add(jLabel11);
        jLabel11.setBounds(300, 470, 70, 17);
        createAccount.add(jTextField5);
        jTextField5.setBounds(440, 440, 220, 20);
        createAccount.add(jTextField6);
        jTextField6.setBounds(440, 470, 220, 20);

        getContentPane().add(createAccount);
        createAccount.setBounds(0, 0, 900, 600);

        viewAccount.setBackground(new java.awt.Color(255, 204, 204));
        viewAccount.setMaximumSize(new java.awt.Dimension(900, 600));
        viewAccount.setMinimumSize(new java.awt.Dimension(900, 600));
        viewAccount.setLayout(null);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
        viewAccount.add(jLabel10);
        jLabel10.setBounds(130, 60, 602, 119);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Account Name", "Account Type"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        viewAccount.add(jScrollPane1);
        jScrollPane1.setBounds(220, 290, 452, 170);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("View Accounts:");
        viewAccount.add(jLabel12);
        jLabel12.setBounds(330, 210, 259, 41);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Back");
        viewAccount.add(jButton4);
        jButton4.setBounds(50, 500, 130, 60);

        getContentPane().add(viewAccount);
        viewAccount.setBounds(0, 0, 974, 705);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buildNameFieldBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildNameFieldBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buildNameFieldBActionPerformed

    private void accessoriesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accessoriesBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accessoriesBtnActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(BuildForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuildForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuildForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuildForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuildForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptBtnB;
    private javax.swing.JButton acceptBtnE;
    private javax.swing.JButton accessoriesBtn;
    private javax.swing.JPanel accessoriesPanel;
    private javax.swing.JTextField buildNameFieldB;
    private javax.swing.JLabel buildNameLabelB;
    private javax.swing.JPanel buildPanel;
    private javax.swing.JButton cancelBtnB;
    private javax.swing.JButton cancelBtnE;
    private javax.swing.JButton caseBtn;
    private javax.swing.JPanel casePanel;
    private javax.swing.JScrollPane componentsListE;
    private javax.swing.JButton coolingBtn;
    private javax.swing.JPanel coolingPanel;
    private javax.swing.JPanel cpuPanel;
    private javax.swing.JPanel createAccount;
    private javax.swing.JLabel editLabelE;
    private javax.swing.JPanel editPanel;
    private javax.swing.JPanel gpuPanel;
    private javax.swing.JButton graphicsBtn;
    private javax.swing.JButton hddBtn;
    private javax.swing.JPanel hddPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel logoB;
    private javax.swing.JLabel logoE;
    private javax.swing.JButton motherboardBtn;
    private javax.swing.JPanel motherboardPanel;
    private javax.swing.JPanel powerPanel;
    private javax.swing.JButton processorBtn;
    private javax.swing.JButton ramBtn;
    private javax.swing.JPanel ramPanel;
    private javax.swing.JButton supplyBtn;
    private javax.swing.JPanel viewAccount;
    // End of variables declaration//GEN-END:variables
}

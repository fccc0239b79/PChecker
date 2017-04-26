/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pchecker;

import java.awt.Cursor;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
            accountPanel.setVisible(false);
            changeAccountTypePanel.setVisible(false);
            //mainUserPanel.setVisible(false);

        }else{
            this.setTitle("User Menu"); 
            mainUserPanel.setVisible(true);
            accountPanel.setVisible(false);
            changeAccountTypePanel.setVisible(false);
            getBuilds();
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

        changeAccountTypePanel = new javax.swing.JPanel();
        logoAccount1 = new javax.swing.JLabel();
        accountSettingsLabel1 = new javax.swing.JLabel();
        saveAccountTypeBtn = new javax.swing.JButton();
        accountTypeComboBox = new javax.swing.JComboBox<>();
        cancelAccountTypeBtn = new javax.swing.JButton();
        currentTypelbl = new javax.swing.JLabel();
        deleteDifferentAccount = new javax.swing.JButton();
        mainUserPanel = new javax.swing.JPanel();
        logoMain = new javax.swing.JLabel();
        menuLabel = new javax.swing.JLabel();
        profileBtn = new javax.swing.JButton();
        logOffBtn = new javax.swing.JButton();
        jScrollBuildList = new javax.swing.JScrollPane();
        buildsList = new javax.swing.JList<>();
        addBuildBtn = new javax.swing.JButton();
        adminBackBtn = new javax.swing.JButton();
        compareBuildsBtn = new javax.swing.JButton();
        accountPanel = new javax.swing.JPanel();
        logoAccount = new javax.swing.JLabel();
        accountSettingsLabel = new javax.swing.JLabel();
        accountBackBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        accountsTable = new javax.swing.JTable();
        mainAdminPanel = new javax.swing.JPanel();
        logoAdmin = new javax.swing.JLabel();
        editAccountAdminBtn = new javax.swing.JButton();
        logOffAdminBtn = new javax.swing.JButton();
        profileAdminBtn = new javax.swing.JButton();
        newComponentAdminBtn = new javax.swing.JButton();
        viewComponentAdminBtn = new javax.swing.JButton();
        viewBuildAdminBtn = new javax.swing.JButton();
        adminMenuLabel = new javax.swing.JLabel();
        profilePanel = new javax.swing.JPanel();
        profileLabel = new javax.swing.JLabel();
        backBtnProfile = new javax.swing.JButton();
        editBtnProfile = new javax.swing.JButton();
        acceptBtnProfile = new javax.swing.JButton();
        mobilPro = new javax.swing.JTextField();
        fnamePro = new javax.swing.JTextField();
        snamePro = new javax.swing.JTextField();
        DOBPro = new javax.swing.JTextField();
        emailPro = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailLabel1 = new javax.swing.JLabel();
        emailLabel2 = new javax.swing.JLabel();
        deleteAccount = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        changeAccountTypePanel.setBackground(new java.awt.Color(153, 204, 255));
        changeAccountTypePanel.setMaximumSize(new java.awt.Dimension(900, 600));
        changeAccountTypePanel.setMinimumSize(new java.awt.Dimension(900, 600));
        changeAccountTypePanel.setPreferredSize(new java.awt.Dimension(900, 600));
        changeAccountTypePanel.setLayout(null);

        logoAccount1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoAccount1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
        changeAccountTypePanel.add(logoAccount1);
        logoAccount1.setBounds(150, 80, 600, 120);

        accountSettingsLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        accountSettingsLabel1.setText("[Account Name]");
        changeAccountTypePanel.add(accountSettingsLabel1);
        accountSettingsLabel1.setBounds(340, 230, 300, 40);

        saveAccountTypeBtn.setText("Save");
        saveAccountTypeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAccountTypeBtnActionPerformed(evt);
            }
        });
        changeAccountTypePanel.add(saveAccountTypeBtn);
        saveAccountTypeBtn.setBounds(700, 20, 80, 40);

        accountTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select account type-", "Admin", "User" }));
        accountTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountTypeComboBoxActionPerformed(evt);
            }
        });
        changeAccountTypePanel.add(accountTypeComboBox);
        accountTypeComboBox.setBounds(340, 310, 210, 30);

        cancelAccountTypeBtn.setText("Cancel");
        cancelAccountTypeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAccountTypeBtnActionPerformed(evt);
            }
        });
        changeAccountTypePanel.add(cancelAccountTypeBtn);
        cancelAccountTypeBtn.setBounds(800, 20, 80, 40);

        currentTypelbl.setText("jLabel1");
        changeAccountTypePanel.add(currentTypelbl);
        currentTypelbl.setBounds(350, 280, 310, 16);

        deleteDifferentAccount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deleteDifferentAccount.setText("Delete Account");
        deleteDifferentAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDifferentAccountActionPerformed(evt);
            }
        });
        changeAccountTypePanel.add(deleteDifferentAccount);
        deleteDifferentAccount.setBounds(340, 350, 210, 41);

        getContentPane().add(changeAccountTypePanel);
        changeAccountTypePanel.setBounds(0, 0, 900, 600);

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

        profileBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        profileBtn.setText("Profile");
        profileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileBtnActionPerformed(evt);
            }
        });
        mainUserPanel.add(profileBtn);
        profileBtn.setBounds(710, 10, 80, 43);

        logOffBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        logOffBtn.setText("Log Off");
        logOffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOffBtnActionPerformed(evt);
            }
        });
        mainUserPanel.add(logOffBtn);
        logOffBtn.setBounds(799, 10, 80, 43);

        buildsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        buildsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buildsListMouseClicked(evt);
            }
        });
        jScrollBuildList.setViewportView(buildsList);

        mainUserPanel.add(jScrollBuildList);
        jScrollBuildList.setBounds(206, 277, 491, 172);

        addBuildBtn.setText("Add Build");
        addBuildBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBuildBtnActionPerformed(evt);
            }
        });
        mainUserPanel.add(addBuildBtn);
        addBuildBtn.setBounds(310, 470, 95, 43);

        adminBackBtn.setText("Back");
        adminBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminBackBtnActionPerformed(evt);
            }
        });
        mainUserPanel.add(adminBackBtn);
        adminBackBtn.setBounds(20, 10, 75, 40);
        adminBackBtn.setVisible(false);

        compareBuildsBtn.setText("Compare Builds");
        compareBuildsBtn.setEnabled(false);
        compareBuildsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compareBuildsBtnActionPerformed(evt);
            }
        });
        mainUserPanel.add(compareBuildsBtn);
        compareBuildsBtn.setBounds(450, 470, 140, 40);

        getContentPane().add(mainUserPanel);
        mainUserPanel.setBounds(0, 0, 900, 600);
        mainUserPanel.setVisible(false);

        accountPanel.setBackground(new java.awt.Color(153, 255, 255));
        accountPanel.setMaximumSize(new java.awt.Dimension(900, 600));
        accountPanel.setMinimumSize(new java.awt.Dimension(900, 600));
        accountPanel.setPreferredSize(new java.awt.Dimension(900, 600));
        accountPanel.setLayout(null);

        logoAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
        accountPanel.add(logoAccount);
        logoAccount.setBounds(150, 80, 602, 119);

        accountSettingsLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        accountSettingsLabel.setText("Account Settings");
        accountPanel.add(accountSettingsLabel);
        accountSettingsLabel.setBounds(290, 220, 320, 40);

        accountBackBtn.setText("Back");
        accountBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountBackBtnActionPerformed(evt);
            }
        });
        accountPanel.add(accountBackBtn);
        accountBackBtn.setBounds(800, 20, 80, 40);

        accountsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        accountsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(accountsTable);

        accountPanel.add(jScrollPane1);
        jScrollPane1.setBounds(230, 310, 454, 190);

        getContentPane().add(accountPanel);
        accountPanel.setBounds(0, 0, 900, 600);

        mainAdminPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainAdminPanel.setMaximumSize(new java.awt.Dimension(900, 600));
        mainAdminPanel.setMinimumSize(new java.awt.Dimension(900, 600));
        mainAdminPanel.setLayout(null);

        logoAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
        mainAdminPanel.add(logoAdmin);
        logoAdmin.setBounds(150, 80, 602, 119);

        editAccountAdminBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editAccountAdminBtn.setText("Account Settings");
        editAccountAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAccountAdminBtnActionPerformed(evt);
            }
        });
        mainAdminPanel.add(editAccountAdminBtn);
        editAccountAdminBtn.setBounds(200, 380, 160, 80);

        logOffAdminBtn.setText("Log Off");
        logOffAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOffAdminBtnActionPerformed(evt);
            }
        });
        mainAdminPanel.add(logOffAdminBtn);
        logOffAdminBtn.setBounds(809, 11, 91, 43);

        profileAdminBtn.setText("Profile");
        profileAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileAdminBtnActionPerformed(evt);
            }
        });
        mainAdminPanel.add(profileAdminBtn);
        profileAdminBtn.setBounds(720, 10, 84, 43);

        newComponentAdminBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        newComponentAdminBtn.setText("Add New Part");
        newComponentAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newComponentAdminBtnActionPerformed(evt);
            }
        });
        mainAdminPanel.add(newComponentAdminBtn);
        newComponentAdminBtn.setBounds(370, 290, 160, 80);

        viewComponentAdminBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewComponentAdminBtn.setText("View Components");
        viewComponentAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewComponentAdminBtnActionPerformed(evt);
            }
        });
        mainAdminPanel.add(viewComponentAdminBtn);
        viewComponentAdminBtn.setBounds(370, 470, 160, 80);

        viewBuildAdminBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewBuildAdminBtn.setText("View Build");
        viewBuildAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBuildAdminBtnActionPerformed(evt);
            }
        });
        mainAdminPanel.add(viewBuildAdminBtn);
        viewBuildAdminBtn.setBounds(540, 380, 160, 80);

        adminMenuLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        adminMenuLabel.setText("Admin Menu");
        mainAdminPanel.add(adminMenuLabel);
        adminMenuLabel.setBounds(330, 220, 240, 40);

        getContentPane().add(mainAdminPanel);
        mainAdminPanel.setBounds(0, 0, 900, 600);
        mainAdminPanel.setVisible(false);

        profilePanel.setBackground(new java.awt.Color(255, 255, 255));
        profilePanel.setMaximumSize(new java.awt.Dimension(900, 600));
        profilePanel.setMinimumSize(new java.awt.Dimension(900, 600));
        profilePanel.setLayout(null);

        profileLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        profileLabel.setText("PROFILE");
        profilePanel.add(profileLabel);
        profileLabel.setBounds(100, 100, 180, 44);

        backBtnProfile.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backBtnProfile.setText("Back");
        backBtnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnProfileActionPerformed(evt);
            }
        });
        profilePanel.add(backBtnProfile);
        backBtnProfile.setBounds(790, 20, 80, 41);

        editBtnProfile.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        editBtnProfile.setText("Edit Profile");
        editBtnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnProfileActionPerformed(evt);
            }
        });
        profilePanel.add(editBtnProfile);
        editBtnProfile.setBounds(290, 100, 103, 41);

        acceptBtnProfile.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        acceptBtnProfile.setText("Accept");
        acceptBtnProfile.setEnabled(false);
        acceptBtnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtnProfileActionPerformed(evt);
            }
        });
        profilePanel.add(acceptBtnProfile);
        acceptBtnProfile.setBounds(150, 400, 90, 41);

        mobilPro.setText("jTextField1");
        mobilPro.setEnabled(false);
        profilePanel.add(mobilPro);
        mobilPro.setBounds(200, 340, 150, 30);

        fnamePro.setText("jTextField1");
        fnamePro.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        fnamePro.setEnabled(false);
        profilePanel.add(fnamePro);
        fnamePro.setBounds(200, 180, 150, 30);

        snamePro.setText("jTextField1");
        snamePro.setEnabled(false);
        profilePanel.add(snamePro);
        snamePro.setBounds(200, 220, 150, 30);

        DOBPro.setText("jTextField1");
        DOBPro.setEnabled(false);
        profilePanel.add(DOBPro);
        DOBPro.setBounds(200, 260, 150, 30);

        emailPro.setText("jTextField1");
        emailPro.setEnabled(false);
        profilePanel.add(emailPro);
        emailPro.setBounds(200, 300, 150, 30);

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameLabel.setText("Forename:");
        profilePanel.add(nameLabel);
        nameLabel.setBounds(100, 180, 90, 30);

        surnameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        surnameLabel.setText("Surname:");
        profilePanel.add(surnameLabel);
        surnameLabel.setBounds(110, 220, 80, 30);

        emailLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailLabel.setText("email:");
        profilePanel.add(emailLabel);
        emailLabel.setBounds(130, 300, 60, 30);

        emailLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailLabel1.setText("Mobile No.");
        profilePanel.add(emailLabel1);
        emailLabel1.setBounds(100, 340, 90, 30);

        emailLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailLabel2.setText("Date of birth:");
        profilePanel.add(emailLabel2);
        emailLabel2.setBounds(90, 260, 100, 30);

        deleteAccount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deleteAccount.setText("Delete Account");
        deleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAccountActionPerformed(evt);
            }
        });
        profilePanel.add(deleteAccount);
        deleteAccount.setBounds(130, 480, 180, 41);

        getContentPane().add(profilePanel);
        profilePanel.setBounds(0, 0, 910, 600);
        profilePanel.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void loggOff(){

    
        LogInForm frm = new LogInForm(); //opens admin user form
        this.setVisible(false);
        frm.setVisible(true);
        //currentUser.reset();
        

}
private void getProfile(){
    mainAdminPanel.setVisible(false);
    mainUserPanel.setVisible(false);
    profilePanel.setVisible(true);
    accountPanel.setVisible(false);
    changeAccountTypePanel.setVisible(false);
    
    fnamePro.setText(currentUser.getFname());
    snamePro.setText(currentUser.getSname());
    DOBPro.setText(currentUser.getDOB());
    emailPro.setText(currentUser.getEmail());
    mobilPro.setText(currentUser.getMobile());
    
}

private void enbleEdit(boolean torf){
    fnamePro.setEnabled(torf);
    snamePro.setEnabled(torf);
    DOBPro.setEnabled(torf);
    emailPro.setEnabled(torf);
    mobilPro.setEnabled(torf);
    acceptBtnProfile.setEnabled(torf);
}

    private void getBuilds(){
        buildsList.removeAll();
        ArrayList builds = new ArrayList();
        builds = currentUser.getBuilds();

        

        DefaultListModel model = new DefaultListModel();
        //model.clear();
        for (Object str : builds) { 		      
          // System.out.println(str); 	
          model.addElement(str);
          
        }
        globalmodel = model;
        
        buildsList.setModel(model);
        
       if(builds.size()>1){
           compareBuildsBtn.setEnabled(true);
       }else{
           compareBuildsBtn.setEnabled(false);
       }
      }

    DefaultListModel globalmodel;

    private void logOffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOffBtnActionPerformed
       loggOff();
        
    }//GEN-LAST:event_logOffBtnActionPerformed

    private void acceptBtnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnProfileActionPerformed
        
        

        String name = fnamePro.getText();
        String surname = snamePro.getText();
        String email = emailPro.getText();
        String DOB = DOBPro.getText();
        String mobilNumber = mobilPro.getText();
        
       
        int emailValidation = email.indexOf('@');

        
        boolean confirm = true;
        
        if( name.isEmpty() || surname.isEmpty() || email.isEmpty()|| DOB.isEmpty() || mobilNumber.isEmpty()){
          
        confirm = false;
        
        }
        
        // validation process, sets lenths and types needed to validate form
        if (confirm) { //Checks to see all fields are complete.
            
          if (emailValidation >= 0) {

                if (surname.length() <= 45) {
                    if (name.length() <= 45 ) {
                        if(DOB.length() >= 10 && DOB.length() <= 10){
                            if(mobilNumber.length()>=11 && mobilNumber.length()<=11){
                            
                               
                            currentUser.setFname(name);
                            currentUser.setSname(surname);
                            currentUser.setEmail(email);
                            currentUser.setDOB(DOB);     
                            currentUser.setMobil(mobilNumber); 
                            
                            currentUser.UpdateUser();
                            
                            enbleEdit(false);
                            
                            //if valid the account is created in database 
                            JOptionPane.showMessageDialog(null, "Account Updated.", "Account Updated", JOptionPane.INFORMATION_MESSAGE);
                           

                        
                            } else {
                        JOptionPane.showMessageDialog(null, "Invaid Mobile Number .", "", JOptionPane.INFORMATION_MESSAGE);

                    }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invaid Date of Birth", "", JOptionPane.INFORMATION_MESSAGE);

                    }

                    } else {
                        JOptionPane.showMessageDialog(null, "Name too long.", "", JOptionPane.INFORMATION_MESSAGE);

                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Surname too long.", "", JOptionPane.INFORMATION_MESSAGE);

                }

            } else {
                JOptionPane.showMessageDialog(null, "Email Issue: Please ensure the email field contains an '@'.", "Email Issue", JOptionPane.INFORMATION_MESSAGE);

            }

        } else {

            JOptionPane.showMessageDialog(null, "Please complete all fields!", "Complete All fields", JOptionPane.INFORMATION_MESSAGE);
        }
                                       

    
    }//GEN-LAST:event_acceptBtnProfileActionPerformed

    private void logOffAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOffAdminBtnActionPerformed
        loggOff();
    }//GEN-LAST:event_logOffAdminBtnActionPerformed

    private void newComponentAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newComponentAdminBtnActionPerformed
        ArrayList<String> INFO = null;
        BuildForm frm = new BuildForm(currentUser,true,"",INFO);
        this.dispose();
        frm.setVisible(true);
        
    }//GEN-LAST:event_newComponentAdminBtnActionPerformed

    private void profileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBtnActionPerformed
       getProfile();
    }//GEN-LAST:event_profileBtnActionPerformed

    private void profileAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileAdminBtnActionPerformed
        getProfile();
    }//GEN-LAST:event_profileAdminBtnActionPerformed

    private void editBtnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnProfileActionPerformed

    enbleEdit(true);
       
    }//GEN-LAST:event_editBtnProfileActionPerformed

    private void backBtnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnProfileActionPerformed
        profilePanel.setVisible(false);

        if(currentUser.getType()){
            this.setTitle("Admin Menu"); 
            mainAdminPanel.setVisible(true);
            accountPanel.setVisible(false);
            changeAccountTypePanel.setVisible(false);
        }else{
            this.setTitle("User Menu"); 
            mainUserPanel.setVisible(true);
            accountPanel.setVisible(false);
            changeAccountTypePanel.setVisible(false);
        }
        
    }//GEN-LAST:event_backBtnProfileActionPerformed

    private void addBuildBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBuildBtnActionPerformed
        
        BuildForm frm = new BuildForm(currentUser);
        frm.setVisible(true);
        this.dispose();
        
        
        
        
    }//GEN-LAST:event_addBuildBtnActionPerformed

    private void buildsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buildsListMouseClicked


        String selectedBuild = buildsList.getSelectedValue();
        //String username = currentUser.getUsername();
        if(!selectedBuild.equals("No Builds")){
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            BuildForm frm = new BuildForm(currentUser,selectedBuild); //
            System.out.println(selectedBuild);
            this.dispose();
           
            frm.setVisible(true);
        }
    }//GEN-LAST:event_buildsListMouseClicked

    private void viewBuildAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBuildAdminBtnActionPerformed
        mainAdminPanel.setVisible(false);
        accountPanel.setVisible(false);
        changeAccountTypePanel.setVisible(false);
        mainUserPanel.setVisible(true);
        getBuilds();
        adminBackBtn.setVisible(true);
    }//GEN-LAST:event_viewBuildAdminBtnActionPerformed

    private void adminBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminBackBtnActionPerformed
        mainAdminPanel.setVisible(true);
        mainUserPanel.setVisible(false);
        accountPanel.setVisible(false);
        changeAccountTypePanel.setVisible(false);
    }//GEN-LAST:event_adminBackBtnActionPerformed

    private void viewComponentAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewComponentAdminBtnActionPerformed
       mainAdminPanel.setVisible(false);
       accountPanel.setVisible(false);
       changeAccountTypePanel.setVisible(false);
       BuildForm frm = new BuildForm(currentUser,true, true);
        this.dispose();
        frm.setVisible(true);
      //
    }//GEN-LAST:event_viewComponentAdminBtnActionPerformed

    private void editAccountAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAccountAdminBtnActionPerformed
       
        mainAdminPanel.setVisible(false);
        changeAccountTypePanel.setVisible(false);
        accountPanel.setVisible(true);
       // System.out.println("works");
        
        // take all data from db
        DefaultTableModel getAccounts = new DefaultTableModel();
        getAccounts = currentUser.getAccounts();
        
        // display data in a table
        accountsTable.setModel(getAccounts);
       
    }//GEN-LAST:event_editAccountAdminBtnActionPerformed

    private void accountBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountBackBtnActionPerformed
        mainAdminPanel.setVisible(true);
        mainUserPanel.setVisible(false);
        accountPanel.setVisible(false);
        changeAccountTypePanel.setVisible(false);
    }//GEN-LAST:event_accountBackBtnActionPerformed
    
    String accountNameValue;
    private void saveAccountTypeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAccountTypeBtnActionPerformed
        // TODO add your handling code here:
        
        // !
        if(accountTypeComboBox.getSelectedItem() == "Admin" && !currentTypelbl.getText().contains("Admin")) {
            //System.out.println("ADMIN !!!");
            currentUser.updateAccountType(true, accountSettingsLabel1.getText());
        } else if(accountTypeComboBox.getSelectedItem() == "User" && !currentTypelbl.getText().contains("User")){
            //System.out.println("USER !!!");
            currentUser.updateAccountType(false, accountSettingsLabel1.getText());
        }
        AdminUserFrame frm = new AdminUserFrame(currentUser);
        this.dispose();
        frm.setVisible(true);
        
    }//GEN-LAST:event_saveAccountTypeBtnActionPerformed

    private void accountTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountTypeComboBoxActionPerformed

    }//GEN-LAST:event_accountTypeComboBoxActionPerformed

    private void cancelAccountTypeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAccountTypeBtnActionPerformed
        
        mainAdminPanel.setVisible(false);
        changeAccountTypePanel.setVisible(false);
        accountPanel.setVisible(true);
    }//GEN-LAST:event_cancelAccountTypeBtnActionPerformed

    private void accountsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountsTableMouseClicked
        // System.out.println("WKS");
         
         //for(int column = 0; column < accountsTable.getColumnCount(); column++) {
         //String name = String.valueOf(accountsTable.getModel().getColumnName(1));
           // if(name.equals("Account Name")){
         accountNameValue = String.valueOf(accountsTable.getValueAt(accountsTable.getSelectedRow(), 0)); 

               accountSettingsLabel1.setText(accountNameValue);
        String TorF = String.valueOf(accountsTable.getValueAt(accountsTable.getSelectedRow(), 1)); 
        if(TorF.equals("true")){
            currentTypelbl.setText("Current Account Type: Admin");
        } else{
            currentTypelbl.setText("Current Account Type: User");
        }
               //currentTypelbl.
          // }

            //accountSettingsLabel1.setText(currentUser.getAccountName());
        // System.out.println(value);
        // }
        mainAdminPanel.setVisible(false);
        changeAccountTypePanel.setVisible(true);
        accountPanel.setVisible(false);
         
    }//GEN-LAST:event_accountsTableMouseClicked

    private void deleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAccountActionPerformed
       
        
        deleteAccount("");
        
        
    }//GEN-LAST:event_deleteAccountActionPerformed

    private void deleteDifferentAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDifferentAccountActionPerformed
       
    deleteAccount(accountSettingsLabel1.getText());

        
    }//GEN-LAST:event_deleteDifferentAccountActionPerformed

    private void compareBuildsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compareBuildsBtnActionPerformed
        
        
        
        
      BuildForm frm = new BuildForm( currentUser,true);
      this.dispose();
      frm.setVisible(true);
    }//GEN-LAST:event_compareBuildsBtnActionPerformed

    public void deleteAccount(String username){
        int answer = JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Delete your Account, this will erase all your data like Builds saved?", "Delete Account", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
       
        if (answer == JOptionPane.YES_OPTION) {
          if(!currentUser.getType()){
            JOptionPane.showMessageDialog(null, "Account Deleted. You will be returnd to log in screen");
            currentUser.deleteAccount(currentUser.getUsername());
            LogInForm frm = new LogInForm();
            this.dispose();
            frm.setVisible(true);
          }else{
            JOptionPane.showMessageDialog(null, "Account Deleted");
            currentUser.deleteAccount(username);
            AdminUserFrame frm = new AdminUserFrame(currentUser);
            this.dispose();
            frm.setVisible(true);
          }
        }
    }
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
    private javax.swing.JTextField DOBPro;
    private javax.swing.JButton acceptBtnProfile;
    private javax.swing.JButton accountBackBtn;
    private javax.swing.JPanel accountPanel;
    private javax.swing.JLabel accountSettingsLabel;
    private javax.swing.JLabel accountSettingsLabel1;
    private javax.swing.JComboBox<String> accountTypeComboBox;
    private javax.swing.JTable accountsTable;
    private javax.swing.JButton addBuildBtn;
    private javax.swing.JButton adminBackBtn;
    private javax.swing.JLabel adminMenuLabel;
    private javax.swing.JButton backBtnProfile;
    private javax.swing.JList<String> buildsList;
    private javax.swing.JButton cancelAccountTypeBtn;
    private javax.swing.JPanel changeAccountTypePanel;
    private javax.swing.JButton compareBuildsBtn;
    private javax.swing.JLabel currentTypelbl;
    private javax.swing.JButton deleteAccount;
    private javax.swing.JButton deleteDifferentAccount;
    private javax.swing.JButton editAccountAdminBtn;
    private javax.swing.JButton editBtnProfile;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailLabel1;
    private javax.swing.JLabel emailLabel2;
    private javax.swing.JTextField emailPro;
    private javax.swing.JTextField fnamePro;
    private javax.swing.JScrollPane jScrollBuildList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logOffAdminBtn;
    private javax.swing.JButton logOffBtn;
    private javax.swing.JLabel logoAccount;
    private javax.swing.JLabel logoAccount1;
    private javax.swing.JLabel logoAdmin;
    private javax.swing.JLabel logoMain;
    private javax.swing.JPanel mainAdminPanel;
    private javax.swing.JPanel mainUserPanel;
    private javax.swing.JLabel menuLabel;
    private javax.swing.JTextField mobilPro;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton newComponentAdminBtn;
    private javax.swing.JButton profileAdminBtn;
    private javax.swing.JButton profileBtn;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JButton saveAccountTypeBtn;
    private javax.swing.JTextField snamePro;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JButton viewBuildAdminBtn;
    private javax.swing.JButton viewComponentAdminBtn;
    // End of variables declaration//GEN-END:variables
}

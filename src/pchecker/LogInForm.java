/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pchecker;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Pawel Szymczyk
 */
public class LogInForm extends javax.swing.JFrame {

    /**
     * Creates new form LogInForm
     */
    public LogInForm() {
        initComponents();
        setLocationRelativeTo(null);
        RegistrationPanel.setVisible(false);
        ForgotPasswordPanel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogInPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        UserNameLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        UsernameInput = new javax.swing.JTextField();
        forgotPswLink = new javax.swing.JLabel();
        createAccountLink = new javax.swing.JLabel();
        PasswordInput = new javax.swing.JPasswordField();
        RegistrationPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        headingLabel = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        confirmLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        forenameField = new javax.swing.JTextField();
        surnameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        cancelBtn = new javax.swing.JButton();
        createBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();
        confirmPassField = new javax.swing.JPasswordField();
        emailLabel1 = new javax.swing.JLabel();
        mobilNumField = new javax.swing.JTextField();
        emailLabel2 = new javax.swing.JLabel();
        DOBField = new javax.swing.JTextField();
        ForgotPasswordPanel = new javax.swing.JPanel();
        informLabelFP = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameLabelFP = new javax.swing.JLabel();
        emailLabelFP = new javax.swing.JLabel();
        usernameFieldFP = new javax.swing.JTextField();
        emailFieldFP = new javax.swing.JTextField();
        acceptBtnFP = new javax.swing.JButton();
        cancelBtnFP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ComPChecker");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        LogInPanel.setBackground(new java.awt.Color(255, 255, 255));
        LogInPanel.setMaximumSize(new java.awt.Dimension(900, 600));
        LogInPanel.setMinimumSize(new java.awt.Dimension(900, 600));
        LogInPanel.setPreferredSize(new java.awt.Dimension(900, 600));
        LogInPanel.setLayout(null);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
        LogInPanel.add(logo);
        logo.setBounds(140, 150, 602, 119);

        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        LogInPanel.add(loginBtn);
        loginBtn.setBounds(377, 421, 70, 45);

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        LogInPanel.add(exitBtn);
        exitBtn.setBounds(460, 421, 70, 45);

        UserNameLabel.setFont(new java.awt.Font("Kalinga", 0, 14)); // NOI18N
        UserNameLabel.setText("Username:");
        LogInPanel.add(UserNameLabel);
        UserNameLabel.setBounds(240, 340, 76, 17);

        PasswordLabel.setFont(new java.awt.Font("Kalinga", 0, 14)); // NOI18N
        PasswordLabel.setText("Password:");
        LogInPanel.add(PasswordLabel);
        PasswordLabel.setBounds(251, 382, 69, 17);

        UsernameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameInputActionPerformed(evt);
            }
        });
        LogInPanel.add(UsernameInput);
        UsernameInput.setBounds(350, 340, 210, 30);

        forgotPswLink.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        forgotPswLink.setForeground(new java.awt.Color(255, 0, 0));
        forgotPswLink.setText("Forgot Password ?");
        forgotPswLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forgotPswLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPswLinkMouseClicked(evt);
            }
        });
        LogInPanel.add(forgotPswLink);
        forgotPswLink.setBounds(413, 516, 117, 15);

        createAccountLink.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        createAccountLink.setForeground(new java.awt.Color(255, 0, 0));
        createAccountLink.setText("Create Account");
        createAccountLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createAccountLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createAccountLinkMouseClicked(evt);
            }
        });
        LogInPanel.add(createAccountLink);
        createAccountLink.setBounds(413, 495, 81, 15);

        PasswordInput.setToolTipText("");
        PasswordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordInputActionPerformed(evt);
            }
        });
        LogInPanel.add(PasswordInput);
        PasswordInput.setBounds(350, 376, 210, 30);

        getContentPane().add(LogInPanel);
        LogInPanel.setBounds(0, 0, 900, 610);

        RegistrationPanel.setBackground(new java.awt.Color(255, 255, 255));
        RegistrationPanel.setMaximumSize(new java.awt.Dimension(900, 600));
        RegistrationPanel.setMinimumSize(new java.awt.Dimension(900, 600));
        RegistrationPanel.setLayout(null);

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        titleLabel.setText("Welcome !");
        RegistrationPanel.add(titleLabel);
        titleLabel.setBounds(322, 176, 252, 58);

        headingLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        headingLabel.setText("Create Account:");
        RegistrationPanel.add(headingLabel);
        headingLabel.setBounds(400, 252, 97, 17);

        userLabel.setText("Username: ");
        RegistrationPanel.add(userLabel);
        userLabel.setBounds(328, 290, 70, 16);

        passLabel.setText("Password:");
        RegistrationPanel.add(passLabel);
        passLabel.setBounds(333, 321, 63, 16);

        confirmLabel.setText("Confirm password:");
        RegistrationPanel.add(confirmLabel);
        confirmLabel.setBounds(280, 350, 119, 16);

        nameLabel.setText("Forename:");
        RegistrationPanel.add(nameLabel);
        nameLabel.setBounds(331, 383, 65, 16);

        surnameLabel.setText("Surname:");
        RegistrationPanel.add(surnameLabel);
        surnameLabel.setBounds(337, 411, 58, 16);

        emailLabel.setText("email:");
        RegistrationPanel.add(emailLabel);
        emailLabel.setBounds(355, 442, 38, 16);
        RegistrationPanel.add(usernameField);
        usernameField.setBounds(401, 287, 201, 26);
        RegistrationPanel.add(forenameField);
        forenameField.setBounds(401, 380, 201, 26);
        RegistrationPanel.add(surnameField);
        surnameField.setBounds(401, 411, 201, 26);
        RegistrationPanel.add(emailField);
        emailField.setBounds(401, 442, 201, 26);

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        RegistrationPanel.add(cancelBtn);
        cancelBtn.setBounds(300, 560, 107, 29);

        createBtn.setText("Create Account");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });
        RegistrationPanel.add(createBtn);
        createBtn.setBounds(500, 560, 140, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
        RegistrationPanel.add(jLabel1);
        jLabel1.setBounds(140, 61, 602, 104);

        passField.setToolTipText("");
        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });
        RegistrationPanel.add(passField);
        passField.setBounds(400, 320, 210, 26);

        confirmPassField.setToolTipText("");
        confirmPassField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPassFieldActionPerformed(evt);
            }
        });
        RegistrationPanel.add(confirmPassField);
        confirmPassField.setBounds(400, 350, 210, 26);

        emailLabel1.setText("Mobile No.");
        RegistrationPanel.add(emailLabel1);
        emailLabel1.setBounds(318, 470, 70, 16);
        RegistrationPanel.add(mobilNumField);
        mobilNumField.setBounds(400, 470, 201, 26);

        emailLabel2.setText("Date of birth (dd/mm/yyyy)");
        RegistrationPanel.add(emailLabel2);
        emailLabel2.setBounds(218, 500, 180, 16);
        RegistrationPanel.add(DOBField);
        DOBField.setBounds(400, 500, 201, 26);

        getContentPane().add(RegistrationPanel);
        RegistrationPanel.setBounds(0, 0, 900, 600);

        ForgotPasswordPanel.setBackground(new java.awt.Color(255, 255, 255));
        ForgotPasswordPanel.setMaximumSize(new java.awt.Dimension(900, 600));
        ForgotPasswordPanel.setMinimumSize(new java.awt.Dimension(900, 600));
        ForgotPasswordPanel.setLayout(null);

        informLabelFP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        informLabelFP.setText("Did you forget password? Do NOT worry, please insert:");
        ForgotPasswordPanel.add(informLabelFP);
        informLabelFP.setBounds(260, 320, 335, 15);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
        ForgotPasswordPanel.add(jLabel2);
        jLabel2.setBounds(149, 78, 602, 119);

        usernameLabelFP.setText("Username:");
        ForgotPasswordPanel.add(usernameLabelFP);
        usernameLabelFP.setBounds(320, 380, 66, 16);

        emailLabelFP.setText("email:");
        ForgotPasswordPanel.add(emailLabelFP);
        emailLabelFP.setBounds(340, 420, 38, 16);
        ForgotPasswordPanel.add(usernameFieldFP);
        usernameFieldFP.setBounds(390, 380, 180, 26);
        ForgotPasswordPanel.add(emailFieldFP);
        emailFieldFP.setBounds(390, 410, 180, 26);

        acceptBtnFP.setText("Accept");
        ForgotPasswordPanel.add(acceptBtnFP);
        acceptBtnFP.setBounds(510, 500, 86, 29);

        cancelBtnFP.setText("Cancel");
        ForgotPasswordPanel.add(cancelBtnFP);
        cancelBtnFP.setBounds(320, 500, 86, 29);

        getContentPane().add(ForgotPasswordPanel);
        ForgotPasswordPanel.setBounds(0, 0, 900, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsernameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameInputActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
       System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        login();
    }//GEN-LAST:event_loginBtnActionPerformed

    private void PasswordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordInputActionPerformed

    private void createAccountLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createAccountLinkMouseClicked
        
        
            LogInPanel.setVisible(false);
            RegistrationPanel.setVisible(true);
            
        
                              
        
        
    }//GEN-LAST:event_createAccountLinkMouseClicked

    private void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFieldActionPerformed

    private void confirmPassFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPassFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPassFieldActionPerformed

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        
        String username = usernameField.getText();
        String password = String.valueOf(passField.getPassword());
        String passwordConfirm = String.valueOf(confirmPassField.getPassword());

        String name = forenameField.getText();
        String surname = surnameField.getText();
        String email = emailField.getText();
        String DOB = DOBField.getText();
        
        String mobilNumber = mobilNumField.getText();
        //Integer mobilNumber = Integer.parseInt(mobilNumField.getText());
        
        int emailValidation = email.indexOf('@');

        
        boolean confirm = true;
        
        if(username.isEmpty()|| password.isEmpty() || passwordConfirm.isEmpty() || name.isEmpty() || surname.isEmpty() || email.isEmpty()|| DOB.isEmpty() || mobilNumber.isEmpty()){
          
        confirm = false;
        
        }
        
        // validation process, sets lenths and types needed to validate form
        if (confirm) { //Checks to see all fields are complete.
            if (emailValidation >= 0) {
              
                if (surname.length() <= 45) {
                    if (name.length() <= 45) {
                        if(DOB.length() >= 10 && DOB.length() <= 10){
                            if(mobilNumber.length()>=11 && mobilNumber.length()<=11){
                            if(password.equals(passwordConfirm)){
                                
                            
                        userAdminAccount user = new userAdminAccount();
                        boolean result = user.usernameAvailability(username);
                        if (result) {
                            
                            user.setUsername(username);                        
                            user.setPassword(password);
                            user.setFname(name);
                            user.setSname(surname);
                            user.setEmail(email);
                            user.setDOB(DOB);     
                            user.setMobil(mobilNumber); 
                            user.setType(false);
                            
                            user.saveUser();
                            
                            //if valid the account is created in database 
                            JOptionPane.showMessageDialog(null, "Account Created. You will be returned to the Log In Page", "Account Created", JOptionPane.INFORMATION_MESSAGE);
                            LogInForm frm = new LogInForm();
                            this.setVisible(false);
                            frm.setVisible(true);

                        }else{ //error messages for validation
                         JOptionPane.showMessageDialog(null, "Account in use, ","", JOptionPane.INFORMATION_MESSAGE);
                        
                        }
                        } else {
                        JOptionPane.showMessageDialog(null, "Passwords dont match", "", JOptionPane.INFORMATION_MESSAGE);

                    }
                            } else {
                        JOptionPane.showMessageDialog(null, "Invaild Mobile Number", "", JOptionPane.INFORMATION_MESSAGE);

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

    }//GEN-LAST:event_createBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        LogInPanel.setVisible(true);
        RegistrationPanel.setVisible(false);
        
       
        for (Component c : RegistrationPanel.getComponents())
        {
            if (c instanceof JTextField)
            {
                JTextField j = (JTextField)c;
                j.setText("");
            }
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void forgotPswLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPswLinkMouseClicked
       LogInPanel.setVisible(false);
       ForgotPasswordPanel.setVisible(true);
    }//GEN-LAST:event_forgotPswLinkMouseClicked
   
    private void login() {

        String username = UsernameInput.getText();
        String password = String.valueOf(PasswordInput.getPassword());
        
//create new user account
        userAdminAccount user = new userAdminAccount();
          

        boolean successful = user.checkPassword(username, password);
        if (successful) {
            
            user.LogInService(username, password); //asks for username and password

            AdminUserFrame frm = new AdminUserFrame(user); //opens general user form
            this.setVisible(false);
            frm.setVisible(true);

          
        } else { //error message prompted
            JOptionPane.showMessageDialog(null, "User account can not be found. Please try again or create a new account", "No Account Found", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
                ServerControl.connect(); //Connect to VM via ssh Tunnel 

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
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DOBField;
    private javax.swing.JPanel ForgotPasswordPanel;
    private javax.swing.JPanel LogInPanel;
    private javax.swing.JPasswordField PasswordInput;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPanel RegistrationPanel;
    private javax.swing.JLabel UserNameLabel;
    private javax.swing.JTextField UsernameInput;
    private javax.swing.JButton acceptBtnFP;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton cancelBtnFP;
    private javax.swing.JLabel confirmLabel;
    private javax.swing.JPasswordField confirmPassField;
    private javax.swing.JLabel createAccountLink;
    private javax.swing.JButton createBtn;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField emailFieldFP;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailLabel1;
    private javax.swing.JLabel emailLabel2;
    private javax.swing.JLabel emailLabelFP;
    private javax.swing.JButton exitBtn;
    private javax.swing.JTextField forenameField;
    private javax.swing.JLabel forgotPswLink;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JLabel informLabelFP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField mobilNumField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JTextField usernameFieldFP;
    private javax.swing.JLabel usernameLabelFP;
    // End of variables declaration//GEN-END:variables
}

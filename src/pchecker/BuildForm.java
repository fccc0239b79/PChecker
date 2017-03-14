/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pchecker;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Pawel
 */
public class BuildForm extends javax.swing.JFrame {

    /**
     * Creates new form BuildForm
     */
    build newBuild = new build();
    userAdminAccount currentUser;

    public BuildForm() {
        initComponents();
        setLocationRelativeTo(null);
        
    }
    public BuildForm(userAdminAccount user) {
        initComponents();
        setLocationRelativeTo(null);
        currentUser = user;
        if(currentUser.getType()){
            addPart.setVisible(true);
        }else{
         buildPanel.setVisible(true);
        }
        
    }
    public BuildForm(userAdminAccount user,String Build) {
        initComponents();
        setLocationRelativeTo(null);
        editPanel.setVisible(true);
        currentUser = user;
        
        
    }
     public void enbleButtons(){
         
        for (Component c : buildPanel.getComponents())
        {
            if (c instanceof JButton)
            {
                c.setEnabled(true);
           
            }
     }
     }
     
     DefaultTableModel modelParts = new DefaultTableModel();

    public void addPart(String part){

        //partsTable.setEnabled(false);

        buildPanel.setVisible(false);
        addBuildPanel.setVisible(true);
        

        modelParts = currentUser.getparts(part);
        
        partsTable.setModel(modelParts);
        
        //partsTable.disable();             
        partsTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {


                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2 && partsTable.isEnabled()) {

                String PartID = modelParts.getValueAt(row, 0).toString();
                String partModel = modelParts.getValueAt(row, modelParts.findColumn("Model")).toString();
                
                

                   System.out.println(PartID);
                switch (part) {
                
                    case "Motherboard": newBuild.setMotherboard(Integer.parseInt(PartID));
                                        motherboardBtn.setText("MotherBoard "+partModel);
                                        enbleButtons();
                                        break;
                    case "CPU": newBuild.setCPU(Integer.parseInt(PartID));
                                processorBtn.setText("Processor "+partModel);
                                break;
                    case "RAM": newBuild.setRAM(Integer.parseInt(PartID));
                                ramBtn.setText("RAM "+partModel);
                                break;
                    case "GPU": newBuild.setGPU(Integer.parseInt(PartID)); 
                                graphicsBtn.setText("Graphics card \n"+partModel);
                                break;
                    case "Storage": newBuild.setStorage(Integer.parseInt(PartID)); 
                                    hddBtn.setText("HDD \n"+partModel);
                                    break;
                    case "Accessory": newBuild.setAccessory(Integer.parseInt(PartID));
                                      accessoriesBtn.setText("Accessories \n"+partModel);
                                      break;
                    case "PSU": newBuild.setPSU(Integer.parseInt(PartID));    
                                supplyBtn.setText("Power Supply \n"+partModel);
                                break;
                    case "PCCase": newBuild.setPCCase(Integer.parseInt(PartID));  
                                   caseBtn.setText("Case \n"+partModel);
                                   break;
                    case "Cooler": newBuild.setCooler(Integer.parseInt(PartID));
                                   coolingBtn.setText("Cooling \n"+partModel);
                                    break;
                  

                
                }
                buildPanel.setVisible(true);
                addBuildPanel.setVisible(false);
                
                
                }
            }
        });
    }
    
    ArrayList<JLabel> labels = new ArrayList<JLabel>();
    ArrayList<JTextField> inputbox = new ArrayList<JTextField>();

    public void addingNewPart(){

        String newPartType = String.valueOf(partTypeComboBox.getSelectedItem());
        
        ArrayList<String> tableColums = currentUser.getTableColName(newPartType);
        ArrayList<String> dataType = currentUser.getTableData();
        
        tableColums.remove(0);
        
        
        for(int i = 0; i < labels.size(); i++){
            addPart.remove(labels.get(i));
            addPart.remove(inputbox.get(i));
        }
        labels.clear();
        inputbox.clear();
        
        //creats so many labels and input fields 
        int y = 250, x = 0;
        for (String name : tableColums) {
            //Creation of label feild
            JLabel label100  = new JLabel("("+dataType.get(x)+") "+name+":", SwingConstants.RIGHT);
            label100.setBounds(0, y, 160, 30);
            labels.add(label100);
            addPart.add(label100);
            
            //Creation of input field
            JTextField textField = new JTextField(10);
            textField.setName(name+"Input");
            textField.setBounds(170, y, 260, 30);
            inputbox.add(textField);
            addPart.add(textField);
            
            y += 40;
            x++;
        }
        addPart.repaint();
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
        acceptBuildBtn = new javax.swing.JButton();
        logoB = new javax.swing.JLabel();
        buildNameLabelB = new javax.swing.JLabel();
        buildNametxt = new javax.swing.JTextField();
        motherboardBtn = new javax.swing.JButton();
        processorBtn = new javax.swing.JButton();
        ramBtn = new javax.swing.JButton();
        graphicsBtn = new javax.swing.JButton();
        hddBtn = new javax.swing.JButton();
        caseBtn = new javax.swing.JButton();
        supplyBtn = new javax.swing.JButton();
        coolingBtn = new javax.swing.JButton();
        accessoriesBtn = new javax.swing.JButton();
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
        addBuildPanel = new javax.swing.JPanel();
        buildCancelBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        partsTable = new javax.swing.JTable();
        addPart = new javax.swing.JPanel();
        addPartSaveBtn = new javax.swing.JButton();
        addPartCancelBtn = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        partTypeComboBox = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        addPartMakeInput = new javax.swing.JTextField();
        addPartModelInput = new javax.swing.JTextField();
        addPartPriceInput = new javax.swing.JTextField();

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
        cancelBtnE.setBounds(820, 10, 86, 42);

        acceptBtnE.setText("Accept");
        editPanel.add(acceptBtnE);
        acceptBtnE.setBounds(740, 10, 87, 42);
        editPanel.add(componentsListE);
        componentsListE.setBounds(147, 258, 602, 282);

        editLabelE.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        editLabelE.setText("EDIT BUILD:");
        editPanel.add(editLabelE);
        editLabelE.setBounds(342, 196, 229, 44);

        getContentPane().add(editPanel);
        editPanel.setBounds(0, 0, 900, 600);
        editPanel.setVisible(false);

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
        cancelBtnB.setBounds(825, 11, 86, 42);

        acceptBuildBtn.setText("Accept");
        acceptBuildBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBuildBtnActionPerformed(evt);
            }
        });
        buildPanel.add(acceptBuildBtn);
        acceptBuildBtn.setBounds(700, 10, 87, 42);

        logoB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
        buildPanel.add(logoB);
        logoB.setBounds(145, 64, 602, 119);

        buildNameLabelB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buildNameLabelB.setText("Build Name:");
        buildPanel.add(buildNameLabelB);
        buildNameLabelB.setBounds(263, 288, 115, 36);

        buildNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildNametxtActionPerformed(evt);
            }
        });
        buildPanel.add(buildNametxt);
        buildNametxt.setBounds(384, 288, 246, 36);

        motherboardBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        motherboardBtn.setText("MOTHERBOARD");
        motherboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motherboardBtnActionPerformed(evt);
            }
        });
        buildPanel.add(motherboardBtn);
        motherboardBtn.setBounds(250, 340, 132, 62);

        processorBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        processorBtn.setText("PROCESSOR");
        processorBtn.setEnabled(false);
        processorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processorBtnActionPerformed(evt);
            }
        });
        buildPanel.add(processorBtn);
        processorBtn.setBounds(384, 342, 125, 62);

        ramBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ramBtn.setText("RAM");
        ramBtn.setEnabled(false);
        ramBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramBtnActionPerformed(evt);
            }
        });
        buildPanel.add(ramBtn);
        ramBtn.setBounds(515, 342, 115, 62);

        graphicsBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        graphicsBtn.setText("GRAPHICS CARD");
        graphicsBtn.setEnabled(false);
        graphicsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphicsBtnActionPerformed(evt);
            }
        });
        buildPanel.add(graphicsBtn);
        graphicsBtn.setBounds(384, 410, 130, 60);

        hddBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        hddBtn.setText("HDD");
        hddBtn.setEnabled(false);
        hddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hddBtnActionPerformed(evt);
            }
        });
        buildPanel.add(hddBtn);
        hddBtn.setBounds(259, 410, 119, 60);

        caseBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        caseBtn.setText("CASE");
        caseBtn.setEnabled(false);
        caseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caseBtnActionPerformed(evt);
            }
        });
        buildPanel.add(caseBtn);
        caseBtn.setBounds(515, 410, 115, 60);

        supplyBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        supplyBtn.setText("POWER SUPPLY");
        supplyBtn.setEnabled(false);
        supplyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplyBtnActionPerformed(evt);
            }
        });
        buildPanel.add(supplyBtn);
        supplyBtn.setBounds(259, 476, 119, 60);

        coolingBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        coolingBtn.setText("COOLING");
        coolingBtn.setEnabled(false);
        coolingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coolingBtnActionPerformed(evt);
            }
        });
        buildPanel.add(coolingBtn);
        coolingBtn.setBounds(384, 476, 125, 60);

        accessoriesBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        accessoriesBtn.setText("ACCESSORIES");
        accessoriesBtn.setEnabled(false);
        accessoriesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accessoriesBtnActionPerformed(evt);
            }
        });
        buildPanel.add(accessoriesBtn);
        accessoriesBtn.setBounds(515, 476, 115, 60);

        getContentPane().add(buildPanel);
        buildPanel.setBounds(0, 0, 900, 600);
        buildPanel.setVisible(false);

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
        jComboBox1.setBounds(440, 290, 220, 27);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        createAccount.add(jTextField1);
        jTextField1.setBounds(440, 320, 220, 26);
        createAccount.add(jTextField2);
        jTextField2.setBounds(440, 350, 220, 26);
        createAccount.add(jTextField3);
        jTextField3.setBounds(440, 380, 220, 26);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        createAccount.add(jTextField4);
        jTextField4.setBounds(440, 410, 220, 26);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("email:");
        createAccount.add(jLabel11);
        jLabel11.setBounds(300, 470, 70, 17);
        createAccount.add(jTextField5);
        jTextField5.setBounds(440, 440, 220, 26);
        createAccount.add(jTextField6);
        jTextField6.setBounds(440, 470, 220, 20);

        getContentPane().add(createAccount);
        createAccount.setBounds(0, 0, 900, 600);
        createAccount.setVisible(false);

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
        jScrollPane1.setBounds(220, 290, 454, 170);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("View Accounts:");
        viewAccount.add(jLabel12);
        jLabel12.setBounds(330, 210, 259, 41);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Back");
        viewAccount.add(jButton4);
        jButton4.setBounds(50, 500, 130, 60);

        getContentPane().add(viewAccount);
        viewAccount.setBounds(0, 0, 900, 600);
        viewAccount.setVisible(false);

        addBuildPanel.setBackground(new java.awt.Color(255, 255, 255));
        addBuildPanel.setMaximumSize(new java.awt.Dimension(900, 600));
        addBuildPanel.setMinimumSize(new java.awt.Dimension(900, 600));
        addBuildPanel.setLayout(null);

        buildCancelBtn.setText("Cancel");
        buildCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildCancelBtnActionPerformed(evt);
            }
        });
        addBuildPanel.add(buildCancelBtn);
        buildCancelBtn.setBounds(10, 10, 70, 40);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
        addBuildPanel.add(jLabel13);
        jLabel13.setBounds(160, 10, 620, 150);

        partsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}

    );
    partsTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            partsTableMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(partsTable);

    addBuildPanel.add(jScrollPane2);
    jScrollPane2.setBounds(160, 230, 560, 200);

    getContentPane().add(addBuildPanel);
    addBuildPanel.setBounds(0, 0, 900, 600);
    addBuildPanel.setVisible(false);

    addPart.setMaximumSize(new java.awt.Dimension(900, 600));
    addPart.setMinimumSize(new java.awt.Dimension(900, 600));
    addPart.setPreferredSize(new java.awt.Dimension(900, 600));
    addPart.setLayout(null);

    addPartSaveBtn.setText("Save");
    addPartSaveBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addPartSaveBtnActionPerformed(evt);
        }
    });
    addPart.add(addPartSaveBtn);
    addPartSaveBtn.setBounds(650, 90, 75, 29);

    addPartCancelBtn.setText("Cancel");
    addPartCancelBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addPartCancelBtnActionPerformed(evt);
        }
    });
    addPart.add(addPartCancelBtn);
    addPartCancelBtn.setBounds(730, 90, 86, 30);

    jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel14.setText("Part type:");
    addPart.add(jLabel14);
    jLabel14.setBounds(90, 90, 70, 30);

    partTypeComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    partTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Choose-", "Motherboard", "CPU", "GPU", "RAM", "Storage", "PSU", "PCCase", "Accessory", "Cooler" }));
    partTypeComboBox.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            partTypeComboBoxItemStateChanged(evt);
        }
    });
    partTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            partTypeComboBoxActionPerformed(evt);
        }
    });
    addPart.add(partTypeComboBox);
    partTypeComboBox.setBounds(170, 90, 170, 30);

    jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel15.setText("(varchar) Make:");
    addPart.add(jLabel15);
    jLabel15.setBounds(0, 130, 160, 30);

    jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel16.setText("(varchar) Model:");
    addPart.add(jLabel16);
    jLabel16.setBounds(0, 170, 160, 30);

    jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel17.setText("(int) Price:");
    addPart.add(jLabel17);
    jLabel17.setBounds(0, 210, 160, 30);

    addPartMakeInput.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addPartMakeInputActionPerformed(evt);
        }
    });
    addPart.add(addPartMakeInput);
    addPartMakeInput.setBounds(170, 130, 260, 30);
    addPart.add(addPartModelInput);
    addPartModelInput.setBounds(170, 170, 260, 30);

    addPartPriceInput.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addPartPriceInputActionPerformed(evt);
        }
    });
    addPart.add(addPartPriceInput);
    addPartPriceInput.setBounds(170, 210, 260, 30);

    getContentPane().add(addPart);
    addPart.setBounds(0, 0, 900, 600);
    addPart.setVisible(false);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void buildNametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildNametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buildNametxtActionPerformed

    private void accessoriesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accessoriesBtnActionPerformed
        addPart("Accessory");
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

    private void buildCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildCancelBtnActionPerformed
        
        buildPanel.setVisible(true);
        addBuildPanel.setVisible(false);
        
        
    }//GEN-LAST:event_buildCancelBtnActionPerformed

    private void motherboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motherboardBtnActionPerformed
        addPart("Motherboard");
    }//GEN-LAST:event_motherboardBtnActionPerformed

    private void processorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processorBtnActionPerformed
       addPart("CPU");
    }//GEN-LAST:event_processorBtnActionPerformed

    private void ramBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramBtnActionPerformed
       addPart("RAM");
    }//GEN-LAST:event_ramBtnActionPerformed

    private void hddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hddBtnActionPerformed
        addPart("Storage");
    }//GEN-LAST:event_hddBtnActionPerformed

    private void graphicsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphicsBtnActionPerformed
        addPart("GPU");
    }//GEN-LAST:event_graphicsBtnActionPerformed

    private void caseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caseBtnActionPerformed
        addPart("PCCase");
    }//GEN-LAST:event_caseBtnActionPerformed

    private void supplyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplyBtnActionPerformed
       addPart("PSU");
    }//GEN-LAST:event_supplyBtnActionPerformed

    private void coolingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coolingBtnActionPerformed
       addPart("Cooler");
    }//GEN-LAST:event_coolingBtnActionPerformed

    private void addPartCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPartCancelBtnActionPerformed
        AdminUserFrame frm = new AdminUserFrame(currentUser); //opens general user form
        this.dispose();
        frm.setVisible(true);
    }//GEN-LAST:event_addPartCancelBtnActionPerformed

    private void addPartMakeInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPartMakeInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addPartMakeInputActionPerformed

    private void addPartPriceInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPartPriceInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addPartPriceInputActionPerformed

    private void partTypeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_partTypeComboBoxItemStateChanged
    }//GEN-LAST:event_partTypeComboBoxItemStateChanged

    private void partTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partTypeComboBoxActionPerformed
                addingNewPart();
    }//GEN-LAST:event_partTypeComboBoxActionPerformed

    private void addPartSaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPartSaveBtnActionPerformed
    
        ArrayList<String> info = new ArrayList<String>();
        ArrayList<String> infopart = new ArrayList<String>();

        String partT = String.valueOf(partTypeComboBox.getSelectedItem());
        String model =addPartModelInput.getText();
        String make = addPartMakeInput.getText();
        String price = addPartPriceInput.getText();
        
        for(int i = 0; i < inputbox.size(); i++){
            System.out.println(inputbox.get(i).getText());
            
            infopart.add(inputbox.get(i).getText());
        }
        
   
        info.add(price);
        info.add(model);
        info.add(make);
        info.add(partT);
        

        
        
        currentUser.savePart(partT, info,infopart);
        
        
        
    }//GEN-LAST:event_addPartSaveBtnActionPerformed

    private void partsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partsTableMouseClicked

    }//GEN-LAST:event_partsTableMouseClicked

    private void acceptBuildBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBuildBtnActionPerformed
       
        saveB();
        
        
    }//GEN-LAST:event_acceptBuildBtnActionPerformed

    public void saveB(){
        newBuild.setBuildName(buildNametxt.getText());
        newBuild.savebuild(currentUser.getUsername());
        
        AdminUserFrame frm = new AdminUserFrame(currentUser); //opens general user form
        this.dispose();
        frm.setVisible(true);

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
    private javax.swing.JButton acceptBtnE;
    private javax.swing.JButton acceptBuildBtn;
    private javax.swing.JButton accessoriesBtn;
    private javax.swing.JPanel addBuildPanel;
    private javax.swing.JPanel addPart;
    private javax.swing.JButton addPartCancelBtn;
    private javax.swing.JTextField addPartMakeInput;
    private javax.swing.JTextField addPartModelInput;
    private javax.swing.JTextField addPartPriceInput;
    private javax.swing.JButton addPartSaveBtn;
    private javax.swing.JButton buildCancelBtn;
    private javax.swing.JLabel buildNameLabelB;
    private javax.swing.JTextField buildNametxt;
    private javax.swing.JPanel buildPanel;
    private javax.swing.JButton cancelBtnB;
    private javax.swing.JButton cancelBtnE;
    private javax.swing.JButton caseBtn;
    private javax.swing.JScrollPane componentsListE;
    private javax.swing.JButton coolingBtn;
    private javax.swing.JPanel createAccount;
    private javax.swing.JLabel editLabelE;
    private javax.swing.JPanel editPanel;
    private javax.swing.JButton graphicsBtn;
    private javax.swing.JButton hddBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JComboBox<String> partTypeComboBox;
    private javax.swing.JTable partsTable;
    private javax.swing.JButton processorBtn;
    private javax.swing.JButton ramBtn;
    private javax.swing.JButton supplyBtn;
    private javax.swing.JPanel viewAccount;
    // End of variables declaration//GEN-END:variables
}

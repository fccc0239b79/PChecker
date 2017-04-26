/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pchecker;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.JTextComponent;
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
        buildPanel.setVisible(true);
        
        
    }
    public BuildForm(userAdminAccount user, Boolean view) {
        initComponents();
        setLocationRelativeTo(null);
        currentUser = user;
        compareBuilds.setVisible(true);
       
        
          ArrayList<String> builds = currentUser.getBuilds();
        
        for(int i = 0; i < builds.size(); i++){
            buildsOne.addItem(builds.get(i));
            buildsTwo.addItem(builds.get(i));
        }
        
        
    }
    //adding new part 
    public BuildForm(userAdminAccount user,Boolean TorF,String partType, ArrayList<String> INFO) {
        initComponents();
        setLocationRelativeTo(null);
        currentUser = user;
        addPart.setVisible(true);
        viewPartPanel.setVisible(false);
        
        if(partType!=""){
            partTypeComboBox.setSelectedItem(partType);
        }
    }
    
    public BuildForm(userAdminAccount user, Boolean TorF, Boolean ViewP){
        initComponents();
        setLocationRelativeTo(null);
        currentUser = user;
        viewPartPanel.setVisible(true);
    }
    
    public BuildForm(userAdminAccount user,String buildName) {
        initComponents();
        setLocationRelativeTo(null);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        buildPanel.setVisible(true);
        
        acceptBuildBtn.setVisible(false);
        updateBtn.setVisible(true);
        deleteBuildBtn.setVisible(true);
        
        buildNameLabelB.setVisible(false);
        newBuildTitleLable.setVisible(false);
        buildNametxt.setText(buildName);//setVisible(false);
        buildNametxt.setEnabled(false);
        
        currentUser = user;
        setEditBuild(buildName);
        
        choosenPartLabel();
        runCompatibilityCheck();
    }
    
    public void choosenPartLabel() {
         // BUILD PANEL PART LABELS 
        accessoriesLabelSelectedPart.setVisible(true);
        caseLabelSelectedPart.setVisible(true);
        coolingLabelSelectedPart.setVisible(true);
        gpuLabelSelectedPart.setVisible(true);
        hddLabelSelectedPart.setVisible(true);
        motherboardLabelSelectedPart1.setVisible(true);
        processorLabelSelectedPart.setVisible(true);
        psuLabelSelectedPart.setVisible(true);
        ramLabelSelectedPart.setVisible(true);
     
        
       accessoriesLabelSelectedPart.setText(newBuild.getPartName("Accessory"));   
       caseLabelSelectedPart.setText( newBuild.getPartName("PCCase"));
       coolingLabelSelectedPart.setText(newBuild.getPartName("Cooler"));
       gpuLabelSelectedPart.setText( newBuild.getPartName("GPU"));
       hddLabelSelectedPart.setText( newBuild.getPartName("Storage"));
       motherboardLabelSelectedPart1.setText(newBuild.getPartName("Motherboard"));
       processorLabelSelectedPart.setText( newBuild.getPartName("CPU"));
       psuLabelSelectedPart.setText( newBuild.getPartName("PSU"));
       ramLabelSelectedPart.setText( newBuild.getPartName("RAM"));
       

       accessories_ID.setText(String.valueOf(newBuild.getAccessory()));
       case_ID.setText(String.valueOf(newBuild.getCase()));
       cooling_ID.setText(String.valueOf(newBuild.getCooler()));
       graphics_ID.setText(String.valueOf(newBuild.getGpu()));
       hdd_ID.setText(String.valueOf(newBuild.getStorage()));
       motherboard_ID.setText(String.valueOf(newBuild.getMotherboard()));
       processor_ID.setText(String.valueOf(newBuild.getCPU()));
       powersupply_ID.setText(String.valueOf(newBuild.getPSU()));
       ram_ID.setText(String.valueOf(newBuild.getRam()));
       
       accessories_Price.setText(String.valueOf(newBuild.getPartPrice("Accessory")));   
        case_Price.setText(String.valueOf(newBuild.getPartPrice("PCCase")));
        cooling_Price.setText(String.valueOf(newBuild.getPartPrice("Cooler")));
        graphics_Price.setText(String.valueOf(newBuild.getPartPrice("GPU")));
        hdd_Price.setText(String.valueOf(newBuild.getPartPrice("Storage")));
        motherboard_Price.setText(String.valueOf(newBuild.getPartPrice("Motherboard")));
        processor_Price.setText(String.valueOf(newBuild.getPartPrice("CPU")));
        powersupply_Price.setText(String.valueOf(newBuild.getPartPrice("PSU")));
        ram_Price.setText(String.valueOf(newBuild.getPartPrice("RAM")));
       
       
       buildTotalCostLbl.setText(String.valueOf(newBuild.getBuildCost()));
      
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
     String choosenPart;
     
    public void addPart(String part){

     

        buildPanel.setVisible(false);
        addBuildPanel.setVisible(true);
        

        modelParts = currentUser.getparts(part);
        
        partsTable.setModel(modelParts);
        choosenPart = part;
       
        
    }
   
    
    private HashMap componentMap;
    
    private void createComponentMap() {
            componentMap = new HashMap<String,Component>();
            Component[] components = addPart.getComponents();
            for (int i=0; i < components.length; i++) {
                    componentMap.put(components[i].getName(), components[i]);
            }
    }

    public Component getComponentByName(String name) {
        if (componentMap.containsKey(name)) {
                return (Component) componentMap.get(name);
        }
        else return null;
}
    
    ArrayList<JLabel> labels = new ArrayList<JLabel>();
        ArrayList<JLabel> errLables = new ArrayList<JLabel>();

    
    ArrayList<JTextField> inputbox = new ArrayList<JTextField>();
    ArrayList<String> tableColums = new ArrayList<String>();
    
    
   public void addingNewPart(){
        
        addPartSaveBtn.setEnabled(false);

        String newPartType = String.valueOf(partTypeComboBox.getSelectedItem());
        
        tableColums = currentUser.getTableColName(newPartType);
        
        ArrayList<String> dataType = currentUser.getTableData();
        
        System.out.print(tableColums+" - "+dataType);
        //tableColums.remove(0);
        
        for(int i = 0; i < labels.size(); i++){
            addPart.remove(labels.get(i));
            if(i < labels.size()/2){
                addPart.remove(inputbox.get(i));
                addPart.remove(errLables.get(i));
            }
        }
        labels.clear();
        inputbox.clear();
        errLables.clear();
        
        //creats so many labels and input fields 
        int y = 180, x = 0;
        
      
        
        
        for (String name : tableColums) {
            //Creation of label feild
            JLabel label100  = new JLabel(name+": ", SwingConstants.RIGHT);
            label100.setBounds(70, y, 160, 30);
            label100.setFont(new Font("Kalinga", Font.PLAIN, 14));
            labels.add(label100);
            addPart.add(label100);
            
            JLabel errlbl  = new JLabel("", SwingConstants.LEFT);
            errlbl.setName(name+"ERR");
            errlbl.setForeground(Color.RED);
            //errlbl.setBorder(BorderFactory.createLineBorder(Color.RED));
            errlbl.setBounds(510, y, 400, 30);
            errLables.add(errlbl);
            addPart.add(errlbl);
            
            
            JLabel label1000  = new JLabel(dataType.get(x), SwingConstants.RIGHT);
            label1000.setBounds(0, y, 80, 30);
            label1000.setName(name+"Lable");
            label1000.setVisible(false);
            labels.add(label1000);
            addPart.add(label1000);
                        
            //Creation of input field
            JTextField textField = new JTextField(10);
            textField.setName(name+"Input");
            textField.setBounds(240, y, 260, 30);
            if(name != "Model"){
            textField.getDocument().addDocumentListener(new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                      addingNewPartValidation(name);
                    }
                    public void removeUpdate(DocumentEvent e) {
                      addingNewPartValidation(name);

                    }
                    public void insertUpdate(DocumentEvent e) {
                      addingNewPartValidation(name);
                    }
                    
            });
            }else{
                textField.addFocusListener(new FocusListener() {
                    public void focusGained(FocusEvent e) {
                    };
                    public void focusLost(FocusEvent e) {
                        addingNewPartValidation(name);
                    };
                });
            }
            inputbox.add(textField);
            addPart.add(textField);
            
            y += 40;
            x++;
        }
        createComponentMap();

        addPart.repaint();
    }

    private String getContents(Component comp){
        
        if (comp instanceof JTextComponent) {
              return ((JTextComponent)comp).getText();
        }else if (comp instanceof JLabel) {
            return ((JLabel)comp).getText();
        }
        return null;
    }
    
    
    private void addingNewPartValidation(String name){
        

        Component input = getComponentByName(name+"Input");
        Component label = getComponentByName(name+"Lable");    
        Component errlabel = getComponentByName(name+"ERR");    
        JLabel errL =  ((JLabel)errlabel);
        
        String inputText = getContents(input);
        String labelText = getContents(label);
        
        
        
        
        int length = 0;
        String err = "";
        
        Boolean itsAnInt = true;
        switch (labelText){
            case "int":
                length = 4;
                 try { 
                    Integer.parseInt(inputText);
                 } catch(NumberFormatException e) { 
                  itsAnInt = false;
                  err += "Has to be a number";
                 }
                break;
            case "decimal":
                length = 9;
                if(!inputText.matches("\\d+\\.\\d{2}")){
                  itsAnInt = false;
                  err +=" has to be in format 0.00";
                }
                break;
            case "varchar":
                length = 30;
                break;
        }
            
        
        
       
        if(name == "Model"){
            if(currentUser.checkDuplicate(inputText,String.valueOf(partTypeComboBox.getSelectedItem()))){
                err += " Model allready used";
                input.setBackground(Color.RED);
                errL.setText(err);
                return;
            }else{
                input.setBackground(Color.green);
                            errL.setText("");

            }
                
        }
        
        if(inputText.isEmpty()){
            err += " Cant be empty";
                     errL.setText(err);
      

            input.setBackground(Color.RED);
            return;
        }else{
            input.setBackground(Color.green);
                        errL.setText("");

        }
        if(inputText.length() > length ){
           err += " too long,  max " + length + " characters";
         errL.setText(err);

            input.setBackground(Color.RED);
                        return;

        }else{
            input.setBackground(Color.green);
                        errL.setText("");

        }
        if(!itsAnInt){
            
            input.setBackground(Color.RED);
                     errL.setText(err);

                        return;

        }else{
            input.setBackground(Color.green);
            errL.setText("");
        }
        

        ArrayList<String> greens = new ArrayList<String>();

        for (Component c : addPart.getComponents()){
            if (c instanceof JTextField) {
                if(c.getBackground() == Color.green){
                    greens.add("t");
                }
            }
            
        }
        
        
        

        if(greens.size() == tableColums.size()){
           addPartSaveBtn.setEnabled(true);
           addPartUpdateBtn.setEnabled(true);

         }else{
           addPartSaveBtn.setEnabled(false);
           addPartUpdateBtn.setEnabled(false);

        }
            
            
               
        
    }
    
    private void saveNewPart(Boolean TorF){
        
        ArrayList<String> info = new ArrayList<String>();
        ArrayList<String> infopart = new ArrayList<String>();

        String partT = String.valueOf(partTypeComboBox.getSelectedItem());
        //String model =addPartModelInput.getText();
        //String make = addPartMakeInput.getText();
        //String price = addPartPriceInput.getText();
        
        for(int i = 3; i < inputbox.size(); i++){
           System.out.println(inputbox.get(i).getText());
            infopart.add(inputbox.get(i).getText());
        }
        

        info.add(inputbox.get(2).getText());
        info.add(inputbox.get(1).getText());
        info.add(inputbox.get(0).getText());
        info.add(partT);
        

       
        if(TorF){
        int partID = currentUser.savePart(partT, info,infopart);
        addPart.setVisible(false);

        addComp.setVisible(true);
        
        compTable.setModel(currentUser.getCompT(partID));
        }else{
            currentUser.updatePart(partT,partIDLable.getText(), info,infopart);
            AdminUserFrame frm = new AdminUserFrame(currentUser);
            this.dispose();
            frm.setVisible(true);
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

        buildPanel = new javax.swing.JPanel();
        newBuildTitleLable = new javax.swing.JLabel();
        cancelBtnB = new javax.swing.JButton();
        acceptBuildBtn = new javax.swing.JButton();
        logoB = new javax.swing.JLabel();
        buildNameLabelB = new javax.swing.JLabel();
        buildNametxt = new javax.swing.JTextField();
        processorBtn = new javax.swing.JButton();
        motherboardBtn = new javax.swing.JButton();
        ramBtn = new javax.swing.JButton();
        graphicsBtn = new javax.swing.JButton();
        hddBtn = new javax.swing.JButton();
        caseBtn = new javax.swing.JButton();
        supplyBtn = new javax.swing.JButton();
        coolingBtn = new javax.swing.JButton();
        accessoriesBtn = new javax.swing.JButton();
        accessoriesLabelSelectedPart = new javax.swing.JLabel();
        accessories_ID = new javax.swing.JLabel();
        processorLabelSelectedPart = new javax.swing.JLabel();
        ramLabelSelectedPart = new javax.swing.JLabel();
        hddLabelSelectedPart = new javax.swing.JLabel();
        gpuLabelSelectedPart = new javax.swing.JLabel();
        caseLabelSelectedPart = new javax.swing.JLabel();
        psuLabelSelectedPart = new javax.swing.JLabel();
        coolingLabelSelectedPart = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        motherboardLabelSelectedPart1 = new javax.swing.JLabel();
        motherboard_ID = new javax.swing.JLabel();
        processor_ID = new javax.swing.JLabel();
        ram_ID = new javax.swing.JLabel();
        hdd_ID = new javax.swing.JLabel();
        graphics_ID = new javax.swing.JLabel();
        case_ID = new javax.swing.JLabel();
        powersupply_ID = new javax.swing.JLabel();
        cooling_ID = new javax.swing.JLabel();
        buildTotalCostLbl = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        motherboard_Price = new javax.swing.JLabel();
        hdd_Price = new javax.swing.JLabel();
        powersupply_Price = new javax.swing.JLabel();
        cooling_Price = new javax.swing.JLabel();
        accessories_Price = new javax.swing.JLabel();
        case_Price = new javax.swing.JLabel();
        graphics_Price = new javax.swing.JLabel();
        processor_Price = new javax.swing.JLabel();
        ram_Price = new javax.swing.JLabel();
        deleteBuildBtn = new javax.swing.JButton();
        compareBuilds = new javax.swing.JPanel();
        logoE = new javax.swing.JLabel();
        cancelBtnCompare = new javax.swing.JButton();
        buildsTwo = new javax.swing.JComboBox<>();
        buildsOne = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        viewBuildOne = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        viewBuildTwo = new javax.swing.JTable();
        buildTotalCostCompOne = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        buildTotalCostCompTwo = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        addBuildPanel = new javax.swing.JPanel();
        buildCancelBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        partsTable = new javax.swing.JTable();
        viewPartPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        viewAllPartsTable = new javax.swing.JTable();
        partTypeComboBox2 = new javax.swing.JComboBox<>();
        cancelBtnE1 = new javax.swing.JButton();
        acceptBtnE1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
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
        addPart = new javax.swing.JPanel();
        addPartSaveBtn = new javax.swing.JButton();
        addPartCancelBtn = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        partTypeComboBox = new javax.swing.JComboBox<>();
        addPartTitle = new javax.swing.JLabel();
        addPartUpdateBtn = new javax.swing.JButton();
        partIDLable = new javax.swing.JLabel();
        deletePart = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        addComp = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        compTable = new javax.swing.JTable();
        saveCompBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setName("buildFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        buildPanel.setBackground(new java.awt.Color(255, 255, 255));
        buildPanel.setMaximumSize(new java.awt.Dimension(900, 600));
        buildPanel.setMinimumSize(new java.awt.Dimension(900, 600));
        buildPanel.setLayout(null);

        newBuildTitleLable.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        newBuildTitleLable.setText("NEW BUILD");
        buildPanel.add(newBuildTitleLable);
        newBuildTitleLable.setBounds(350, 170, 215, 44);

        cancelBtnB.setText("Cancel");
        cancelBtnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnBActionPerformed(evt);
            }
        });
        buildPanel.add(cancelBtnB);
        cancelBtnB.setBounds(800, 10, 70, 42);

        acceptBuildBtn.setText("Accept");
        acceptBuildBtn.setEnabled(false);
        acceptBuildBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBuildBtnActionPerformed(evt);
            }
        });
        buildPanel.add(acceptBuildBtn);
        acceptBuildBtn.setBounds(730, 10, 70, 42);

        logoB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
        buildPanel.add(logoB);
        logoB.setBounds(140, 50, 602, 119);

        buildNameLabelB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buildNameLabelB.setText("Build Name:");
        buildPanel.add(buildNameLabelB);
        buildNameLabelB.setBounds(270, 230, 115, 36);

        buildNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildNametxtActionPerformed(evt);
            }
        });
        buildNametxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buildNametxtKeyPressed(evt);
            }
        });
        buildPanel.add(buildNametxt);
        buildNametxt.setBounds(390, 230, 246, 36);

        processorBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        processorBtn.setText("PROCESSOR");
        processorBtn.setEnabled(false);
        processorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processorBtnActionPerformed(evt);
            }
        });
        buildPanel.add(processorBtn);
        processorBtn.setBounds(410, 270, 130, 62);

        motherboardBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        motherboardBtn.setText("MOTHERBOARD");
        motherboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motherboardBtnActionPerformed(evt);
            }
        });
        buildPanel.add(motherboardBtn);
        motherboardBtn.setBounds(240, 270, 130, 60);

        ramBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ramBtn.setText("RAM");
        ramBtn.setEnabled(false);
        ramBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramBtnActionPerformed(evt);
            }
        });
        buildPanel.add(ramBtn);
        ramBtn.setBounds(570, 270, 130, 62);

        graphicsBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        graphicsBtn.setText("GRAPHICS CARD");
        graphicsBtn.setEnabled(false);
        graphicsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphicsBtnActionPerformed(evt);
            }
        });
        buildPanel.add(graphicsBtn);
        graphicsBtn.setBounds(390, 390, 130, 60);

        hddBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        hddBtn.setText("HDD");
        hddBtn.setEnabled(false);
        hddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hddBtnActionPerformed(evt);
            }
        });
        buildPanel.add(hddBtn);
        hddBtn.setBounds(230, 390, 130, 60);

        caseBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        caseBtn.setText("CASE");
        caseBtn.setEnabled(false);
        caseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caseBtnActionPerformed(evt);
            }
        });
        buildPanel.add(caseBtn);
        caseBtn.setBounds(550, 390, 130, 60);

        supplyBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        supplyBtn.setText("POWER SUPPLY");
        supplyBtn.setEnabled(false);
        supplyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplyBtnActionPerformed(evt);
            }
        });
        buildPanel.add(supplyBtn);
        supplyBtn.setBounds(250, 500, 130, 60);

        coolingBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        coolingBtn.setText("COOLING");
        coolingBtn.setEnabled(false);
        coolingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coolingBtnActionPerformed(evt);
            }
        });
        buildPanel.add(coolingBtn);
        coolingBtn.setBounds(410, 500, 130, 60);

        accessoriesBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        accessoriesBtn.setText("ACCESSORIES");
        accessoriesBtn.setEnabled(false);
        accessoriesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accessoriesBtnActionPerformed(evt);
            }
        });
        buildPanel.add(accessoriesBtn);
        accessoriesBtn.setBounds(570, 500, 130, 60);

        accessoriesLabelSelectedPart.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        accessoriesLabelSelectedPart.setText("model -  make");
        buildPanel.add(accessoriesLabelSelectedPart);
        accessoriesLabelSelectedPart.setBounds(570, 580, 130, 15);
        accessoriesLabelSelectedPart.setVisible(false);

        accessories_ID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        accessories_ID.setText("MotherB_ID");
        accessories_ID.setName(""); // NOI18N
        buildPanel.add(accessories_ID);
        accessories_ID.setBounds(570, 600, 130, 15);
        accessories_ID.setVisible(false);

        processorLabelSelectedPart.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        processorLabelSelectedPart.setText("model -  make");
        buildPanel.add(processorLabelSelectedPart);
        processorLabelSelectedPart.setBounds(410, 350, 130, 15);
        processorLabelSelectedPart.setVisible(false);

        ramLabelSelectedPart.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ramLabelSelectedPart.setText("model -  make");
        buildPanel.add(ramLabelSelectedPart);
        ramLabelSelectedPart.setBounds(570, 350, 130, 15);
        ramLabelSelectedPart.setVisible(false);

        hddLabelSelectedPart.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hddLabelSelectedPart.setText("model -  make");
        buildPanel.add(hddLabelSelectedPart);
        hddLabelSelectedPart.setBounds(250, 470, 130, 15);
        hddLabelSelectedPart.setVisible(false);

        gpuLabelSelectedPart.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gpuLabelSelectedPart.setText("model -  make");
        buildPanel.add(gpuLabelSelectedPart);
        gpuLabelSelectedPart.setBounds(410, 470, 130, 15);
        gpuLabelSelectedPart.setVisible(false);

        caseLabelSelectedPart.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        caseLabelSelectedPart.setText("model -  make");
        buildPanel.add(caseLabelSelectedPart);
        caseLabelSelectedPart.setBounds(570, 470, 130, 15);
        caseLabelSelectedPart.setVisible(false);

        psuLabelSelectedPart.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        psuLabelSelectedPart.setText("model -  make");
        buildPanel.add(psuLabelSelectedPart);
        psuLabelSelectedPart.setBounds(250, 580, 130, 15);
        psuLabelSelectedPart.setVisible(false);

        coolingLabelSelectedPart.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        coolingLabelSelectedPart.setText("model -  make");
        buildPanel.add(coolingLabelSelectedPart);
        coolingLabelSelectedPart.setBounds(410, 580, 130, 15);
        coolingLabelSelectedPart.setVisible(false);

        updateBtn.setText("Update");
        updateBtn.setEnabled(false);
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        buildPanel.add(updateBtn);
        updateBtn.setBounds(730, 10, 70, 40);
        updateBtn.setVisible(false);

        motherboardLabelSelectedPart1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        motherboardLabelSelectedPart1.setText("model -  make");
        buildPanel.add(motherboardLabelSelectedPart1);
        motherboardLabelSelectedPart1.setBounds(250, 350, 130, 20);
        motherboardLabelSelectedPart1.setVisible(false);

        motherboard_ID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        motherboard_ID.setText("MotherB_ID");
        motherboard_ID.setName(""); // NOI18N
        buildPanel.add(motherboard_ID);
        motherboard_ID.setBounds(250, 370, 130, 15);
        motherboard_ID.setVisible(false);

        processor_ID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        processor_ID.setText("MotherB_ID");
        processor_ID.setName(""); // NOI18N
        buildPanel.add(processor_ID);
        processor_ID.setBounds(410, 370, 130, 15);
        processor_ID.setVisible(false);

        ram_ID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ram_ID.setText("MotherB_ID");
        ram_ID.setName(""); // NOI18N
        buildPanel.add(ram_ID);
        ram_ID.setBounds(570, 370, 130, 15);
        ram_ID.setVisible(false);

        hdd_ID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hdd_ID.setText("MotherB_ID");
        hdd_ID.setName(""); // NOI18N
        buildPanel.add(hdd_ID);
        hdd_ID.setBounds(250, 490, 130, 15);
        hdd_ID.setVisible(false);

        graphics_ID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        graphics_ID.setText("MotherB_ID");
        graphics_ID.setName(""); // NOI18N
        buildPanel.add(graphics_ID);
        graphics_ID.setBounds(410, 490, 130, 15);
        graphics_ID.setVisible(false);

        case_ID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        case_ID.setText("MotherB_ID");
        case_ID.setName(""); // NOI18N
        buildPanel.add(case_ID);
        case_ID.setBounds(570, 490, 130, 15);
        case_ID.setVisible(false);

        powersupply_ID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        powersupply_ID.setText("MotherB_ID");
        powersupply_ID.setName(""); // NOI18N
        buildPanel.add(powersupply_ID);
        powersupply_ID.setBounds(250, 600, 130, 15);
        powersupply_ID.setVisible(false);

        cooling_ID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cooling_ID.setText("MotherB_ID");
        cooling_ID.setName(""); // NOI18N
        buildPanel.add(cooling_ID);
        cooling_ID.setBounds(410, 600, 130, 15);
        cooling_ID.setVisible(false);
        buildPanel.add(buildTotalCostLbl);
        buildTotalCostLbl.setBounds(730, 390, 140, 30);

        jLabel17.setText("Total Cost");
        buildPanel.add(jLabel17);
        jLabel17.setBounds(730, 360, 120, 14);

        motherboard_Price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        motherboard_Price.setText("MotherB_ID");
        motherboard_Price.setName(""); // NOI18N
        buildPanel.add(motherboard_Price);
        motherboard_Price.setBounds(250, 330, 130, 15);

        hdd_Price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hdd_Price.setText("MotherB_ID");
        hdd_Price.setName(""); // NOI18N
        buildPanel.add(hdd_Price);
        hdd_Price.setBounds(250, 450, 130, 15);

        powersupply_Price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        powersupply_Price.setText("MotherB_ID");
        powersupply_Price.setName(""); // NOI18N
        buildPanel.add(powersupply_Price);
        powersupply_Price.setBounds(250, 560, 130, 15);

        cooling_Price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cooling_Price.setText("MotherB_ID");
        cooling_Price.setName(""); // NOI18N
        buildPanel.add(cooling_Price);
        cooling_Price.setBounds(410, 560, 130, 15);

        accessories_Price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        accessories_Price.setText("MotherB_ID");
        accessories_Price.setName(""); // NOI18N
        buildPanel.add(accessories_Price);
        accessories_Price.setBounds(570, 560, 130, 15);

        case_Price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        case_Price.setText("MotherB_ID");
        case_Price.setName(""); // NOI18N
        buildPanel.add(case_Price);
        case_Price.setBounds(570, 450, 130, 15);

        graphics_Price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        graphics_Price.setText("MotherB_ID");
        graphics_Price.setName(""); // NOI18N
        buildPanel.add(graphics_Price);
        graphics_Price.setBounds(410, 450, 130, 15);

        processor_Price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        processor_Price.setText("MotherB_ID");
        processor_Price.setName(""); // NOI18N
        buildPanel.add(processor_Price);
        processor_Price.setBounds(410, 330, 130, 15);

        ram_Price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ram_Price.setText("MotherB_ID");
        ram_Price.setName(""); // NOI18N
        buildPanel.add(ram_Price);
        ram_Price.setBounds(570, 330, 130, 15);

        deleteBuildBtn.setText("Delete");
        deleteBuildBtn.setEnabled(false);
        deleteBuildBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBuildBtnActionPerformed(evt);
            }
        });
        buildPanel.add(deleteBuildBtn);
        deleteBuildBtn.setBounds(660, 10, 70, 40);
        deleteBuildBtn.setVisible(false);

        getContentPane().add(buildPanel);
        buildPanel.setBounds(0, 0, 900, 600);
        buildPanel.setVisible(false);

        compareBuilds.setBackground(new java.awt.Color(255, 255, 255));
        compareBuilds.setMaximumSize(new java.awt.Dimension(900, 600));
        compareBuilds.setMinimumSize(new java.awt.Dimension(900, 600));
        compareBuilds.setLayout(null);

        logoE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
        compareBuilds.add(logoE);
        logoE.setBounds(140, 40, 602, 119);

        cancelBtnCompare.setText("Cancel");
        cancelBtnCompare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnCompareActionPerformed(evt);
            }
        });
        compareBuilds.add(cancelBtnCompare);
        cancelBtnCompare.setBounds(820, 10, 70, 42);

        buildsTwo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Choose -" }));
        buildsTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildsTwoActionPerformed(evt);
            }
        });
        compareBuilds.add(buildsTwo);
        buildsTwo.setBounds(550, 220, 170, 20);

        buildsOne.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Choose -" }));
        buildsOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildsOneActionPerformed(evt);
            }
        });
        compareBuilds.add(buildsOne);
        buildsOne.setBounds(100, 220, 170, 20);

        viewBuildOne.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}

    );
    viewBuildOne.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            viewBuildOneMouseClicked(evt);
        }
    });
    jScrollPane7.setViewportView(viewBuildOne);

    compareBuilds.add(jScrollPane7);
    jScrollPane7.setBounds(40, 260, 300, 200);

    viewBuildTwo.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {

        }
    )
    {public boolean isCellEditable(int row, int column){return false;}}

    );
    viewBuildTwo.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            viewBuildTwoMouseClicked(evt);
        }
    });
    jScrollPane8.setViewportView(viewBuildTwo);

    compareBuilds.add(jScrollPane8);
    jScrollPane8.setBounds(490, 260, 300, 200);
    compareBuilds.add(buildTotalCostCompOne);
    buildTotalCostCompOne.setBounds(40, 500, 140, 30);

    jLabel18.setText("Total Cost");
    compareBuilds.add(jLabel18);
    jLabel18.setBounds(40, 470, 120, 14);
    compareBuilds.add(buildTotalCostCompTwo);
    buildTotalCostCompTwo.setBounds(500, 500, 140, 30);

    jLabel19.setText("Total Cost");
    compareBuilds.add(jLabel19);
    jLabel19.setBounds(500, 470, 120, 14);

    getContentPane().add(compareBuilds);
    compareBuilds.setBounds(0, 0, 900, 600);
    compareBuilds.setVisible(false);

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
    buildCancelBtn.setBounds(800, 20, 70, 40);

    jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
    addBuildPanel.add(jLabel13);
    jLabel13.setBounds(140, 10, 620, 150);

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
    jScrollPane2.setBounds(30, 230, 840, 280);

    getContentPane().add(addBuildPanel);
    addBuildPanel.setBounds(0, 0, 900, 600);
    addBuildPanel.setVisible(false);

    viewPartPanel.setBackground(new java.awt.Color(255, 255, 255));
    viewPartPanel.setMaximumSize(new java.awt.Dimension(900, 600));
    viewPartPanel.setMinimumSize(new java.awt.Dimension(900, 600));
    viewPartPanel.setPreferredSize(new java.awt.Dimension(900, 600));
    viewPartPanel.setLayout(null);

    viewAllPartsTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {},
            {},
            {},
            {}
        },
        new String [] {

        }
    ));
    viewAllPartsTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            viewAllPartsTableMouseClicked(evt);
        }
    });
    jScrollPane4.setViewportView(viewAllPartsTable);

    viewPartPanel.add(jScrollPane4);
    jScrollPane4.setBounds(20, 360, 850, 200);

    partTypeComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Choose-","Motherboard", "CPU", "GPU", "RAM", "Storage", "PSU", "PCCase", "Accessory", "Cooler" }));
    partTypeComboBox2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            partTypeComboBox2ActionPerformed(evt);
        }
    });
    viewPartPanel.add(partTypeComboBox2);
    partTypeComboBox2.setBounds(340, 310, 210, 30);

    cancelBtnE1.setText("Cancel");
    cancelBtnE1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cancelBtnE1ActionPerformed(evt);
        }
    });
    viewPartPanel.add(cancelBtnE1);
    cancelBtnE1.setBounds(820, 10, 70, 42);

    acceptBtnE1.setText("Accept");
    acceptBtnE1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            acceptBtnE1ActionPerformed(evt);
        }
    });
    viewPartPanel.add(acceptBtnE1);
    acceptBtnE1.setBounds(740, 10, 65, 42);

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo.png"))); // NOI18N
    jLabel1.setText("jLabel1");
    viewPartPanel.add(jLabel1);
    jLabel1.setBounds(130, 70, 600, 120);

    jLabel15.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
    jLabel15.setText("View Components");
    viewPartPanel.add(jLabel15);
    jLabel15.setBounds(280, 210, 340, 40);

    getContentPane().add(viewPartPanel);
    viewPartPanel.setBounds(0, 0, 900, 600);
    viewPartPanel.setVisible(false);

    createAccount.setBackground(new java.awt.Color(255, 255, 255));
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
    createAccount.setVisible(false);

    viewAccount.setBackground(new java.awt.Color(255, 255, 255));
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
    viewAccount.setBounds(0, 0, 900, 600);
    viewAccount.setVisible(false);

    addPart.setBackground(new java.awt.Color(255, 255, 255));
    addPart.setMaximumSize(new java.awt.Dimension(900, 600));
    addPart.setMinimumSize(new java.awt.Dimension(900, 600));
    addPart.setPreferredSize(new java.awt.Dimension(900, 600));
    addPart.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            addPartFocusGained(evt);
        }
    });
    addPart.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            addPartMouseClicked(evt);
        }
    });
    addPart.setLayout(null);

    addPartSaveBtn.setBackground(new java.awt.Color(127, 127, 127));
    addPartSaveBtn.setFont(new java.awt.Font("Kalinga", 1, 14)); // NOI18N
    addPartSaveBtn.setForeground(new java.awt.Color(255, 255, 255));
    addPartSaveBtn.setText("Save");
    addPartSaveBtn.setEnabled(false);
    addPartSaveBtn.setMaximumSize(new java.awt.Dimension(51, 23));
    addPartSaveBtn.setMinimumSize(new java.awt.Dimension(51, 23));
    addPartSaveBtn.setPreferredSize(new java.awt.Dimension(51, 23));
    addPartSaveBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addPartSaveBtnActionPerformed(evt);
        }
    });
    addPart.add(addPartSaveBtn);
    addPartSaveBtn.setBounds(670, 20, 90, 43);

    addPartCancelBtn.setBackground(new java.awt.Color(127, 127, 127));
    addPartCancelBtn.setFont(new java.awt.Font("Kalinga", 1, 14)); // NOI18N
    addPartCancelBtn.setForeground(new java.awt.Color(255, 255, 255));
    addPartCancelBtn.setText("Cancel");
    addPartCancelBtn.setMaximumSize(new java.awt.Dimension(51, 23));
    addPartCancelBtn.setMinimumSize(new java.awt.Dimension(51, 23));
    addPartCancelBtn.setPreferredSize(new java.awt.Dimension(51, 23));
    addPartCancelBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addPartCancelBtnActionPerformed(evt);
        }
    });
    addPart.add(addPartCancelBtn);
    addPartCancelBtn.setBounds(780, 20, 90, 43);

    jLabel14.setFont(new java.awt.Font("Kalinga", 0, 18)); // NOI18N
    jLabel14.setForeground(new java.awt.Color(179, 0, 0));
    jLabel14.setText("Part type:");
    addPart.add(jLabel14);
    jLabel14.setBounds(200, 120, 100, 30);

    partTypeComboBox.setFont(new java.awt.Font("Kalinga", 0, 14)); // NOI18N
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
    partTypeComboBox.setBounds(300, 120, 180, 30);

    addPartTitle.setFont(new java.awt.Font("Kalinga", 1, 36)); // NOI18N
    addPartTitle.setForeground(new java.awt.Color(127, 127, 127));
    addPartTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    addPartTitle.setText("Add Computer Part");
    addPart.add(addPartTitle);
    addPartTitle.setBounds(180, 20, 360, 50);

    addPartUpdateBtn.setText("Update");
    addPartUpdateBtn.setEnabled(false);
    addPartUpdateBtn.setMaximumSize(new java.awt.Dimension(51, 23));
    addPartUpdateBtn.setMinimumSize(new java.awt.Dimension(51, 23));
    addPartUpdateBtn.setPreferredSize(new java.awt.Dimension(51, 23));
    addPartUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addPartUpdateBtnActionPerformed(evt);
        }
    });
    addPart.add(addPartUpdateBtn);
    addPartUpdateBtn.setBounds(780, 500, 70, 40);
    addPartUpdateBtn.setVisible(false);

    partIDLable.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
    partIDLable.setText("ID");
    addPart.add(partIDLable);
    partIDLable.setBounds(60, 520, 550, 70);
    partIDLable.setVisible(false);

    deletePart.setText("DELETE");
    deletePart.setMaximumSize(new java.awt.Dimension(51, 23));
    deletePart.setMinimumSize(new java.awt.Dimension(51, 23));
    deletePart.setPreferredSize(new java.awt.Dimension(51, 23));
    deletePart.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            deletePartActionPerformed(evt);
        }
    });
    addPart.add(deletePart);
    deletePart.setBounds(780, 540, 70, 40);
    deletePart.setVisible(false);

    jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pchecker/logo2.png"))); // NOI18N
    jLabel20.setText("jLabel20");
    addPart.add(jLabel20);
    jLabel20.setBounds(20, 60, 100, 470);

    getContentPane().add(addPart);
    addPart.setBounds(0, 0, 900, 600);
    addPart.setVisible(false);

    addComp.setMaximumSize(new java.awt.Dimension(900, 600));
    addComp.setPreferredSize(new java.awt.Dimension(900, 600));
    addComp.setLayout(null);

    compTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    jScrollPane3.setViewportView(compTable);

    addComp.add(jScrollPane3);
    jScrollPane3.setBounds(60, 40, 690, 370);

    saveCompBtn.setText("save");
    saveCompBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            saveCompBtnActionPerformed(evt);
        }
    });
    addComp.add(saveCompBtn);
    saveCompBtn.setBounds(780, 30, 55, 23);

    getContentPane().add(addComp);
    addComp.setBounds(0, 0, 900, 600);
    addComp.setVisible(false);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void buildNametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildNametxtActionPerformed
        
    }//GEN-LAST:event_buildNametxtActionPerformed

    private void accessoriesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accessoriesBtnActionPerformed
        addPart("Accessory");
    }//GEN-LAST:event_accessoriesBtnActionPerformed

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


    
    private void runCompatibilityCheck(){
        //this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        motherboardBtn.setBackground(Color.GREEN); // sets color on green after selected part 

        
        if(Integer.parseInt(processor_ID.getText()) >= 0){
            Color color = checkCompatible(processor_ID.getText());
            processorBtn.setBackground(color); // sets color on green after selected part 
        }

        
       if(Integer.parseInt(accessories_ID.getText()) >= 0){
           Color color = checkCompatible(accessories_ID.getText());
           accessoriesBtn.setBackground(color); // sets color on green after selected part 
       }
       
       if(Integer.parseInt(case_ID.getText()) >= 0){
           Color color = checkCompatible(case_ID.getText());
           caseBtn.setBackground(color); // sets color on green after selected part 
       }
       
       if(Integer.parseInt(cooling_ID.getText()) >= 0){
           Color color = checkCompatible(cooling_ID.getText());
           coolingBtn.setBackground(color); // sets color on green after selected part 
       }
       
       if(Integer.parseInt(graphics_ID.getText()) >= 0){
           Color color = checkCompatible(graphics_ID.getText());
           graphicsBtn.setBackground(color); // sets color on green after selected part 
       }
       
       if(Integer.parseInt(hdd_ID.getText()) >= 0){
           Color color = checkCompatible(hdd_ID.getText());
           hddBtn.setBackground(color); // sets color on green after selected part 
       }
       
       if(Integer.parseInt(powersupply_ID.getText()) >= 0){
           Color color = checkCompatible(powersupply_ID.getText());
           supplyBtn.setBackground(color); // sets color on green after selected part 
       }
       
       if(Integer.parseInt(ram_ID.getText()) >= 0){
           Color color = checkCompatible(ram_ID.getText());
           ramBtn.setBackground(color); // sets color on green after selected part 
       }
        saveValidation();
    }
    
    private Color checkCompatible(String ID){
        Color color = Color.RED;
        Boolean compatible = newBuild.checkComp(ID);
        System.out.print(compatible);

        if(compatible) {
            color = Color.GREEN;
        }
        return color;
    }
    
    String PartID;
    private void acceptBuildBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBuildBtnActionPerformed
        
        saveBuild();
        
    }//GEN-LAST:event_acceptBuildBtnActionPerformed
    Color color = Color.GREEN;
    public void saveValidation() {
        
       
        
        System.out.println(motherboardBtn.getBackground() == color);
        
        if(buildNametxt.getText().isEmpty() || motherboardBtn.getBackground()!= color || processorBtn.getBackground() != color || ramBtn.getBackground() != color || hddBtn.getBackground() != color || graphicsBtn.getBackground() != color || caseBtn.getBackground() != color || supplyBtn.getBackground() != color || coolingBtn.getBackground() != color || accessoriesBtn.getBackground() != color) {
            acceptBuildBtn.setEnabled(false);
            updateBtn.setEnabled(false);
        } else {
            acceptBuildBtn.setEnabled(true);
            updateBtn.setEnabled(true);
        }
          
    }
        
    
      public void saveBuild(){
          
        if(!buildNametxt.getText().equals("") && (PartID != null)) {
            newBuild.setBuildName(buildNametxt.getText());
            newBuild.savebuild(currentUser.getUsername());
        
            AdminUserFrame frm = new AdminUserFrame(currentUser); //opens general user form
        
            this.dispose();
            frm.setVisible(true);
        } else {
            
            JOptionPane.showMessageDialog(null, "Please insert build name and have sure that you selected at least one part, ","", JOptionPane.INFORMATION_MESSAGE);
        }
      
    }
    
    private void cancelBtnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnBActionPerformed
       
        AdminUserFrame frm = new AdminUserFrame(currentUser); //opens general user form
        this.dispose();
        frm.setVisible(true);
      
    }//GEN-LAST:event_cancelBtnBActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        
       
     if(motherboardBtn.getBackground()== color || processorBtn.getBackground() == color || ramBtn.getBackground() == color || hddBtn.getBackground() == color || graphicsBtn.getBackground() == color || caseBtn.getBackground() == color || supplyBtn.getBackground() == color || coolingBtn.getBackground() == color || accessoriesBtn.getBackground() == color){
        newBuild.UpdateBuild(currentUser.getUsername());
        AdminUserFrame frm = new AdminUserFrame(currentUser); //opens general user form
        this.dispose();
        frm.setVisible(true);
     } else {
         JOptionPane.showMessageDialog(null, "Please select other component. ","", JOptionPane.INFORMATION_MESSAGE);
     }

    }//GEN-LAST:event_updateBtnActionPerformed

    private void saveCompBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveCompBtnActionPerformed
        Connection con = ServerControl.ConnectDB();
        
        try {
        Statement stmt = (Statement) con.createStatement();
            
        for(int i=0;i<compTable.getRowCount();i++){

            String Part1=compTable.getValueAt(i, 0).toString();
            String Part2=compTable.getValueAt(i, 2).toString();
            String comp=compTable.getValueAt(i, 4).toString();
            String NumStri=compTable.getValueAt(i, 5).toString();
            int num = Integer.parseInt(NumStri);
        


            
            stmt.executeUpdate("INSERT INTO Compatibility VALUES('"+Part1+"','"+Part2+"',"+comp+","+num+")");
        }
            } catch (SQLException err) {
               System.out.println(err.getMessage());   

            }
        AdminUserFrame frm = new AdminUserFrame(currentUser); //opens general user form
        this.dispose();
        frm.setVisible(true);
        
        
        
    }//GEN-LAST:event_saveCompBtnActionPerformed

    private void buildNametxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buildNametxtKeyPressed
       saveValidation();
    }//GEN-LAST:event_buildNametxtKeyPressed

    private void cancelBtnE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnE1ActionPerformed
        AdminUserFrame frm = new AdminUserFrame(currentUser); //opens general user form
        this.dispose();
        frm.setVisible(true);
    }//GEN-LAST:event_cancelBtnE1ActionPerformed

    private void partTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partTypeComboBoxActionPerformed
        if(String.valueOf(partTypeComboBox.getSelectedItem()) != "-Choose-"){
            addingNewPart();
        }
    }//GEN-LAST:event_partTypeComboBoxActionPerformed

    private void partTypeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_partTypeComboBoxItemStateChanged

    }//GEN-LAST:event_partTypeComboBoxItemStateChanged

    private void addPartCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPartCancelBtnActionPerformed
        AdminUserFrame frm = new AdminUserFrame(currentUser); //opens general user form
        this.dispose();
        frm.setVisible(true);
    }//GEN-LAST:event_addPartCancelBtnActionPerformed

    private void addPartSaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPartSaveBtnActionPerformed
        //addingNewPartValidation();
        saveNewPart(true);
    }//GEN-LAST:event_addPartSaveBtnActionPerformed

    private void addPartFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addPartFocusGained
        
    }//GEN-LAST:event_addPartFocusGained

    private void addPartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPartMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addPartMouseClicked

    
    private void partTypeComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partTypeComboBox2ActionPerformed
        
        if(String.valueOf(partTypeComboBox2.getSelectedItem()) != "-Choose-"){
           // addingNewPart();
           
           getSelectedPart();
        } 
    }//GEN-LAST:event_partTypeComboBox2ActionPerformed

    private void viewAllPartsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewAllPartsTableMouseClicked

        //String selected = viewAllPartsTable.getS
        String partType = String.valueOf(partTypeComboBox2.getSelectedItem());
        partTypeComboBox.setSelectedItem(partType);
        

        
       for(int column = 0; column < viewAllPartsTable.getColumnCount(); column++) {
           String value = String.valueOf(viewAllPartsTable.getValueAt(viewAllPartsTable.getSelectedRow(), column)), name = String.valueOf(viewAllPartsTable.getModel().getColumnName(column));
           if(name.equals("PartID")){
               partIDLable.setText(value);
           }
           
           if(name != "PartType" || name != "PartID"){
            System.out.println(name +" "+value);
             Component input = getComponentByName(name+"Input");
              if (input instanceof JTextField) {        
                JTextField mytext = (JTextField) input;
                mytext.setText(value);
                
                if(name.equals("Model")){
                    mytext.setEnabled(false);
                    mytext.setBackground(Color.green);
                    addPartTitle.setText("Edit '"+value+"'");

                }
               }
              
             
        }
       }
       
       partTypeComboBox.setEnabled(false);
       
        addPartUpdateBtn.setVisible(true);
        deletePart.setVisible(true);
        addPartSaveBtn.setVisible(false);
        
        viewPartPanel.setVisible(false);
        addPart.setVisible(true);

    }//GEN-LAST:event_viewAllPartsTableMouseClicked

    private void addPartUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPartUpdateBtnActionPerformed
        saveNewPart(false);
    }//GEN-LAST:event_addPartUpdateBtnActionPerformed

    private void deletePartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePartActionPerformed
        currentUser.deletePart(partIDLable.getText());
        AdminUserFrame frm = new AdminUserFrame(currentUser); //opens general user form
        this.dispose();
        frm.setVisible(true);
    }//GEN-LAST:event_deletePartActionPerformed

    private void acceptBtnE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnE1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acceptBtnE1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void partsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partsTableMouseClicked

        int row =  partsTable.getSelectedRow();
        if (evt.getClickCount() == 2 ) {
            PartID = modelParts.getValueAt(row, 0).toString();
            double price = Double.parseDouble(modelParts.getValueAt(row, partsTable.getColumn("Price").getModelIndex()).toString());
                    
                    
            Color color = checkCompatible(PartID);

            String partModel = modelParts.getValueAt(row, modelParts.findColumn("Model")).toString();
            String partMake = modelParts.getValueAt(row, modelParts.findColumn("Make")).toString();

            switch (choosenPart) {

                case "Motherboard": newBuild.setMotherboard(Integer.parseInt(PartID),partMake+" "+partModel,price);
                choosenPartLabel();
                //accessoriesLabelSelectedPart.setVisible(true);
                //processorLabelSelectedPart.setText(newBuild.getCPU() + " - " + newBuild.getPartName("CPU"));

                // motherboardBtn.setText(newBuild.getPartName(choosenPart));
                enbleButtons();
                this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                runCompatibilityCheck();

                break;
                case "CPU": newBuild.setCPU(Integer.parseInt(PartID),partMake+" "+partModel,price);
                // processorBtn.setText("Processor "+PartID);

                choosenPartLabel();
                processorBtn.setBackground(color); // sets color on green after selected part
                break;
                case "RAM": newBuild.setRAM(Integer.parseInt(PartID),partMake+" "+partModel,price);
                // ramBtn.setText("RAM "+PartID);
                choosenPartLabel();
                ramBtn.setBackground(color); // sets color on green after selected part
                break;
                case "GPU": newBuild.setGPU(Integer.parseInt(PartID),partMake+" "+partModel,price);
                // graphicsBtn.setText("Graphics card \n"+PartID);
                choosenPartLabel();
                graphicsBtn.setBackground(color); // sets color on green after selected part
                break;
                case "Storage": newBuild.setStorage(Integer.parseInt(PartID),partMake+" "+partModel,price);
                //  hddBtn.setText("HDD \n"+PartID);
                choosenPartLabel();
                hddBtn.setBackground(color); // sets color on green after selected part
                break;
                case "Accessory": newBuild.setAccessory(Integer.parseInt(PartID),partMake+" "+partModel,price);
                // accessoriesBtn.setText("Accessories \n"+PartID);
                choosenPartLabel();
                accessoriesBtn.setBackground(color); // sets color on green after selected part
                break;
                case "PSU": newBuild.setPSU(Integer.parseInt(PartID),partMake+" "+partModel,price);
                //  supplyBtn.setText("Power Supply \n"+PartID);
                choosenPartLabel();
                supplyBtn.setBackground(color); // sets color on green after selected part
                break;
                case "PCCase": newBuild.setPCCase(Integer.parseInt(PartID),partMake+" "+partModel,price);
                //  caseBtn.setText("Case \n"+PartID);
                choosenPartLabel();
                caseBtn.setBackground(color); // sets color on green after selected part
                break;
                case "Cooler": newBuild.setCooler(Integer.parseInt(PartID),partMake+" "+partModel,price);
                //  coolingBtn.setText("Cooling \n"+PartID);
                choosenPartLabel();
                coolingBtn.setBackground(color); // sets color on green after selected part
                break;

            }
            buildPanel.setVisible(true);
            addBuildPanel.setVisible(false);
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            //runCompatibilityCheck();

        }

    }//GEN-LAST:event_partsTableMouseClicked

    private void buildCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildCancelBtnActionPerformed

        buildPanel.setVisible(true);
        addBuildPanel.setVisible(false);

    }//GEN-LAST:event_buildCancelBtnActionPerformed

    private void cancelBtnCompareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnCompareActionPerformed
        
        AdminUserFrame frm = new AdminUserFrame(currentUser); //opens general user form
        this.dispose();
        frm.setVisible(true);
    }//GEN-LAST:event_cancelBtnCompareActionPerformed

    private void buildsTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildsTwoActionPerformed
       
         if(String.valueOf(buildsTwo.getSelectedItem()) != "-Choose-"){
            String build = buildsTwo.getSelectedItem().toString();
            getPartsToCompare(build, "two");
         }
    }//GEN-LAST:event_buildsTwoActionPerformed

    private void viewBuildOneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewBuildOneMouseClicked

    }//GEN-LAST:event_viewBuildOneMouseClicked

    private void viewBuildTwoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewBuildTwoMouseClicked

    }//GEN-LAST:event_viewBuildTwoMouseClicked

    private void buildsOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildsOneActionPerformed
        
         if(String.valueOf(buildsOne.getSelectedItem()) != "-Choose-"){
            String build = buildsOne.getSelectedItem().toString();
            getPartsToCompare(build, "one");
         }
    }//GEN-LAST:event_buildsOneActionPerformed

    private void deleteBuildBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBuildBtnActionPerformed
      int answer = JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Delete your Build?", "Delete Build", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
       
        if (answer == JOptionPane.YES_OPTION) {
          
            JOptionPane.showMessageDialog(null, "Build Deleted. You will be returnd to main menu");
            currentUser.deleteBuild(newBuild.getBuildName());
            AdminUserFrame frm = new AdminUserFrame(currentUser);
            this.dispose();
            frm.setVisible(true);
        }
    }//GEN-LAST:event_deleteBuildBtnActionPerformed
    
    public void getPartsToCompare(String buildName, String BuildNum){
       
        TableColumn colBuild = new TableColumn();
        ArrayList<String> columns = new ArrayList<>();
        columns.add("PC");
        columns.add("Parts");

        
       
        //jTableBuild.disable();
        
        JTable table = null;
        JLabel lable = null;
        if(BuildNum.equals("one")){
            table = (JTable) viewBuildOne;
            lable = (JLabel) buildTotalCostCompOne;
        }else{
            table = (JTable) viewBuildTwo;
            lable = (JLabel) buildTotalCostCompTwo;

        }
        
        

        DefaultTableModel model = (DefaultTableModel) table.getModel();
                
        
                       
        //TableColumn col1 = new TableColumn(model.getColumnCount());
        for (String temp : columns) { //Adds columns to table.
            colBuild.setHeaderValue(temp);
            table.addColumn(colBuild);
            model.addColumn(temp);
        }
        
        Connection con = ServerControl.ConnectDB();

        try {
            Statement stmt = (Statement) con.createStatement();
           // String query = ("Select P.PartID, P.Make, P.Model, P.Price, Speed, Cores, Graphics FROM CPU JOIN Part AS P on CPU.ID=P.PartID");
            String query = "Select P.PartType,P.Model, P.Make FROM Build AS B JOIN Part AS P ON P.PartID IN(B.Motherboard,B.CPU,B.RAM,B.Storage,B.GPU,B.PSU,B.PCCase,B.Cooler,B.Accessory) where Account = '"+currentUser.getUsername()+"' AND BuildName = '"+buildName+"';";
                       // System.out.println(query);


                stmt.executeQuery(query);
                ResultSet rs = stmt.getResultSet();
                
                while (rs.next()) {   
                    
                String partType = rs.getString("PartType");
                String part = (rs.getString("Model")+" - "+rs.getString("Make"));   
                model.addRow(new Object[]{partType,part});
                
                   
                }
                
                Statement st = (Statement) con.createStatement();
      
                st.executeQuery("SELECT totalBuildCost FROM Build WHERE Account = '"+currentUser.getUsername()+"' AND BuildName = '"+buildName+"';");
                ResultSet result = st.getResultSet();
    
                while (result.next()) {
                 
                    lable.setText(result.getString("totalBuildCost"));
                
                }   
             
        
    }catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
    }
    
    
    
    
    
    /**
     * getSelectedPart() allows to get a list selected component from jComboBox. Display all available parts from database in table.
     */
    public void getSelectedPart(){
        
        // get selected value
        String selectedPartType = String.valueOf(partTypeComboBox2.getSelectedItem());        
        
        // go and take all components data from database
        DefaultTableModel getParts = new DefaultTableModel();
        getParts = currentUser.getparts(selectedPartType);
        
        // display data in a table
        viewAllPartsTable.setModel(getParts);
    }
    
    private void addPartModelInputActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 
                                          
    private void testbtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
       
    }                                       
    
    public void setEditBuild(String value) {
        newBuildTitleLable.setText(value);
        newBuild.getBuild(currentUser.getUsername(), value);
        enbleButtons();
        System.out.println(newBuild.getCPU()+newBuild.getPartName("CPU"));
        
        //
    }
    
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
 
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
    private javax.swing.JButton acceptBtnE1;
    private javax.swing.JButton acceptBuildBtn;
    private javax.swing.JButton accessoriesBtn;
    private javax.swing.JLabel accessoriesLabelSelectedPart;
    private javax.swing.JLabel accessories_ID;
    private javax.swing.JLabel accessories_Price;
    private javax.swing.JPanel addBuildPanel;
    private javax.swing.JPanel addComp;
    private javax.swing.JPanel addPart;
    private javax.swing.JButton addPartCancelBtn;
    private javax.swing.JButton addPartSaveBtn;
    private javax.swing.JLabel addPartTitle;
    private javax.swing.JButton addPartUpdateBtn;
    private javax.swing.JButton buildCancelBtn;
    private javax.swing.JLabel buildNameLabelB;
    private javax.swing.JTextField buildNametxt;
    private javax.swing.JPanel buildPanel;
    private javax.swing.JLabel buildTotalCostCompOne;
    private javax.swing.JLabel buildTotalCostCompTwo;
    private javax.swing.JLabel buildTotalCostLbl;
    private javax.swing.JComboBox<String> buildsOne;
    private javax.swing.JComboBox<String> buildsTwo;
    private javax.swing.JButton cancelBtnB;
    private javax.swing.JButton cancelBtnCompare;
    private javax.swing.JButton cancelBtnE1;
    private javax.swing.JButton caseBtn;
    private javax.swing.JLabel caseLabelSelectedPart;
    private javax.swing.JLabel case_ID;
    private javax.swing.JLabel case_Price;
    private javax.swing.JTable compTable;
    private javax.swing.JPanel compareBuilds;
    private javax.swing.JButton coolingBtn;
    private javax.swing.JLabel coolingLabelSelectedPart;
    private javax.swing.JLabel cooling_ID;
    private javax.swing.JLabel cooling_Price;
    private javax.swing.JPanel createAccount;
    private javax.swing.JButton deleteBuildBtn;
    private javax.swing.JButton deletePart;
    private javax.swing.JLabel gpuLabelSelectedPart;
    private javax.swing.JButton graphicsBtn;
    private javax.swing.JLabel graphics_ID;
    private javax.swing.JLabel graphics_Price;
    private javax.swing.JButton hddBtn;
    private javax.swing.JLabel hddLabelSelectedPart;
    private javax.swing.JLabel hdd_ID;
    private javax.swing.JLabel hdd_Price;
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
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
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
    private javax.swing.JLabel motherboardLabelSelectedPart1;
    private javax.swing.JLabel motherboard_ID;
    private javax.swing.JLabel motherboard_Price;
    private javax.swing.JLabel newBuildTitleLable;
    private javax.swing.JLabel partIDLable;
    private javax.swing.JComboBox<String> partTypeComboBox;
    private javax.swing.JComboBox<String> partTypeComboBox2;
    private javax.swing.JTable partsTable;
    private javax.swing.JLabel powersupply_ID;
    private javax.swing.JLabel powersupply_Price;
    private javax.swing.JButton processorBtn;
    private javax.swing.JLabel processorLabelSelectedPart;
    private javax.swing.JLabel processor_ID;
    private javax.swing.JLabel processor_Price;
    private javax.swing.JLabel psuLabelSelectedPart;
    private javax.swing.JButton ramBtn;
    private javax.swing.JLabel ramLabelSelectedPart;
    private javax.swing.JLabel ram_ID;
    private javax.swing.JLabel ram_Price;
    private javax.swing.JButton saveCompBtn;
    private javax.swing.JButton supplyBtn;
    private javax.swing.JButton updateBtn;
    private javax.swing.JPanel viewAccount;
    private javax.swing.JTable viewAllPartsTable;
    private javax.swing.JTable viewBuildOne;
    private javax.swing.JTable viewBuildTwo;
    private javax.swing.JPanel viewPartPanel;
    // End of variables declaration//GEN-END:variables
}

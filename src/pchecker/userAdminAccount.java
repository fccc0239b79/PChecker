package pchecker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * This class creates an object of an user 
 * @author Greg 
 * @author Pawel 
 */
public class userAdminAccount {
    
    private String username, password, fName, sName, email, DOB,mobilNum, accountName;
    private boolean type; //True for admin, false for general. 
    private ArrayList<String> builds = new ArrayList<String>(),
            tableColums = new ArrayList<String>(),
            tableDataType= new ArrayList<String>(),
            listOfParts= new ArrayList<String>();

    /**
     *
     * @return methods that return profile information
     */
    public String getUsername() {
        return username;
    }
    public String getFname(){
        return fName;
    }
    public String getSname(){
        return sName;
    }
    public String getEmail(){
        return email;
    }
    public String getMobile(){
        return mobilNum;
    }
    public String getDOB(){
        return DOB;
    }
    public String getAccountName() {
        return accountName;
    }
    public boolean getType() {
        return type;
    }
    
    
    /**
     * This method sets the username of logged in user.
     * @param username sets username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method sets the password of logged in user.
     * @param password sets password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *This method sets firstname of logged in user.
     * @param fname sets firstname
     */
    public void setFname(String fname) {
        this.fName = fname;
    }

    /**
     *This method sets surname of logged in user.
     * @param sname sets surname
     */
    public void setSname(String sname) {
        this.sName = sname;
    }

    /**
     *This method sets email of logged in user.
     * @param email sets email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     *This method sets mobile number of logged in user.
     * @param mobile sets mobile
     */
    public void setMobil(String mobile) {
        this.mobilNum = mobile;
    }
    /**
     *This method sets date of birth of logged in user.
     * @param dob sets date of birth
     */
    public void setDOB(String dob) {
        this.DOB = dob;
    }
    /**
     *This method sets type of logged in user true=admin, false=user.
     * @param type represents the type of user 
     * 
     */
    public void setType(boolean type) {
        this.type = type;
    }

    /**
     * logs an user in, stores his details in an object 
     * @param enteredUname the username that user inputed at login.
     * @param enteredPass the password that user inputed at login.
     * @return if true, login is successfully. If false login has not been
     * completed
     */
    public boolean LogInService(String enteredUname, String enteredPass) {
        //Checks entered username and password against ones stored in database.
        Connection con = ServerControl.ConnectDB();
        String dbUname;
        boolean loged = false; 
        
        try {
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT userName, accountType, Fname, Sname, Email, MobilNum, DOB FROM Account WHERE userName='" + enteredUname +"'");
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                //resets previous loged in user
                reset();
                //sets loged in users details
                dbUname = rs.getString("userName");
                accountName = rs.getString("userName");
                fName = rs.getString("Fname");
                sName = rs.getString("Sname");
                email = rs.getString("Email");
                mobilNum = rs.getString("MobilNum");
                DOB = rs.getString("DOB");
                
                boolean dbType = rs.getBoolean("accountType");
                setType(dbType); //Sets type of user.
                setUsername(dbUname);
                loged = true;

            }
            con.close();
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }

        return loged;
        
    }

    /**
     * gets all builds from database for logged in user 
     * @return an array list of users builds 
     */
      public ArrayList<String> getBuilds(){
        builds.clear();
        //connects to database and retrives all builds froma given user  
           Connection con = ServerControl.ConnectDB();
           String user = username;
            try {
                Statement stmt = (Statement) con.createStatement();
                String query = ("SELECT BuildName FROM Build WHERE Account='" + user+"'");
                stmt.executeQuery(query);
                ResultSet rs = stmt.getResultSet();
                while (rs.next()) {
                    builds.add(rs.getString("BuildName"));
                }
                if(!rs.first()){
                    builds.add("No Builds");
                    return builds;
                }
                con.close();
           }
        catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
           return builds;
    }
    /**
     * deletes an build form system 
     * @param buildname build that is going to be deleted.
     * 
     */
    public void deleteBuild(String buildname){
        //Tries to delete a given build 
         Connection con = ServerControl.ConnectDB();
         try {
            String query = "DELETE FROM Build WHERE Account = '"+username+"' AND BuildName = '"+buildname+"';";
            PreparedStatement statement = con.prepareStatement(query);
            statement.execute();
            con.close();
         } 
         catch(SQLException err){
             System.out.println(err); //Prints out SQL error 
        }
    }
    /**
     * checks if inputed password matches to the one in database 
     * @param username the username that user inputed at login.
     * @param password the password that user inputed at login.
     * @return if true, user exists and passwords match
     */
    public boolean checkPassword(String username, String password){
        // this statement establishes the connection between netbeans and the vm
        Connection con = ServerControl.ConnectDB();

        String user = username;
        String enteredPassword = password;
        try {
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT userName, Password FROM Account WHERE userName='" + user+"'");

            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                //checks if inputed password match with the one in database
                String dbPassword = rs.getString("Password");
                if(dbPassword.equals(enteredPassword)){
                return true;
                }else{
                    return false;
                }                   
             }
            con.close();
        }
        catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
            return false;
        }
       return false;
    }
   
    
    
    /**
     * Enables user to change password in the GUI and new password is then
     * accepted through connected database. 
     * @param newPassword new password for user 
     * @param user that wants to change password 
     */
    
    public void changePassword(String newPassword, String user){
        Connection con = ServerControl.ConnectDB();
        try {
           //SQL query - changes password where the username is equal to input, entered by user.
           String query = ("UPDATE Account SET Password = '" + newPassword + "' WHERE Username = '" + user +"';");
           PreparedStatement statement = con.prepareStatement(query);
           statement.execute();
        }
        catch(SQLException err){ //error message
             System.out.println(err.getMessage());   //Prints out SQL error 
        }
    }
    
    /**
     * checks inputed details match with the ones in database 
     * @param DOB  that user inputed at forget password screen.
     * @param email that user inputed at forget password screen.
     * @param username inputed by user 
     * @return true if date of birth and email math to the ones in database
     */
    public boolean checkDetails(String username,String DOB, String email){
        Connection con = ServerControl.ConnectDB();

        try {
                Statement stmt = (Statement) con.createStatement();
                String query = ("SELECT Email,DOB FROM Account WHERE Username = '"+username+"';");

                stmt.executeQuery(query);
                ResultSet rs = stmt.getResultSet();
            
                while (rs.next()) {
                   if(DOB.equals(rs.getString("DOB"))&&email.equals(rs.getString("Email"))) {
                       return true;
                   }
                }
            }
            catch(SQLException err){ //error message
                System.out.println(err.getMessage());   //Prints out SQL error 

        }
        return false; 
    }
   

    /**
     * checking the availability of a username in the database.
     * @param username inputed by user 
     * @return true if that username isent taken 
     */
    public boolean usernameAvailability(String username) {
        Connection con = ServerControl.ConnectDB();
        try {
            int availability;
            Statement stmt = (Statement) con.createStatement();
            //checks username entered against usernames within database.
            String query = ("SELECT COUNT(*) FROM Account WHERE userName = '" + username + "'");

            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
               availability = rs.getInt("COUNT(*)");
               if(availability == 1){ //username is already taken
                   return false;
               }else{
                return true; //username is available
               }
            }
            con.close();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return false;
        }
        return false;
    }    
   
    /**
     * saves the users details into database 
     */
    public void saveUser(){
        Connection con = ServerControl.ConnectDB();
        try {
            //SQL query for inserting data into account table
           String query = "INSERT INTO Account values (?,?,?,?,?,?,?,?)"; 
           PreparedStatement statement = con.prepareStatement(query);
           //setting user inputs into sql query
           statement.setString(1,username);
           statement.setString(2, password);
           statement.setString(3, fName);
           statement.setString(4, sName);
           statement.setString(5,email);
           statement.setString(6,mobilNum);
           statement.setString(7,DOB);
           statement.setBoolean(8, type);
           statement.execute();
           
        con.close();
        }catch(SQLException err){
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
    }
    
    /**
     * Updates users details 
     */
    public void UpdateUser(){
   
        Connection con = ServerControl.ConnectDB();
    
        try {
           //SQL query for inserting data into account table
           String query = "UPDATE Account SET Fname = ?, Sname = ?, Email = ?, MobilNum = ?, DOB = ? WHERE userName = ?"; 
           PreparedStatement statement = con.prepareStatement(query);
           
           //setting user inputs into sql query
           statement.setString(1, fName);
           statement.setString(2, sName);
           statement.setString(3,email);
           statement.setString(4,mobilNum);
           statement.setString(5,DOB);
           statement.setString(6, username);
           statement.execute();
           con.close();
        }
        catch(SQLException err){
             System.out.println(err.getMessage());   //Prints out SQL error 
        }
    }
    
    /*
    *resets users details
    */
    protected void reset(){
       username = "";
       password= "";
       fName= "";
       sName= "";
       email= "";
       mobilNum = "";
       DOB = "";
       type= false;
    }
     
     /**
     * gets parts for input of compatibility 
     * @param newPid its the new parts ID 
     * @return an table model of parts that are in database 
     */
     public DefaultTableModel getCompT(int newPid){

            Connection con = ServerControl.ConnectDB();
            String newMakeModel = "",colNames[] = {"ID","OtherParts","IDNew","NewPart","Compatible","CompNo"};
            Object[][] data = {};
            DefaultTableModel dtm = new DefaultTableModel(data,colNames){
                
                @Override
                public Class<?> getColumnClass(int column) {
                    if (column == 4) {
                        return Boolean.class;
                    } else {
                        return String.class;
                    }
                }
            };
        
            try {
                //gets all parts from databse to give them compatibility
                Statement stmt = (Statement) con.createStatement();
                String query2 = "select Make,Model,PartType From Part where PartID = "+newPid+";",
                        query = "select PartID,Make,Model From Part where PartType = \"Motherboard\";";
             
                //selects new added part from database 
                ResultSet rs2 = stmt.executeQuery(query2);
                while(rs2.next()){
                    newMakeModel = rs2.getString("Make")+" - "+rs2.getString("Model");
                    
                    //if new part is a motherboard selects all parts that are not motherboad type
                    if(rs2.getString("PartType").equals("Motherboard")){
                        query = ("select PartID,Make,Model From Part where PartType <> \"Motherboard\";");
                    }
                }
                //else all motherboards 
                ResultSet rs = stmt.executeQuery(query);
                Random r = new Random();
                int Low = 1,High = 100,Result = 0;
                while(rs.next()){
                    Result = r.nextInt(High-Low) + Low;
                    if(rs.getInt("PartID") != (newPid)){
                        //adds selected parts from database into table model 
                      dtm.addRow(new Object[]{rs.getInt("PartID"),rs.getString("Make")+" - "+rs.getString("Model"),newPid,newMakeModel,new Boolean(false),Result});
                    }
                }
            }catch (SQLException err) {
                System.out.println(err.getMessage());   //Prints out SQL error
            }
        return dtm;
     }
            
     
    
    
    /**
     * gets an given part type from database 
     * @param part type that needs to be selected from database 
     * @return table model with all parts of a given type 
     */
    public static DefaultTableModel getparts(String part){
        DefaultTableModel modelParts = new DefaultTableModel() ;
        Connection con = ServerControl.ConnectDB();
            try {
                Statement stmt = (Statement) con.createStatement();
                
                String query = ("Select * FROM Part JOIN "+part+" ON Part.PartID = "+part+".ID;");
                
                //selects parts from database and creates an table model 
                ResultSet rs = stmt.executeQuery(query);
                ResultSetMetaData metaData = rs.getMetaData();

                // names of columns
                Vector<String> columnNames = new Vector<String>();
                int columnCount = metaData.getColumnCount();
                for (int column = 1; column <= columnCount; column++) {
                    columnNames.add(metaData.getColumnName(column));
                }

                // data of the table
                Vector<Vector<Object>> data = new Vector<Vector<Object>>();
                while (rs.next()) {
                    Vector<Object> vector = new Vector<Object>();
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        vector.add(rs.getObject(columnIndex));
                    }
                    data.add(vector);
                }

                con.close();

                modelParts = new DefaultTableModel(data, columnNames){
                    
                @Override
                //makes cells not editable
                public boolean isCellEditable(int row, int column) {
                   //all cells false
                   return false;
                }
            };
           }
        catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
        return modelParts;
    }
    
    /**
     * getAccounts() - method shows all accounts names and accounts types from db and returns to table
     * @return table model with all accounts in database 
     */
    public static DefaultTableModel getAccounts () {
        DefaultTableModel modelParts = new DefaultTableModel() ;
        Connection con = ServerControl.ConnectDB();
        try {
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT userName, accountType FROM Account");
            
            //selects accounts from databse and creates an table model 
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();

            // names of columns
            Vector<String> columnNames = new Vector<String>();
            columnNames.add("Account Name");
            columnNames.add("Account Type");

            // data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnNames.size(); columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
            data.add(vector);
            }

            con.close();

            modelParts = new DefaultTableModel(data, columnNames){

            @Override
            public boolean isCellEditable(int row, int column) {
               //makes all cells non editable 
               return false;
            }
            };
        }
        catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
        return modelParts;
    }

    /**
     * gets table column names
     * @param table that will get its column names selected from database 
     * @return array of column names 
     */
     public ArrayList<String> getTableColName(String table){
        tableColums.clear();
        tableDataType.clear();

        tableColums.add("Make");
        tableColums.add("Model");
        tableColums.add("Price");
        
        tableDataType.add("varchar");
        tableDataType.add("varchar");
        tableDataType.add("decimal");

        Connection con = ServerControl.ConnectDB();
           
            try {
                Statement stmt = (Statement) con.createStatement();
                String query = ("SELECT COLUMN_NAME, DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME ='" + table+"'");

                stmt.executeQuery(query);
                ResultSet rs = stmt.getResultSet();
            
            while (rs.next()) {
                if(!rs.getString("COLUMN_NAME").equals("ID")){
                    tableColums.add(rs.getString("COLUMN_NAME"));
                    tableDataType.add(rs.getString("DATA_TYPE"));
                }
            }
            con.close();
           }
        catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
            return tableColums;
    }
     
   /**
   *
   * @return array of table columns data types 
   */
    public ArrayList<String> getTableData(){
        return tableDataType;
    }
      
   /**
    * checks for duplicated model name in database 
     * @param model entered by user .
     * @param partType of part that need to be added.
     * @return true if model insert used yet
     */
    public boolean checkDuplicate(String model,String partType){

      Connection con = ServerControl.ConnectDB();

      try { 
          String query = ("SELECT COUNT(*) FROM Part WHERE  Model = '" + model + "' AND PartType = '"+ partType + "'");

          Statement stmt = (Statement) con.createStatement();    

          stmt.executeQuery(query);
          ResultSet rs = stmt.getResultSet();
          while (rs.next()) {
              int availability = rs.getInt("COUNT(*)");
              if(availability == 1){ //model is already taken
                  return true;
              }else{
                  return false; //model is available
              }
           }
          con.close();
        }catch(SQLException err){
            System.out.println(err.getMessage());   //Prints out SQL error 
        }      
        return false;
   }
      
     /**
     * Adds a new part int the system 
     * @param partType of the part being added to system .
     * @param info information about the part like model make price .
     * @param partinfo information about the part it self like its strength etc 
     * @return new parts id 
     */
    public int savePart(String partType, ArrayList<String> info,ArrayList<String> partinfo){
        int partID = 0;
        Connection con = ServerControl.ConnectDB();
        
        //inserting into first table 'Part'
        try {
           //SQL query for inserting data into account table
          String query = "INSERT INTO Part values (?,?,?,?,?)"; 

          PreparedStatement statement = con.prepareStatement(query);

          statement.setInt(1,0);
          for(int i = 0; i < 4;i++){
            statement.setString((2+i), info.get(i));
          }
          statement.execute();
        }catch(SQLException err){
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
        
        //selecting new parts id from 'Part' tabe 
        try {
            String query = ("SELECT PartID FROM Part WHERE  Model = '" + info.get(1) + "' AND Make = '"+ info.get(2) + "'");

            Statement stmt = (Statement) con.createStatement();    

            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                System.out.println(rs.getInt("PartID"));
                partID = rs.getInt("PartID");
            }

        }catch(SQLException err){
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
         
        //inserting into given parts table 
        try {
            
            String value="", query = "INSERT INTO "+partType+" values ("+value+"?)"; 
            for(int i = 0; i < partinfo.size();i++){
                value += "?,";
            }

            PreparedStatement statement = con.prepareStatement(query);

            statement.setInt(1,partID);
            for(int i = 0; i < partinfo.size();i++){
             statement.setString((2+i), partinfo.get(i));
            }

            statement.execute();
            con.close();
        }
        catch(SQLException err){
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
    return partID;
    }
    
     /**
     * updates a given parts details
     * @param partType of the part being added to system .
     * @param info information about the part like model make price .
     * @param partid parts id to be updated 
     * @param partinfo information about the part it self like its strength etc 
     */
    public void updatePart(String partType, String partid, ArrayList<String> info,ArrayList<String> partinfo){
        Connection con = ServerControl.ConnectDB();

        try {
          String query = "UPDATE Part SET Price = ?, Model = ?, Make = ?, PartType = ?  WHERE PartID = ?"; 

          PreparedStatement statement = con.prepareStatement(query);

          for(int i = 0; i < 4;i++){
            statement.setString((1+i), info.get(i));
          }

          statement.setInt((5),Integer.valueOf(partid));

          statement.execute();

        }
        catch(SQLException err){
            System.out.println(err.getMessage());   //Prints out SQL error 
        }

        try {
          
          String value="";
          for(int i = 3; i < tableColums.size();i++){
            value += tableColums.get(i) + " = ?,";
          }
           value = value.substring(0, value.length()-1);

          String query = "UPDATE "+partType+" SET "+value+" WHERE ID = ?"; 

          PreparedStatement statement = con.prepareStatement(query);

          for(int i = 0; i < partinfo.size();i++){
            statement.setString((1+i), partinfo.get(i));
          }

          statement.setInt(partinfo.size()+1,Integer.valueOf(partid));   

          statement.execute();
          con.close();
        }
        catch(SQLException err){
            System.out.println(err.getMessage());   //Prints out SQL error 

        }
    
    }
    
    /**
     * Deletes an given part 
     * @param partID part to be deleted.
     */
    public void deletePart(String partID){
       
        Connection con = ServerControl.ConnectDB();
        try {
          String query = "DELETE FROM Part WHERE PartID = "+partID; 
          PreparedStatement statement = con.prepareStatement(query);
          statement.execute();
          con.close();
        }
        catch(SQLException err){
            System.out.println(err.getMessage());   //Prints out SQL error 

        }
    }
    
    /**
     * Method to update users account type  
     * @param type new type of account .
     * @param name user to update.
     */
    public void updateAccountType(Boolean type, String name) {
        Connection con = ServerControl.ConnectDB();
        try {
           String query = "UPDATE Account SET accountType = "+type+" WHERE userName = '"+name+"';";
           PreparedStatement statement = con.prepareStatement(query);
            statement.execute();
        } 
        catch(SQLException err){
            System.out.println(err.getMessage());   //Prints out SQL error 
       }
    }
    
    /**
     * Method to delete an user from system 
     * @param name username to be deleted
     */
    public void deleteAccount(String name) {
         Connection con = ServerControl.ConnectDB();
         try {
            String query = "DELETE FROM Account WHERE userName = '"+name+"';";
            PreparedStatement statement = con.prepareStatement(query);
            statement.execute();
         } 
         catch(SQLException err){
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
    }
   
}

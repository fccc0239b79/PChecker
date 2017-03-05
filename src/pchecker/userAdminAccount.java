/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pchecker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author Greg
 */
public class userAdminAccount {
    
    private String username, password, fName, sName, email, DOB,mobilNum;
    ///private Integer mobilNum;
    private boolean type;          //True for admin, false for general. 

    

    //private String loggedFname;
    //private String loggedSname;
    //private String loggedEmail;


    /**
     *
     * @return
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
    

    /**
     *
     * @param enteredUname
     * @param enteredPass
     * @return
     */
    public boolean LogInService(String enteredUname, String enteredPass) {
        //Checks entered username and password against ones stored in database.
        Connection con = ServerControl.ServerControl();
        String dbUname, dbPassword;
        
        try {
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT userName, accountType, Fname, Sname, Email, MobilNum, DOB FROM Account WHERE userName='" + enteredUname +"'");

            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {

                dbUname = rs.getString("userName");
                //dbPassword = rs.getString("Password");
                
                fName = rs.getString("Fname");
                sName = rs.getString("Sname");
                email = rs.getString("Email");
                mobilNum = rs.getString("MobilNum");
                DOB = rs.getString("DOB");

                 //System.out.println(loggedFname + loggedSname + loggedEmail);
                 
                boolean dbType = rs.getBoolean("accountType");
                //if (dbUname.equals(enteredUname) && dbPassword.equals(enteredPass)) { //Comparison check
                setType(dbType); //Sets type of user.
                con.close();
                setUsername(dbUname);
                    //setPassword(dbPassword);
                    //return true;
                //}

            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }

        return false;
        
    }

   
    ArrayList<String> builds = new ArrayList<String>();

    public ArrayList<String> getBuilds(){
        builds.clear();
           Connection con = ServerControl.ServerControl();
           String user = username;
            
      //ArrayList<String> builds = new ArrayList<String>();
           
            try {
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT name FROM Build WHERE Account='" + user+"'");

            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            
            while (rs.next()) {
          
                builds.add(rs.getString("name"));
                
            }
            if(!rs.first()){
                builds.add("No Builds");
                return builds;
            }
           }
        catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
     //System.out.println(builds);

           return builds;
    }
    
    
    public boolean checkPassword(String username, String password){
            // this statement establishes the connection between netbeans and the vm
           Connection con = ServerControl.ServerControl();
           String user = username;
           String enteredPassword = password;
            try {
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT userName, Password FROM Account WHERE userName='" + user+"'");

            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                   String dbPassword = rs.getString("Password");
                   if(dbPassword.equals(enteredPassword)){
                   return true;
                   }else{
                       return false;
                       
                   }                   
                }
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
     * 
     * @param username
     * @param newPassword
     * @return
     */
    /*
    public void changePassword(String username, String newPassword){
    Connection con = DatabaseConnection.establishConnection();
    String user = username;
    String password = newPassword;
    try {
    
       //SQL query - changes password where the username is equal to input, entered by user.
       String query = ("UPDATE Account SET Password '" + password + "' WHERE Username = '" + username +"' ;  ");
       PreparedStatement statement = con.prepareStatement(query);
    
 
    }
    catch(SQLException err){ //error message
        
    
    }
   
    // setting the users data entered below
    }
    */
    
    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param fname
     */
    public void setFname(String fname) {
        this.fName = fname;
    }

    /**
     *
     * @param sname
     */
    public void setSname(String sname) {
        this.sName = sname;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    public void setMobil(String mobil) {
        this.mobilNum = mobil;
    }
    public void setDOB(String dob) {
        this.DOB = dob;
    }
    /**
     *
     * @param type
     */
    public void setType(boolean type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public boolean getType() {
        return type;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LogInForm frm = new LogInForm();
        frm.setVisible(true);

    }

    /**
     * checking the availability of a username in the database.
     * @param username
     * @return
     */
    public boolean usernameAvailability(String username) {
        Connection con = ServerControl.ServerControl();

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
            
        } catch (SQLException err) {

            System.out.println(err.getMessage());
            return false;
        }
        return false;
    }    
    
    /**
     * saves the users details into the database
     */
    public void saveUser(){
    
        //connecting to the vm
    Connection con = ServerControl.ServerControl();
    
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
    }
    catch(SQLException err){
        
    
    }
    
 
    
    
    
    }
    
    
     protected void reset(){
        username = " ";
        password= " ";
        fName= " ";
        sName= " ";
        email= " ";
        mobilNum = " ";
        DOB = " ";
        
        type= false;         //True for admin, false for general. 

   

    }
    
    
    
    
    
    
    
    
}

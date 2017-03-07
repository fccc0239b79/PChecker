package pchecker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Greg
 */
public class build {
    private int motherBoardID, cpuID, ramID, storageID, gpuID, psuID, caseID, coolerID,accessoryID,systemCompRating;
    private String buildName;
    
    public void setBuildName(String name){
        this.buildName = name;
    }    
    public void setMotherboard(int ID){
        this.motherBoardID = ID;
    }
    public void setCPU(int ID){
        this.cpuID = ID;
    }
    public void setRam(int ID){
        this.ramID = ID;
    }
    public void setStorage(int ID){
        this.storageID = ID;
    }
    public void setGpu(int ID){
        this.gpuID = ID;
    }
    public void setPSU(int ID){
        this.psuID = ID;
    }
    public void setCase(int ID){
        this.caseID = ID;
    }
    public void setCooler(int ID){
        this.coolerID = ID;
    }
    public void setAccessory(int ID){
        this.accessoryID = ID;
    }
    
    
    public String setBuildName(){
        return buildName;
    }    
    public int setMotherboard(){
        return motherBoardID;
    }
    public int setCPU(){
        return cpuID;
    }
    public int setRam(){
        return ramID;
    }
    public int setStorage(){
        return storageID;
    }
    public int setGpu(){
        return gpuID;
    }
    public int setPSU(){
        return psuID;
    }
    public int getCase(){
        return caseID;
    }
    public int getCooler(){
        return coolerID;
    }
    public int getAccessory(){
        return accessoryID;
    }
    
    
    public void savebuild(String username){
    Connection con = ServerControl.ConnectDB();
    
    try {
        //SQL query for inserting data into account table
       String query = "INSERT INTO Build values (?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
          
       PreparedStatement statement = con.prepareStatement(query);
       
       //setting user inputs into sql query
       statement.setInt(1,0);
       statement.setString(2, buildName);
       statement.setString(3, username);
       statement.setInt(4, motherBoardID);
       statement.setInt(5,cpuID);
       statement.setInt(6,ramID);
       statement.setInt(7,storageID);
       statement.setInt(8, gpuID);
       statement.setInt(9, psuID);
       statement.setInt(10, caseID);
       statement.setInt(11, coolerID);
       statement.setInt(12, accessoryID);
       statement.setInt(13, systemCompRating);
       statement.execute();
     
    }
    catch(SQLException err){
        System.out.println(err);
    }
    }
}

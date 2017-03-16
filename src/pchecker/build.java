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
    private String buildName,motherBoardName, cpuName, ramName, storageName, gpuName, psuName, caseName, coolerName,accessoryName;
    
    //stworzyc method na kazdy lable 
    public void setBuildName(String name){
        this.buildName = name;
    }    
    public void setMotherboard(int ID, String name ){
        this.motherBoardID = ID;
        this.motherBoardName = name;
    }
    public void setCPU(int ID, String name ){
        this.cpuID = ID;
        this.cpuName = name;
    }
    public void setRAM(int ID, String name ){
        this.ramID = ID;
        this.ramName = name;
    }
    public void setStorage(int ID, String name ){
        this.storageID = ID;
        this.storageName = name;
    }
    public void setGPU(int ID, String name ){
        this.gpuID = ID;
        this.gpuName  = name;
    }
    public void setPSU(int ID, String name ){
        this.psuID = ID;
        this.psuName = name;
    }
    public void setPCCase(int ID, String name ){
        this.caseID = ID;
        this.caseName = name;
    }
    public void setCooler(int ID, String name ){
        this.coolerID = ID;
        this.coolerName = name;
    }
    public void setAccessory(int ID, String name ){
        this.accessoryID = ID;
        this.accessoryName = name;
    }
    
    public String getPartName(String partType){
        String partName = "";
        switch (partType) {
                
                    case "Motherboard": partName = motherBoardName;
                                        break;
                    case "CPU": partName = cpuName;
                                break;
                    case "RAM":  partName = ramName;
                                break;
                    case "GPU": partName = gpuName;
                                break;
                    case "Storage": partName = storageName;
                                    break;
                    case "Accessory":  partName = accessoryName;
                                      break;
                    case "PSU": partName = psuName;
                                break;
                    case "PCCase": partName = caseName;
                                   break;
                    case "Cooler": partName = coolerName;
                                    break;
        }
        return partName;
        
    }
    
    public String getBuildName(){
        return buildName;
    }    
    public int getMotherboard(){
        return motherBoardID;
    }
    public int getCPU(){
        return cpuID;
    }
    public int getRam(){
        return ramID;
    }
    public int getStorage(){
        return storageID;
    }
    public int getGpu(){
        return gpuID;
    }
    public int getPSU(){
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
    public void getBuild(String username, String name){
        Connection con = ServerControl.ConnectDB();
    
    try {
        Statement stmt = (Statement) con.createStatement();
        //String query = "Select P.PartID,P.PartType,P.Model, P.Make FROM Build AS B JOIN Part AS P ON P.PartID IN(B.Motherboard,B.CPU,B.RAM,B.Storage,B.GPU,B.PSU,B.PCCase,B.Cooler,B.Accessory) where Account = '"+username+"' AND BuildName = '"+buildName+"';";

        String query = "SELECT * FROM Build where Account = '"+username+"' AND BuildName = '"+name+"';";
       
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();


        while (rs.next()) {
            buildName = name;
            motherBoardID = rs.getInt("Motherboard");
            cpuID = rs.getInt("CPU");
            ramID = rs.getInt("RAM");
            storageID = rs.getInt("Storage");
            gpuID = rs.getInt("GPU");
            psuID = rs.getInt("PSU");
            caseID = rs.getInt("PCCase");
            coolerID = rs.getInt("Cooler");
            accessoryID = rs.getInt("Accessory");
            systemCompRating = rs.getInt("systemCompRating");
    
        }
    
    } catch(SQLException err){
        System.out.println(err);
    } 
    
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
            System.out.print(statement);

       statement.execute();
    }
    catch(SQLException err){
        System.out.println(err);
    }
    }
}

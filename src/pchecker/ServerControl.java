/**
 * @author Grzegorz Lindert
 * @version 1.0
 * @since 07/03/2017
 */
//sets packages needed
package pchecker;


import java.sql.Connection;
import java.sql.DriverManager;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 *This class creates an connection to the remote database.
 */
public class ServerControl {

    static int lport;
    static int rport;

    public static void connect(){
        //this method creates an remote ssh tunnel to an remote virtual machine
        //it creates an ssh tunnel by port forwarding which is saved and then used 
        //to connect to mysql 

        //login details to virtual machine 
        String rUser = "up780016";
        String rPassword = "gregl33";
        String rHost = "35.187.14.195";
        try{
            //creating a new ssh tunnel 
            JSch jsch = new JSch();
            Session session = jsch.getSession(rUser, rHost, 22);
            lport = 4321;
            rport = 3306;
            session.setPassword(rPassword);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("Establishing Connection...");
            session.connect(); 
            session.setPortForwardingL(lport, "localhost", rport);
            System.out.println("Connected");
           } catch(Exception e){
               System.out.print(e);
        }
    }
    
     /**
     * Establishes the connection to database
     * @return connection to database 
     */
    public static Connection ConnectDB() {    //This method connects to the database and returns the connection.
       
          Connection DBconnection = null;
          String url = "jdbc:mysql://localhost:" + lport + "/PChecker"; //Location of mySQL server
           //account details for accessing database      
          String dbUser = "root";
          String dbPasswd = "root";
          try{
            //trying to connect to mysql 
            Class.forName("com.mysql.jdbc.Driver");
            DBconnection = DriverManager.getConnection(url, dbUser, dbPasswd);
            System.out.println("Connected to database successfully...");
            //returning connection 
            return DBconnection;
            }
          catch (Exception err){
            System.out.println(err.getMessage());   //Prints out SQL error if connection is not established
            return null;
          }       
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pchecker;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Greg
 */
public class userAdminAccountTest {

    /**
     * Test of LogInService method, of class userAdminAccount.
     */
    public userAdminAccountTest() {
        ServerControl.connect();

    }
    
    @Test
    public void testLogInService() {

        
        userAdminAccount instance1 = new userAdminAccount();        
        instance1.LogInService("user", "user");
        String result = instance1.getFname();
        
        userAdminAccount instance2 = new userAdminAccount();
        instance2.LogInService(" ", "pass");
        String wrongresult = instance2.getFname();

        assertEquals("User", result); // correct log in info 
        assertEquals(null, wrongresult); //incorrect log in info 

    }
    

 @Test
public void testcheckPassword() {

    userAdminAccount instance = new userAdminAccount();

    boolean result = instance.checkPassword("user", "user");
    boolean wrongresult = instance.checkPassword("user", "pass");

    assertEquals(true, result);
    assertEquals(false, wrongresult);

}

@Test
public void testusernameAvailability() {

    userAdminAccount instance = new userAdminAccount();

    boolean result = instance.usernameAvailability("newUser");
    boolean wrongresult = instance.usernameAvailability("user");

    assertEquals(true, result);
    assertEquals(false, wrongresult);
    

}
@Test
public void testrset() {

    userAdminAccount instance = new userAdminAccount();
    instance.setFname("user");


    assertEquals("user", instance.getFname());//checks before reset
    instance.reset();
    assertEquals(" ", instance.getFname());//checks after reset
    

}

    
}
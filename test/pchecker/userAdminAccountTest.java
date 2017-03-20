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
@Test
public void testgetTableColName() {

    userAdminAccount instance = new userAdminAccount();
    ArrayList<String> rs = instance.getTableColName("Part");
    Boolean result = rs.isEmpty();

    

    assertEquals(false, result);

    
    
}


@Test
public void testgetparts() {

    userAdminAccount instance = new userAdminAccount();
    DefaultTableModel rs = instance.getparts("PSU");
    int ress = rs.findColumn("ID");
    Boolean result = ress<=0;
    

    assertEquals(false,result);
    
    
}
@Test
public void testgetBuilds() {

    userAdminAccount instance = new userAdminAccount();
    instance.setUsername("user");
   
    ArrayList<String> result = instance.getBuilds();
    
    String ress = result.get(0);
    
    assertEquals(ress,"No Builds");
    

}



@Test
public void testUpdateUser() {

    userAdminAccount instance = new userAdminAccount();
    instance.LogInService("user", "user");
    instance.setFname("USER");
    instance.UpdateUser();
    
    instance.reset();
    instance.LogInService("user", "user");
    
    String result = instance.getFname();
   
    assertEquals("USER",result);
    assertEquals("User",instance.getSname());

    
    instance.setFname("User");
    instance.UpdateUser();
}


@Test
public void testSetUsername() {
    String useername = "user";
    
    userAdminAccount instance = new userAdminAccount();
    instance.setUsername(useername);
    
    assertEquals("user", instance.getUsername());
}
// passed

@Test
public void testSetPassword() {
    String password = "password";
    
    userAdminAccount instance = new userAdminAccount();
    instance.setPassword(password);
    
   // assertEquals("password", instance.getPassword());
}
// not possible to check there is no getPassword()

@Test
public void testSetFirstName() {
    String name = "Kevin";
    
    userAdminAccount instance = new userAdminAccount();
    instance.setFname(name);
    
    assertEquals("Kevin", instance.getFname());
}

@Test
public void testSetSurname() {
    String surname = "Smith";
    
    userAdminAccount instance = new userAdminAccount();
    instance.setSname(surname);
    
    assertEquals("Smith", instance.getSname());
}

@Test
public void testSetEmail() {
    String email = "smmith@yahoo.co.uk";
    
    userAdminAccount instance = new userAdminAccount();
    instance.setEmail(email);
    
    assertEquals("smmith@yahoo.co.uk", instance.getEmail());
}

@Test
public void testSetMobile() {
    String mobile = "0123423421";
    
    userAdminAccount instance = new userAdminAccount();
    instance.setMobil(mobile);
    
    assertEquals("0123423421", instance.getMobile());
}

@Test
public void testSetDOB() {
    String dob = "12091990";
    
    userAdminAccount instance = new userAdminAccount();
    instance.setDOB(dob);
    
    assertEquals("12091990", instance.getDOB());
}

@Test
public void testSetType() {
    Boolean type = true;
    
    userAdminAccount instance = new userAdminAccount();
    instance.setType(type);
    
    assertEquals(true, instance.getType());
}


}
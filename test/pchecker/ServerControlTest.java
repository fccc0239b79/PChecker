/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pchecker;

import java.sql.Connection;
import java.sql.SQLException;
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
public class ServerControlTest {

    /**
     * Test of ConnectDB method, of class ServerControl.
     */
    @Test
    public void testConnectDB() throws SQLException {
        ServerControl.connect();
        
        Connection con = ServerControl.ConnectDB();
        
        Boolean result = con.isClosed();
        Boolean  expResult = false;
        
        assertEquals(expResult, result);
        
    }
    
}

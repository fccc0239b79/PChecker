/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pchecker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pawel
 */
public class buildTest {
    
    public buildTest() {
    }
  
     /**
     * Test of setBuildName method, of class build.
     */
    @Test
    public void testSetBuildName() {
        String name = "setBuildName";
        String nullName = null;
        build instance = new build();
        
        instance.setBuildName(name);
        //assertEquals(expected, actual result)
        assertEquals("setBuildName", instance.getBuildName());
        
        instance.setBuildName(nullName);
        assertEquals("setBuildName", instance.getBuildName()); // getByuildName is not null
    
    }
}
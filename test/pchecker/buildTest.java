/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pchecker;

import java.util.Set;
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
    
    @Test
    public void testSetMotherboard() {
        int id = 1;
        String name = "Asus";
        String partTypeName = "Motherboard";
        double price = 99.99;
        
        build instance = new build();
        
        instance.setMotherboard(id, name,price);
        assertEquals(1, instance.getMotherboard());
        
        instance.setMotherboard(id, name,price);
        assertEquals("Asus", instance.getPartName(partTypeName));
    }
    
    @Test
    public void testSetCPU() {
        int id = 1;
        String name = "AMD";
        String partTypeName = "CPU";
        double price = 99.99;

        
        build instance = new build();
        
        instance.setCPU(id, name,price);
        assertEquals(1, instance.getCPU());
        
        instance.setCPU(id, name,price);
        assertEquals("AMD", instance.getPartName(partTypeName));
    }
    
    @Test
    public void testSetRAM() {
        int id = 1;
        String name = "KINGSTON";
        String partTypeName = "RAM";
                double price = 99.99;

        
        build instance = new build();
        
        instance.setRAM(id, name,price);
        assertEquals(1, instance.getRam());
        
        instance.setRAM(id, name,price);
        assertEquals("KINGSTON", instance.getPartName(partTypeName));
    }
    
    @Test
    public void testSetStorage() {
        int id = 1;
        String name = "WD";
        String partTypeName = "Storage";
                double price = 99.99;

        
        build instance = new build();
        
        instance.setStorage(id, name,price);
        assertEquals(1, instance.getStorage());
        
        instance.setStorage(id, name,price);
        assertEquals("WD", instance.getPartName(partTypeName));
    }
    
    @Test
    public void testSetGPU() {
        int id = 1;
        String name = "MSI";
        String partTypeName = "GPU";
                double price = 99.99;

        build instance = new build();
        
        instance.setGPU(id, name,price);
        assertEquals(1, instance.getGpu());
        
        instance.setGPU(id, name,price);
        assertEquals("MSI", instance.getPartName(partTypeName));
    }
    
    @Test
    public void testSetPSU() {
        int id = 1;
        String name = "Corsair";
        String partTypeName = "PSU";
                double price = 99.99;

        build instance = new build();
        
        instance.setPSU(id, name,price);
        assertEquals(1, instance.getPSU());
        
        instance.setPSU(id, name,price);
        assertEquals("Corsair", instance.getPartName(partTypeName));
    }
    
    @Test
    public void testSetPCCase() {
        int id = 1;
        String name = "BeQuiet";
        String partTypeName = "PCCase";
                double price = 99.99;

        build instance = new build();
        
        instance.setPCCase(id, name,price);
        assertEquals(1, instance.getCase());
        
        instance.setPCCase(id, name,price);
        assertEquals("BeQuiet", instance.getPartName(partTypeName));
    }
    
    @Test
    public void testSetCooler() {
        int id = 1;
        String name = "BeQuiet";
        String partTypeName = "Cooler";
                double price = 99.99;

        build instance = new build();
        
        instance.setCooler(id, name,price);
        assertEquals(1, instance.getCooler());
        
        instance.setCooler(id, name,price);
        assertEquals("BeQuiet", instance.getPartName(partTypeName));
    }
    
     @Test
    public void testSetAccessory() {
        int id = 1;
        String name = "mouse";
        String partTypeName = "Accessory";
                double price = 99.99;

        build instance = new build();
        
        instance.setAccessory(id, name,price);
        assertEquals(1, instance.getAccessory());
        
        instance.setAccessory(id, name,price);
        assertEquals("mouse", instance.getPartName(partTypeName));
    }
    
    
    

            
            
@Test
public void testgetBuild() {

    build instance = new build();
    instance.getBuild("user","My First Build");
   
    
    String ress = instance.getBuildName();
    
    assertEquals("My First Build",ress);
    

}

@Test 
public void stressTestSetMotherboard() {
    
   for (int i = 0; i < 1000; i++) {
        testSetMotherboard();
   }

}

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szorzas_eny4g2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static szorzas_eny4g2.Szorzas_ENY4G2.multiplyNaturals;

/**
 *
 * @author szili
 */
public class Szorzas_ENY4G2Test {
    
    public Szorzas_ENY4G2Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Szorzas_ENY4G2.
     */
     
    @Test
    public void elsoTeszt() {
        assertEquals(2, multiplyNaturals(1, 2));
    }
    
    @Test
    public void masodikTeszt() {
        assertEquals(-1, multiplyNaturals(-1, 2));
    }
    
    @Test
    public void harmadikTeszt() {
        assertEquals(0, multiplyNaturals(0, 5));
    }
    
    @Test
    public void negyedikTeszt() {
        assertEquals(-1, multiplyNaturals(-100, -100));
    }
    
    @Test
    public void otodikTeszt() {
        assertEquals(1000000, multiplyNaturals(1000, 1000));
    }
}

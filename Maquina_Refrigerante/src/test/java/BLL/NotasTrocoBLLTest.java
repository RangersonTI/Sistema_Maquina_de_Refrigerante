/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BLL;

import Models.NotasTroco;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author LUIS FELIPE
 */
public class NotasTrocoBLLTest {
    private NotasTrocoBLL troco;
    public NotasTrocoBLLTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        troco = new NotasTrocoBLL();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of EntradaDeTroco method, of class NotasTrocoBLL.
     */
  

    /**
     * Test of BuscarNotasTroco method, of class NotasTrocoBLL.
     */
    @Test
    public void testBuscarNotasTroco() {
        
    }

    /**
     * Test of VerificarTroco method, of class NotasTrocoBLL.
     */
    @Test
    public void testVerificarTroco() {
      assertEquals(true, troco.VerificarTroco(5));
    }
    
}

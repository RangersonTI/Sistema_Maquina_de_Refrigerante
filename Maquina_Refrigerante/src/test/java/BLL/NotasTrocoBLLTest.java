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
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of EntradaDeTroco method, of class NotasTrocoBLL.
     */
    @Test
    public void testEntradaDeTroco() {
        System.out.println("EntradaDeTroco");
        NotasTroco _troco = null;
        NotasTroco _trocoAnterior = null;
        NotasTrocoBLL instance = new NotasTrocoBLL();
        instance.EntradaDeTroco(_troco, _trocoAnterior);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarNotasTroco method, of class NotasTrocoBLL.
     */
    @Test
    public void testBuscarNotasTroco() {
        System.out.println("BuscarNotasTroco");
        NotasTrocoBLL instance = new NotasTrocoBLL();
        NotasTroco expResult = null;
        NotasTroco result = instance.BuscarNotasTroco();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of VerificarTroco method, of class NotasTrocoBLL.
     */
    @Test
    public void testVerificarTroco() {
        System.out.println("VerificarTroco");
        double _troco = 0.0;
        NotasTrocoBLL instance = new NotasTrocoBLL();
        boolean expResult = false;
        boolean result = instance.VerificarTroco(_troco);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

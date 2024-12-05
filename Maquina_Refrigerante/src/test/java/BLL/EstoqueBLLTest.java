/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BLL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 202212160041@ifto.local
 */
public class EstoqueBLLTest {
    
    public EstoqueBLLTest() {
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
     * Test of EntradaDeEstoque method, of class EstoqueBLL.
     */
    @Test
    public void testEntradaDeEstoque() {
        System.out.println("EntradaDeEstoque");
        int _id = 0;
        int QtdEstoqueEntrada = 0;
        EstoqueBLL instance = new EstoqueBLL();
        instance.EntradaDeEstoque(_id, QtdEstoqueEntrada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SaidaDeEstoque method, of class EstoqueBLL.
     */
    @Test
    public void testSaidaDeEstoque() {
        System.out.println("SaidaDeEstoque");
        EstoqueBLL instance = new EstoqueBLL();
        instance.SaidaDeEstoque();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of VerificarEstoque method, of class EstoqueBLL.
     */
    @Test
    public void testVerificarEstoque() {
        System.out.println("VerificarEstoque");
        int _id = 0;
        int qtd_solicitado = 0;
        EstoqueBLL instance = new EstoqueBLL();
        boolean expResult = false;
        boolean result = instance.VerificarEstoque(_id, qtd_solicitado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

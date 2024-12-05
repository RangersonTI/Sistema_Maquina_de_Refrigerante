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
    
    private EstoqueBLL estoque;
    
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
        
        estoque = new EstoqueBLL();
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of EntradaDeEstoque method, of class EstoqueBLL.
     */
    @Test
    public void testEntradaDeEstoque() {
      
    }

    /**
     * Test of SaidaDeEstoque method, of class EstoqueBLL.
     */
    @Test
    public void testSaidaDeEstoque() {
       
    }

    /**
     * Test of VerificarEstoque method, of class EstoqueBLL.
     */
    @Test
    public void testVerificarEstoque() {
        
        assertEquals(true, estoque.VerificarEstoque(1, 10));
      
    }
    
}

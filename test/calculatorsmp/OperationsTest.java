/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package calculatorsmp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author CltControl
 */
public class OperationsTest {
    
    public OperationsTest() {
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
     * Test of MakeFormula method, of class Operations.
     */
    @Test
    public void testMakeFormula() {
        System.out.println("MakeFormula");
        String expResult = "";
        String result = Operations.MakeFormula();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Solve method, of class Operations.
     */
    @Test
    public void testSolve() {
        System.out.println("Solve");
        String formula = "";
        String expResult = "";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSolveUsandoStringNumericoyAlfabetico() {
        System.out.println("Probar el funcionamiento del metodoSolve al recibir un String numerico y uno alfabetico ");
        String formula = "15+a";
        String expResult = "NumberFormatException";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSolveUsandoDosOperadoresSeguidosconStringsNumericos() {
        System.out.println("Probar funcionamiento del método Solve si recibe 2 operadores seguidos en la formula ");
        String formula = "2**2";
        String expResult = " DobleOperadorException";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
    }


    @Test
    public void testSolveUsandoNumerosDecimales() {
        System.out.println("Probar funcionamiento del método Solve si recibe números decimales");
        String formula = "2.2+2";
        String expResult = " 4.2";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
        
    }






}

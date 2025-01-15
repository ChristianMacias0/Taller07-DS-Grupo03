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
    /**
     * Test ID: 001
     * Propósito: Probar que el metodo MakeFormula genera formulas correctamente con un arreglo `op` válido.
     */
    @Test
    public void testMakeFormulaValidOp() {
        System.out.println("Test ID: 001");
        // Simular un arreglo op correcto
        String[] originalOp = Operations.op1;
        Operations.op1 = new String[]{"+", "-", "*", "/"};

        // Probar la salida
        String result = Operations.MakeFormula();
        assertNotNull(result, "La formula generada no debe ser nula.");
        assertTrue(result.matches("\\d+[+\\-*/]\\d+([+\\-*/]\\d+)?"), "La formula debe seguir el formato esperado.");

        // Restaurar el estado original
        Operations.op1 = originalOp;
    }

    /**
     * Test ID: 002
     * Propósito: Probar que el método MakeFormula lanza una excepción con un arreglo `op` inválido.
     */
    @Test
    public void testMakeFormulaInvalidOp() {
        System.out.println("Test ID: 002");
        // Simular un arreglo op inválido
        String[] originalOp = Operations.op1;
        Operations.op1 = new String[]{"456", "gr", "hth", "567"};

        // Ejecutar y validar que no produce una fórmula válida
        String result = Operations.MakeFormula();
        assertNotNull(result, "La formula generada no debe ser nula.");
        assertTrue(result.contains("456") || result.contains("gr") || result.contains("hth"), "La formula incluye elementos no validos.");

        // Restaurar el estado original
        Operations.op1 = originalOp;
    }

    /**
     * Test ID: 003
     * Propósito: Probar que el metodo MakeFormula lanza una excepcion con un arreglo `op` de un solo elemento.
     */
    @Test
    public void testMakeFormulaSingleOp() {
        System.out.println("Test ID: 003");
        // Simular un arreglo op con un solo elemento
        String[] originalOp = Operations.op1;
        Operations.op1 = new String[]{"+"};

        // Probar la salida
        String result = Operations.MakeFormula();
        assertNotNull(result, "La formula generada no debe ser nula.");
        assertTrue(result.matches("\\d+\\+\\d+(\\+\\d+)?"), "La formula debe seguir el formato esperado.");

        // Restaurar el estado original
        Operations.op1 = originalOp;
    }

    /**
     * Test ID: 004
     * Proposito: Probar que el metodo MakeFormula lanza una excepcion con un arreglo `op` vacío.
     */
    @Test
    public void testMakeFormulaEmptyOp() {
        System.out.println("Test ID: 004");
        // Simular un arreglo op vacío
        String[] originalOp = Operations.op1;
        Operations.op1 = new String[]{};

        // Esperar una excepción
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, Operations::MakeFormula, "Debe lanzar una excepción si el arreglo op esta vacío.");
        assertNotNull(exception);

        // Restaurar el estado original
        Operations.op1 = originalOp;
    }

    /**
     * Test ID: 005
     * Propósito: Probar que el método MakeFormula lanza una excepción con un arreglo `op` nulo.
     */
    @Test
    public void testMakeFormulaNullOp() {
        System.out.println("Test ID: 005");
        // Simular un arreglo op nulo
        String[] originalOp = Operations.op1;
        Operations.op1 = null;

        // Esperar una excepción
        Exception exception = assertThrows(NullPointerException.class, Operations::MakeFormula, "Debe lanzar una excepcion si el arreglo op es nulo.");
        assertNotNull(exception);

        // Restaurar el estado original
        Operations.op1 = originalOp;
    }


    /**
     * Test of Solve method, of class Operations.
     */

     @Test
    public void testSolveUsandoStringNumericoyAlfabetico() {
        System.out.println("Probar el funcionamiento del metodoSolve al recibir un String numerico y uno alfabetico ");
        String formula = "15+a";
        String expResult = "NumberFormatException";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);

        
    }

     @Test
    public void testSolveUsandoDigitosUnitarios() {
        System.out.println("Solve");
        String formula = "1-1";
        String expResult = "0";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result, "El resultado de la operación 1-1 debe ser 0");
    }

    @Test
    public void testSolveUsandoNumeros2Digitos() {
        System.out.println("Solve");
        String formula = "01-01";
        String expResult = "0";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result, "el resultado de la operación 01-01 debe ser 0");
    }
    
    @Test
    public void testSolveDejandoEspacioEntreCaracteres() {
        System.out.println("Solve");
        String formula = "01 + 01";
        String expResult = "2";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result, "el resultado de la operación 01 + 01 debe ser 2");
    }

    @Test
    public void testSolveSumaDeStrings() {
        System.out.println("Solve");
        String formula = "01"+"+"+"02";
        String expResult = "3";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result, "el resultado de la operación 01-02 debe ser 3");
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


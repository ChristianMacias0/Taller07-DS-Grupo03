package calculatorsmp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OperationsTest {

    /**
     * Test ID: 001
     * Propósito: Probar que el metodo MakeFormula genera formulas correctamente con un arreglo `op` válido.
     */
    @Test
    public void testMakeFormulaValidOp() {
        System.out.println("Test ID: 001 - MakeFormula with valid op array");
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
        System.out.println("Test ID: 002 - MakeFormula with invalid op array");
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
        System.out.println("Test ID: 003 - MakeFormula with single-element op array");
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
        System.out.println("Test ID: 004 - MakeFormula with empty op array");
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
        System.out.println("Test ID: 005 - MakeFormula with null op array");
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
    public void testSolve() {
        System.out.println("Solve");
        String formula = "";
        String expResult = "";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

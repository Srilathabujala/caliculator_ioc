import com.example.caliculator_ioc.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        assertEquals(5, calculator.calculate(Operation.ADD, 2, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(1, calculator.calculate(Operation.SUBTRACT, 3, 2));
    }

    @Test
    public void testMultiplication() {
        assertEquals(6, calculator.calculate(Operation.MULTIPLY, 2, 3));
    }

    @Test
    public void testDivision() {
        assertEquals(2, calculator.calculate(Operation.DIVIDE, 6, 3));
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(Operation.DIVIDE, 6, 0);
        });
    }

    @Test
    public void testUnsupportedOperation() {
        Operation unsupportedOperation = Operation.MODULO;
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(unsupportedOperation, 6, 2);
        });
    }

    @Test
    public void testChainingOperations() {
        double result = calculator.chainCalculate(5.0, Operation.ADD, 3.0, Operation.MULTIPLY, 2.0);
        assertEquals(16, result);
    }
}
package guru.springframework.spring5webapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OperationsServiceTest {

    private OperationsService operationsService;

    @BeforeEach
    void setUp() {
        operationsService = new OperationsService();
    }

    @Test
    void testAdd() {
        assertEquals(5, operationsService.add(2, 3));
        assertEquals(-1, operationsService.add(2, -3));
        assertEquals(0, operationsService.add(0, 0));
    }

    @Test
    void testSubtract() {
        assertEquals(-1, operationsService.subtract(2, 3));
        assertEquals(5, operationsService.subtract(2, -3));
        assertEquals(0, operationsService.subtract(0, 0));
    }

    @Test
    void testMultiply() {
        assertEquals(6, operationsService.multiply(2, 3));
        assertEquals(-6, operationsService.multiply(2, -3));
        assertEquals(0, operationsService.multiply(0, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, operationsService.divide(6, 3));
        assertEquals(-2.5, operationsService.divide(-5, 2), 0.001);
        assertThrows(ArithmeticException.class, () -> operationsService.divide(5, 0));
    }

    @Test
    void testPower() {
        assertEquals(8, operationsService.power(2, 3));
        assertEquals(1, operationsService.power(5, 0));
        assertEquals(0.25, operationsService.power(2, -2), 0.001);
    }

    @Test
    void testModulus() {
        assertEquals(1, operationsService.modulus(5, 2));
        assertEquals(0, operationsService.modulus(4, 2));
        assertThrows(ArithmeticException.class, () -> operationsService.modulus(5, 0));
    }

    @Test
    void testSqrt() {
        assertEquals(3, operationsService.sqrt(9));
        assertEquals(0, operationsService.sqrt(0));
        assertThrows(ArithmeticException.class, () -> operationsService.sqrt(-9));
    }

    @Test
    void testFactorial() {
        assertEquals(Long.valueOf(120), operationsService.factorial(5)); // Updated to expect BigInteger
        assertEquals(Long.valueOf(120), operationsService.factorial(5));
        assertThrows(ArithmeticException.class, () -> operationsService.factorial(-5));
    }
}

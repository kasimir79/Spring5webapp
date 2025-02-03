package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.service.OperationsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class OperationsConsoleAppTest {

    @Mock
    private OperationsService operationsService;

    @InjectMocks
    private OperationsConsoleApp operationsConsoleApp;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    void testAddition() {
        provideInput("1\n2\n3\n9\n"); // Simulating user input: 1 (Addition), 2, 3, then exit
        when(operationsService.add(2, 3)).thenReturn(5);
        operationsConsoleApp.run();
        assertTrue(outputStreamCaptor.toString().contains("Result: 5"));
    }

    @Test
    void testSubtraction() {
        provideInput("2\n7\n4\n9\n"); // Simulating user input: 2 (Subtraction), 7, 4, then exit
        when(operationsService.subtract(7, 4)).thenReturn(3);
        operationsConsoleApp.run();
        assertTrue(outputStreamCaptor.toString().contains("Result: 3"));
    }

    @Test
    void testMultiplication() {
        provideInput("3\n5\n6\n9\n"); // Simulating user input: 3 (Multiplication), 5, 6, then exit
        when(operationsService.multiply(5, 6)).thenReturn(30);
        operationsConsoleApp.run();
        assertTrue(outputStreamCaptor.toString().contains("Result: 30"));
    }

    @Test
    void testDivision() {
        provideInput("4\n10\n2\n9\n"); // Simulating user input: 4 (Division), 10, 2, then exit
        when(operationsService.divide(10.0, 2.0)).thenReturn(5.0);
        operationsConsoleApp.run();
        assertTrue(outputStreamCaptor.toString().contains("Result: 5.0"));
    }

    @Test
    void testDivisionByZero() {
        provideInput("4\n10\n0\n9\n"); // Simulating division by zero
        operationsConsoleApp.run();
        assertTrue(outputStreamCaptor.toString().contains("Error: Division by zero is not allowed."));
    }

    @Test
    void testExitOption() {
        provideInput("9\n"); // Simulating user selecting exit
        operationsConsoleApp.run();
        assertTrue(outputStreamCaptor.toString().contains("Exiting... Goodbye!"));
    }
}

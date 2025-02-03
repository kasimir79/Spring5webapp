package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.OperationsController;
import guru.springframework.spring5webapp.service.OperationsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OperationsController.class)
class OperationsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private OperationsService operationsService;

    @InjectMocks
    private OperationsController operationsController;

    @Test
    void add_ShouldReturnSum() throws Exception {
        when(operationsService.add(2, 3)).thenReturn(5);

        mockMvc.perform(MockMvcRequestBuilders.get("/operations/add?num1=2&num2=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    void subtract_ShouldReturnDifference() throws Exception {
        when(operationsService.subtract(10, 4)).thenReturn(6);

        mockMvc.perform(MockMvcRequestBuilders.get("/operations/subtract?num1=10&num2=4"))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }

    @Test
    void multiply_ShouldReturnProduct() throws Exception {
        when(operationsService.multiply(3, 4)).thenReturn(12);

        mockMvc.perform(MockMvcRequestBuilders.get("/operations/multiply?num1=3&num2=4"))
                .andExpect(status().isOk())
                .andExpect(content().string("12"));
    }

    @Test
    void divide_ShouldReturnQuotient() throws Exception {
        when(operationsService.divide(10, 2)).thenReturn(5.0);

        mockMvc.perform(MockMvcRequestBuilders.get("/operations/divide?num1=10&num2=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    void divide_ByZero_ShouldReturnBadRequest() throws Exception {
        when(operationsService.divide(10, 0)).thenThrow(new ArithmeticException("Cannot divide by zero"));

        mockMvc.perform(MockMvcRequestBuilders.get("/operations/divide?num1=10&num2=0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void power_ShouldReturnExponentiationResult() throws Exception {
        when(operationsService.power(2, 3)).thenReturn(8.0);

        mockMvc.perform(MockMvcRequestBuilders.get("/operations/power?base=2&exponent=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("8.0"));
    }

    @Test
    void modulus_ShouldReturnRemainder() throws Exception {
        when(operationsService.modulus(10, 3)).thenReturn(1);

        mockMvc.perform(MockMvcRequestBuilders.get("/operations/modulus?num1=10&num2=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    void sqrt_ShouldReturnSquareRoot() throws Exception {
        when(operationsService.sqrt(9)).thenReturn(3.0);

        mockMvc.perform(MockMvcRequestBuilders.get("/operations/sqrt?num=9"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.0"));
    }

    @Test
    void factorial_ShouldReturnFactorial() throws Exception {
        when(operationsService.factorial(5)).thenReturn(120L);

        mockMvc.perform(MockMvcRequestBuilders.get("/operations/factorial?num=5"))
                .andExpect(status().isOk())
                .andExpect(content().string("120"));
    }
}

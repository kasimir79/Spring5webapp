package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.service.OperationsService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/operations")
public class OperationsController {

    private final OperationsService operationsService;

    public OperationsController(OperationsService operationsService) {
        this.operationsService = operationsService;
    }

    @GetMapping("/add")
    public int add(@RequestParam int num1, @RequestParam int num2) {
        return operationsService.add(num1, num2);
    }

    @GetMapping("/subtract")
    public int subtract(@RequestParam int num1, @RequestParam int num2) {
        return operationsService.subtract(num1, num2);
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam int num1, @RequestParam int num2) {
        return operationsService.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public double divide(@RequestParam int num1, @RequestParam int num2) {
        return operationsService.divide(num1, num2);
    }

    @GetMapping("/power")
    public double power(@RequestParam int base, @RequestParam int exponent) {
        return operationsService.power(base, exponent);
    }

    @GetMapping("/modulus")
    public int modulus(@RequestParam int num1, @RequestParam int num2) {
        return operationsService.modulus(num1, num2);
    }

    @GetMapping("/sqrt")
    public double sqrt(@RequestParam int num) {
        return operationsService.sqrt(num);
    }

    @GetMapping("/factorial")
    public Long factorial(@RequestParam int num) {
        return operationsService.factorial(num);
    }
}
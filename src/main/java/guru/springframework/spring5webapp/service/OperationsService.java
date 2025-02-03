
package guru.springframework.spring5webapp.service;


import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class OperationsService {

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) num1 / num2;
    }

    public double power(int base, int exponent) {
        return Math.pow(base, exponent);
    }

    public int modulus(int num1, int num2) {
        return num1 % num2;
    }

    public double sqrt(double num) {
        if (num < 0) {
            throw new ArithmeticException("Cannot compute square root of a negative number");
        }
        return Math.sqrt(num);
    }

    public Long factorial(int n) {
        if (n < 0) throw new ArithmeticException("Factorial is not defined for negative numbers");

        long result = 1L;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}

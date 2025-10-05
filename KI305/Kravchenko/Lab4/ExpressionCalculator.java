package KI305.Kravchenko.Lab4;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас {@code ExpressionCalculator} реалізує метод обчислення виразу
 * y = sin(x) / tg(4x).
 * 
 * @author Kravchenko
 * @version 1.0
 */
public class ExpressionCalculator {

    /**
     * Метод для обчислення виразу y = sin(x) / tg(4x).
     *
     * @param x значення аргументу
     * @return результат обчислення
     * @throws ArithmeticException якщо tg(4x) = 0
     */
    public double calculate(double x) throws ArithmeticException {
        double denominator = Math.tan(4 * x);
        if (Math.abs(denominator) < 1e-10) {
            throw new ArithmeticException("Ділення на нуль: tg(4x) = 0");
        }
        return Math.sin(x) / denominator;
    }
}

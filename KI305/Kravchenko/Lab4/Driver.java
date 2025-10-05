package KI305.Kravchenko.Lab4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Головний клас {@code Driver} для демонстрації роботи
 * класу {@link ExpressionCalculator}.
 * 
 * Програма зчитує значення x, обчислює y = sin(x)/tg(4x)
 * та записує результат у файл.
 * 
 * @author Kravchenko
 * @version 1.0
 */
public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpressionCalculator calc = new ExpressionCalculator();

        try {
            System.out.print("Введіть значення x (у радіанах): ");
            double x = scanner.nextDouble();

            double result = calc.calculate(x);

            // Запис у файл
            try (FileWriter writer = new FileWriter("Result.txt")) {
                writer.write("x = " + x + "\n");
                writer.write("y = sin(x)/tg(4x) = " + result + "\n");
                System.out.println("Результат обчислення записано у файл Result.txt");
            } catch (IOException e) {
                System.err.println("Помилка запису у файл: " + e.getMessage());
            }

        } catch (ArithmeticException e) {
            System.err.println("Помилка обчислення: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Сталася помилка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

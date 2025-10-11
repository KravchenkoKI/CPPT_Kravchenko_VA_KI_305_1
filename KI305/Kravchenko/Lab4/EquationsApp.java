package KI305.Kravchenko.Lab4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Головний клас {@code EquationsApp} демонструє роботу з класом {@link Equations}.
 * <p>
 * Програма зчитує значення x, виконує обчислення y = sin(x)/tg(4x),
 * виводить результат у консоль і записує його у файл "Result.txt".
 * </p>
 */
public class EquationsApp {
    /**
     * Точка входу у програму.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Equations eq = new Equations();

        try {
            System.out.print("Введіть значення x (у радіанах): ");
            double x = scanner.nextDouble();

            double y = eq.calculate(x); // Обчислення
            System.out.printf("Результат: y = %.5f%n", y);

            // Запис у файл
            try (FileWriter writer = new FileWriter("Result.txt")) {
                writer.write("x = " + x + "\n");
                writer.write("y = " + y + "\n");
                System.out.println("Результат записано у файл Result.txt");
            } catch (IOException e) {
                System.err.println("Помилка запису у файл: " + e.getMessage());
            }

        } catch (CalcException e) {
            System.err.println("Помилка обчислення: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Помилка введення: введіть дійсне число!");
        } finally {
            scanner.close();
            System.out.println("Програма завершила роботу.");
        }
    }
}

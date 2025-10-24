package KI305.Kravchenko.Lab5;

import KI305.Kravchenko.Lab4.CalcException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Головний клас {@code EquationsFioApp} демонструє роботу з класом {@link EquationsFio}.
 * Програма:
 *  - Зчитує x від користувача;
 *  - Обчислює y = sin(x)/tg(4x);
 *  - Записує результат у текстовий і двійковий файли;
 *  - Зчитує їх назад і виводить у консоль.
 */
public class EquationsFioApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EquationsFio eqFio = new EquationsFio();

        try {
            System.out.print("Введіть значення x (у радіанах): ");
            double x = sc.nextDouble();

            // Обчислення
            eqFio.calculate(x);
            System.out.printf("Результат: y = %.5f%n", eqFio.getResult());

            // --- Запис у файли ---
            eqFio.writeResTxt("Result.txt");
            System.out.println("✅ Результат записано у файл Result.txt");

            eqFio.writeResBin("Result.bin");
            System.out.println("✅ Результат записано у файл Result.bin");

            // Перевірка розміру двійкового файлу
            System.out.println("Розмір Result.bin = " + new java.io.File("Result.bin").length() + " байт");

            // --- Зчитування з файлів ---
            eqFio.readResTxt("Result.txt");
            System.out.printf("Зчитано з текстового файлу: y = %.5f%n", eqFio.getResult());

            eqFio.readResBin("Result.bin");
            System.out.printf("Зчитано з двійкового файлу: y = %.5f%n", eqFio.getResult());

        } catch (CalcException e) {
            System.err.println("Помилка обчислення: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Помилка роботи з файлом: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Помилка введення: введіть дійсне число!");
        } finally {
            sc.close();
            System.out.println("Програма завершила роботу.");
        }
    }
}

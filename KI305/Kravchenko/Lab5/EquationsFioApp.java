package KI305.Kravchenko.Lab5; // Пакет, де розташований головний клас програми

import KI305.Kravchenko.Lab4.CalcException; // Імпортуємо власний тип виключення
import java.io.IOException; // Для обробки помилок роботи з файлами
import java.util.Scanner;   // Для введення даних користувачем

/**
 * Головний клас {@code EquationsFioApp} демонструє роботу з класом {@link EquationsFio}.
 * <p>
 * Програма:
 * <ul>
 *     <li>Зчитує значення x від користувача;</li>
 *     <li>Обчислює y = sin(x)/tg(4x);</li>
 *     <li>Записує результат у текстовий та двійковий файли;</li>
 *     <li>Зчитує результат з обох файлів;</li>
 *     <li>Виводить значення у консоль;</li>
 *     <li>Обробляє помилки обчислень та введення.</li>
 * </ul>
 * </p>
 *
 * @author Kravchenko
 * @version 1.0
 */
public class EquationsFioApp {

    /**
     * Точка входу у програму.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        // Створюємо об’єкт Scanner для введення даних користувачем
        Scanner sc = new Scanner(System.in);

        // Створюємо об’єкт класу EquationsFio для роботи з обчисленнями і файлами
        EquationsFio eqFio = new EquationsFio();

        try {
            System.out.print("Введіть значення x (у радіанах): ");
            double x = sc.nextDouble(); // Зчитуємо число типу double

            eqFio.calculate(x); // Обчислюємо y = sin(x)/tg(4x)
            System.out.printf("Результат обчислення: y = %.10f%n", eqFio.getResult());

            // --- Запис результатів у файли ---
            eqFio.writeResTxt("Result.txt"); // Запис у текстовий файл
            eqFio.writeResBin("Result.bin"); // Запис у двійковий файл
            System.out.println("Результати записано у файли Result.txt та Result.bin.");

            // --- Зчитування результатів із файлів ---
            eqFio.readResTxt("Result.txt"); // Читання з текстового файлу
            System.out.printf("Зчитано з текстового файлу: y = %.10f%n", eqFio.getResult());

            eqFio.readResBin("Result.bin"); // Читання з двійкового файлу
            System.out.printf("Зчитано з двійкового файлу: y = %.10f%n", eqFio.getResult());

        } catch (CalcException e) { // Обробка помилок при обчисленні
            System.err.println("Помилка обчислення: " + e.getMessage());
        } catch (IOException e) { // Обробка помилок роботи з файлами
            System.err.println("Помилка роботи з файлом: " + e.getMessage());
        } catch (Exception e) { // Обробка будь-яких інших помилок (наприклад, при введенні)
            System.err.println("Помилка введення: введіть дійсне число!");
        } finally {
            sc.close(); // Закриваємо Scanner після завершення роботи
            System.out.println("Програма завершила роботу.");
        }
    }
}

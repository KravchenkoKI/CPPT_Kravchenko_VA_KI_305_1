import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Лабораторна робота №1.
 * <p>
 * Клас Lab1KravchenkoKI305 генерує квадратну матрицю (зубчастий масив),
 * де верхня ліва та нижня права частини заповнені символом-заповнювачем.
 * Решта елементів матриці залишаються порожніми.
 * <p>
 * Масив виводиться на екран та зберігається у файл output.txt.
 * <p>
 * Приклад запуску:
 * <pre>
 * java Lab1KravchenkoKI305
 * </pre>
 * 
 * @author Kravchenko
 * @version 1.0
 */
public class Lab1KravchenkoKI305 {

    /**
     * Головний метод програми.
     * <p>
     * Програма виконує наступні дії:
     * <ol>
     * <li>Запитує розмір квадратної матриці у користувача.</li>
     * <li>Запитує символ-заповнювач.</li>
     * <li>Генерує зубчастий масив з верхньою лівою та нижньою правою заштрихованими областями.</li>
     * <li>Виводить масив на екран.</li>
     * <li>Записує масив у файл output.txt.</li>
     * </ol>
     * 
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитування розміру матриці
        System.out.print("Введіть розмір квадратної матриці: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // очищення буфера

        // Зчитування символа-заповнювача
        System.out.print("Введіть символ-заповнювач: ");
        String input = scanner.nextLine();

        if (input.length() != 1) {
            System.out.println("Помилка: потрібно ввести рівно один символ.");
            return;
        }

        char fillChar = input.charAt(0);

        // Генерація зубчастого масиву
        char[][] jaggedArray = generateJaggedArray(n, fillChar);

        // Вивід масиву на екран
        System.out.println("\nЗубчастий масив:");
        printArray(jaggedArray);

        // Запис масиву у файл output.txt
        try (FileWriter writer = new FileWriter("output.txt")) {
            for (char[] row : jaggedArray) {
                for (char c : row) {
                    writer.write(c + " ");
                }
                writer.write(System.lineSeparator());
            }
            System.out.println("\nМасив записано у файл output.txt");
        } catch (IOException e) {
            System.out.println("Помилка запису у файл: " + e.getMessage());
        }
    }

    /**
     * Генерує зубчастий масив для верхньої лівої та нижньої правої частини матриці.
     * <p>
     * Верхня ліва частина: рядки і стовпці з 0 до n/2-1.
     * Нижня права частина: рядки і стовпці з n/2 до n-1.
     * Інші місця залишаються порожніми.
     * 
     * @param n розмір квадратної матриці
     * @param fillChar символ-заповнювач
     * @return двовимірний масив символів розміром n x n
     */
    public static char[][] generateJaggedArray(int n, char fillChar) {
        char[][] array = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Заповнюємо верхню ліву та нижню праву частини символом-заповнювачем
                if ((i < n / 2 && j < n / 2) || (i >= n / 2 && j >= n / 2)) {
                    array[i][j] = fillChar;
                } else {
                    array[i][j] = ' '; // порожнє місце
                }
            }
        }

        return array;
    }

    /**
     * Виводить зубчастий масив на екран.
     * 
     * @param array двовимірний масив символів для виводу
     */
    public static void printArray(char[][] array) {
        for (char[] row : array) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}

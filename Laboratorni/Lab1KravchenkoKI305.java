import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Лабораторна робота №1.
 * 
 * Клас Lab1KravchenkoKI305 генерує квадратну матрицю (справжній зубчастий масив),
 * де верхня ліва та нижня права частини заповнені символом-заповнювачем.
 * Решта елементів не зберігаються у пам'яті, але при виводі замінюються пробілами.
 * 
 * Масив виводиться на екран та зберігається у файл output.txt.
 * 
 * @author Kravchenko
 * @version 2.0
 */
public class Lab1KravchenkoKI305 {

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
        printArray(jaggedArray, n);

        // Запис масиву у файл output.txt
        try (FileWriter writer = new FileWriter("output.txt")) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    char c;
                    if (i < n / 2 && j < n / 2) {
                        c = jaggedArray[i][j]; // верхня ліва
                    } else if (i >= n / 2 && j >= n / 2) {
                        c = jaggedArray[i][j - n / 2]; // нижня права
                    } else {
                        c = ' '; // порожнє місце
                    }
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
     * Генерує справжній зубчастий масив для верхньої лівої та нижньої правої частини.
     * 
     * @param n розмір квадратної матриці
     * @param fillChar символ-заповнювач
     * @return зубчастий масив
     */
    public static char[][] generateJaggedArray(int n, char fillChar) {
        char[][] array = new char[n][];

        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                // Верхня ліва частина
                array[i] = new char[n / 2];
            } else {
                // Нижня права частина
                array[i] = new char[n - n / 2];
            }

            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = fillChar;
            }
        }

        return array;
    }

    /**
     * Виводить зубчастий масив на екран у вигляді квадратної матриці.
     * 
     * @param array зубчастий масив
     * @param n розмір квадратної матриці
     */
    public static void printArray(char[][] array, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c;
                if (i < n / 2 && j < n / 2) {
                    c = array[i][j]; // верхня ліва
                } else if (i >= n / 2 && j >= n / 2) {
                    c = array[i][j - n / 2]; // нижня права
                } else {
                    c = ' '; // порожнє місце
                }
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}

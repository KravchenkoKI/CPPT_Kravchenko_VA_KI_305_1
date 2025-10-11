package KI305.Kravchenko.Lab5;

import KI305.Kravchenko.Lab4.Equations;
import KI305.Kravchenko.Lab4.CalcException;

import java.io.*;
import java.util.Scanner;

/**
 * Клас {@code EquationsFio} реалізує методи запису та читання результатів
 * роботи класу {@link Equations} у текстовому та двійковому форматах.
 * <p>
 * Дає можливість:
 * <ul>
 *     <li>Обчислювати значення функції y = sin(x)/tg(4x);</li>
 *     <li>Записувати результат у текстовий файл;</li>
 *     <li>Записувати результат у двійковий файл;</li>
 *     <li>Зчитувати результат із текстового файлу;</li>
 *     <li>Зчитувати результат із двійкового файлу.</li>
 * </ul>
 * </p>
 *
 * @author Kravchenko
 * @version 1.0
 */
public class EquationsFio {
    /** Змінна для збереження результату обчислення */
    private double result;

    /**
     * Метод для обчислення значення функції y = sin(x)/tg(4x)
     * <p>Використовує метод {@link Equations#calculate(double)}.</p>
     *
     * @param x аргумент функції
     * @throws CalcException якщо tg(4x) = 0 (тобто ділення на нуль)
     */
    public void calculate(double x) throws CalcException {
        Equations eq = new Equations();
        result = eq.calculate(x);
    }

    /**
     * Метод для отримання результату обчислення.
     *
     * @return результат функції y
     */
    public double getResult() {
        return result;
    }

    /**
     * Метод для запису результату у текстовий файл.
     * <p>Використовується клас {@link PrintWriter}.</p>
     *
     * @param fName назва текстового файлу
     * @throws IOException якщо виникла помилка під час запису
     */
    public void writeResTxt(String fName) throws IOException {
        PrintWriter writer = new PrintWriter(fName);
        writer.printf("%.10f%n", result);
        writer.close();
    }

    /**
     * Метод для зчитування результату з текстового файлу.
     * <p>Використовується клас {@link Scanner}.</p>
     *
     * @param fName назва текстового файлу
     * @throws FileNotFoundException якщо файл не знайдено
     */
    public void readResTxt(String fName) throws FileNotFoundException {
        File file = new File(fName);
        if (file.exists()) {
            Scanner sc = new Scanner(file);
            if (sc.hasNextDouble())
                result = sc.nextDouble();
            sc.close();
        } else {
            throw new FileNotFoundException("Файл " + fName + " не знайдено!");
        }
    }

    /**
     * Метод для запису результату у двійковий файл.
     * <p>Використовується клас {@link DataOutputStream}.</p>
     *
     * @param fName назва двійкового файлу
     * @throws IOException якщо виникла помилка запису
     */
    public void writeResBin(String fName) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(fName));
        out.writeDouble(result);
        out.close();
    }

    /**
     * Метод для зчитування результату з двійкового файлу.
     * <p>Використовується клас {@link DataInputStream}.</p>
     *
     * @param fName назва двійкового файлу
     * @throws IOException якщо виникла помилка читання
     */
    public void readResBin(String fName) throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream(fName));
        result = in.readDouble();
        in.close();
    }
}

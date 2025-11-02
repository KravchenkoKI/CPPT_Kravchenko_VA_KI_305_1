package KI305.Kravchenko.Lab5;                           // Пакет, у якому знаходиться клас

import KI305.Kravchenko.Lab4.Equations;                   // Імпортуємо клас для обчислень
import KI305.Kravchenko.Lab4.CalcException;               // Імпортуємо власний тип виключення
import java.io.*;                                         // Імпортуємо класи для роботи з файлами
import java.util.Scanner;                                 // Імпортуємо Scanner для читання текстових файлів

/**
 * Клас EquationsFio — відповідає за запис/читання результатів обчислень у файли.
 */
public class EquationsFio {
    private double result;                                // Поле для збереження результату обчислення

    /**
     * Метод обчислює y = sin(x) / tg(4x)
     */
    public void calculate(double x) throws CalcException { // Викликає метод calculate із класу Equations
        Equations eq = new Equations();                    // Створюємо об’єкт класу Equations
        result = eq.calculate(x);                          // Зберігаємо результат обчислення
    }

    /** Повертає результат */
    public double getResult() {
        return result;                                     // Просто повертає значення result
    }

    /**
     * Запис результату у текстовий файл
     */
    public void writeResTxt(String fName) throws IOException {
        // try-with-resources — відкриває потік і автоматично закриває його після завершення
        try (PrintWriter writer = new PrintWriter(fName)) { // Створюємо об’єкт для запису тексту у файл
            writer.printf("%.10f%n", result);               // Записуємо результат із 10 знаками після коми
        } // Потік автоматично закриється тут
    }

    /**
     * Зчитування результату з текстового файлу
     */
    public void readResTxt(String fName) throws IOException {
        File file = new File(fName);                       // Створюємо об’єкт File для перевірки існування
        if (!file.exists()) {                              // Якщо файл не знайдено —
            throw new FileNotFoundException(               // — кидаємо виняток із поясненням
                    "Файл " + fName + " не знайдено!");
        }

        // try-with-resources: Scanner закриється автоматично після завершення блоку
        try (Scanner sc = new Scanner(file)) {
            if (sc.hasNextDouble()) {                      // Якщо у файлі є число —
                result = sc.nextDouble();                  // — зчитуємо його у result
            } else {                                       // Якщо у файлі нема числа —
                throw new IOException(                     // — кидаємо виняток
                        "Файл не містить числового значення результату.");
            }
        } // Потік Scanner автоматично закриється тут
    }

    /**
     * Запис результату у двійковий файл
     */
    public void writeResBin(String fName) throws IOException {
        // try-with-resources: відкриває двійковий потік і сам його закриває
        try (DataOutputStream out = new DataOutputStream(  // Створюємо двійковий потік для запису
                new BufferedOutputStream(                  // Обгортка з буфером — пришвидшує запис
                        new FileOutputStream(fName)))) {   // Створює/перезаписує файл

            out.writeDouble(result);                       // Записуємо значення типу double (8 байт)
            out.flush();                                   // Примусово записуємо буфер у файл
        } // Потік автоматично закриється після завершення блоку
    }

    /**
     * Зчитування результату з двійкового файлу
     */
    public void readResBin(String fName) throws IOException {
        // try-with-resources: відкриває двійковий потік і сам його закриває
        try (DataInputStream in = new DataInputStream(     // Створюємо потік для читання double
                new BufferedInputStream(                   // Буфер — пришвидшує зчитування
                        new FileInputStream(fName)))) {    // Відкриваємо файл на читання

            result = in.readDouble();                      // Зчитуємо число типу double із файлу
        } // Потік автоматично закриється після завершення блоку
    }
}

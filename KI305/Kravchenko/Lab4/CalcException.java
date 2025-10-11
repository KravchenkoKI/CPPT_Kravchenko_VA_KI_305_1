package KI305.Kravchenko.Lab4;

/**
 * Клас {@code CalcException} реалізує власний тип виключення
 * для обробки помилок під час математичних обчислень.
 */
public class CalcException extends Exception {
    /**
     * Конструктор, який приймає повідомлення про помилку.
     *
     * @param message текст повідомлення про помилку
     */
    public CalcException(String message) {
        super(message);
    }
}

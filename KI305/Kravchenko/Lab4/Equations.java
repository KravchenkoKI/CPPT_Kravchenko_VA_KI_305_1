package KI305.Kravchenko.Lab4;

/**
 * Клас {@code Equations} виконує обчислення математичного виразу:
 * <p>y = sin(x) / tg(4x)</p>
 */
public class Equations {

    /**
     * Метод для обчислення виразу y = sin(x) / tg(4x).
     *
     * @param x аргумент функції (у радіанах)
     * @return результат обчислення
     * @throws CalcException якщо tg(4x) = 0 (тобто ділення на нуль)
     */
    public double calculate(double x) throws CalcException {
        double denominator = Math.tan(4 * x); // Обчислення tg(4x)

        // Перевірка на ділення на нуль
        if (Math.abs(denominator) < 1e-10) {
            throw new CalcException("Помилка: ділення на нуль (tg(4x) = 0)");
        }

        return Math.sin(x) / denominator; // Повертаємо результат sin(x)/tg(4x)
    }
}

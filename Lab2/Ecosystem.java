package KI305.Kravchenko.lab2;

/**
 * Клас {@code Ecosystem} представляє екосистему водойми, яка складається
 * з кількості рослин та тварин. Цей клас дозволяє змінювати кількість
 * рослин і тварин, що живуть у водоймі.
 */
public class Ecosystem {
    private int plantCount;  // Кількість рослин в екосистемі
    private int animalCount; // Кількість тварин в екосистемі

    /**
     * Конструктор за замовчуванням, створює екосистему з нульовою кількістю
     * рослин та тварин.
     */
    public Ecosystem() {
        this.plantCount = 0;  // Ініціалізація рослин нулем
        this.animalCount = 0; // Ініціалізація тварин нулем
    }

    /**
     * Конструктор, що створює екосистему з певною кількістю рослин та тварин.
     *
     * @param plantCount  кількість рослин в екосистемі
     * @param animalCount кількість тварин в екосистемі
     */
    public Ecosystem(int plantCount, int animalCount) {
        this.plantCount = plantCount;   // Встановлення кількості рослин
        this.animalCount = animalCount; // Встановлення кількості тварин
    }

    /**
     * Встановлює кількість рослин в екосистемі.
     *
     * @param plantCount нова кількість рослин
     */
    public void setPlantCount(int plantCount) {
        this.plantCount = plantCount; // Оновлення кількості рослин
    }

    /**
     * Встановлює кількість тварин в екосистемі.
     *
     * @param animalCount нова кількість тварин
     */
    public void setAnimalCount(int animalCount) {
        this.animalCount = animalCount; // Оновлення кількості тварин
    }
}

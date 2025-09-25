package KI305.Kravchenko.lab2;

/**
 * Клас {@code Ecosystem} представляє екосистему водойми, яка складається
 * з кількості рослин та тварин. Цей клас дозволяє змінювати кількість
 * рослин і тварин, що живуть у водоймі.
 */
public class Ecosystem {
    private int plantCount;
    private int animalCount;

    /**
     * Конструктор за замовчуванням, створює екосистему з нульовою кількістю
     * рослин та тварин.
     */
    public Ecosystem() {
        this.plantCount = 0;
        this.animalCount = 0;
    }

    /**
     * Конструктор, що створює екосистему з певною кількістю рослин та тварин.
     *
     * @param plantCount  кількість рослин в екосистемі
     * @param animalCount кількість тварин в екосистемі
     */
    public Ecosystem(int plantCount, int animalCount) {
        this.plantCount = plantCount;
        this.animalCount = animalCount;
    }

    /**
     * Встановлює кількість рослин в екосистемі.
     *
     * @param plantCount нова кількість рослин
     */
    public void setPlantCount(int plantCount) {
        this.plantCount = plantCount;
    }

    /**
     * Встановлює кількість тварин в екосистемі.
     *
     * @param animalCount нова кількість тварин
     */
    public void setAnimalCount(int animalCount) {
        this.animalCount = animalCount;
    }
}

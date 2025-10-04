package Lab3.KI305.Kravchenko.Lab3;

/**
 * Клас {@code Fish} представляє рибу, що живе у водоймі.
 * Має єдину характеристику — ім'я риби.
 */
public class Fish {
    private String name; // Ім'я риби

    /**
     * Конструктор створює новий об'єкт риби з заданим іменем.
     *
     * @param name назва риби
     */
    public Fish(String name) {
        this.name = name; // Ініціалізація імені риби
    }

    /**
     * Повертає назву риби.
     *
     * @return назва риби
     */
    public String getName() {
        return name; // Повертає ім'я риби
    }
}

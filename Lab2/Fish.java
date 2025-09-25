package KI305.Kravchenko.lab2;

/**
 * Клас {@code Fish} представляє рибу, що живе у водоймі.
 * Має єдину характеристику — ім'я риби.
 */
public class Fish {
    private String name;

    /**
     * Конструктор створює новий об'єкт риби з заданим іменем.
     *
     * @param name назва риби
     */
    public Fish(String name) {
        this.name = name;
    }

    /**
     * Повертає назву риби.
     *
     * @return назва риби
     */
    public String getName() {
        return name;
    }
}

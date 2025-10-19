package KI305.Kravchenko.lab6;

/**
 * Клас, що представляє контейнер.
 * Реалізує інтерфейс Comparable для порівняння контейнерів за об'ємом.
 * @version 1.0
 */
class Container implements Comparable<Container> {
    private double volume;
    private String type;

    /**
     * Конструктор класу Container.
     * @param volume об'єм контейнера
     * @param type тип контейнера
     */
    public Container(double volume, String type) {
        this.volume = volume;
        this.type = type;
    }

    /**
     * Повертає об'єм контейнера.
     * @return об'єм контейнера
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Повертає тип контейнера.
     * @return тип контейнера
     */
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Container{volume=" + volume + ", type='" + type + "'}";
    }

    @Override
    public int compareTo(Container other) {
        return Double.compare(this.volume, other.volume);
    }
}


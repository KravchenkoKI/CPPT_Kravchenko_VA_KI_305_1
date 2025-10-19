package KI305.Kravchenko.lab6;

/**
 * Клас, що представляє коробку з вантажем.
 * Реалізує інтерфейс Comparable для порівняння коробок за вагою.
 * @version 1.0
 */
class Box implements Comparable<Box> {
    private double weight;
    private String content;

    /**
     * Конструктор класу Box.
     * @param weight вага коробки
     * @param content вміст коробки
     */
    public Box(double weight, String content) {
        this.weight = weight;
        this.content = content;
    }

    /**
     * Повертає вагу коробки.
     * @return вага коробки
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Повертає вміст коробки.
     * @return вміст коробки
     */
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Box{weight=" + weight + ", content='" + content + "'}";
    }

    @Override
    public int compareTo(Box other) {
        return Double.compare(this.weight, other.weight);
    }
}

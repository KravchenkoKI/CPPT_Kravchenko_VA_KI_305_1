package KI305.Kravchenko.lab6;

/**
 * Клас-драйвер для демонстрації роботи класу Truck.
 * Створює приклади вантажівок для перевезення коробок та контейнерів,
 * додає вантажі, знаходить найлегші коробки та контейнери з найменшим об'ємом.
 */
public class TruckDriver {
    public static void main(String[] args) {
        // Створюємо екземпляр вантажівки для перевезення коробок
        Truck<Box> boxTruck = new Truck<>(5000, "Volvo FH");

        // Додаємо коробки
        boxTruck.addCargo(new Box(100, "Electronics"));
        boxTruck.addCargo(new Box(50, "Clothes"));
        boxTruck.addCargo(new Box(200, "Books"));

        // Знаходимо найлегшу коробку
        Box minBox = boxTruck.findMinElement(Box::compareTo);
        System.out.println("Найлегша коробка: " + minBox);

        // Створюємо екземпляр вантажівки для перевезення контейнерів
        Truck<Container> containerTruck = new Truck<>(10000, "MAN TGX");

        // Додаємо контейнери
        containerTruck.addCargo(new Container(1000, "Refrigerated"));
        containerTruck.addCargo(new Container(500, "Standard"));
        containerTruck.addCargo(new Container(750, "Hazardous"));

        // Знаходимо контейнер з найменшим об'ємом
        Container minContainer = containerTruck.findMinElement(Container::compareTo);
        System.out.println("Контейнер з найменшим об'ємом: " + minContainer);
    }
}


package KI305.Kravchenko.lab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Параметризований клас, що представляє грузову машину як контейнер для вантажу
 * @param <T> тип вантажу, що перевозиться
 */
public class Truck<T extends Comparable<T>> {
    private List<T> cargo;
    private double maxWeight;
    private String model;

    /**
     * Конструктор класу Truck
     * @param maxWeight максимальна вантажопідйомність
     * @param model модель машини
     */
    public Truck(double maxWeight, String model) {
        this.cargo = new ArrayList<>();
        this.maxWeight = maxWeight;
        this.model = model;
    }

    /**
     * Додає вантаж до машини
     * @param item елемент вантажу
     */
    public void addCargo(T item) {
        cargo.add(item);
    }

    /**
     * Видаляє вантаж з машини
     * @param item елемент вантажу для видалення
     * @return true якщо елемент було видалено, false якщо елемент не знайдено
     */
    public boolean removeCargo(T item) {
        return cargo.remove(item);
    }

    /**
     * Знаходить мінімальний елемент у вантажі за заданим компаратором
     * @param comparator компаратор для порівняння елементів
     * @return мінімальний елемент або null якщо вантаж порожній
     */
    public T findMinElement(Comparator<T> comparator) {
        if (cargo.isEmpty()) {
            return null;
        }
        return Collections.min(cargo, comparator);
    }

    /**
     * Очищає весь вантаж з машини
     */
    public void clearCargo() {
        cargo.clear();
    }

    /**
     * Повертає список всього вантажу
     * @return список вантажу
     */
    public List<T> getAllCargo() {
        return new ArrayList<>(cargo);
    }

    /**
     * Повертає модель машини
     * @return модель машини
     */
    public String getModel() {
        return model;
    }
}


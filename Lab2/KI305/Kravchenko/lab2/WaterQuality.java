package KI305.Kravchenko.lab2;

/**
 * Клас {@code WaterQuality} представляє якість води у водоймі.
 * Включає рівень pH та рівень кисню.
 */
public class WaterQuality {
    private double ph;           // Рівень pH води
    private double oxygenLevel;  // Рівень кисню у воді (мг/л)

    /**
     * Конструктор за замовчуванням створює об'єкт з типовими значеннями якості води:
     * pH = 6.5 та рівень кисню = 6.5.
     */
    public WaterQuality() {
        this.ph = 6.5;            // Встановлення стандартного pH
        this.oxygenLevel = 6.5;   // Встановлення стандартного рівня кисню
    }

    /**
     * Конструктор створює об'єкт з заданими рівнями pH та кисню.
     *
     * @param ph          рівень pH води
     * @param oxygenLevel рівень кисню у воді
     */
    public WaterQuality(double ph, double oxygenLevel) {
        this.ph = ph;              // Ініціалізація pH
        this.oxygenLevel = oxygenLevel; // Ініціалізація рівня кисню
    }

    /**
     * Встановлює нове значення pH води.
     *
     * @param ph новий рівень pH
     */
    public void setPh(double ph) {
        this.ph = ph;              // Оновлення значення pH
    }

    /**
     * Встановлює нове значення рівня кисню у воді.
     *
     * @param oxygenLevel новий рівень кисню
     */
    public void setOxygenLevel(double oxygenLevel) {
        this.oxygenLevel = oxygenLevel; // Оновлення рівня кисню
    }

    /**
     * Повертає поточне значення рівня pH води.
     *
     * @return рівень pH води
     */
    public double getPh() {
        return ph;                 // Повернення поточного pH
    }

    /**
     * Повертає поточний рівень кисню у воді.
     *
     * @return рівень кисню у воді
     */
    public double getOxygenLevel() {
        return oxygenLevel;        // Повернення поточного рівня кисню
    }
}

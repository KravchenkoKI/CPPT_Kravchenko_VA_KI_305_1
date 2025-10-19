package Lab3.KI305.Kravchenko.lab3;

/**
 * Інтерфейс {@code Navigable} представляє можливість для водойми
 * підтримувати навігацію (наприклад, судноплавство).
 */
public interface Navigable {
    /**
     * Перевіряє, чи водойма придатна для судноплавства.
     *
     * @return true, якщо водойма придатна
     */
    boolean isNavigable();
}

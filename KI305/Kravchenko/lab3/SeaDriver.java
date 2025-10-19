package Lab3.KI305.Kravchenko.lab3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Клас {@code SeaDriver} є точкою входу в програму.
 * Демонструє роботу з класом {@link Sea}.
 */
public class SeaDriver {
    public static void main(String[] args) {
        try {
            List<Fish> fishes = new ArrayList<>(Arrays.asList(
                    new Fish("Тунець"), 
                    new Fish("Скумбрія")
            ));

            Sea sea = new Sea(fishes, new Ecosystem(100, 20), 
                              new WaterQuality(8.0, 7.5),
                              "Чорне море", 500, 30, 3.8);

            sea.addFish(new Fish("Дорадо"));
            System.out.println(sea.getInfo());
            sea.clean();
            System.out.println("Придатне для судноплавства: " + sea.isNavigable());

            sea.closeLogger();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package zadanie2;

import java.util.Random;

public class operations {
    public static void randomInt(int[] tab) {
        Random randomize = new Random();
        for (int i=0; i < tab.length; i++) {
            tab[i] = randomize.nextInt(1000);
        }
    }
}

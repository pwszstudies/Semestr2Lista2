package zadanie2;

import java.util.Random;

class operations {
    static void randomInt(int[] tab) {
        Random randomize = new Random();
        for (int i=0; i < tab.length; i++) {
            tab[i] = randomize.nextInt(1000);
        }
    }
}

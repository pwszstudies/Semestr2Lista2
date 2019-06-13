package s2l2;

import java.util.Arrays;
import java.util.Random;

public class Dodawanie {
    public static void main(String[] args) throws InterruptedException{
        int[] intTabA = new int[100];
        int[] intTabB = new int[100];
        randomInt(intTabA);
        randomInt(intTabB);

        SummingThread first = new SummingThread("first", intTabA, intTabB);
        SummingThread second = new SummingThread("second", intTabA, intTabB);

        long startTime = System.currentTimeMillis();
        first.start();
        second.start();
        first.join();
        second.join();
        long endTime = System.currentTimeMillis();
        long operationTime = (endTime - startTime);
        System.out.println("Time: " + operationTime + "ms");

    }

    static class SummingThread extends Thread {
        private int[] tabA;
        private int[] tabB;
        private int[] tabC = new int[100];

        public SummingThread(String name, int[] tabA, int[] tabB) {
            super(name);
            this.tabA = tabA;
            this.tabB = tabB;
        }

        @Override
        public void run() {
            System.out.println(String.format("Starting thread: %s", currentThread().getName()));
            for (int i = 0; i < tabC.length; i++) {
                tabC[i] = tabA[i] + tabB[i];
            }
            System.out.println((String.format("Sum of tabA and tabB equals %s", Arrays.toString(tabC))));
        }
    }



    private static void randomInt(int[] tab) {
        Random randomize = new Random();
        for (int i=0; i < tab.length; i++) tab[i] = randomize.nextInt(100000);
    }



}

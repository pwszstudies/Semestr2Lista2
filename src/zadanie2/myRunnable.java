package zadanie2;

import java.sql.SQLOutput;

public class myRunnable {

    public static class MyRunnable1 implements Runnable {
        private int[] tabA;
        private int[] tabB;
        private int[] tabC;

        public MyRunnable1(int[] tabA, int[] tabB, int[] tabC) {
            this.tabA = tabA;
            this.tabB = tabB;
            this.tabC = tabC;
        }

        @Override
        public void run() {
            System.out.println(String.format("Thread %s started", Thread.currentThread().getName()));
            for (int i=0; i < (tabA.length/2); i++) {
                tabC[i] = tabA[i] + tabB[i];
            }
            System.out.println(String.format("Thread %s finished", Thread.currentThread().getName()));
        }
    }

    public static class MyRunnable2 implements Runnable {
        private int[] tabA;
        private int[] tabB;
        private int[] tabC;

        public MyRunnable2(int[] tabA, int[] tabB, int[] tabC) {
            this.tabA = tabA;
            this.tabB = tabB;
            this.tabC = tabC;
        }

        @Override
        public void run() {
            System.out.println(String.format("Thread %s started", Thread.currentThread().getName()));
            for (int i=(tabA.length/2 + 1); i < (tabA.length); i++) {
                tabC[i] = tabA[i] + tabB[i];
            }
            System.out.println(String.format("Thread %s finished", Thread.currentThread().getName()));
        }
    }
    public static class MyRunnable implements Runnable {
        private int[] tabA;
        private int[] tabB;
        private int[] tabC;

        public MyRunnable(int[] tabA, int[] tabB, int[] tabC) {
            this.tabA = tabA;
            this.tabB = tabB;
            this.tabC = tabC;
        }

        @Override
        public void run() {
            System.out.println(String.format("Thread %s started", Thread.currentThread().getName()));
            for (int i=0; i < (tabA.length); i++) {
                tabC[i] = tabA[i] + tabB[i];
            }
            System.out.println(String.format("Thread %s finished", Thread.currentThread().getName()));
        }
    }
}

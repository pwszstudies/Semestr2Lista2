package zadanie2;

import static zadanie2.operations.*;
import zadanie2.myRunnable.*;
public class main {
    public static void main(String[] args) throws InterruptedException {
        int amount = 1000000;
        int[] intTabA = new int[amount];
        int[] intTabB = new int[amount];
        int[] intTabC = new int[amount];
        int[] intTabD = new int[amount];
        randomInt(intTabA);
        randomInt(intTabB);

        Thread first = new Thread(new MyRunnable1(intTabA, intTabB, intTabD), "first");
        Thread second = new Thread(new MyRunnable2(intTabA, intTabB, intTabD), "second");
        Thread single = new Thread(new MyRunnable(intTabA, intTabB, intTabC), "single");

        long startTime = System.currentTimeMillis();
        single.start();
        single.join();
        System.out.println(String.format("It took single thread %sms to finish", (System.currentTimeMillis()-startTime)));

        startTime = System.currentTimeMillis();
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println(String.format("It took multithread %sms to finish", (System.currentTimeMillis()-startTime)));


    }



}


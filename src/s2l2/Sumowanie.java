package s2l2;

import java.util.Arrays;
import java.util.Random;

public class Sumowanie {
    public static void main(String[] args) {

        int[] numberTab = generateTable(50000);

        final long  startTime1 = System.currentTimeMillis();
        final int sum1 = Arrays.stream(numberTab).sum();
        final long  endTime1 = System.currentTimeMillis();
        System.out.println(String.format("Sum = %s, calculated within %sms with single thread.", sum1, endTime1 - startTime1));

        final long  startTime2 = System.currentTimeMillis();
        final int sum2 = Arrays.stream(numberTab).parallel().sum();
        final long  endTime2 = System.currentTimeMillis();
        System.out.println(String.format("Sum = %s, calculated within %sms with multiple threads.", sum2, endTime2 - startTime2));

    }

    private static int randomizeNumber() {
        Random randomizeNum = new Random();
        return randomizeNum.nextInt(100);
    }

    private static int[] generateTable (int size) {
        int[] numTab = new int[size];
        for (int i = 0; i < size; i++) {
            numTab[i] = randomizeNumber();
        }
        return numTab;
    }

}

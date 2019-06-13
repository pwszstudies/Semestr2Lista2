package s2l2;

public class Odliczanie {
    public static void main(String[] args) throws InterruptedException {
        MyThread first = new MyThread ("first");
        MyThread second = new MyThread ("second");
        MyThread third = new MyThread ("third");
        MyThread fourth = new MyThread ("fourth");
        MyThread fifth = new MyThread ("fifth");
//        Thread second = new Thread (new MyRunnable(), "second");
//        Thread third = new Thread ( new MyRunnable(),"third");
//        Thread fourth = new Thread ( new MyRunnable(),"fourth");
//        Thread fifth = new Thread ( new MyRunnable(),"fifth");

        long startTime = System.currentTimeMillis();
        first.start();
        second.start();
        third.start();
        fourth.start();
        fifth.start();
        first.join();
        second.join();
        third.join();
        fourth.join();
        fifth.join();
        long endTime = System.currentTimeMillis();
        long operationTime = endTime - startTime;
        System.out.println("These operations took: " + operationTime + " miliseconds!");
    }

    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }


        @Override
        public void run() {
            System.out.println("Starting thread " + currentThread().getName() );
            for (int i = 1; i <= 100; i++) {
                System.out.println(String.format("Thread name: %s, count: %s", currentThread().getName(), i));
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                System.out.println(String.format("Runnable: %s, iteration: %s", Thread.currentThread().getName(), i));
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

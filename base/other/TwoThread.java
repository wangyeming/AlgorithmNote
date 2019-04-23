package other;

/**
 * 两个线程轮流打印1-100
 */
public class TwoThread {

    private static int num = 1;

    private static final Object lock = new Object();

    public static void main(String[] argv) {
        CustomRunnable runnable = new CustomRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }

    private static class CustomRunnable implements Runnable {

        @Override
        public void run() {
            while (num <= 100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " " + num);
                    num++;
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

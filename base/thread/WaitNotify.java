package thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {

    public static void main(String[] argv) {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        sleepSecond(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    private static boolean flag = true;

    private static final Object lock = new Object();

    private static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(getFormatDate() + " " +
                                Thread.currentThread() + "flag is true wait");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(getFormatDate() + " " +
                        Thread.currentThread() + "flag is false wait");
            }
        }
    }

    private static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(getFormatDate() + " " +
                        Thread.currentThread() + " hold lock");
                lock.notifyAll();
                flag = false;
                sleepSecond(5);
            }
            synchronized (lock) {
                System.out.println(getFormatDate() + " " +
                        Thread.currentThread() + " hold lock again");
                sleepSecond(5);
            }
        }
    }

    private static String getFormatDate() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    private static void sleepSecond(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

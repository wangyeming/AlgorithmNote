package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerCustomerModel1 {
    private static Integer count = 0;
    //创建一个阻塞队列
    static final BlockingQueue blockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        new Thread(new Producer(), "生产者1").start();
        new Thread(new Consumer(), "消费者1").start();
        new Thread(new Producer(), "生产者2").start();
        new Thread(new Consumer(), "消费者2").start();
        new Thread(new Producer(), "生产者3").start();
        new Thread(new Consumer(), "消费者3").start();
        new Thread(new Producer(), "生产者4").start();
        new Thread(new Consumer(), "消费者4").start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    blockingQueue.put(1);
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + " 生产，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    blockingQueue.take();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "  消费，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package other;

import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {

    private static final int MAX_CONSUME_COUNT = 50;
    private static final int MAX_PRODUCE_COUNT = 50;
    private int consumeCount = 0;
    private int produceCount = 0;

    private static final int SIZE = 20;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(SIZE);

    public static void main(String[] argv) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Producer producer = producerConsumer.new Producer();
        Consumer consumer = producerConsumer.new Consumer();
        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {

        @Override
        public void run() {
            while (true) {
                if(consumeCount >= MAX_CONSUME_COUNT) {
                    return;
                }
                try {
                    queue.take();
                    consumeCount++;
                    System.out.println("队列剩余 " + queue.size() + "个元素");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                if(produceCount >= MAX_PRODUCE_COUNT) {
                    return;
                }
                try {
                    queue.put(1);
                    produceCount++;
                    System.out.println("队列剩余空间：" + (SIZE - queue.size()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

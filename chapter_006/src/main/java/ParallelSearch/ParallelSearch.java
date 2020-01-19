package ParallelSearch;

import NotifyQueue.SimpleBlockingQueue;

public class ParallelSearch {
    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();
        final Thread consumer = new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        try {
                            System.out.println(queue.poll());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                   // Thread.currentThread().interrupt();
                }
        );
        consumer.start();
        final Thread producer;
        producer = new Thread(
                () -> {
                    for (int index = 0; index != 3; index++) {
                        System.out.println("from producer" + index);
                        queue.offer(index);
                    }
                    while (queue.getsize() > 0) {
                    }
                    consumer.interrupt();
                }
        );
        producer.start();
    }
}

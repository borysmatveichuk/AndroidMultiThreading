import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerProducerBQ {
    private final int LIMIT = 10000;
    private BlockingQueue<Integer> blockingQueue =
            new LinkedBlockingQueue<Integer>(LIMIT);

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            blockingQueue.put(value++);
            System.out.println("+ produce " + blockingQueue.peek() + " size is " + blockingQueue.size());
        }
    }
    public void consume() throws InterruptedException {
        while (true) {
            int value = blockingQueue.take();
            System.out.println("- consume " + value + " size is " + blockingQueue.size());
        }
    }
}

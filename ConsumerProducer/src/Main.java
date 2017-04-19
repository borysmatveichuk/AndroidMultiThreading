
public class Main {

    public static void main(String[] args) {
        final ConsumerProducer cp = new ConsumerProducer();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cp.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cp.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

    }
}

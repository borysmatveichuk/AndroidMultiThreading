import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        RaceCondition rc = new RaceCondition();
        for (int i = 0; i < 10; i++) {
            rc.startThreads();
        }
    }

    public static class RaceCondition {

        int sharedResource = 0;
        private boolean onOff = true;

        private ReentrantLock mLock = new ReentrantLock();

        public void startThreads() {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    changeState("t1");
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    changeState("t2");
                }
            });

            Thread t3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    changeState("t3");
                }
            });

            Thread t4 = new Thread(new Runnable() {
                @Override
                public void run() {
                    changeState("t4");
                }
            });

            Thread t5 = new Thread(new Runnable() {
                @Override
                public void run() {
                    changeState("t5");
                }
            });

            Thread t6 = new Thread(new Runnable() {
                @Override
                public void run() {
                    changeState("t6");
                }
            });

            Thread t7 = new Thread(new Runnable() {
                @Override
                public void run() {
                    changeState("t7");
                }
            });

            Thread t8 = new Thread(new Runnable() {
                @Override
                public void run() {
                    changeState("t8");
                }
            });

            Thread t9 = new Thread(new Runnable() {
                @Override
                public void run() {
                    changeState("t9");
                }
            });

            Thread t10 = new Thread(new Runnable() {
                @Override
                public void run() {
                    changeState("t10");
                }
            });

            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            t6.start();
            t7.start();
            t8.start();
            t9.start();
            t10.start();
        }

        private void changeState(String threadName) {
            mLock.lock();

            try {
                if (onOff)
                    sharedResource++;
                else
                    sharedResource--;
                onOff = !onOff;

                System.out.println("resource is " + sharedResource + " thread is " + threadName);
            } finally {
                mLock.unlock();
            }

        }

    }
}

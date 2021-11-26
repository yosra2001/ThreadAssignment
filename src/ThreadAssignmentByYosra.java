public class ThreadAssignment {

    static class Counter {
        void count() {
            //todo implement me
            for (int i = 350; i >0 ; i--) {
                System.out.println(i);
            }
        }
    }

    static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {

                synchronized (counter){
                    counter.count();
                    System.out.println("FINISH !!! ");
                }
            }

        }



    public static void main(String[] args) {
        Counter counter = new Counter();

        MyThread T1 = new MyThread(counter);
        MyThread T2 =new MyThread(counter);
        T1.start();
        T2.start();
        try {
            T1.join();
            T2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done!!!!! ");
    }


}

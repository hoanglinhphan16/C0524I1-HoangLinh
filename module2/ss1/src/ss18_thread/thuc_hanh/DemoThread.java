package ss18_thread.thuc_hanh;

public class DemoThread {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        Thread t1 = new Thread(myThread1);
        Thread t2 = new Thread() {
            public void run() {
                myThread2.run();
            }
        };

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("123123");
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}

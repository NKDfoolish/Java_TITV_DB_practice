public class Bai_11 {
    public static void main(String[] args) {

        System.out.println("Hello 2023!!!");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               for (int i = 0; i < 100; i++){
                   System.out.println("Thread 1: " + i);
               }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    System.out.println("Thread 2: " + i);
                }
            }
        });
        t2.start();

        // cach 2
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    System.out.println("Thread 3: " + i);
                }
            }
        }).start();

        // cach 3
        new Thread(() -> {
            for (int i = 0; i < 100; i++){
                System.out.println("Thread 4: " + i);
            }
        }).start();

        // cach 4
        Test_thread_11 test = new Test_thread_11();
        test.start();

        // cach 5
        Test_thread_11_2 test2 = new Test_thread_11_2();
        new Thread(test2).start();

        System.out.println("GoodBye 2022!!!");
    }
}

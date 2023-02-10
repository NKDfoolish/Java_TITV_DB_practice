public class Test_thread_11_2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread_End: " + i);
        }
    }
}

public class Test_thread_11 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println("Test_thread_11: " + i);
        }
    }
}

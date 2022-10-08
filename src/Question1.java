class RunnableClass implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runnable: "+i);
        }
    }
}
public class Question1 extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Class Thread: "+i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Question1 object = new Question1();
        RunnableClass runnableClass = new RunnableClass();
        Thread thread2 = new Thread(runnableClass);
        thread2.setName("Runnable Thread");
        object.setName("Class Thread");
        object.start();
        object.join();
        thread2.start();
        thread2.join();
    }


}
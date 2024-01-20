import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {

    private final int id;
    private Semaphore leftFork;
    private Semaphore rightFork;
    public Philosopher(int id,Semaphore leftFork,Semaphore rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void think() throws InterruptedException {
        System.out.println("Philosopher:"+id+"is thinking");
        Thread.sleep((long) Math.random()*1000);
    }
    public void eat() throws InterruptedException {
        System.out.println("Philosopher:"+id+"is eating");
        Thread.sleep((long) Math.random()*1000);
    }

    public void run(){

        while(true){


            try {
                think();
                leftFork.acquire();
                System.out.println("Philosopher " + id + " picks up left fork.");
                rightFork.acquire();
                System.out.println("Philosopher " + id + " picks up right fork.");
                eat();


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            leftFork.release();
            rightFork.release();


        }


    }

}

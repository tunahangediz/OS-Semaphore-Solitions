import java.util.concurrent.Semaphore;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int felsefeciSayısı = 5;
        Semaphore[] forks = new Semaphore[felsefeciSayısı];
        //felsefeci sayısı kadar semaphore oluşturduk
        //şimdi o semaphorelara bir değer atayalım

        for(Semaphore fork :forks){
            fork = new Semaphore(1);
        }

        Philosopher[] philosophers = new Philosopher[felsefeciSayısı];
        for (int i = 0; i <felsefeciSayısı ; i++){
            philosophers[i] = new Philosopher(i,forks[i],forks[(i+1)%felsefeciSayısı]);


        }
        for (int i = 0; i < felsefeciSayısı; i++) {
            philosophers[i].start();
        }


    }
}
import java.util.concurrent.Semaphore;

public class BarberShop {
    Semaphore mutex;
    Semaphore customer;
    Semaphore barber;
    Semaphore customerDone;
    Semaphore barberDone;
    int customersCount = 0;

    int SHOP_SIZE;

    public BarberShop(int SHOP_SIZE) {
        this.mutex =  new Semaphore(1);
        this.customer =new Semaphore(0) ;
        this.barber = new Semaphore(0);
        this.customerDone = new Semaphore(0);
        this.barberDone = new Semaphore(0);
        this.SHOP_SIZE = SHOP_SIZE;
    }

    public void balk(){
        System.out.println("balkkking");
    }

    public void customerEnter() throws InterruptedException {
        mutex.acquire();
        if(customersCount == SHOP_SIZE){
            mutex.release();
            balk();
        }
        else{
            customersCount++;
            mutex.release();

        }
    }

    public void customerOut() throws InterruptedException {
        mutex.acquire();
        customersCount--;
        mutex.release();
        System.out.println("gettting outttt");
    }







}

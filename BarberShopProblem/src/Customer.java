import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.Semaphore;

public class Customer extends Thread {

    BarberShop barberShop;
    public Customer(BarberShop barberShop){
        this.barberShop = barberShop;
    }

    private void getHairCut() throws InterruptedException {
        System.out.println("A Customer Getting hair cut");


    }
    public  void run(){
        try {
            barberShop.customerEnter();
            barberShop.customer.release();
            barberShop.barber.acquire();
            getHairCut();
            barberShop.customerDone.release();
            barberShop.barberDone.acquire();
            barberShop.customerOut();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

public class Barber extends Thread {
    BarberShop barberShop;
    public Barber(BarberShop barberShop){
        this.barberShop = barberShop;
    }


    private void cutHair(){
        System.out.println("Barber Cutting hair");
    }

    public void run(){
        while (true){
            try {
                barberShop.customer.acquire();
                barberShop.barber.release();
                cutHair();
                barberShop.customerDone.acquire();
                barberShop.barberDone.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

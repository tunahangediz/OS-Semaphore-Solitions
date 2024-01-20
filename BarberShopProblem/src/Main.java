// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        BarberShop barberShop = new BarberShop(4);

        Customer[] customers = new Customer[4];
        for(Customer customer:customers){
            customer = new Customer(barberShop);
            customer.start();
        }

        Barber barber = new Barber(barberShop);

        barber.start();



    }
}
package co.com.design_patterns.creational.factorymethod;

public class GooglePayment implements  Payment{
    @Override
    public void doPayment() {
        //Lógica del pago
        System.out.println("Pagando con GooglePayment");
    }
}

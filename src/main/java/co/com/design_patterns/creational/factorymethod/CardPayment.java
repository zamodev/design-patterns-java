package co.com.design_patterns.creational.factorymethod;

public class CardPayment implements Payment{
    @Override
    public void doPayment() {
        //Lógica del pago
        System.out.println("Pagando con tarjeta de crédito");
    }
}

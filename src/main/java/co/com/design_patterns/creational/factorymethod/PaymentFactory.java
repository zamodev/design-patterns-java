package co.com.design_patterns.creational.factorymethod;

public class PaymentFactory {
    public static Payment buildPayment(TypePayment typePayment) {
        switch (typePayment) {
            case CARD:
                return new CardPayment();
            case GOOGLEPAY:
                return new GooglePayment();
            default:
                throw new IllegalArgumentException("Invalid payment type");
        }
    }
}

package co.com.design_patterns;

import co.com.design_patterns.creational.abstracfactory.AbstractFactory;
import co.com.design_patterns.creational.abstracfactory.abstractproduct.Card;
import co.com.design_patterns.creational.abstracfactory.abstractproduct.PaymentMethod;
import co.com.design_patterns.creational.abstracfactory.factoryprovider.FactoryProvider;
import co.com.design_patterns.creational.factorymethod.Payment;
import co.com.design_patterns.creational.factorymethod.PaymentFactory;
import co.com.design_patterns.creational.factorymethod.TypePayment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignPatternsApplication {

    public static void main(String[] args) {

        SpringApplication.run(DesignPatternsApplication.class, args);
        probarFactoryMethod();
        probarAbstractFactory();
        probarBuilder();
    }

    private static void probarFactoryMethod() {
        Payment payment = PaymentFactory.buildPayment(TypePayment.CARD);
        payment.doPayment();
    }

    private static void probarAbstractFactory() {
        AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
        Card tarjeta = (Card) abstractFactory.create("VISA");

        AbstractFactory abstractFactory1 = FactoryProvider.getFactory("PaymentMethod");
        PaymentMethod paymentMethod = (PaymentMethod) abstractFactory1.create("CREDIT");

        System.out.println("Tarjeta de tipo: " + tarjeta.getCardType() + "con el método de pago: " + paymentMethod.doPayment());
    }

    private static  void probarBuilder() {
        co.com.design_patterns.creational.builder.Card card = new co.com.design_patterns.creational.builder.Card.CardBuilder(
                        "VISA", "00.000.0000")
                .name("Juan Perez")
                .expirationDate("12/25")
                .credit(true)
                .build();
        System.out.println(card);
    }


}

package co.com.design_patterns;

import co.com.design_patterns.behavioral.chainofresponsability.Tarjeta;
import co.com.design_patterns.behavioral.command.CreditCard;
import co.com.design_patterns.behavioral.command.CreditCardActivateCommand;
import co.com.design_patterns.behavioral.command.CreditCardDeactivateCommand;
import co.com.design_patterns.behavioral.command.CreditCardInvoker;
import co.com.design_patterns.behavioral.iterator.CardList;
import co.com.design_patterns.behavioral.iterator.Iterator;
import co.com.design_patterns.behavioral.iterator.List;
import co.com.design_patterns.behavioral.mediator.ConcreteColleage1;
import co.com.design_patterns.behavioral.mediator.ConcreteColleage2;
import co.com.design_patterns.behavioral.mediator.ConcreteMediator;
import co.com.design_patterns.creational.abstracfactory.AbstractFactory;
import co.com.design_patterns.creational.abstracfactory.abstractproduct.Card;
import co.com.design_patterns.creational.abstracfactory.abstractproduct.PaymentMethod;
import co.com.design_patterns.creational.abstracfactory.factoryprovider.FactoryProvider;
import co.com.design_patterns.creational.factorymethod.Payment;
import co.com.design_patterns.creational.factorymethod.PaymentFactory;
import co.com.design_patterns.creational.factorymethod.TypePayment;
import co.com.design_patterns.creational.protoype.PrototypeCard;
import co.com.design_patterns.creational.protoype.PrototypeFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static co.com.design_patterns.creational.protoype.PrototypeFactory.CartType.AMEX;
import static co.com.design_patterns.creational.protoype.PrototypeFactory.CartType.VISA;

@SpringBootApplication
public class DesignPatternsApplication {

    public static void main(String[] args) {

        SpringApplication.run(DesignPatternsApplication.class, args);

        //CREACIONALES
        probarFactoryMethod();
        probarAbstractFactory();
        probarBuilder();
        probarPrototype();
        probarSinglenton();

        //BEHAVIORAL
        probarChainOfResponsability();
        probarCommand();
        probarIterator();
        probarMediator();
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

    private static void probarPrototype() {
        // Cargar las tarjetas en el prototipo
        PrototypeFactory.loadCard();

        try {
            PrototypeCard visa = PrototypeFactory.getInstance(VISA);
            visa.getCard();

            PrototypeCard amex = PrototypeFactory.getInstance(AMEX);
            amex.getCard();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private static void probarSinglenton() {
        co.com.design_patterns.creational.singleton.Card.getInstance().setCardNumber("123435356");
        System.out.println(co.com.design_patterns.creational.singleton.Card.getInstance().getCardNumber());
    }

    private static  void probarChainOfResponsability() {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.creditCardRequest(15000);
    }

    private static  void probarCommand() {
        CreditCard creditCard = new CreditCard();
        CreditCard creditCardDeactivate = new CreditCard();

        CreditCardInvoker invoker = new CreditCardInvoker();

        invoker.setCommand(new CreditCardActivateCommand(creditCard));
        invoker.run();
        System.out.println("-----------------");
        invoker.setCommand(new CreditCardDeactivateCommand(creditCardDeactivate));
        invoker.run();
    }

    private static void probarIterator(){
        co.com.design_patterns.behavioral.iterator.Card[] cards =
                new co.com.design_patterns.behavioral.iterator.Card[5];
        cards[0] = new co.com.design_patterns.behavioral.iterator.Card("VISA");
        cards[1] = new co.com.design_patterns.behavioral.iterator.Card("MASTERCARD");
        cards[2] = new co.com.design_patterns.behavioral.iterator.Card("AMEX");
        cards[3] = new co.com.design_patterns.behavioral.iterator.Card("DINERS");
        cards[4] = new co.com.design_patterns.behavioral.iterator.Card("DISCOVER");
        List lista = new CardList(cards);
        Iterator iterator = lista.iterator();

        while (iterator.hasNext()){
            co.com.design_patterns.behavioral.iterator.Card tarjeta =
                    (co.com.design_patterns.behavioral.iterator.Card) iterator.next();
            System.out.println(tarjeta.getType());
        }

    }

    private static void probarMediator() {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleage1 user1 = new ConcreteColleage1(mediator);
        ConcreteColleage2 user2 = new ConcreteColleage2(mediator);

        mediator.setUser1(user1);
        mediator.setUser2(user2);

        user1.send("Hola soy user1 ");
        user2.send("Hola user1 soy user 2");
    }
}

package co.com.design_patterns.behavioral.mediator;

public class ConcreteColleage1 extends Colleage {
    public ConcreteColleage1(Mediator mediator){
        super(mediator);
    }
    @Override
    public void send(String message) {
        mediator.send(message, this);
    }

    @Override
    public void messageReceived(String message) {
        System.out.println("Collega1 ha recibido el siguiente mensaje; " + message);

    }
}

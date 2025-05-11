package co.com.design_patterns.behavioral.mediator;

//Define el comportamiento que debe implementar cada objeto para poder comunicarse con el mediator
//a traves de una manera estandar
public abstract class Colleage {
    protected Mediator mediator;

    public Colleage(Mediator mediator){
        this.mediator = mediator;
    }

    public abstract void send(String message);
    public abstract void messageReceived(String message);

}

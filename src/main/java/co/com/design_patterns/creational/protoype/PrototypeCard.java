package co.com.design_patterns.creational.protoype;

public interface PrototypeCard extends Cloneable{

    void getCard();
    PrototypeCard clone() throws CloneNotSupportedException;
}

//Cloneable no define un metodo
package co.com.design_patterns.creational.protoype;

public class Amex implements PrototypeCard{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void getCard() {
        System.out.println("Esto es una tarjeta Amex");
    }

    @Override
    public PrototypeCard clone() throws CloneNotSupportedException {
        System.out.println("Clonando tarjeta Amex...");
        return  (Amex) super.clone();
    }
}

package co.com.design_patterns.creational.abstracfactory.abstractproduct;

//Abstract product: Interfaz para los objetos de tipo de productos para este caso es para objetos de tipo
// Tarjeta
public interface Card {
    //Ponemos tantos metodos que necesitemos para nuestros objetos tarjeta
    String getCardType();
    String getCardNumber();
}

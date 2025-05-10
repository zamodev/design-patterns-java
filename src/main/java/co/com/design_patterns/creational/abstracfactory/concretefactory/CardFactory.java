package co.com.design_patterns.creational.abstracfactory.concretefactory;

import co.com.design_patterns.creational.abstracfactory.AbstractFactory;
import co.com.design_patterns.creational.abstracfactory.abstractproduct.Card;
import co.com.design_patterns.creational.abstracfactory.concreteproduct.MasterCard;
import co.com.design_patterns.creational.abstracfactory.concreteproduct.Visa;

//Concrete Factory, factoria concreta porque va a implementar la interfaz para la creacion de objetos de
// productos concretos
public class CardFactory implements AbstractFactory<Card> {
    @Override
    public Card create(String type) {
        if ("VISA".equals(type)) {
            return new Visa();
        } else if ("MASTERCARD".equals(type)) {
            return new MasterCard();
        }
        return null;
    }
}

package co.com.design_patterns.creational.abstracfactory.concreteproduct;

import co.com.design_patterns.creational.abstracfactory.abstractproduct.Card;

public class Visa implements Card {
    @Override
    public String getCardType() {
        return "VISA";
    }

    @Override
    public String getCardNumber() {
        return "000.0000.000.0";
    }
}

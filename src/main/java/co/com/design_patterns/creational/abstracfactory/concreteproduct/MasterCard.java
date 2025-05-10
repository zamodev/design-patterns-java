package co.com.design_patterns.creational.abstracfactory.concreteproduct;

import co.com.design_patterns.creational.abstracfactory.abstractproduct.Card;

public class MasterCard implements Card {
    @Override
    public String getCardType() {
        return "MASTERCARD";
    }

    @Override
    public String getCardNumber() {
        return "111.111.111.000";
    }
}

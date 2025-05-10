package co.com.design_patterns.creational.abstracfactory.factoryprovider;

import co.com.design_patterns.creational.abstracfactory.AbstractFactory;
import co.com.design_patterns.creational.abstracfactory.concretefactory.CardFactory;
import co.com.design_patterns.creational.abstracfactory.concretefactory.PaymentMethodFactory;

public class FactoryProvider {
    public static AbstractFactory getFactory(String chooseFactory){
        if("Card".equals(chooseFactory)) {
            return new CardFactory();
        }else if("PaymentMethod".equals(chooseFactory)){
            return new PaymentMethodFactory();
        }
        return null;
    }
}

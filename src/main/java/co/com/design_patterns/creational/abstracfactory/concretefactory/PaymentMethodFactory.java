package co.com.design_patterns.creational.abstracfactory.concretefactory;

import co.com.design_patterns.creational.abstracfactory.AbstractFactory;
import co.com.design_patterns.creational.abstracfactory.abstractproduct.PaymentMethod;
import co.com.design_patterns.creational.abstracfactory.concreteproduct.Credit;
import co.com.design_patterns.creational.abstracfactory.concreteproduct.Debit;

public class PaymentMethodFactory implements AbstractFactory<PaymentMethod> {
    @Override
    public PaymentMethod create(String type) {
        if("DEBIT".equals(type)) {
            return new Debit();
        } else if ("CREDIT".equals(type)) {
            return new Credit();
        }
        return null;
    }
}

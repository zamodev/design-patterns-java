package co.com.design_patterns.creational.abstracfactory.concreteproduct;

import co.com.design_patterns.creational.abstracfactory.abstractproduct.PaymentMethod;

public class Credit implements PaymentMethod {
    @Override
    public String doPayment() {
        return "Pago a Crédito";
    }
}

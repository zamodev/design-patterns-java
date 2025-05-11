package co.com.design_patterns.creational.protoype;

import java.util.HashMap;
import java.util.Map;

import static co.com.design_patterns.creational.protoype.PrototypeFactory.CartType.AMEX;
import static co.com.design_patterns.creational.protoype.PrototypeFactory.CartType.VISA;

public class PrototypeFactory {
    public static class  CartType {
        public static final String AMEX = "AMEX";
        public static final String VISA = "VISA";
    }
    private static Map<String, PrototypeCard> prototypes = new HashMap<>();

    public static PrototypeCard getInstance(final String tipo) throws CloneNotSupportedException {
        return prototypes.get(tipo).clone();
    }
    public static void loadCard() {
        Visa visa = new Visa();
        visa.setName("Esta tarjeta es visa con numero 1111");
        prototypes.put(VISA, visa);
        //
        Amex amex = new Amex();
        amex.setName("Esta tarjeta es amex con numero 0000");
        prototypes.put(AMEX, amex);
    }
}

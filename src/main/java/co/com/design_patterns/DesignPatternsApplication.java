package co.com.design_patterns;

import co.com.design_patterns.creational.factorymethod.Payment;
import co.com.design_patterns.creational.factorymethod.PaymentFactory;
import co.com.design_patterns.creational.factorymethod.TypePayment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignPatternsApplication {

	public static void main(String[] args) {

		SpringApplication.run(DesignPatternsApplication.class, args);
		probarFactoryMethod();
	}

	private static void probarFactoryMethod(){
		Payment payment = PaymentFactory.buildPayment(TypePayment.CARD);
		payment.doPayment();
	}
}

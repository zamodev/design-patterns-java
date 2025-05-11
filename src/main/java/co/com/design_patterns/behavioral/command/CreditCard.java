package co.com.design_patterns.behavioral.command;

//Este es el reciber
public class CreditCard {
    public void sendPinNumberToCustomer() {
        System.out.println("El pin number ha sido enviado al cliente.");
    }

    public void sendSMSToCustomerActivate() {
        System.out.println("Enviado sms al cliente informanmdo que su tarjeta ha sido activada.");
    }

    public void activate() {
        System.out.println("La tarjeta ha sido activada.");
    }

    public void desactivate() {
        System.out.println("La tarjeta ha sido desactivada.");
    }

    public void sendSMSToCustomerDesactivate() {
        System.out.println("Enviado SMS al cliente informando de que su tarjeta ha sido desactivada.");
    }
}

package co.com.design_patterns.behavioral.command;

public class CreditCardActivateCommand implements Command{

    CreditCard creditCard;
    public CreditCardActivateCommand(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public void execute() {
        creditCard.activate();
        creditCard.sendSMSToCustomerActivate();
        creditCard.sendPinNumberToCustomer();
    }
}

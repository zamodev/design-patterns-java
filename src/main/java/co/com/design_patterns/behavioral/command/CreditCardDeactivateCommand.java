package co.com.design_patterns.behavioral.command;

public class CreditCardDeactivateCommand implements  Command{

    CreditCard creditCard;
    public CreditCardDeactivateCommand(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public void execute() {
        creditCard.desactivate();
        creditCard.sendSMSToCustomerDesactivate();

    }
}

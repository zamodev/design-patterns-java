package co.com.design_patterns.behavioral.chainofresponsability;

import co.com.design_patterns.behavioral.chainofresponsability.concretehandler.Black;
import co.com.design_patterns.behavioral.chainofresponsability.concretehandler.Gold;
import co.com.design_patterns.behavioral.chainofresponsability.concretehandler.Platinum;

public class Tarjeta implements ApproveLoanChain{
    private ApproveLoanChain next;

    @Override
    public void setNext(ApproveLoanChain loan) {
        next = loan;
    }

    @Override
    public ApproveLoanChain getNext() {
        return next;
    }

    @Override
    public void creditCardRequest(int totalLoan) {
        Gold gold = new Gold();
        this.setNext(gold);

        Platinum platinum = new Platinum();
        gold.setNext(platinum);

        Black black = new Black();
        platinum.setNext(black);

        next.creditCardRequest(totalLoan);
    }
}

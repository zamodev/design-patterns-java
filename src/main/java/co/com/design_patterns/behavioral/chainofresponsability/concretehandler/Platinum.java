package co.com.design_patterns.behavioral.chainofresponsability.concretehandler;

import co.com.design_patterns.behavioral.chainofresponsability.ApproveLoanChain;

public class Platinum implements ApproveLoanChain {

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
        if (totalLoan > 10000 && totalLoan <= 15000) {
            System.out.println("Esta solicitud la manjea la tarjeta Platinum" + totalLoan);
        }else {
            next.creditCardRequest(totalLoan);
        }
    }
}

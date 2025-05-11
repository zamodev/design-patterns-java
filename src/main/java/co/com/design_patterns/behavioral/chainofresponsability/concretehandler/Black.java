package co.com.design_patterns.behavioral.chainofresponsability.concretehandler;

import co.com.design_patterns.behavioral.chainofresponsability.ApproveLoanChain;

public class Black implements ApproveLoanChain {
    private ApproveLoanChain next;

    @Override
    public ApproveLoanChain getNext() {
        return next;
    }

    @Override
    public void setNext(ApproveLoanChain loan) {
        next = loan;
    }

    @Override
    public void creditCardRequest(int totalLoan) {
        if (totalLoan > 15000 && totalLoan <= 20000) {
            System.out.println("Esta solicitud la manjea la tarjeta Black" + totalLoan);
        }
    }
}

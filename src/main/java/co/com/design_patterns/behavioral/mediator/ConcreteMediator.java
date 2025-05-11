package co.com.design_patterns.behavioral.mediator;

public class ConcreteMediator implements Mediator {
    private ConcreteColleage1 user1;
    private ConcreteColleage2 user2;

    public void setUser1(ConcreteColleage1 colleage1) {
        user1 = colleage1;
    }

    public void setUser2(ConcreteColleage2 colleage2) {
        user2 = colleage2;
    }

    @Override
    public void send(String message, Colleage colleague) {
        if (colleague == user1) {
            user2.messageReceived(message);
        } else if (colleague == user2) {
            user1.messageReceived(message);
        }
    }
}

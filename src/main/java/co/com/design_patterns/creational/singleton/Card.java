package co.com.design_patterns.creational.singleton;

public class Card {
    //Vairable que siempre se va a devolver
    private static Card INSTANCE;
    private String cardNumber;

    private Card(){
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    //synchronized para que no se pueda acceder a la instancia de forma simultanea. (Evita que si hay 2
    // hilos se genere la instacia 2 veces)
    public synchronized static Card getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Card();
        }
        return INSTANCE;

    }
}

package co.com.design_patterns.behavioral.iterator;

public class CardList implements List{
    private Card[] cards;

    public CardList(Card[] cards) {
        this.cards = cards;
    }
    @Override
    public Iterator iterator() {
        return new CardIterator(cards);
    }
}

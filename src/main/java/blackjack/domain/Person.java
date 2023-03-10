package blackjack.domain;

import java.util.List;

public abstract class Person {
    protected static final int MAX_SCORE = 21;

    protected final String name;
    protected final Cards cards;

    protected Person(String name) {
        this.name = name;
        this.cards = new Cards();
    }

    public void addCard(Card card) {
        this.cards.addCard(card);
    }

    public int getScore() {
        return cards.getScore();
    }

    public boolean isBlackjack() {
        return cards.isBlackjack();
    }

    public boolean isBust() {
        return cards.isBust();
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards.getCards();
    }

    public abstract boolean isPlayer();

    public abstract boolean isDealer();

    public abstract List<Card> getInitCards();

    public abstract boolean canDrawCard();
}

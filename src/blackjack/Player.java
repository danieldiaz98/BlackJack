package blackjack;

import java.util.List;

public class Player {
    private List<Card> cards;

    public Player(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }
}

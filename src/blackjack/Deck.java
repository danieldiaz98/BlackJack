/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danie
 */
public class Deck {
    
    private List<Card>deck;
    
    public Deck (List<Card>deck) {
        this.deck = deck;
    }
    
    public List<Card> getCards () {
        return deck;
    }
    
    public Card drawCard () {
        Card card = deck.get(0);
        deck.remove(0);
        System.out.println(card.getCard());
        return card;
    }
}

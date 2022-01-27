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
public class Croupier {
    
    private List<Card>hand;
    
    public Croupier (List<Card>hand) {
        this.hand = hand;
    }
    
    public List<Card> getCards() {
        return hand;
    }
}



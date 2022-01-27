
package blackjack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
    public static List<String> getWinners(List<Card> player1, List<Card> player2, List<Card> player3 ,List<Card> crupier, List<Card> deck){
        List<String> winners = new ArrayList<>();
        List<Card> crupierC = crupierCards(crupier, deck);
        List<Card>[] players = new LinkedList[3];
        int crupierPoints = calculate(crupierC);
        players[0] = player1;
        players[1] = player2;
        players[2] = player3;

        if(isBlackJack(crupierC)) {
            winners.add("Crupier");
            return winners;
        }

        for (int i = 0; i < players.length; i++) {
            int playerPoints = calculate(players[i]);
            if (crupierPoints > 21 && playerPoints <= 21) {
                winners.add("player" + (i+1));
            } else {
                if (playerPoints > crupierPoints) {
                    winners.add("player" + (i + 1));
                }
            }
        }

        if (crupierPoints <= 21 && winners.isEmpty()) winners.add("Crupier");


        return winners;

    }
    
    public static boolean isBlackJack(List<Card> cards){
        if (calculate(cards) == 21 && cards.size() == 2){
            return true;
        }else{
            return false;
        }
    }
    
    public static List<Card> crupierCards(List<Card> cards, List<Card> deck){
        List<Card> crupier = cards;

        while(calculate(crupier) < 17 && !deck.isEmpty()){
            crupier.add(deck.remove(0));
        }
        return crupier;
    }
    
    public static int calculate(List<Card> cards){
        int points = 0;
        int A = 0;
        for (Card a: cards){
            String value = a.getCard();
            if (value.equals("A")) {
                A++;
                points += 11;
            }else{
                if (value.equals("J") || value.equals("Q") || 
                        value.equals("K")) {
                    points += 10;
                }else{
                    points += Integer.parseInt(value);
                }
                
            }
        }
        if(points > 21 && A >= 1){
            for(int i = 0; i < A; i++){
                points -= 10;
            }
        }
        return points;
    }
    
    
}

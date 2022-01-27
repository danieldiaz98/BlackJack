import blackjack.Card;
import blackjack.Croupier;
import blackjack.Deck;
import blackjack.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

public class BlackJackTests {
    private Croupier crupier;
    private Player p1;
    private Player p2;
    private Player p3;
    private Deck deck;
    private Card card;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;
    private Card card6;
    private Card card7;
    private Card card8;
    private Card card9;
    private Card cardJ;
    private Card cardQ;
    private Card cardK;
    private Card cardA;

    @Before
    public void inicializa() {
        card = new Card("1");
        card2 = new Card("2");
        card3 = new Card("3");
        card4 = new Card("4");
        card5 = new Card("5");
        card6 = new Card("6");
        card7 = new Card("7");
        card8 = new Card("8");
        card9 = new Card("9");
        cardJ = new Card("J");
        cardQ = new Card("Q");
        cardK = new Card("K");
        cardA = new Card("A");
    }

    @Test
    public void pruebaP1BlackJack() {
        List<Card> p1Cards = new LinkedList<>();
        p1Cards.add(cardJ);
        p1Cards.add(cardA);
        p1 = new Player(p1Cards);

        List<Card> p2Cards = new LinkedList<>();
        p2Cards.add(card3);
        p2Cards.add(card6);
        p2 = new Player(p2Cards);

        List<Card> p3Cards = new LinkedList<>();
        p3Cards.add(card8);
        p3Cards.add(card9);
        p3 = new Player(p3Cards);

        List<Card> crupierCards = new LinkedList<>();
        crupierCards.add(card5);
        crupierCards.add(card5);
        crupier = new Croupier(crupierCards);

        List<Card> deckCards = new LinkedList<>();
        deckCards.add(card4);
        deckCards.add(card3);
        deck = new Deck(deckCards);
        List<String> win = new ArrayList<>();
        win.add("player1");
        List<String> winners = new blackjack.Game().getWinners(p1Cards, p2Cards, p3Cards, crupierCards, deckCards);
        assertEquals(win, winners);
    }

    @Test
    public void pruebaCrupierBlackJack() {
        List<Card> p1Cards = new LinkedList<>();
        p1Cards.add(card8);
        p1Cards.add(card9);
        p1 = new Player(p1Cards);

        List<Card> p2Cards = new LinkedList<>();
        p2Cards.add(card3);
        p2Cards.add(card6);
        p2 = new Player(p2Cards);

        List<Card> p3Cards = new LinkedList<>();
        p3Cards.add(card5);
        p3Cards.add(card6);
        p3 = new Player(p3Cards);


        List<Card> crupierCards = new LinkedList<>();
        crupierCards.add(cardJ);
        crupierCards.add(cardA);

        crupier = new Croupier(crupierCards);

        List<Card> deckCards = new LinkedList<>();
        deckCards.add(card4);
        deckCards.add(card3);
        deck = new Deck(deckCards);
        List<String> win = new ArrayList<>();
        win.add("Crupier");
        List<String> winners = new blackjack.Game().getWinners(p1Cards, p2Cards, p3Cards, crupierCards, deckCards);
        assertEquals(win, winners);
    }

    @Test
    public void pruebaCrupierLooses() {
        List<Card> p1Cards = new LinkedList<>();
        p1Cards.add(card8);
        p1Cards.add(card9);
        p1 = new Player(p1Cards);

        List<Card> p2Cards = new LinkedList<>();
        p2Cards.add(card3);
        p2Cards.add(card6);
        p2 = new Player(p2Cards);

        List<Card> p3Cards = new LinkedList<>();
        p3Cards.add(card5);
        p3Cards.add(card6);
        p3 = new Player(p3Cards);


        List<Card> crupierCards = new LinkedList<>();
        crupierCards.add(card3);
        crupierCards.add(card8);

        crupier = new Croupier(crupierCards);

        List<Card> deckCards = new LinkedList<>();
        deckCards.add(card4);
        deckCards.add(card8);
        deck = new Deck(deckCards);
        List<String> win = new ArrayList<>();
        win.add("player1");
        win.add( "player2");
        win.add("player3");
        List<String> winners = new blackjack.Game().getWinners(p1Cards, p2Cards, p3Cards, crupierCards, deckCards);
        assertEquals(win, winners);
    }

    @Test
    public void pruebaDeckGetCards() {

        List<Card> deckCards = new LinkedList<>();
        deckCards.add(card4);
        deckCards.add(card8);
        deck = new Deck(deckCards);

        assertEquals(deckCards, deck.getCards());
    }
    @Test
    public void pruebaCrupierGetCards() {

        List<Card> crupierCards = new LinkedList<>();
        crupierCards.add(card3);
        crupierCards.add(card8);

        crupier = new Croupier(crupierCards);

        assertEquals(crupierCards, crupier.getCards());
    }

    @Test
    public void pruebaCardValue() {
        assertEquals("A", cardA.getCard());
        assertEquals("J", cardJ.getCard());
    }
}
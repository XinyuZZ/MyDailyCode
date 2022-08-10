package jensen.Lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {

    // spades, hearts, clubs, diamonds
    public static final String[] SUITS = new String[]{"\u2660", "\u2665", "\u2663", "\u2666"};
    public static final String[] RANKS = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    public final String suit;
    public final String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return suit + rank;
    }

    public static void main(String[] args) {
        //1
        List<Card> initial = new ArrayList<>();

//        for (int i = 0; i < SUITS.length; i++) {
//            for (int j = 0; j < RANKS.length; j++)
//            initial.add(SUITS[i]+RANKS[j]);
//        }
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                initial.add(new Card(suit, rank));
            }
        }
        System.out.println(initial);

        // 2
        Collections.shuffle(initial);
        System.out.println(initial);

        //3
        int numOfPlayer = 4;
        int cardsPerHand = 13;
        for (int i = 0; i < numOfPlayer; i++) {
            List<Card> handView = initial.subList(cardsPerHand * i, cardsPerHand * i + 1);
            List<Card> hand = new ArrayList<>(handView);
//            Collections.sort(hand);
        }
    }
}

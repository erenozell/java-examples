package Pisti;

import java.util.Random;
import java.util.Scanner;

public class Pisti {

    private Player[] players;
    private Card[] deck;
    private int Score;

    public Pisti(Player[] players) {

        /* DESTE OLUŞTURMA */
        String[] suits = { "Sinek", "Maça", "Karo", "Kupa" };
        String[] ranks = { "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2" };
        deck = new Card[suits.length * ranks.length];
        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = new Card(ranks[j], suits[i]);
                index++;
            }
        }

        for (Card card : deck) {
            System.out.println(card.getCard());
        }

        System.out.println("---------------------------");

        this.shuffle();

        for (Card card : deck) {
            System.out.println(card.getCard());
        }

    }

    private void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < 52; i++) {
            int random = rand.nextInt(52);
            Card tempCard = this.deck[i];
            this.deck[i] = this.deck[random];
            this.deck[random] = tempCard;
        }
    }

    private void cutCard(int cutNumber) {

        Card[] newdeck = new Card[cutNumber];
        Card[] newdeck1 = new Card[52 - cutNumber];

        for (int i = 0; i < cutNumber; i++) {
            newdeck[i] = deck[i];
        }

        for (int i = cutNumber; i < this.deck.length; i++) {
            newdeck1[i] = deck[i];
        }

        for (int i = 0; i < newdeck1.length; i++) {
            deck[i] = newdeck1[i];
        }

        for (int i = cutNumber; i < newdeck.length; i++) {
            deck[i] = newdeck[i];
        }

    }

}

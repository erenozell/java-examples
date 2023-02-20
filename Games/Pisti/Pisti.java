package Pisti;

import java.util.Random;
import java.util.Scanner;

public class Pisti {
    Scanner scan = new Scanner(System.in);
    private Player[] players;
    private Card[] placesCards = new Card[52];
    private int placesCardsİndex = -1;
    private Card[] deck = new Card[52];
    private int index = 51;

    public Pisti(Player[] players) {
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
    }

    private void shuffleCutCard() {
        Random rand = new Random();
        for (int i = 0; i < 52; i++) {
            int random = rand.nextInt(52);
            Card tempCard = this.deck[i];
            this.deck[i] = this.deck[random];
            this.deck[random] = tempCard;
        }
        System.out.println("lütfen kartın kesilmesini istediğiniz sayıyı giriniz :");
        int cutNumber = scan.nextInt();
        Card[] newdeck = new Card[cutNumber];
        Card[] newdeck1 = new Card[this.deck.length - cutNumber];
        int x = 0;
        int y = 0;

        for (int i = 0; i < cutNumber; i++) {
            newdeck[i] = this.deck[i];
        }
        for (int i = cutNumber; i < this.deck.length; i++) {
            newdeck1[x] = this.deck[i];
            x++;
        }
        for (int i = 0; i < newdeck1.length; i++) {
            this.deck[i] = newdeck1[i];
        }
        for (int i = deck.length - cutNumber; i < this.deck.length; i++) {
            this.deck[i] = newdeck[y];
            y++;
        }
    }

    private Card[] distrubCard() {
        Card[] tempCards = new Card[4];
        for (int i = 0; i < 4; i++) {
            tempCards[i] = deck[index];
            index--;
        }
        return tempCards;
    }

    private int choosenCard(Player player) {
        if (this.placesCardsİndex != -1) {
            System.out.println("Yerdeki kart :");
            this.placesCards[placesCardsİndex].getCard();
        } else {
            System.out.println("Yer boş!");
        }
        System.out.println("Elinizdeki kartlar :");
        player.showCards();
        System.out.println("Lütfen atmak istediğiniz kartın sıra numarasını giriniz :");
        int sentNumber = scan.nextInt();
        return sentNumber;
    }

    private int numberOfPlayers(Player[] players) {
        int x = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null) {
                x++;
            }
        }
        return x;
    }

    private int calculatePlaceCards() {
        int value = 0;
        int temp = 0;
        for (int i = -1; i < this.placesCardsİndex; i++) {
            value = value + placesCards[temp].value();
            temp++;
        }
        return value;
    }

    public void onGame(Player[] players) {
        shuffleCutCard();
        Player temPlayer = new Player(null);
        int nOP = numberOfPlayers(players);
        Card[] tempCard = distrubCard();
        for (int i = 0; i < tempCard.length; i++) {
            placesCards[i] = tempCard[i];
        }
        placesCardsİndex = 3;
        boolean x = true;
        while (x) {
            for (int i = 0; i < nOP; i++) {
                if (players[i].getCardOnHand()[0] == null) {
                    players[i].setCardOnHand(distrubCard());
                }
                System.out.println("=======" + players[i].getName() + "========");
                Card card = players[i].giveCard(choosenCard(players[i]));
                if (placesCardsİndex == 0 && card.getRank() == placesCards[placesCardsİndex].getRank()) {
                    players[i].setScore(10 + card.value() + placesCards[placesCardsİndex].value());
                    temPlayer = players[i];
                    placesCardsİndex = -1;
                }
                if (placesCardsİndex > 0 && card.getRank() == placesCards[placesCardsİndex].getRank()
                        || placesCardsİndex > -1 && card.getRank() == "J") {
                    players[i].setScore(calculatePlaceCards() + card.value());
                    temPlayer = players[i];
                    placesCardsİndex = -1;
                } else {
                    placesCardsİndex++;
                    placesCards[placesCardsİndex] = card;
                }
                if (placesCardsİndex != -1 && this.index == -1) {
                    for (int j = 0; j < nOP; j++) {
                        if (players[j].equals(temPlayer)) {
                            players[j].setScore(calculatePlaceCards());
                        }
                    }
                }
                if (players[i].getCardOnHand()[0] == null && this.index == -1) {
                    x = false;
                    for (int k = 0; k < nOP; k++) {
                        System.out.println(players[k].getName() + "Score : " + players[k].getScore());
                    }
                }
            }

        }
    }
}

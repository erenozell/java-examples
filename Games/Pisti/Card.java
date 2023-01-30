package Pisti;

public class Card {
    private String rank;
    private String suit;

    Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return this.rank;
    }

    public String getSuit() {
        return this.suit;
    }

    public String getCard() {
        return "rank: " + this.rank + " | " + "suit: " + this.suit;
    }

}

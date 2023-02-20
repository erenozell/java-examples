package Pisti;

public class Card {
    private String rank;
    private String suit;
    private int value;

    Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
        this.value = 0;
    }

    public int value() {
        if (this.rank == "2" && this.suit == "Sinek") {
            this.value = 2;
        } else if (this.rank == "10" && this.suit == "Karo") {
            this.value = 3;
        } else if (this.rank == "J") {
            this.value = 1;

        } else if (this.rank == "A") {
            this.value = 1;

        } else {
            this.value = 0;
        }
        return value;
    }

    public String getRank() {
        return this.rank;
    }

    public String getSuit() {
        return this.suit;
    }

    public void getCard() {
        System.out.println("rank: " + this.rank + " | " + "suit: " + this.suit);
    }

}

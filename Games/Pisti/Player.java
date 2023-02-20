package Pisti;

public class Player {
    private String name;
    private int score;
    private Card[] cardOnHand = new Card[4];
    private int index;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.index = 0;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int value) {
        this.score = this.score + value;
    }

    public Card giveCard(int x) {
        Card[] cards = new Card[4];
        Card givenCard = new Card(name, name);
        int temp = 0;
        for (int i = 0; i < this.index; i++) {
            if (x != i) {
                cards[temp] = cardOnHand[i];
                temp++;
            } else {
                givenCard = cardOnHand[i];
            }
        }
        cardOnHand = cards;
        this.index--;
        return givenCard;
    }

    public Card[] getCardOnHand() {
        return cardOnHand;
    }

    public void setCardOnHand(Card[] cards) {
        this.cardOnHand = cards;
        this.index = 4;
    }

    public void showCards() {
        for (int i = 0; i < this.index; i++) {
            System.out.print(i + "-) ");
            cardOnHand[i].getCard();
        }
    }

    public String getName() {
        return this.name;
    }
}

package HighLow;

public class Hand extends Deck{
    public Card getHighCard() {
        return drawCard();
    }

    public void setHighCard(Card highCard) {
        HighCard = highCard;
    }

    public Card getLowCard() {
        return drawCard();
    }

    public void setLowCard(Card lowCard) {
        LowCard = lowCard;
    }

    public Card HighCard;
    public  Card LowCard;


    public Hand(Card HighCard,Card LowCard) {
        this.HighCard=HighCard;
        this.LowCard=LowCard;
    }

}

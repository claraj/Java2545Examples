package HighLow;




public class Card  {




    public enum Suit {
        DIAMONDS, CLUBS, HEARTS, SPADES;

    }

    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
        NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

        final int value;

        private Rank(int value) {
            this.value = value;
        }
    };
    public final Suit suit;
    public final Rank rank;
    public final int value;
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.value=rank.value;


    }

    @Override
    public String toString() {
        return rank.toString()+" of "+suit.toString();
    }




}

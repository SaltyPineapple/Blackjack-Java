public class Card {
    public static final int SPADE = 4;
    public static final int HEART = 3;
    public static final int CLUB = 2;
    public static final int DIAMOND = 1;

    private static final String[] Suit = {"*", " Diamonds", " Clubs", " Hearts", " Spades"};
    private static final String[] Rank = {"*", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private byte cardSuit;
    private byte cardRank;



    public Card(int suit, int rank){

        if(rank == 0){
            cardRank = 13;
        }
        else {
            cardRank = (byte) rank;
        }

        cardSuit = (byte) suit;

    }


    public int suit() {
        return cardSuit;
    }

    public String suitStr(){
        return Suit[cardSuit];
    }

    public int rank() {
        return cardRank;
    }

    public String rankStr(){
        return Rank[cardRank];
    }

    public String toString(){
        return Rank[cardRank] + Suit[cardSuit];
    }

}

public class Deck {

    public static final int NCARDS = 52;

    private Card[] deckOfCards;
    private int currentCard;

    public Deck() {
        deckOfCards = new Card[52];

        int i=0;
        for(int suit = Card.DIAMOND; suit <= Card.SPADE; suit++){
            for(int rank=1; rank<=13; rank++){
                deckOfCards[i++] = new Card(suit, rank);
            }
        }

        currentCard = 0;
    }

    public String toString() {
        String s = "";

        int k =0;

        for(int i=0; i<4; i++){
            for(int j=1; j<=13; j++){
                s += deckOfCards[k++] + " ";
            }
            s += "\n";
        }
        return s;
    }

    public Card deal() {
        if(currentCard < NCARDS){
            return deckOfCards[currentCard++];
        }
        else{
            System.out.println("out of cards");
            return(null);
        }
    }


    public void shuffle(int n){
        for(int k=0; k<n;k++){
            double i = 52*Math.random();
            double j = 52*Math.random();

            Card help;
            help = deckOfCards[(int) i];
            deckOfCards[(int) i] = deckOfCards[(int) j];
            deckOfCards[(int) j] = help;

        }
        currentCard = 0;
    }


}

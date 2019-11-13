import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        game();
    }


    static void game(){
        Scanner in = new Scanner(System.in);
        Card[] player = new Card[10];
        Card[] dealer = new Card[10];
        int playerMoney = 40;


        while(true){

            // Create Deck and shuffle it
            Deck deck = new Deck();
            deck.shuffle(1000);


            // Create Player wager and take in the bets
            System.out.printf("Player Money: $%d\n", playerMoney);
            System.out.println("What is your bet?");
            int wager = in.nextInt();


            // Deal two cards to player and dealer
            player[1] = deck.deal();
            player[2] = deck.deal();

            dealer[1] = deck.deal();
            dealer[2] = deck.deal();

            System.out.println();


            // Print out the hands, print dealer with one card face down
            System.out.println("Dealer Hand: ");
            dealPrint(dealer);

            System.out.println();

            System.out.println("Player Hand: ");
            printHand(player);

            System.out.println();


            // Player Gameplay
            int value = handValue(player);
            if (value < 21) {
                while(handValue(player) < 21){

                    System.out.println("What do you choose to do? ");
                    System.out.println("HIT    [1]");
                    System.out.println("STAND  [2]");
                    int playerInput = in.nextInt();

                    if(playerInput == 1){
                        for(int x=0; x<player.length; x++){
                            if(player[x] == null){
                                player[x] = deck.deal();
                                break;
                            }
                        }
                        printHand(player);
                    }
                    else if(playerInput == 2){
                        break;
                    }
                }
            }
            else {
                System.out.println("BLACKJACK");
            }

            // Dealer Gameplay
            System.out.println();
            while(handValue(dealer) < 17){
                for(int x=0; x< dealer.length; x++){
                    if(dealer[x] == null){
                        dealer[x] = deck.deal();
                        break;
                    }
                }
            }



            // Compare hand values
            System.out.println("Dealer Hand: ");
            printHand(dealer);

            System.out.println();

            System.out.println("Player Hand: ");
            printHand(player);


            int dealerValue = handValue(dealer);
            int playerValue = handValue(player);



            if(playerValue > 21){
                System.out.println("PLAYER BUST");
                playerMoney -= wager;
            }
            else if(dealerValue > 21 && playerValue < 21){
                System.out.println("DEALER BUST");
                playerMoney += wager;
            }





            System.out.println("Would you like to play another hand? [y / n]");
            String choice = in.next();

            if(choice.equals("n")){
                System.out.println("Thanks for playing!");
                break;
            }




        }


    }

    static int handValue(Card[] hand){

        int total = 0;

        for(int x=0; x< hand.length; x++){
            if(hand[x] != null){
                if(hand[x].rank() >= 10){
                    total += 10;
                }
                else {
                    total += hand[x].rank();
                }
            }
        }

        return total;
    }

    static void printHand(Card[] hand){
        for(int x=0; x< hand.length; x++){
            if(hand[x] != null){
                System.out.println(hand[x]);
            }
        }

    }

    static void dealPrint(Card[] hand){
        System.out.println(hand[1]);
        System.out.print("*");
    }



}

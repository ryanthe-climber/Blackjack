/**
*blackjack.java
*Ryan Agricola
*12/20/2024
*plays black jack
*/

import java.util.ArrayList;
import java.util.Scanner;

public class blackjack {

 
   public static void main(String[] args) {
      Scanner bob = new Scanner(System.in);

      System.out.println("\n");
      System.out.println("▀█████████▄   ▄█          ▄████████  ▄████████    ▄█   ▄█▄      ▄█    ▄████████  ▄████████    ▄█   ▄█▄\n" + //
                         "  ███    ███ ███         ███    ███ ███    ███   ███ ▄███▀     ███   ███    ███ ███    ███   ███ ▄███▀\n" + //
                         "  ███    ███ ███         ███    ███ ███    █▀    ███▐██▀       ███   ███    ███ ███    █▀    ███▐██▀  \n" + //
                         " ▄███▄▄▄██▀  ███         ███    ███ ███         ▄█████▀        ███   ███    ███ ███         ▄█████▀   \n" + //
                         "▀▀███▀▀▀██▄  ███       ▀███████████ ███        ▀▀█████▄        ███ ▀███████████ ███        ▀▀█████▄   \n" + //
                         "  ███    ██▄ ███         ███    ███ ███    █▄    ███▐██▄       ███   ███    ███ ███    █▄    ███▐██▄  \n" + //
                         "  ███    ███ ███▌    ▄   ███    ███ ███    ███   ███ ▀███▄     ███   ███    ███ ███    ███   ███ ▀███▄\n" + //
                         "▄█████████▀  █████▄▄██   ███    █▀  ████████▀    ███   ▀█▀ █▄ ▄███   ███    █▀  ████████▀    ███   ▀█▀\n" + //
                         "             ▀                                   ▀         ▀▀▀▀▀▀                            ▀        ");

      System.out.println("\nWelcome to Blackjack!");

      boolean valid = true;
      do {
         System.out.println("\n1 - Play\n2 - Rules");
         System.out.print("Enter a number to get started: ");
         int choice = bob.nextInt();
         switch(choice) {
            case 1: valid = true;
                  int result = playBlackjack();

                  switch(result) {
                     case 1: 
                     System.out.println("Normal Win (2:1)");
                     break;
                     case 2: 
                     System.out.println("Blackjack Win (3:2)");
                     break;
                     case 3: 
                     System.out.println("Lost");
                     break;
                     case 4: 
                     System.out.println("Tie (Push)");
                     break;
                     default: 
                     System.out.println("Error");
                     
                  }
                  break;
            case 2: valid = false;
                  rules();
                  break;
            default: {
               valid = false;
               System.out.print("\nInvalid choice. Please try again: ");
            }
         } 
      } while(valid == false);
   }

   public static void rules() {
      System.out.println("\nBlackjack Rules\n" + //
                  "In Blackjack, everyone plays against the dealer. Players receive all cards face up and the dealer’s first card is face up and the second is face down. The object of the game is to get closer to 21 than the dealer without going over 21. If a hand goes over 21, it is called a “bust” or “break” and the wager is lost. In 21, Jacks, Queens, Kings and 10s count as 10. An Ace may be played as a one or an 11. All other cards are played at face value.\n" + //
                  "\n" + //
                  "When you receive your first two cards, you may either “stand” or “hit”. When you “stand” it means you feel you are close enough to 21 and no longer wish any additional cards and indicated by waving off with your hand. If you wish to receive another card or “hit,” tap or scratch the table behind your wager with your finger.  In either situation, you will never touch the cards, everything is communicated using hand signals. You may draw as many cards as you want until you are close to 21 or until you “bust.”\n" + //
                  "\n" + //
                  "If you are closer to 21 than the dealer, you win and are paid an amount equal to your original wager. If your hand is less than the dealer’s, you lose. If the dealer’s hand “busts” or “breaks,” you win as well. Ties are a standoff or “push” and your bet remains on the table.\n" + //
                  "\n" + //
                  "If your initial two cards total 21, any Ace with a 10, Jack, Queen, or King, you have a Blackjack. Blackjack is paid either 6 to 5 or 3 to 2 depending on the type of Blackjack you are playing.\n" + //
                  "\n" + //
                  "In 21, the player has many options to choose from:\n" + //
                  "\n" + //
                  "\n" + //
                  "Splitting Pairs\n" + //
                  "If your first two cards have the same numerical value, you may split them into two hands. The bet on the second hand must equal the original bet. If the split pair is Aces, you are limited to a one-card draw on each hand.\n" + //
                  "\n" + //
                  "\n" + //
                  "Doubling Down\n" + //
                  "After receiving your first two cards you may elect to wager an additional amount not to exceed the value of the original bet. With a double down, you will be dealt one additional card only.\n" + //
                  "");
                  Delay.prompt();
   }
   
   public static int playBlackjack() {

      /*RETURN VALS
      *1 - player wins (2:1) (noraml win)
      *2 - player wins (3:2) (Blackjack win)
      *3 - player loses
      *4 - player ties with dealer (push)
      */

      
      System.out.println("\n");

      Deck deck = new Deck();
      deck.shuffle();
      
      //INITIAL 2-CARD DEAL

      Hand dealerHand = new Hand();
      Hand playerHand = new Hand();
      ArrayList<Hand> hands = new ArrayList<Hand>();
      hands.add(playerHand);

      Card d1 = deck.dealOne();
      dealerHand.dealToHand(d1);

      Card d2 = deck.dealOne();
      dealerHand.dealToHand(d2);
   
      playerHand.dealToHand(deck.dealOne());

      playerHand.dealToHand(deck.dealOne());

      System.out.println("The dealer has a(n) " + d1);
      playerHand.displayHand(1);

      boolean doHand = true;

      if(dealerHand.val() == 21 && playerHand.val() == 21){
         System.out.println("Both you and the dealer have Blackjack! Push!"); //PUSH
         doHand = false;
         return(4);
      } else if(dealerHand.val() == 21) {
         System.out.println("The dealer has Blackjack! You lose!"); //LOSE
         System.out.println("The dealer had a(n) " + d1 + " and a(n) " + d2);
         doHand = false;
         return(3);
      } else if(playerHand.val() == 21) {
         System.out.println("You have Blackjack! You win!!"); //WIN
         doHand = false;
         return(2);
      }
      
      //PLAYER TURN
      for(int i = 0; i < hands.size(); i++) {
         playHand(hands, i, deck);
         if(hands.get(i).hasBusted()) {
            return(3);
         }
      }
      
      //DEALER TURN
      if(playerHand.val() <= 21 && dealerHand.val() < 21) {
         System.out.println("The dealer has a(n) " + d1 + " and a(n) " + d2);
         System.out.println("\nThe dealer's hand total is " + dealerHand.val());
         System.out.print("\n");

         Delay.prompt();
         
         boolean dealCont = true;

         while(dealCont){
            int softDealVal = dealerHand.val() - (10 * dealerHand.numAces());

            if(softDealVal < 17) { //DEALER HIT
               System.out.println("The dealer hits!\n");

               dealerHand.dealToHand(deck.dealOne());

               dealerHand.displayHand(2);

               dealCont = true;

               Delay.prompt();

            } else if(dealerHand.val() > 21) { //DEALER BUST
               System.out.println("The dealer busted! You win!"); //WIN
               dealCont = false;
               return(1);
               
            } else { // DEALER STAND
               System.out.println("The dealer stands!\n");
               dealCont = false;
            }
   
         }

      }

      if(playerHand.val() <= 21 && dealerHand.val() <= 21) {
         if(playerHand.val() == dealerHand.val()) {
            System.out.println("You tied with the dealer!");
            return(4);
         } else if(playerHand.val() > dealerHand.val()) {
            System.out.println("You win!");
            return(1);
         } else {
            System.out.println("You lose!");
            return(3);
         }
      }

      return 0;
   
   }

   public static void playHand(ArrayList<Hand> hands, int i, Deck deck) {
      Scanner joe = new Scanner(System.in);

      boolean cont = true;

      Hand currentHand = hands.get(i);

      while(cont){

         System.out.print("\nWould you like to (h)it or (s)tand?: ");
         char answer = joe.next().charAt(0);
         
         switch(answer) {
            case 'h' :
               cont = true;
               currentHand.dealToHand(deck.dealOne());
               currentHand.displayHand(1);
               break;
            case 's': 
               cont = false;
               System.out.println("\n");
               break;
            default: 
               cont = true;
               System.out.println("Invalid choice. Please try again: \n");
         }

         if(currentHand.val() == 21) {
            System.out.println("You have 21! Dealer's turn!\n");
            cont = false;
         } else if(currentHand.hasBusted()) {
            System.out.println("Bust! You lose!\n"); //LOSE
            cont = false;
            break;
         }

      }

      return;
   }

}
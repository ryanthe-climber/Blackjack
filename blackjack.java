/**
*blackjack.java
*Ryan Agricola
*01/04/2024
*plays black jack
*/

import java.util.ArrayList;
import java.util.Scanner;

public class blackjack {

   public static int bankBalance = 0;
 
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
      boolean again = false;
      do {
         System.out.println("\n1 - Play\n2 - Rules");
         System.out.print("Enter a number to get started: ");
         int choice = bob.nextInt();
         switch(choice) {
            case 1: 
               valid = true;
               System.out.print("How much money would you like to put in your account?: $");
               bankBalance = bob.nextInt();
               while(bankBalance <= 0) {
                  System.out.print("Invalid amount. Please enter an amount greater than zero: $");
                  bankBalance = bob.nextInt();
               }

               do {
                  System.out.println("\nBank Balance: " + bankBalance);
                  System.out.print("How much money would you like to bet?: $");
                  int bet = bob.nextInt();
                  while(bet <= 0 || bet > bankBalance) {
                     System.out.println("\nBank Balance: " + bankBalance);
                     System.out.print("Invalid bet. Please make sure your bet is positive and not greater than your current bank balance: $");
                     bet = bob.nextInt();
                  }
                  
                  playBlackjack(bet);
                  if(bankBalance < 1) {
                     System.out.println("You have no money left!\nCome back later!");
                     again = false;
                     valid = true;
                  } else {
                     System.out.print("\nWould you like to play again? (1 for yes): ");
                     int yes = bob.nextInt();
                     if(yes == 1) {
                        again = true;
                     } else {
                        again = false;
                     }
                  }
               } while(again);
               
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
   
   public static void playBlackjack(int betAmt) {

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

      Hand dealerHand = new Hand(0);
      Hand playerHand = new Hand(betAmt);
      ArrayList<Hand> hands = new ArrayList<Hand>();
      hands.add(playerHand);

      Card d1 = deck.dealOne();
      dealerHand.dealToHand(d1);

      Card d2 = deck.dealOne();
      dealerHand.dealToHand(d2);
   
      playerHand.dealToHand(deck.dealOne());

      playerHand.dealToHand(deck.dealOne());

      System.out.println("DEALER: ???");
      display.cardFace(d1);
      display.cardBack();

      boolean doPlayerHands = true;
      boolean doDealerHand = true;

      if(dealerHand.val() == 21 && playerHand.val() == 21){
         System.out.println("Both you and the dealer have Blackjack!"); //PUSH
         doPlayerHands = false;
         doDealerHand = false;

         playerHand.setOutcome(Hand.Outcome.PUSH);
      } else if(dealerHand.val() == 21) {
         System.out.println("DEALER: 21");
         display.cardFace(d1);
         display.cardFace(d2);
         System.out.println("The dealer has Blackjack!"); //LOSE
         //System.out.println("The dealer had a(n) " + d1 + " and a(n) " + d2);

         doPlayerHands = false;
         doDealerHand = false;

         playerHand.setOutcome(Hand.Outcome.LOST);
      } else if(playerHand.val() == 21) {
         doPlayerHands = false;
         doDealerHand = false;

         playerHand.setOutcome(Hand.Outcome.BLACKJACK_WIN);
      }
      
      //PLAYER TURN
      if (doPlayerHands) {
         for(int i = 0; i < hands.size(); i++) {
            Hand currentHand = hands.get(i);
            playHand(hands, i, deck);
            if(currentHand.hasBusted()) {
               currentHand.setOutcome(Hand.Outcome.LOST);
               doDealerHand = false;
            }
         }
      }

      
      //DEALER TURN

      if(doDealerHand) {
         System.out.println("DEALER TURN\n");

         System.out.println("DEALER: " + dealerHand.val());
         display.cardFace(d1);
         display.cardFace(d2);
         System.out.print("\n");

         dealerTurn(hands, dealerHand, deck);

         for(int i = 0; i < hands.size(); i++) {
            Hand currentHand = hands.get(i);
            if(currentHand.val() <= 21 && dealerHand.val() <= 21) {
               if(currentHand.val() == dealerHand.val()) {
                  
                  currentHand.setOutcome(Hand.Outcome.PUSH);
               } else if(currentHand.val() > dealerHand.val()) {
                  
                  currentHand.setOutcome(Hand.Outcome.NORMAL_WIN);
               } else {
                  
                  currentHand.setOutcome(Hand.Outcome.LOST);
               }
            }
         }
      }


      for(int i = 0; i < hands.size(); i++) {
         Hand.Outcome outcome = hands.get(i).outcome();
         switch(outcome) {
            case NORMAL_WIN:
               System.out.println("You won $" + betAmt + "!");
               bankBalance += betAmt;
               break;
            case BLACKJACK_WIN:
               System.out.println("You have Blackjack!\nYou won $" + (betAmt * 1.5) + "!"); 
               bankBalance += (betAmt * 1.5);
               break;
            case LOST:
               System.out.println("You lost $" + betAmt + "!");
               bankBalance -= betAmt;
               break;
            case PUSH:
               System.out.println("You tied with the dealer!");
               break;
            case NOT_RESOLVED:
               System.out.println("ERROR");
               break;

         }
      }

   }

   public static void playHand(ArrayList<Hand> hands, int i, Deck deck) {
      Scanner joe = new Scanner(System.in);

      boolean cont = true;

      Hand currentHand = hands.get(i);

      while(cont){

         System.out.println("HAND " + (i + 1) + ": " + currentHand.val());
         System.out.println("Current Bet: " + currentHand.bet());
         currentHand.displayHand(1);
         int answer;
         if(currentHand.canBeSplit()) {
            System.out.print("1 - HIT\n" + //
                          "2 - STAND\n" + //
                          "3 - SPLIT\n"); //
            System.out.print("Choose and option: ");
                          
            answer = joe.nextInt();
         } else {
            System.out.print("1 - HIT\n" + //
                             "2 - STAND\n");
            System.out.print("Choose and option: "); //SPLITTING DOES NOT WORK. FIX THIS
            answer = joe.nextInt();
         }
         
         
         switch(answer) {
            case 1: //Hit
               cont = true;
               currentHand.dealToHand(deck.dealOne());
               
               break;
            case 2: // Stand
               cont = false;
               System.out.println("\n");
               break;
            case 3: //Split
               cont = true;;
               Hand newHand = new Hand(currentHand.bet());
               hands.add(newHand);
               newHand.dealToHand(currentHand.split());
               newHand.dealToHand(deck.dealOne());
               currentHand.dealToHand(deck.dealOne());
               break;
               
            default: 
               cont = true;
               System.out.println("Invalid choice. Please try again: \n");
         }

         if(currentHand.val() == 21) {
            System.out.println("Hand " + (i + 1));
            currentHand.displayHand(1);
            System.out.println("You have 21! Dealer's turn!\n");
            cont = false;
         } else if(currentHand.hasBusted()) {
            System.out.println("Hand " + (i + 1));
            currentHand.displayHand(1);
            System.out.println("Bust! You lose!\n"); //LOSE
            cont = false;
            break;
         }

      }

      return;
   }

   public static void dealerTurn(ArrayList<Hand> hands, Hand dealerHand, Deck deck) {

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
            for(int i = 0; i < hands.size(); i++) {
               hands.get(i).setOutcome(Hand.Outcome.NORMAL_WIN);
            }
               
               
         } else { // DEALER STAND
            System.out.println("The dealer stands!\n");
            dealCont = false;
         }
   
      }
   }
}
/**
*blackjack.java
*Ryan Agricola
*01/05/2024
*plays black jack
*/

import java.util.ArrayList;
import java.util.Scanner;

public class blackjack {

   public static int bankBalance = 1000; //Starting balance
 
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

      int cheatCount = 0;
      boolean valid = true;
      boolean again = false;
      do {
         System.out.println("\n1 - Play\n2 - Rules");
         System.out.print("Enter a number to get started: ");
         int choice = bob.nextInt();
         switch(choice) {
            case 1: 
               valid = true;

               do {
                  
                  System.out.println("\nBank Balance: $" + bankBalance);
                  System.out.print("How much money would you like to bet?: $");
                  int bet = bob.nextInt();
                  if(bet == 8675309) { //CHEATCODE - ENTER 8675309 INTO THE BET TO GAIN $100,000
                     if (cheatCount >= 2) {
                        System.out.print("\nYou greedy little brat! $200,000 is plenty!\n");
                        bankBalance = 100;
                     } else {
                        bankBalance += 100000;
                        System.out.print("\n\nCongratulations! You found a cheatcode! Here is $100,000.\n\n");
                        bet = -1;
                        cheatCount += 1;
                     }
                  }
                  while(bet <= 0 || bet > bankBalance) {
                     System.out.println("\nBank Balance: $" + bankBalance);
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

   /**Prints out the rules of blackjack
    *@param - no parameters
    *@return - returns nothing
    */
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
   
   /**Simulates a game of blackjack with the player and the dealer
    *@param betAmt - the inputted bet for the hand
    *@return - returns nothing
    */
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

      //DO ACTION ACCORDING TO WHAT THE OUTCOME IS SET TO FOR THE HAND (WIN MONEY, LOSE MONEY)
      
      for(int i = 0; i < hands.size(); i++) {
         Hand currentHand = hands.get(i);
         Hand.Outcome outcome = currentHand.outcome();
         int bet = currentHand.bet();
         switch(outcome) {
            case NORMAL_WIN:
               System.out.println("You won $" + bet + "!\n");
               bankBalance += bet;
               break;
            case BLACKJACK_WIN:
               System.out.println("\nCurrent Bet: $" + bet + "\n");
               currentHand.displayHand(1);
               System.out.println("You have Blackjack!\nYou won $" + (bet * 1.5) + "!\n"); 
               bankBalance += (bet * 1.5);
               break;
            case LOST:
               System.out.println("You lost $" + bet + "!\n");
               bankBalance -= bet;
               break;
            case PUSH:
               System.out.println("You tied with the dealer!\n");
               System.out.println("Bank Balance: $" + bankBalance);
               break;
            case NOT_RESOLVED:
               System.out.println("\nERROR\n");
               break;

         }
      }

   }

   /**plays all of the players hands
    *@param hands - the list of hands that the player currently has
    *@param i - the current iteratioon of the for loop
    *@param deck - the Deck object that the Cards are dealt out of
    *@return - returns nothing
    */
   public static void playHand(ArrayList<Hand> hands, int i, Deck deck) {
      Scanner joe = new Scanner(System.in);

      boolean cont = true;

      Hand currentHand = hands.get(i);

      while(cont){

         System.out.println("\nHAND " + (i + 1) + ": " + currentHand.val());
         System.out.println("Current Bet: $" + currentHand.bet() + "\n");
         currentHand.displayHand(1);
         char answer;
         
         System.out.print("(h)it, (s)tand");
         if(currentHand.canBeSplit()) {
            System.out.print(", s(p)lit");
         }
         if(currentHand.canBeDoubled() && (currentHand.bet() * 2) <= bankBalance) {
            System.out.print(", (d)ouble");
         }
         System.out.print("?\n");

         System.out.print("Choose and option: ");
         
         answer = joe.next().charAt(0);
         boolean doubled = false;
         
         switch(answer) {
            case 'h': //Hit
               cont = true;
               currentHand.dealToHand(deck.dealOne());
               
               break;
            case 's': // Stand
               cont = false;
               System.out.print("\n");
               break;
            case 'p': //Split
               if(currentHand.canBeSplit()) {
                  cont = true;;
                  Hand newHand = new Hand(currentHand.bet());
                  hands.add(newHand);
                  newHand.dealToHand(currentHand.split());
                  newHand.dealToHand(deck.dealOne());
                  currentHand.dealToHand(deck.dealOne());
               } else {
                  cont = true;
                  System.out.println("Invalid choice. Please try again: \n");
               }
               
               break;
            case 'd': //Double
               if(currentHand.canBeDoubled() && (currentHand.bet() * 2) <= bankBalance) {
                  doubled = true;
                  currentHand.doubleBet();
                  currentHand.dealToHand(deck.dealOne());
                  cont = false;
               } else {
                  cont = true;
                  System.out.println("Invalid choice. Please try again: \n");
               }
               break;

            default: 
               cont = true;
               System.out.println("Invalid choice. Please try again: \n");
         }

         if(currentHand.val() == 21) {
            System.out.println("\nHAND " + (i + 1));
            currentHand.displayHand(1);
            System.out.println("You have 21! Dealer's turn!\n");
            cont = false;
         } else if(currentHand.hasBusted()) {
            System.out.println("\nHAND " + (i + 1));
            currentHand.displayHand(1);
            System.out.println("Bust! You lose!\n"); //LOSE
            cont = false;
            break;
         } else if(doubled) {
            System.out.println("\nHAND " + (i + 1));
            System.out.println("Current Bet: $" + currentHand.bet() + "\n");
            currentHand.displayHand(1);
            Delay.prompt();
         }

      }

      return;
   }

   /**plays the dealers hand
    *@param hands - the list of hands that the player currently has
    *@param dealerHand - the Hand object that store the dealers cardsd
    *@param deck - the Deck object that the Cards are dealt out of
    *@return - returns nothing
    */
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
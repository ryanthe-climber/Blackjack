/**
*Hand.java
*Ryan Agricola
*01/05/2024
*
*/
import java.util.ArrayList;

public class Hand {

    enum Outcome {
        NOT_RESOLVED,
        NORMAL_WIN,
        BLACKJACK_WIN,
        LOST,
        PUSH
    }

    private ArrayList<Card> cards;
    private int handVal;
    private int handAces;
    private boolean busted;
    private Outcome outcome;
    private int bet;

    /**constructor method for a Hand object
    *@param bet - the current bet of the hand
    *@return nothing
    */
    public Hand(int bet) {
        this.cards = new ArrayList<Card>();
        this.handVal = 0;
        this.handAces = 0;
        this.busted = false;
        this.outcome = Outcome.NOT_RESOLVED;
        this.bet = bet;
      }

    /**deals one card to a hand
    *@param card - the Card object that will be dealt to the Hand
    *@return - returns nothing
    */
    public void dealToHand(Card card) {
        this.cards.add(card);

        if(card.BJvalue() == 1) {
            this.handVal += 11;
            this.handAces += 1;
        } else {
            this.handVal += card.BJvalue();
        }

        while(this.handVal > 21 && this.handAces > 0) {
            this.handVal -= 10;
            this.handAces -= 1;
        }

        if(this.val() > 21) {
            this.busted = true;
        }

        return;
    }

    /**reutrns if the hand has busted or not
    *@param - there are no parameters
    *@return - a boolean value that determines whether or not the current hand has busted
    */
    public boolean hasBusted() {
        return this.busted;
    }

    /**returns the total value of all the cards in the current hand
    *@param - there are no parameters
    *@return - an int that is the total value of the hand
    */
    public int val() {
        return this.handVal;
    }

    /**returns the number of aces in the current hand
    *@param - there are no parameters
    *@return - an int that is the number of aces in the hand
    */
    public int numAces() {
        return this.handAces;
    }

    /**Displays the cards in a hand with ascii art
    *@param who - tells whether the hand belongs to the player or the dealer
    *@return - returns nothing
    */
    public void displayHand(int who) {
        String prefix1 = "";
        String prefix2 = "";

        if(who == 1) {
            prefix1 = "You have";
            prefix2 = "Your";
        } else if(who == 2) {
            prefix1 = "The dealer has";
            prefix2 = "The dealer's";
        }

        for(int i = 0; i < this.cards.size(); i++) {
            display.cardFace(this.cards.get(i));
        }

        /* for(int i = 0; i < this.cards.size(); i++) {
            if(i == 0)
               System.out.print(prefix1 + " a(n) " + this.cards.get(i));
            else
               System.out.print(" and a(n) " + this.cards.get(i));
        } */

        System.out.println("\n" + prefix2 + " hand total is " + this.handVal);
    }

    /**splits a hand of two cards into two seperate hands
    *@param - no parameters
    *@return a card object that has been taken from the original hand
    */
    public Card split() {
        
        Card secondCard = this.cards.get(1);
        this.cards.remove(1);

        if(secondCard.BJvalue() == 1) {
            this.handVal = 11;
            this.handAces = 1;
        } else {
            this.handVal -= secondCard.BJvalue();
        }
        
        return secondCard;
    }

    /** determines whether the current hand is splittable or not
    *@param - no parameters
    *@return a booleans that tells if it can be split or not
    */
    public boolean canBeSplit() {
        if (this.cards.size() == 2 && this.cards.get(0).value() == this.cards.get(1).value()) {
            return true;
        } else {
            return false;
        }
    }

    /**returns the outcome of the hand
    *@param - no parameters
    *@return the outcome of the current hand
    */
    public Outcome outcome() {
        return outcome;
    }

    /**Sets the outcome of the curent hand
    *@param outcome - the outcome that will be set
    *@return nothing
    */
    public void setOutcome(Outcome outcome) {
        if(this.outcome == Outcome.NOT_RESOLVED) {
            this.outcome = outcome;
        } else {
            System.out.println("\nBRUH YOU TRIED TO SET THE OUTCOME FOR THE SAME HAND TWICE\n");
        }
    }

    /**tells the curent bet amount of the hand
    *@param - no parameters
    *@return the current bet amount
    */
    public int bet() {
        return this.bet;
    }

    /**Multiplies the current bet by 2
    *@param - no paramters
    *@return nothing
    */
    public void doubleBet() {
        this.bet *= 2;
    }

    /**Tells if the hand can be doubled
    *@param - no parameters
    *@return a boolean value that determines if the hand can be doubled
    */
    public boolean canBeDoubled() {
        if (this.cards.size() == 2) {
            return true;
        } else {
            return false;
        }
    }

}

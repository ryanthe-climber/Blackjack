import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;
    private int handVal;
    private int handAces;
    private boolean busted;

    public Hand() {
        this.cards = new ArrayList<Card>();
        this.handVal = 0;
        this.handAces = 0;
        this.busted = false;
      }

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
            System.out.println("Bust! You lose!\n"); //LOSE
            this.busted = true;
        }
        
        return;
    }

    public boolean hasBusted() {
        return this.busted;
    }

    public int val() {
        return this.handVal;
    }

    public int numAces() {
        return this.handAces;
    }

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
            if(i == 0)
               System.out.print(prefix1 + " a(n) " + this.cards.get(i));
            else
               System.out.print(" and a(n) " + this.cards.get(i));
        }

        System.out.println("\n" + prefix2 + " hand total is " + this.handVal);
    }

}

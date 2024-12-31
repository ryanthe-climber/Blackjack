import java.util.Random;

public class Deck {
  private int[] myDeck = new int[52];
  
  private int cell;
  
  private static Random rand;
  
  public Deck() {
    for (byte b = 0; b < 52; b++)
      this.myDeck[b] = b; 
    this.cell = 0;
    rand = new Random();
  }
  
  public void shuffle() {
    int i = 0;
    for (byte b = 0; b < 'G'; b++) {
      int j = rand.nextInt(52);
      int k = rand.nextInt(52);
      i = this.myDeck[j];
      this.myDeck[j] = this.myDeck[k];
      this.myDeck[k] = i;
    } 
    this.cell = 0;
  }
  
  public int cardsLeft() {
    return 52 - this.cell;
  }
  
  public Card dealOne() {
    int i = 0;
    int j = 0;
    if (cardsLeft() > 0) {
      int k = this.myDeck[this.cell];
      this.cell++;
      String str1 = "";
      String str2 = "";
      switch (k / 13) {
        case 0:
          str1 = "Clubs";
          break;
        case 1:
          str1 = "Diamonds";
          break;
        case 2:
          str1 = "Hearts";
          break;
        case 3:
          str1 = "Spades";
          break;
        default:
          str1 = "NoSuit";
          break;
      } 
      if (k % 13 == 0) {
        str2 = "Ace";
        j = 1;
        i = 1;
      } else if (k % 13 < 9) {
        str2 = str2 + (char)(49 + k % 13);
        j = k % 13 + 1;
        i = k % 13 + 1;
      } else {
        j = 10;
        i = k % 13 + 1;
        switch (k % 13) {
          case 9:
            str2 = "10";
            return new Card(str1, str2, j, i);
          case 10:
            str2 = "Jack";
            return new Card(str1, str2, j, i);
          case 11:
            str2 = "Queen";
            return new Card(str1, str2, j, i);
          case 12:
            str2 = "King";
            return new Card(str1, str2, j, i);
        } 
        str2 = "NoFace";
      } 
      return new Card(str1, str2, j, i);
    } 
    System.out.println("No cards left!  You need to shuffle.");
    return new Card("NoSuit", "NoFace", j, i);
  }
}
public class Card {
  private String mySuit;
  
  private String myFace;
  
  private int myBJVal;
  
  private int myVal;
  
  public Card(String paramString1, String paramString2, int paramInt1, int paramInt2) {
    this.mySuit = paramString1;
    this.myFace = paramString2;
    this.myBJVal = paramInt1;
    this.myVal = paramInt2;
  }
  
  public String suit() {
    return this.mySuit;
  }
  
  public String face() {
    return this.myFace;
  }
  
  public int BJvalue() {
    return this.myBJVal;
  }
  
  public int value() {
    return this.myVal;
  }
  
  public String toString() {
    return face() + " of " + suit();
  }
}
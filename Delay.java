import java.util.Scanner;

public class Delay {
  public static void wait(int paramInt) {
    try {
      Thread.sleep((paramInt * 10));
    } catch (Exception exception) {}
  }
  
  public static void prompt() {
    Scanner bob = new Scanner(System.in);
    System.out.print("Hit 'C' and the <Enter> key to continue... ");
    char c = bob.next().charAt(0);
    while (c != 'c' && c != 'C') {
      System.out.print("That means the 'c' key on the keyboard and <Enter> ");
      c = bob.next().charAt(0);
    } 
  }
}
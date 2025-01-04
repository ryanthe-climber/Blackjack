public class display {

    public static void cardFace (Card card) {
        
        int cardVal = card.value();
        String suit = card.suit();

        String rank;
        if (cardVal > 1 && cardVal < 11) {
            rank = Integer.toString(cardVal);
        } else {
            switch(cardVal) {
                case 1:
                    rank = "A";
                    break;
                case 11:
                    rank = "J";
                    break;
                case 12:
                    rank = "Q";
                    break;
                case 13:
                    rank = "K";
                    break;
                default:
                    rank = "ERROR";
            }
        }
        String suitSymbol;

        switch(suit) {
            case "Clubs":
                suitSymbol = "♣";
                break;
            case "Diamonds":
                suitSymbol = "♦";
                break;
            case "Hearts":
                suitSymbol = "♥";
                break;
            case "Spades":
                suitSymbol = "♠";
                break;
            default:
                suitSymbol = "ERROR";
        }

        String rank_right;
        String rank_left;

        if (rank.equals("10")){ //Ten is the only rank with two digits
            rank_right = rank;
            rank_left = rank;
        } else {
            rank_right = (rank + " ");
            rank_left = (" " + rank);
        }
        

        String top = ("┌─────────┐");
        String bottom = ("└─────────┘");
        String side = ("│         │");
        String suit_line = ("│    " + suitSymbol + "    │");
        String rank_line_left = ("│" + rank_left + "       │");
        String rank_line_right = ("│       " + rank_right + "│");

        System.out.println(top);
        System.out.println(rank_line_left);
        System.out.println(side);
        System.out.println(suit_line);
        System.out.println(side);
        System.out.println(rank_line_right);
        System.out.println(bottom);

    }

    public static void cardBack () {
        System.out.println(//
                        "┌─────────┐\n" + //
                        "│_|___|___│\n" + //
                        "│___|___|_│\n" + //
                        "│_|___|___│\n" + //
                        "│___|___|_│\n" + //
                        "│_|___|___│\n" + //
                        "└─────────┘");

        /* BLANK CARD FOR ADITIONAL PATTERNS IF WANTED
        
        System.out.println(//
                        "┌─────────┐\n" + //
                        "│         │\n" + //
                        "│         │\n" + //
                        "│         │\n" + //
                        "│         │\n" + //
                        "│         │\n" + //
                        "└─────────┘") */


    }

}

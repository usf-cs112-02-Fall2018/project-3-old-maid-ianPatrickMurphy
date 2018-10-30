import java.util.*;

public class OldMaid {

    public static void main(String[] args){

        ArrayList<OldMaidPlayer> players = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Please input the number of players: ");

        int numOfPlayers = Integer.parseInt(scan.nextLine());

        OldMaidHand handler = new OldMaidHand(numOfPlayers);

        for(int i = 0; i < numOfPlayers; i++) {

            System.out.println("Please input Player #" + (i + 1)
                    + "'s name: ");
            OldMaidPlayer temp = new OldMaidPlayer(scan.nextLine());
            players.add(temp);

        }

        System.out.println(handler.getCardFromList(0,0));

        System.out.println("Displaying Player's Hands: ");
        for(int i = 0; i < numOfPlayers; i++){

            displayPlayerDeck(i, handler, players.get(i));

        }

        System.out.println("Removing all pairs in all player's hands... ");
        for(int i = 0; i < numOfPlayers; i++){

            removingPairs(i, handler, players.get(i));

        }

        System.out.println("Displaying Player's Hands: ");
        for(int i = 0; i < numOfPlayers; i++){

            displayPlayerDeck(i, handler, players.get(i));

        }



    }

    public static void displayPlayerDeck(int playerNum, OldMaidHand handler, OldMaidPlayer player){

        System.out.println(player.getName() + "'s Hand: ");
        System.out.println(handler.getArrayList(playerNum) + "\n");

    }

    public static void removingPairs(int playerNum, OldMaidHand handler, OldMaidPlayer player) {

        String tempCard1, tempCard2;
        ArrayList<Card> tempArray = new ArrayList<>();
        Card tempCardObj1 = new Card();
        Card tempCardObj2 = new Card();

        for (int i = 0; i < handler.getArrayList(playerNum).size();i++) {

            for (int j = 0; j < handler.getArrayList(playerNum).size();j++) {

                tempCard1 = removeRankOfCard(handler.getArrayList(playerNum).get(i).toString());
                tempCard2 = removeRankOfCard(handler.getArrayList(playerNum).get(j).toString());

                tempCardObj1 = handler.getArrayList(playerNum).get(i);
                tempCardObj2 = handler.getArrayList(playerNum).get(j);

                if (i != j) {

                    if (tempCard1.equals(tempCard2)) {

                        handler.getArrayList(playerNum).remove(tempCardObj1);
                        handler.getArrayList(playerNum).remove(tempCardObj2);

                    }

                    else{

                    }
                }
            }
        }
    }

    public static String removeRankOfCard(String input){

        String clubs = " of Clubs";
        String hearts = " of Hearts";
        String spades = " of Spades";
        String diamonds = " of Diamonds";

        input = input.replace(clubs, "");
        input = input.replace(hearts, "");
        input = input.replace(spades, "");
        input = input.replace(diamonds, "");

        return input;

    }

}

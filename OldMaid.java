import java.util.*;

public class OldMaid {

    public static void main(String[] args) {

        ArrayList<OldMaidPlayer> players = new ArrayList<>();
        ArrayList<OldMaidPlayer> winnerPlayers = new ArrayList<>();
        Boolean iAvoider;
        Scanner scan = new Scanner(System.in);
        OldMaid staticMethodAvoider = new OldMaid();
        int tempInt = 0;
        int playerResetter = 0;
        OldMaidPlayer taker = new OldMaidPlayer("temp");
        OldMaidPlayer giver = new OldMaidPlayer("temp");

        System.out.println("!! PLEASE ENTER ALL NUMBERS AS INTEGERS !!");
        System.out.println("!! AS USING LETTERS WILL CRASH THE GAME !!");
        System.out.println("Please input the number of players: ");

        int numOfPlayers = Integer.parseInt(scan.nextLine());
        int truePlayerNum = numOfPlayers;
        OldMaidHand handler = new OldMaidHand(numOfPlayers);

        System.out.println("\n");
        //Assigns the name of each player
        for (int i = 0; i < numOfPlayers; i++) {

            System.out.println("Please input Player #" + (i + 1)
                    + "'s name: ");
            OldMaidPlayer temp = new OldMaidPlayer(scan.nextLine());
            players.add(temp);


        }

        System.out.println("\n");
        //Displays the hand that each player has been dealt
        System.out.println("Displaying Player's Hands: ");
        for (int i = 0; i < numOfPlayers; i++) {

            staticMethodAvoider.displayPlayerDeck(i, handler, players.get(i));

        }

        System.out.println("\n");
        //Checks and removes each pair from each player's hand, printing pairs
        //as the pairs are removed.
        System.out.println("Removing all pairs in all player's hands... ");
        for (int i = 0; i < numOfPlayers; i++) {

            staticMethodAvoider.removingPairs(i, handler, players.get(i));
            System.out.println("\n");

        }

        //Game Begins

        while (true) {

            while (true) {

                numOfPlayers = truePlayerNum;

                System.out.println("\n");
                //Displaying Players Hands after pairs have been removed
                System.out.println("Displaying Player's Hands: ");
                for (int i = 0; i < numOfPlayers; i++) {

                    try{

                        if(handler.getArrayList(i).size() != 0) {

                            staticMethodAvoider.displayPlayerDeck(i, handler, players.get(i));

                        }
                    }

                    catch(IndexOutOfBoundsException e){



                    }

                }

                System.out.println("\n");
                //Shuffling Players Hands
                System.out.println("Shuffling Player's Hands...");
                for (int i = 0; i < numOfPlayers; i++) {

                    try {

                        if (handler.getArrayList(i).size() != 0) {

                            handler.shuffleHand(i);

                        }
                    }

                    catch(IndexOutOfBoundsException e){



                    }
                }

                System.out.println("\n");
                //Allow Players to Pick Cards
                //and check for pairs after each exchange

                for (int i = 0; i < numOfPlayers;) {

                    numOfPlayers = players.size();
                    iAvoider = false;

                    try {


                        if (i < numOfPlayers - 1) {

                            taker = players.get(i);
                            giver = players.get(i + 1);

                        } else {

                            taker = players.get(i);
                            giver = players.get(0);

                        }
                    }
                    catch(IndexOutOfBoundsException e){

                        taker = players.get(i-1);
                        giver = players.get(0);

                    }

                    if(handler.getArrayList(players.indexOf(giver)).size() != 0) {

                        System.out.println("!! PLEASE ENTER ALL NUMBERS AS INTEGERS !!");
                        System.out.println("!! AS USING LETTERS WILL CRASH THE GAME !!");
                        System.out.println(players.get(players.indexOf(taker)).getName()
                                + ", please enter which card you with to take"
                                + " from " + players.get(players.indexOf(giver)).getName() + "'s Hand. ");
                        System.out.println("Choose between numbers 0 through "
                                + handler.getArrayList(players.indexOf(giver)).size()
                                + ", excluding " + handler.getArrayList(players.indexOf(giver)).size() + ":");

                        tempInt = Integer.parseInt(scan.nextLine());
                    }

                    else{

                        tempInt = 0;

                    }

                    try {

                        handler.addCardToList(i, handler.getCardFromList(players.indexOf(giver), tempInt));

                    }

                    catch(IndexOutOfBoundsException e){



                    }
                    ////
                    try {

                        handler.removeCardFromList(players.indexOf(giver), tempInt);

                    }

                    catch(IndexOutOfBoundsException e){



                    }

                    System.out.println("Removing any new pairs from "
                            + players.get(players.indexOf(taker)).getName() + "'s Hand...");
                    staticMethodAvoider.removingPairs(i, handler, taker);

                    for(int j = 0; j < numOfPlayers-1; j++) {

                        try
                        {
                            if (handler.getArrayList(j+1).size() == 0) {

                                winnerPlayers.add(players.get(j+1));
                                players.remove(j+1);
                                handler.removePlayerHand(j+1);
                                iAvoider = true;

                            }
                        }

                        catch(IndexOutOfBoundsException e){

                        }

                        try {
                            if (handler.getArrayList(j).size() == 0) {

                                winnerPlayers.add(players.get(j));
                                players.remove(j);
                                handler.removePlayerHand(j);
                                iAvoider = true;
                                break;

                            }
                        }

                        catch(IndexOutOfBoundsException e){

                        }
                    }

                    if(players.size() == 1){

                        break;

                    }

                    if(!iAvoider){

                        i++;

                    }
                }

                if(players.size() == 1){

                    break;

                }
            }

            System.out.println("\n");
            staticMethodAvoider.endGameResults(players, winnerPlayers);

            System.out.println("Would you like to play again? y/n");
            String temperString = scan.nextLine();
            if(temperString.equals("0") || temperString.equals("y")){

                //Reset Game for Another Game

                handler = new OldMaidHand(truePlayerNum);
                playerResetter = winnerPlayers.size();

                for(int i = 0; i < playerResetter;i++){

                    players.add(winnerPlayers.get(i-i));
                    winnerPlayers.remove(i-i);

                }

            }

            else{

                break;

            }

        }
    }

    public void endGameResults(ArrayList<OldMaidPlayer> players, ArrayList<OldMaidPlayer> winnerPlayers){

        System.out.println("Game Over");
        System.out.println("\n");

        winnerPlayers.get(0).won();
        winnerPlayers.get(0).setPoints(2);

        System.out.println("Winner: " + winnerPlayers.get(0).getName());
        System.out.println("Winner's Score: " + winnerPlayers.get(0).getPoints());
        System.out.println("\n");

        for(int i = 1; i < winnerPlayers.size(); i++){

            winnerPlayers.get(i).setPoints(1);
            System.out.println("Non-Loser: " + winnerPlayers.get(i).getName());
            System.out.println("Non-Loser's Score: " + winnerPlayers.get(i).getPoints());
            System.out.println("\n");

        }

        players.get(0).lost();
        players.get(0).setPoints(0);

        System.out.println("Loser: " + players.get(0).getName());
        System.out.println("Loser's Score: " + players.get(0).getPoints());
        System.out.println("\n");

    }

    public void displayPlayerDeck(int playerNum, OldMaidHand handler, OldMaidPlayer player){

        System.out.println(player.getName() + "'s Hand: ");
        System.out.println(handler.getArrayList(playerNum));

    }

    public void removingPairs(int playerNum, OldMaidHand handler, OldMaidPlayer player) {

        String tempCard1, tempCard2;
        Boolean breaking = false;
        ArrayList<Card> tempArray = new ArrayList<>();
        Card tempCardObj1 = new Card();
        Card tempCardObj2 = new Card();

        for (int i = 0; i < handler.getArrayList(playerNum).size();) {

            breaking = false;

            for (int j = 0; j < handler.getArrayList(playerNum).size();j++) {

                tempCard1 = removeRankOfCard(handler.getArrayList(playerNum).get(i).toString());
                tempCard2 = removeRankOfCard(handler.getArrayList(playerNum).get(j).toString());

                tempCardObj1 = handler.getArrayList(playerNum).get(i);
                tempCardObj2 = handler.getArrayList(playerNum).get(j);

                if (i != j) {

                    if (tempCard1.equals(tempCard2)) {

                        handler.getArrayList(playerNum).remove(tempCardObj1);
                        handler.getArrayList(playerNum).remove(tempCardObj2);

                        breaking = true;

                        System.out.println("Removed " + tempCardObj1
                        + " from " + player.getName());
                        System.out.println("Removed " + tempCardObj2
                                + " from " + player.getName());

                    }

                    else{

                    }
                }
            }
            if(!breaking){
                i++;
            }
        }
    }

    public String removeRankOfCard(String input){

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

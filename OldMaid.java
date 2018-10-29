import java.util.*;

public class OldMaid {

    public static void main(String[] args){

        ArrayList<String> playerNames = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Please input the number of players: ");

        int numOfPlayers = Integer.parseInt(scan.nextLine());

        for(int i = 0; i < numOfPlayers; i++){

            System.out.println("Please input Player #" + (i+1)
            + "'s name: ");
            playerNames.add(scan.nextLine());

        }

        /*
        for(String ele : playerNames){

            System.out.println(ele);

        }
        */

        OldMaidHand handler = new OldMaidHand(numOfPlayers);

    }
}

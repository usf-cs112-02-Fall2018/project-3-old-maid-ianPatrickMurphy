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

    }
}

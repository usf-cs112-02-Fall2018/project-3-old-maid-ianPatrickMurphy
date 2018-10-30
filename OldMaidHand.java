import java.util.*;

public class OldMaidHand extends Deck {

    protected ArrayList<ArrayList<Card>> allPlayerHands = new ArrayList<>();
    Random rand = new Random();

    public OldMaidHand(int playerNum){

        super();
        removeFirstCard();
        shuffleDeck();
        dealAllHands(playerNum);

    }

    public Card removeCardFromList(int playerNum, int cardInt){

        return allPlayerHands.remove(playerNum).remove(cardInt);

    }

    public Card getCardFromList(int playerNum, int cardInt){

        return allPlayerHands.get(playerNum).get(cardInt);

    }

    public ArrayList<Card> getArrayList(int input){

        return allPlayerHands.get(input);

    }

    public void setArrayList(int input, ArrayList<Card> inputArray){

        allPlayerHands.set(input, inputArray);

    }

    public void shuffleDeck(){

        ArrayList<Card> temp = new ArrayList<Card>();

        for(int i = 0; i < super.stack.size(); i++){

            temp.add(super.stack.get(rand.nextInt(super.stack.size())));

        }

        super.stack = temp;

    }

    public void removeFirstCard(){

        super.stack.remove(rand.nextInt(super.stack.size()));

    }

    public void dealAllHands(int playerNum){

        int tempInt;
        ArrayList<Card> temp;

        for(int i = 0; i < playerNum; i++){

            temp = new ArrayList<Card>();
            allPlayerHands.add(temp);

        }

        for(int i = 0; i < super.stack.size();){

            for(int j = 0; j < playerNum; j++){

                if(super.stack.size() > 0) {

                    tempInt = rand.nextInt(super.stack.size());

                    allPlayerHands.get(j).add(super.stack.get(tempInt));
                    super.stack.remove(tempInt);
                    super.size--;

                }
            }
        }

        /*
        System.out.println(allPlayerHands);
        for(int i = 0; i < allPlayerHands.size(); i++){

            System.out.println(allPlayerHands.get(i).size());

        }
        */
    }

}

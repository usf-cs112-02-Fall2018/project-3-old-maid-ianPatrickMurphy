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

    public void removePlayerHand(int playerNum){

        allPlayerHands.remove(playerNum);

    }

    public void removeCardFromList(int playerNum, int cardInt){

        allPlayerHands.get(playerNum).remove(cardInt);

    }

    public void removeCardFromList(int playerNum, Card cardEle){

        allPlayerHands.get(playerNum).remove(cardEle);

    }

    public Card getCardFromList(int playerNum, int cardInt){

        return allPlayerHands.get(playerNum).get(cardInt);

    }

    public void addCardToList(int playerNum, int cardInt, Card cardEle){

        allPlayerHands.get(playerNum).add(cardInt, cardEle);

    }

    public void addCardToList(int playerNum, Card cardEle){

        allPlayerHands.get(playerNum).add(cardEle);

    }

    public ArrayList<Card> getArrayList(int input){

        return allPlayerHands.get(input);

    }

    public void setArrayList(int input, ArrayList<Card> inputArray){

        allPlayerHands.set(input, inputArray);

    }

    public void shuffleHand(int playerNum){

        ArrayList<Card> temp = new ArrayList<Card>();
        int tempInt = 0;
        int initialArraySize = allPlayerHands.get(playerNum).size();

        for(int i = 0; i < initialArraySize; i++){

            tempInt = rand.nextInt(allPlayerHands.get(playerNum).size());
            temp.add(allPlayerHands.get(playerNum).get(tempInt));
            allPlayerHands.get(playerNum).remove(allPlayerHands.get(playerNum).get(tempInt));

        }

        allPlayerHands.set(playerNum, temp);

    }

    public void shuffleDeck(){

        ArrayList<Card> temp = new ArrayList<Card>();
        int tempInt = 0;

        for(int i = 0; i < 51; i++){

            tempInt = rand.nextInt(super.stack.size());
            temp.add(super.stack.get(tempInt));
            super.stack.remove(super.stack.get(tempInt));

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

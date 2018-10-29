public class Deck extends CardStack{

    public Deck(){

        super();
        Card temp;

        for (int i = 1; i < 5; i++){

            for (int j = 1; j < 14; j++){

                temp = new Card(j,i);
                super.stack.add(temp);
            }

        }

    }

}

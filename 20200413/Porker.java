import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/12 16:35
 */

public class Porker {
    static class Card{
        public String suit;
        public String rank;

        public Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return String.format("%s%s",suit, rank);
        }
    }
}
//构建一副
public static List<Card> buyPork(){
    String[] suit = {"♥","♠","♣","♦"};
    List<Card> pork = new ArrayList<>();
    for(int i = 0 ; i < 4; i++){
        for(int j = 0; j<=10 ; j++){
            Card card = new Card(suit[i],String.valueOf(i));
            pork.add(card);
        }
        pork.add(new Card(suit[i],"J"));
        pork.add(new Card(suit[i],"Q"));
        pork.add(new Card(suit[i],"K"));
        pork.add(new Card(suit[i],"A"));
    }
    return pork;
}



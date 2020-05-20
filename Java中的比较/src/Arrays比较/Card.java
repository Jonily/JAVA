package Arrays比较;


import java.util.Arrays;
import java.util.Comparator;

public class Card {
    public String rank; // 数值
    public String suit; // 花色

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int convertRank() {
        //把String类型的rank转成int值
        //2-10 =》2-10
        //J-A => 11-14
        if ("A".equals(rank)) {
            return 14;
        }
        if ("K".equals(rank)) {
            return 13;
        }
        if ("Q".equals(rank)) {
            return 12;
        }
        if ("J".equals(rank)) {
            return 11;
        }
        return Integer.parseInt(rank);
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}
    class CardComparator implements Comparator<Card> {
        @Override
        public int compare(Card o1, Card o2) {
            int rank1 = o1.convertRank();
            int rank2  = o2.convertRank();
            return rank1 - rank2;//根据数值升序
            //return rank2 - rank1;//根据数值降序
        }
        public static void main(String[] args) {
            Card[] cards = new Card[3];
            cards[0] = new Card("A","♥");
            cards[1] = new Card("2","♥");
            cards[2] = new Card("J","♥");
            CardComparator cardComparator = new CardComparator();
            Arrays.sort(cards,cardComparator);
            System.out.println(Arrays.toString(cards));
        }
}


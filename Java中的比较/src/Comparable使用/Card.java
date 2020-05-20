package Comparable使用;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card implements Comparable<Card> {
    public String rank; // 数值
    public String suit; // 花色

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card o) {
        //对this 和 o 进行比较
        //如果this < o ,返回 < 0
        //如果this > o ,返回 > 0
        //如果this 和 o 相等 ,返回 0
        //定义比较规则：扑克牌的点数进行比较
        int rank1 = this.convertRank();
        int rank2 = o.convertRank();
        return rank1 - rank2;//升序
        //return rank2 - rank1;//降序
    }
    public int convertRank(){
        //把String类型的rank转成int值
        //2-10 =》2-10
        //J-A => 11-14
        if("A".equals(rank)){
            return 14;
        }
        if("K".equals(rank)){
            return 13;
        }
        if("Q".equals(rank)){
            return 12;
        }
        if("J".equals(rank)){
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

    public static void main(String[] args) {
        Card card1 = new Card("1","♥");
        Card card2 = new Card("1","♥");
        Card card3 = new Card("A","♥");
        Card o = card1;

        System.out.println(card1.compareTo(card2)); // 0
        System.out.println(card1.compareTo(card3)); // -13   A定义为数字14 // 1-14=-13

        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card("A","♥"));
        cardList.add(new Card("K","♥"));
        cardList.add(new Card("2","♥"));
        cardList.add(new Card("J","♥"));
        cardList.add(new Card("10","♥"));
        Collections.sort(cardList);
        System.out.println(cardList);
    }
}


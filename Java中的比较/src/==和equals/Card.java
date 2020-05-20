



public class Card {
    public int rank; // 数值
    public String suit; // 花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || !(o instanceof Card)){
            return false;
        }

        Card card = (Card)o;
        return rank == card.rank
                && suit.equals(card.suit);
    }

    public static void main(String[] args) {
        Card card1 = new Card(1,"♥");
        Card card2 = new Card(1,"♥");
        Card o = card1;

        System.out.println(card1 == o); //true
        System.out.println(card1 == card2); //false

        System.out.println(card1.equals(o));  //true
        System.out.println(card1.equals(card2)); //true
    }
}

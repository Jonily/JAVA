import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/12 16:35
 */




//创建扑克，模拟洗牌 发牌
public class Porker {
    //不加static的内部类我们创建Card对象的时候必须要依靠porker实例才能创建
    //加上static 我们创建Card对象时可以不用依赖Porker的实例，就可以在porker的静态方法中创建实例
    static class Card{
        public String suit;
        public String rank;

        public Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public String toString() {
            //return "("+suit+rank+")";
            //String.format静态方法，可以像c语言中的printf一样构造格式化字符串
            return String.format("（%s%s）",suit, rank);
        }
    }
    //构建一副
    public static List<Card> buyPorker(){
        String[] suit = {"♥","♠","♣","♦"};
        List<Card> porker = new ArrayList<>();
        for(int i = 0 ; i < 4; i++){//处理四种花色
            for(int j = 2; j<=10 ; j++){//2-10
                Card card = new Card(suit[i],String.valueOf(j));//""+j
                porker.add(card);
            }
            porker.add(new Card(suit[i],"J"));
            porker.add(new Card(suit[i],"Q"));
            porker.add(new Card(suit[i],"K"));
            porker.add(new Card(suit[i],"A"));
        }
        return porker;
    }
    public static void shuffle(List<Card> Porker){
        //从后往前遍历List，每次取到一个和前面的的一个随机位置的牌交换
        Random random = new Random();
        for(int i = Porker.size() - 1; i > 0 ; i--){
            //随机产生一个[0,i)随机数
            int r = random.nextInt(i);
            swap(Porker,i,r);
        }
    }
    private static void swap(List<Card>Porker,int i , int j){
        Card tmp = Porker.get(i);
        Porker.set(i,Porker.get(j));
        Porker.set(j,tmp);
    }

    public static void main(String[] args) {
        //1、创建牌
        List<Card> Porker = buyPorker();
        //2、洗牌
        shuffle(Porker);
        //Collections.shuffle(Porker);
        System.out.println(Porker);
        //3、发牌，把牌发给三个玩家，每人五张
        //通过嵌套List表示
        // 每个玩家的手牌是一个List。多个玩家的手牌再放到一个List,每个玩家自己是一个List用来放手牌
        List<List<Card>> players = new ArrayList<List<Card>>();
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());

        //轮流发牌一人一张
        for( int cardIndex = 0 ; cardIndex < 5 ; cardIndex++){
            for(int playersIndex = 0; playersIndex < 3 ; playersIndex++){
                //获取玩家
                List<Card> player = players.get(playersIndex);
                //把porker中的最上面的牌给当前玩家
                Card topCard = Porker.remove(0);
                player.add(topCard);

            }

        }

        //4、展示手牌比大小
        System.out.println("玩家1 的手牌：");
        System.out.println(players.get(0));
        System.out.println("玩家2 的手牌：");
        System.out.println(players.get(1));
        System.out.println("玩家3 的手牌：");
        System.out.println(players.get(2));
        System.out.println("发牌后的牌堆：");
        System.out.println(Porker);













    }
}



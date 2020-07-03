
public class OneZeroBag {
    //此处不考虑第一行和第一列都为0的情况，所以下标直接从1开始，数组开辟也多加1
    public static int solution(int W, int N, int[] weights, int[] values){
        int[][] map = new int[W+1][N+1];
        //定义二维数组 W表示容量行  N表示数量的列
        for (int i = 1; i <= N ; i++) {
            int value = values[i-1];//取当前物品的的价值
            int weight = weights[i-1];//取当前物品的容量
            for (int j = 1 ; j <= W ; j++) {
                if(j < weight){
                    //剩余容量不足以放入最后一个
                    map[j][i]  = map[j][i-1];
                    continue;
                }
                //取放入和不放入两个的价值的较大值
                map[j][i] = Math.max(map[j-weight][i-1]+value,map[j][i-1]);

            }
        }
        int a = map[W][N];
        return a;
    }

    public static void main(String[] args) {
        //物品的重量
        int[] weight = {2,3,4,5};
        //物品价值
        int[] value = {3,4,5,6};
        //背包容量
        int BagWeight = 8;
        //物品数量
        int Num = 4;
        System.out.println("最大价值为："+solution(8,4,weight,value));
    }

}

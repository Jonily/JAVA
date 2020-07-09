package 风口的猪中国牛市;
public class Solution {
    /**
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */

    public int calculateMax(int[] prices){
        int firstBuy = Integer.MAX_VALUE;//第一次买入的右区间
        int firstSell = 0;//第一次卖出的利润
        int secondBuyOfsell = Integer.MIN_VALUE;//第二次买入的左区间
        int secondSell = 0;//第二卖出的利润
        for (int p: prices) {
            //第一次买入的要越低越好
            firstBuy = Math.min(firstBuy,p);
            //第一次卖出的利润,当前的价格-第一次买的要越大越好
            firstSell = Math.max(firstSell,p-firstBuy);
            //用第一次卖出去的钱来第二次买入后剩余的钱的要越大越好
            secondBuyOfsell = Math.max(secondBuyOfsell,firstSell - p);
            //第二次卖出的钱+第一次用来第二次买入后剩余的钱要越大越好
            secondSell = Math.max(secondSell,secondBuyOfsell+p);
        }
        return secondSell;
    }
}
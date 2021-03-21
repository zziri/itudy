class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            if (minPrice > price) {
                minPrice = price;
            } else {
                if (maxProfit < price - minPrice) {
                    maxProfit = price - minPrice;
                }
            }
        }
        
        return maxProfit;
    }
}

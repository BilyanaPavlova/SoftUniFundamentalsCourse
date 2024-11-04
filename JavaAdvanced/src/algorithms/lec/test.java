package algorithms.lec;

public class test {

    //I have a target sum of 18 and I have a bunch of coin values. How to find the minimum number of coins and values I need to reach the target?
    //I have coins with values 1, 2, 5
    //I need to find the minimum number of coins I need to reach the target sum of 18
    //I can use each coin as many times as I want
    //I can use the same coin multiple times

public static void main(String[] args) {
        int targetSum = 9;
        int[] coins = {1, 2, 5};

        int[] dp = new int[targetSum + 1];
        dp[0] = 0;

        for (int i = 1; i <= targetSum; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        System.out.println(dp[targetSum]);

        //print how many coins of each value are used to reach the target sum

        int sum = targetSum;
        while (sum > 0) {
            for (int coin : coins) {
                if (sum - coin >= 0 && dp[sum] == dp[sum - coin] + 1) {
                    System.out.print(coin + " ");
                    sum -= coin;
                    break;
                }
            }
        }
    }

}

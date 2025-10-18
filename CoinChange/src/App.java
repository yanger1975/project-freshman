import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class App {
    static List<Integer> result;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        result = new ArrayList<Integer>();
        //int[] coins = { 186,419,83,408 };
        //int amount = 6249;  // answer: 20

        int[] coins = { 7, 5 };
        int amount = 11;

        Arrays.sort(coins);
        int result = coinChangeDP(coins, amount);

        System.out.println("result= " + result);
    }

    public static int coinChange(int[] coins, int amount) {
        int i = 0;
        int result = -1;

        if (coins == null || coins.length == 0) {
            return -1;
        }
        
        if (amount == 0) {
            return 0;
        }

        if (amount < coins[0]) {
            return -1;
        }

        for (i = coins.length - 1; i >= 0; i--) {
            int j = coinChange(coins, amount - coins[i]);

            if (j != -1) {
                result = j + 1;

                System.out.println("  Using coin: " + coins[i]);
                break;
            }

        }

        return result;
    }

    public static int coinChangeDP(int[] coins, int amount) {
        int i = 0;
        int result = -1;

        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount+ 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (i = 1; i <= amount; i++)
        {
            //int min = -1;
            for (int coin : coins)
            {
                if (i >= coin && dp[i-coin] < amount+1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }

            }
            //dp[i] = min;
        }

        return dp[amount]==amount+1 ? -1: dp[amount];

    }
}

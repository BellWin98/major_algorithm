import java.util.Arrays;

public class DPCoinProblem {
    public static void main(String[] args) {
        int[] coins = {1, 4, 5};
        int amount = 13;
        // 최소 동전의 개수 산출
        int answer = 0;
        int[] dp = new int[amount + 1];
        dp[1] = 1;
        // i: 최소 동전 값
        for (int i = 2; i <= amount; i++) {
            int min = amount;
            for (int c : coins) {
                if (i - c < 0) {
                    continue;
                }
                if (dp[i - c] < min) {
                    min = dp[i - c];
                }
            }
            dp[i] = min + 1;
        }
        System.out.println(Arrays.toString(dp));
    }
}

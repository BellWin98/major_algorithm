import java.util.Arrays;

public class GreedyCoinProblem {
    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25};
        int amount = 99;
        int count  = 0;

        // 최소 동전의 개수 산출
        Arrays.sort(coins);
        int i = coins.length - 1;
        while (amount > 0){
            if (coins[i] > amount){
                i--;
                continue;
            }
            amount -= coins[i];
            count++;
        }

        // 강사님 풀이
        int answer = 0;
        for (int k = coins.length - 1; k >= 0; k--){
            int temp = amount / coins[k];
            answer += temp;
            amount -= temp * coins[k];
        }
        System.out.println(count);
        System.out.println(answer);
    }
}

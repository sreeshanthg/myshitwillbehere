public class Knapsack {
    
    public static int solveKnapsack(int W, int[] w, int[] v, int n) {
        int[] dp = new int[W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = W; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int[] v = {60, 100, 120}, w = {10, 20, 30};
        System.out.println("Maximum value (0/1 Knapsack) = " + solveKnapsack(50, w, v, 3));
    }
}
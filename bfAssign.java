public class bfAssign {
    static int minCost = Integer.MAX_VALUE;

    public static void solve(int[][] c, boolean[] a, int w, int cost) {
        if (w == c.length) minCost = Math.min(minCost, cost);
        else for (int i = 0; i < c.length; i++) {
            if (!a[i]) { a[i] = true; solve(c, a, w + 1, cost + c[w][i]); a[i] = false; }
        }
    }

    public static void main(String[] args) {
        int[][] c = {{9, 2, 7}, 
                    {6, 4, 3},
                     {5, 8, 1}};
        solve(c, new boolean[c.length], 0, 0);
        System.out.println("Minimum Assignment Cost: " + minCost);
    }
}
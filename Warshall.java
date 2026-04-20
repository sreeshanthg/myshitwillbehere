import java.util.Arrays;

public class Warshall {
    public static void findTransitiveClosure(int[][] g) {
        int n = g.length;
        
        // Compute transitive closure in-place using bitwise operations
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) g[i][j] |= (g[i][k] & g[k][j]);
            }
        }
        
        System.out.println("Transitive Closure:");
        for (int[] row : g) System.out.println(Arrays.toString(row));
    }

    public static void main(String[] args) {
        int[][] g = {{1, 1, 0, 1}, {0, 1, 1, 0}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        findTransitiveClosure(g);
    }
}
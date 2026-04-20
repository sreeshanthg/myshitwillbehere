import java.util.Arrays;

public class LUD {

    // Modifies matrix A in-place to contain both L and U
    public static void decompose(double[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            // Calculate U (stored on and above diagonal)
            for (int k = i; k < n; k++) {
                for (int j = 0; j < i; j++) A[i][k] -= A[i][j] * A[j][k];
            }
            // Calculate L (stored below diagonal)
            for (int k = i + 1; k < n; k++) {
                for (int j = 0; j < i; j++) A[k][i] -= A[k][j] * A[j][i];
                A[k][i] /= A[i][i];
            }
        }
    }

    public static void main(String[] args) {
        double[][] A = {{2, -1, -2}, {-4, 6, 3}, {-4, -2, 8}};
        
        decompose(A);
        
        // Print the combined L/U matrix
        for (double[] row : A) {
            System.out.println(Arrays.toString(row));
        }
    }
}
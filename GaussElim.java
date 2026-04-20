public class GaussElim {

    public static double[] solve(double[][] A, double[] B) {
        int n = B.length;
        double[] x = new double[n];

        // 1. Forward Elimination (Modifies A and B in-place)
        for (int p = 0; p < n; p++) {
            for (int i = p + 1; i < n; i++) {
                double factor = A[i][p] / A[p][p];
                B[i] -= factor * B[p];
                for (int j = p; j < n; j++) A[i][j] -= factor * A[p][j];
            }
        }

        // 2. Back Substitution
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) sum += A[i][j] * x[j];
            x[i] = (B[i] - sum) / A[i][i];
        }

        return x;
    }

    public static void main(String[] args) {
        double[][] A = {{2, 1, -1}, {-3, -1, 2}, {-2, 1, 2}};
        double[] B = {8, -11, -3};
        
        for (double val : solve(A, B)) System.out.printf("%.4f\n", val);
    }
}
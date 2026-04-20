import java.util.Arrays;

public class GreedyKnapsack {
    public static void main(String[] args) {
        int[] w = {10, 20, 30}, v = {60, 100, 120};
        double c = 50, tv = 0, items[][] = new double[w.length][2];
        
        for (int i = 0; i < w.length; i++) items[i] = new double[]{w[i], v[i]};
        
        // Sort directly by calculating the ratio on the fly
        Arrays.sort(items, (a, b) -> Double.compare(b[1] / b[0], a[1] / a[0]));

        for (double[] i : items) {
            if (c >= i[0]) { c -= i[0]; tv += i[1]; } 
            else { tv += i[1] * (c / i[0]); break; }
        }

        System.out.println("Maximum value we can obtain = " + tv);
    }
}
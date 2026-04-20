public class RabinKarp {
    public static void search(String p, String t, int q) {
        int m = p.length(), n = t.length(), d = 256, hp = 0, ht = 0, h = 1, i = 0, j;
        
        // Calculate the multiplier (h) and initial hashes for pattern and text
        for (; i < m; i++) {
            if (i < m - 1) h = (h * d) % q;
            hp = (d * hp + p.charAt(i)) % q;
            ht = (d * ht + t.charAt(i)) % q;
        }
        
        // Slide the window
        for (i = 0; i <= n - m; i++) {
            if (hp == ht) {
                for (j = 0; j < m && t.charAt(i + j) == p.charAt(j); j++);
                if (j == m) System.out.println("Pattern found at index " + i);
            }
            // Rolling hash with inline negative modulo correction
            if (i < n - m) ht = ((d * (ht - t.charAt(i) * h) + t.charAt(i + m)) % q + q) % q;
        }
    }

    public static void main(String[] args) {
        search("GEEK", "GEEKS FOR GEEKS", 101);
    }
}
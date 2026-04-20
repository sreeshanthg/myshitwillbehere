import java.util.Arrays;

public class Horspool {
    public static int search(String t, String p) {
        int n = t.length(), m = p.length(), i = m - 1, s[] = new int[256];
        if (m == 0) return 0;
        
        Arrays.fill(s, m);
        for (int j = 0; j < m - 1; j++) s[p.charAt(j)] = m - 1 - j;
        
        while (i < n) {
            int k = 0;
            while (k < m && p.charAt(m - 1 - k) == t.charAt(i - k)) k++;
            if (k == m) return i - m + 1;
            i += s[t.charAt(i)];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Pattern found at index: " + search("TRUST_HARD_WORK", "HARD"));
    }
}
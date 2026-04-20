public class KMP {
    public static void search(String p, String t) {
        int m = p.length(), n = t.length(), lps[] = new int[m], i = 1, j = 0, len = 0;
        
        // Compute LPS array
        while (i < m) {
            if (p.charAt(i) == p.charAt(len)) lps[i++] = ++len;
            else if (len > 0) len = lps[len - 1];
            else i++;
        }
        
        // Search text
        for (i = 0, j = 0; i < n; ) {
            if (p.charAt(j) == t.charAt(i)) { j++; i++; }
            if (j == m) { 
                System.out.println("Pattern found at index " + (i - j)); 
                j = lps[j - 1]; 
            } else if (i < n && p.charAt(j) != t.charAt(i)) { 
                if (j > 0) j = lps[j - 1]; else i++; 
            }
        }
    }

    public static void main(String[] args) {
        search("ABABCABAB", "ABABDABACDABABCABAB");
    }
}
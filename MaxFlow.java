public class MaxFlow {
    static boolean bfs(int[][] r, int s, int t, int[] p) {
        int n = r.length, q[] = new int[n], head = 0, tail = 0;
        boolean[] vis = new boolean[n];
        q[tail++] = s; vis[s] = true;
        
        while (head < tail) {
            int u = q[head++];
            for (int v = 0; v < n; v++) {
                if (!vis[v] && r[u][v] > 0) {
                    p[v] = u; vis[v] = true; q[tail++] = v;
                    if (v == t) return true;
                }
            }
        }
        return false;
    }

    public static int fordFulkerson(int[][] r, int s, int t) {
        int p[] = new int[r.length], mf = 0;
        
        while (bfs(r, s, t, p)) {
            int flow = Integer.MAX_VALUE;
            for (int v = t; v != s; v = p[v]) flow = Math.min(flow, r[p[v]][v]);
            for (int v = t; v != s; v = p[v]) { r[p[v]][v] -= flow; r[v][p[v]] += flow; }
            mf += flow;
        }
        return mf;
    }

    public static void main(String[] args) {
        int[][] g = { 
            {0, 16, 13, 0, 0, 0}, {0, 0, 10, 12, 0, 0}, {0, 4, 0, 0, 14, 0}, 
            {0, 0, 9, 0, 0, 20}, {0, 0, 0, 7, 0, 4}, {0, 0, 0, 0, 0, 0}
        };
        System.out.println("The maximum possible flow is " + fordFulkerson(g, 0, 5));
    }
}
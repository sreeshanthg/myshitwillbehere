public class LongMulti {
    public static long multiply(long x, long y) {
        if (x < 10 || y < 10) return x * y;
        int h = Math.max((x + "").length(), (y + "").length()) / 2;
        long p = (long) Math.pow(10, h), a = x / p, b = x % p, c = y / p, d = y % p;
        long z0 = multiply(b, d), z2 = multiply(a, c);
        return z2 * p * p + (multiply(a + b, c + d) - z2 - z0) * p + z0;
    }

    public static void main(String[] args) {
        System.out.println("Product: " + multiply(1234, 5678));
    }
}
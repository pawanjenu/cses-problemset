import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.*;
import java.util.*;

// https://cses.fi/problemset/task/1084
class Solution {

    static final File ip = new File("input.txt");
    static final File op = new File("output.txt");
    static FastReader in;

    // If You Are Running Your Code
    // in Sublime Text then set The
    // System Out to output.txt and
    // Input Stream to input.txt
    // otherwise leave it as standard
    // ones for ONLINE JUDGE
    static {
        if (System.getProperty("ONLINE_JUDGE") == null) {
            try {
                System.setOut(new PrintStream(op));
                System.setIn(new FileInputStream(ip));
            } catch (Exception e) {
            }
        }
        in = new FastReader();
    }

    /***
     * Write your code in this function! Input: Use InputReader "in" for reading
     * data. Output: Use System.out.println() to write output to file
     */
    private static void solve() {
        int n = in.nextInt();
        int m = in.nextInt();
        long k = in.nextLong();
        long[] applicants = new long[n];
        long[] apt_price = new long[m];

        for (int i = 0; i < n; i++)
            applicants[i] = in.nextLong();

        for (int i = 0; i < m; i++)
            apt_price[i] = in.nextLong();

        sortL(applicants);
        sortL(apt_price);

        int i = 0, j = 0, ans = 0;
        while (i < n && j < m) {
            if (Math.abs(applicants[i] - apt_price[j]) <= k){
                ans++;
                i++;
                j++;
            }
            else if (applicants[i] > apt_price[j])
                j++;
            else
                i++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    /**
     * A class for Fast Input
     */
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public boolean hasNext() {
            return false;
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }

    static void sortL(long[] arr) {
        int n = arr.length;
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            long tmp = arr[i];
            int randomPos = i + rnd.nextInt(n - i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
        Arrays.sort(arr);
    }
}
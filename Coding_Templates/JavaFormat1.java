import org.json.JSONArray;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.stream.Stream;

@SuppressWarnings("Duplicates")
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
    }

    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    /**
     * A class for Fast Input
     */
    @SuppressWarnings("unused")
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

        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }
    }

    @SuppressWarnings("unused")
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

    @SuppressWarnings("unused")
    static void sortI(int[] arr) {
        int n = arr.length;
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            int tmp = arr[i];
            int randomPos = i + rnd.nextInt(n - i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
        Arrays.sort(arr);
    }

    @SuppressWarnings("unused")
    static void sortD(double[] arr) {
        int n = arr.length;
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            double tmp = arr[i];
            int randomPos = i + rnd.nextInt(n - i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
        Arrays.sort(arr);
    }
    @SuppressWarnings("unused")
    static int upperBound(ArrayList<Integer> arr, int key) {//returns closest upper or equal value
        int low = 0, high = arr.size()-1, mid = 0,index;
        while (low <= high) {
            mid = low + (high - low) / 2; //essential
            if (arr.get(mid) <= key) {
                low = mid + 1;
            } else if (arr.get(mid) > key) {
                high = mid - 1;
            } else {
                return mid+1;
            }
        }
        index = (arr.get(mid) > key)?mid:(mid + 1);//upper bound index
        return (index <arr.size())?index:-1;//closest upper or equal value
    }

    @ParameterizedTest
    @MethodSource("generateData")
    public void testSolution(int[] nums,  int output) {
//        int result = new Solution().maxSubArray(nums);
//        assertSame(output, result);
    }
    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6)
        );
    }
    public static int[][] convertString2DArray(String input) {

        JSONArray array = new JSONArray(input);
        int n = array.length();
        int m = array.getJSONArray(0).length();
        int[][] op = new int[n][m];
        for (int i = 0; i < n; i++) {
            JSONArray innerArray = array.getJSONArray(i);
            Object[] ob = innerArray.toList().toArray();
            for (int j = 0; j < innerArray.length(); j++) {
                op[i][j] = (int) ob[j];
            }

        }
        return op;

    }

    public static int[] convertString1DArray(String input) {

        JSONArray array = new JSONArray(input);
        Object[] ob = array.toList().toArray();
        int[] arr = new int[array.length()];
        for (int i = 0; i < array.length(); i++) {
            arr[i] = (int) ob[i];
        }
        return arr;
    }
}
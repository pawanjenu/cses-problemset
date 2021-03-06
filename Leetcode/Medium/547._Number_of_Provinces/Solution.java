import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertSame;

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
    private static void solve() throws IOException {

    }

    public int findCircleNum2(int[][] isConnected) {
        // BFS approach
        int n = isConnected.length;
        int[] visited = new int[n];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++){
            if (visited[i] == 0){
                queue.add(i);
                while (!queue.isEmpty()){
                    int node = queue.remove();
                    visited[node] = 1;
                    for (int j = 0; j < n; j++){
                        if (isConnected[node][j] == 1 && visited[j] == 0){
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, int[] visited, int node){
        for (int j = 0; j < isConnected.length; j++){
            if (isConnected[node][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(isConnected, visited, j);
            }
        }
    }
    public int findCircleNum3(int[][] isConnected) {
        // DFS approach
        int count = 0;
        int n = isConnected.length;
        int[] visited  = new int[n];
        for (int i = 0; i < isConnected.length; i++){
            if (visited[i] == 0){
                visited[i] = 1;
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    public int find(int[] parent, int node){
        return parent[node] == 0 ? node : find(parent, parent[node]);
    }
    public void union(int[] parent, int x, int y){
        int xpar = find(parent, x);
        int ypar = find(parent, y);

        if (xpar != ypar){
            parent[xpar] = ypar;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (isConnected[i][j] == 1 && i != j){
                    union(parent, i, j);
                }
            }
        }
        for (int i = 0; i < n; i++){
            if (parent[i] == -1)
                count++;
        }
        return count;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        solve();
    }

    /**
     * A class for Fast Input
     */
    static class FastReader {

        private final int BUFFER_SIZE = 1 << 24;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[1001]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }

        int[] fillIntegerArray(int n) throws IOException {
            int[] array = new int[n];
            for (int i = 0; i < n; i++)
                array[i] = nextInt();
            return array;
        }

        long[] fillLongArray(int n) throws IOException {
            long[] array = new long[n];
            for (int i = 0; i < n; i++)
                array[i] = nextLong();
            return array;
        }

        <T extends List<Long>> T fillList(T list, int n) throws IOException {
            for (int i = 0; i < n; i++)
                list.add(nextLong());
            return list;
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

    @ParameterizedTest
    @MethodSource("generateData")
    public void testSolution(int[][] nums, int output) {
        int result = new Solution().findCircleNum(nums);
        assertSame(output, result);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(new int[][]{{1,1,0}, {1,1,0}, {0,0,1}}, 2)
        );
    }
}
import java.io.IOException;
import java.io.File;
import java.io.*;
import java.util.*;

@SuppressWarnings({"Duplicates"})
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
        int n = in.nextInt();
        StringBuffer res = new StringBuffer();
        ArrayList<Integer> children = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            children.add(i);
        }
        // initially the start index = 1
        // choose kids from index 1
        int start = 1;
        while (!children.isEmpty()) {
            // increase there's only one kid left, add it to result and break the loop
            if (children.size() == 1) {
                res.append(children.get(0));
                break;
            }
            ArrayList<Integer> survivors = new ArrayList<>();
            // if start index is 1, that means the 0th survives and won't be chosen
            // add to add 0th kid to survivors and remove him from childeren
            // so that looping through children is easy next line 58
            if (start == 1) {
                survivors.add(children.get(0));
                children.remove(0);
            }
            for (int i = 0; i < children.size(); i++) {
                // choose the every 2nd kid
                if (i % 2 == 0) {
                    res.append(children.get(i)).append(" ");
                } else
                    survivors.add(children.get(i));
            }

            // in case no survivors, break the loop
            if (survivors.isEmpty()) {
                break;
            } else {
                // the start index for next loop can be either 0, 1
                // based on below condition
                // consider 1, 2, 3, 4, 5
                // in first loop, 2, 4 are chosen and surviors have (1, 3, 5) in next loop 1 (0th index is chosen)
                // so in short if children's last element = surviors last element
                // in next iteration start index will be 0
                // in case they are not equal start index will be 0.

                // basically if last kid is chosen, in next loop the start index will be 1
                // in case last kid is not chose, the start index will be 0.
                start = !Objects.equals(children.get(children.size() - 1), survivors.get(survivors.size() - 1)) ? 1 : 0;
            }
            children = survivors;

        }
        System.out.println(res);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        solve();
    }

    /**
     * A class for Fast Input
     */
    @SuppressWarnings("unused")
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

}
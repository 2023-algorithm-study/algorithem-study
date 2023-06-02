package BFS;

import java.io.*;
import java.util.*;

public class 최송희_1697 {
    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int arr[];
    static int count = 0;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[100001];

        queue.add(n);
        arr[n] = 0;
        if (n != m) {
            if (n > m) {
                System.out.println(n - m);
                return;
            } else if (n < m) {
                bfs();
            }
        } else if (n == m) {
            System.out.println(1);
            return;
        }

        System.out.println(arr[m]);
    }

    static void bfs() {

        while (!queue.isEmpty()) {
            int rest = queue.poll();
            if(rest == m){
                return;
            }
            int backOne = rest - 1;
            int frontOne = rest + 1;
            int twiceOne = rest * 2;
            if (backOne < 0 || frontOne >= 100001 || twiceOne >= 100001)
                continue;
            if (arr[backOne] == 0) {
                arr[backOne] = arr[rest] + 1;
                queue.add(backOne);
            }
            if (arr[frontOne] == 0) {
                arr[frontOne] = arr[rest] + 1;
                queue.add(frontOne);
            }
            if (arr[twiceOne] == 0) {
                arr[twiceOne] = arr[rest] + 1;
                queue.add(twiceOne);
            }
        }
    }
}

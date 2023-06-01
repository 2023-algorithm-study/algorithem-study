package BFS;

import java.io.*;
import java.util.*;

public class 최송희_24444 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static StringTokenizer st;
    static int n, m, v, count;
    static ArrayList<Integer>[] list;
    static boolean visited[];
    static int visitedNum[];
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        visitedNum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for(int i=1;i<=n;i++){
            Collections.sort(list[i]);
        }

        visited[v] = true;
        queue.add(v);
        bfs();

        for(int i=1;i<=n;i++){
            System.out.println(visitedNum[i]);
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int num = queue.poll();
            count++;
            visitedNum[num] = count;
            for (int i = 0; i < list[num].size(); i++) {
                if (visited[list[num].get(i)] == false) {
                    queue.add(list[num].get(i));
                    visited[list[num].get(i)]=true;
                }
            }
        }
    }
}
package BFS;

import java.io.*;
import java.util.*;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 최송희_7562 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int testcase, size, goalX, goalY;
    static Queue<Pair> queue = new LinkedList<>();
    static boolean visited[][];
    static int distance[][];
    static int dirX[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
    static int dirY[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static void main(String[] args) throws Exception {
        testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (testcase-- > 0) {
            size = Integer.parseInt(br.readLine());

            visited = new boolean[size][size];
            distance = new int[size][size];

            
            queue.clear();

            st = new StringTokenizer(br.readLine());
            st.
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            visited[x][y] = true;
            queue.add(new Pair(x, y));

            st = new StringTokenizer(br.readLine());
            goalX = Integer.parseInt(st.nextToken());
            goalY = Integer.parseInt(st.nextToken());

            sb.append(dfs()).append("\n");
        }
        
        System.out.println(sb);
    }

    static int dfs() {
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for(int i=0;i<dirX.length;i++){
                int nowX=pair.x+dirX[i];
                int nowY=pair.y+dirY[i];

                if(nowX<0 || nowX>=size || nowY<0 || nowY>=size) continue;
                if(visited[nowX][nowY] == false && distance[nowX][nowY] == 0){
                    visited[nowX][nowY] = true;
                    distance[nowX][nowY] = distance[pair.x][pair.y] + 1;
                    queue.add(new Pair(nowX, nowY));
                }

                if(nowX == goalX && nowY == goalY){
                    return distance[nowX][nowY];
                }
            }
        }
        return 0;
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Spot {
   int x, y;
   
   public Spot(int x, int y) {
      this.x = x;
      this.y = y;
   }
}

public class _2178 {

   static int[][] arr;
   static boolean[][] visited;
   static int N, M;
   static int[] dx = new int[] { 0, 0, 1, -1 };
   static int[] dy = new int[] { 1, -1, 0, 0 };
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      
      arr = new int[N][M];
      visited = new boolean[N][M];
      
      for (int i = 0; i < N; i++) {
         String s = br.readLine();
         for (int j = 0; j < M; j++) {
            arr[i][j] = s.charAt(j) - '0';
         }
      }
      
      visited[0][0] = true;
      bfs(0, 0);
      
      bw.write(arr[N - 1][M - 1] + "");
      bw.flush();
      bw.close();
   }
   
   
   public static void bfs(int x, int y) {
      Queue<Spot> queue = new LinkedList<>();
      queue.offer(new Spot(x, y));

      while (!queue.isEmpty()) {
         Spot s = queue.poll();
         int nowX = s.x;
         int nowY = s.y;
         
         for (int i = 0; i < 4; i++) {
            int X = nowX + dx[i];
            int Y = nowY + dy[i];
            
            if (X < 0 || Y < 0 || X >= M || Y >= N) continue;
            if (visited[Y][X] || arr[Y][X] == 0) continue;
            
            arr[Y][X] = arr[nowY][nowX] + 1;
            visited[Y][X] = true;
            
            queue.offer(new Spot(X, Y));
         }
      }
   }

}
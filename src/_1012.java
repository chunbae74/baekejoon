import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/* 
 * T : 케이스 개수
 * M : 가로길이
 * N : 세로길이
 * K : 배추의 개수
 */
public class _1012 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			
			// 배추 위치 map에 표시하기
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				map[Y][X] = 1;
			}
			
//			int count = bfs(M, N);
			int count = dfs(M, N);
			sb.append(count).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	/*
	 * map = new int[N][M];
	 */
	public static int bfs(int M, int N) {
		Queue<Spot> queue = new LinkedList<>();
		// 필요한 지렁이 개수
		int count = 0;
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (visited[y][x] || map[y][x] == 0) continue;
				
				queue.offer(new Spot(x, y));
				visited[y][x] = true;
				count ++;
				
				while (!queue.isEmpty()) {
					Spot s = queue.poll();
					int nowX = s.x;
					int nowY = s.y;
					
					for (int i = 0; i < 4; i++) {
						int nextX = nowX + dx[i];
						int nextY = nowY + dy[i];
						
						if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
						if (visited[nextY][nextX] || map[nextY][nextX] == 0) continue;
						
						queue.offer(new Spot(nextX, nextY));
						visited[nextY][nextX] = true;
					}
				} // while문 끝
			}
		} // 이중for문 끝
		
		return count;
	}
	
	
	/*
	 * map = new int[N][M];
	 */
	public static int dfs(int M, int N) {
		Stack<Spot> stack = new Stack<>();
		// 필요한 지렁이 개수
		int count = 0;
		
		for (int x = 0; x < M; x++) {
			for (int y = 0; y < N; y++) {
				if (visited[y][x] || map[y][x] == 0) continue;
				
				stack.add(new Spot(x, y));
				visited[y][x] = true;
				count ++;
				
				while (!stack.isEmpty()) {
					Spot s = stack.pop();
					int nowX = s.x;
					int nowY = s.y;
					
					for (int i = 0; i < 4; i++) {
						int nextX = nowX + dx[i];
						int nextY = nowY + dy[i];
						
						if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
						
						if (visited[nextY][nextX] || map[nextY][nextX] == 0) continue;
						
						stack.add(new Spot(nextX, nextY));
						visited[nextY][nextX] = true;
					}
				} // while문 끝
			}
		} // 이중for 문 끝
		
		return count;
	}
}

class Spot {
	   int x, y;
	   
	   public Spot(int x, int y) {
	      this.x = x;
	      this.y = y;
	   }
	}



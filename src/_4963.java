import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 입력 첫째줄 : 가로 세로
 * 1 : 땅
 * 0 : 바다
 */
public class _4963 {
	static int X, Y;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			
			if (X == 0 && Y == 0) break;
			
			map = new int[Y][X];
			visited = new boolean[Y][X];
			
			for (int y = 0; y < Y; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < X; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			int order = 0;
			for (int y = 0; y < Y; y++) {
				for (int x = 0; x < X; x++) {
					if (visited[y][x] || map[y][x] == 0) continue;
					bfs(x, y);
					order ++;
				}
			}
			sb.append(order).append("\n");
			
		} //while문 끝
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	
	}
	
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		visited[y][x] = true;
		
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			queue.poll();
			
			for (int i = 0; i < 8; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= X || nextY >= Y) continue;
				if (visited[nextY][nextX] || map[nextY][nextX] == 0) continue;
				
				visited[nextY][nextX] = true;
				queue.offer(new int[] { nextX, nextY });
			}
		}
	}

}

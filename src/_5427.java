import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int INF = Integer.MAX_VALUE >> 1;
		final int[] dx = new int[] { 0, 0, 1, -1 };
		final int[] dy = new int[] { 1, -1, 0, 0 };
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			Queue<int[]> queue = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int Y = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			/*
			 * -1 : 벽 (#)
			 * 0 : 빈공간 (.)
			 * 1 : 불 (*)
			 */
			int[][] graph = new int[Y][X];
			int[][] dist = new int[Y][X];
			int startX = -1;
			int startY = -1;
			for (int y = 0; y < Y; y++) {
				String l = br.readLine();
				for (int x = 0; x < X; x++) {
					dist[y][x] = INF;
					char c = l.charAt(x);
					if (c == '#') {
						graph[y][x] = -1;
					} else if (c == '@') {
						startX = x;
						startY = y;
						graph[y][x] = 0;
					} else if (c == '.') {
						graph[y][x] = 0;
					} else if (c == '*') {
						graph[y][x] = 1;
						queue.offer(new int[] { x, y });
					}
				}
			}
			
			dist[startY][startX] = 0;
			queue.offer(new int[] { startX, startY });
			while (!queue.isEmpty()) {
				int nowX = queue.peek()[0];
				int nowY = queue.peek()[1];
				queue.poll();
				
				for (int i = 0; i < 4; i++) {
					int nextX = nowX + dx[i];
					int nextY = nowY + dy[i];
					
					if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y) continue;
				}
			}
		}
	}

}

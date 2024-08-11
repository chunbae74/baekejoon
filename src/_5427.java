import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		final int INF = Integer.MAX_VALUE >> 1;
		final int[] dx = new int[] { 0, 0, 1, -1 };
		final int[] dy = new int[] { 1, -1, 0, 0 };
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			Queue<int[]> queue = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			/*
			 * -1 : 벽 (#)
			 * 0 : 빈공간 (.)
			 * 1 : 불 (*)
			 */
			int[][] graph = new int[Y][X];
			int[][] distOfFire = new int[Y][X];
			int[][] distOfPlayer = new int[Y][X];
			int startX = -1;
			int startY = -1;
			for (int y = 0; y < Y; y++) {
				String l = br.readLine();
				for (int x = 0; x < X; x++) {
					distOfFire[y][x] = distOfPlayer[y][x] = INF;
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
						distOfFire[y][x] = 0;
						queue.offer(new int[] { x, y, distOfFire[y][x] });
					}
				}
			}
			
			while (!queue.isEmpty()) {
				int nowX = queue.peek()[0];
				int nowY = queue.peek()[1];
				int nowCost = queue.peek()[2];
				queue.poll();
				
				if (distOfFire[nowY][nowX] < nowCost) continue;
				
				for (int i = 0; i < 4; i++) {
					int nextX = nowX + dx[i];
					int nextY = nowY + dy[i];
					
					if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y) continue;
					if (graph[nextY][nextX] == -1) continue;
					if (distOfFire[nextY][nextX] > nowCost + 1) {
						distOfFire[nextY][nextX] = nowCost + 1;
						queue.offer(new int[] { nextX, nextY, distOfFire[nextY][nextX] });
					}
				}
			}
			
			queue.clear();
			distOfPlayer[startY][startX] = 0;
			queue.offer(new int[] { startX, startY, distOfPlayer[startY][startX] });
			while (!queue.isEmpty()) {
				int nowX = queue.peek()[0];
				int nowY = queue.peek()[1];
				int nowCost = queue.peek()[2];
				queue.poll();
				
				if (distOfPlayer[nowY][nowX] < nowCost) continue;
				
				for (int i = 0; i < 4; i++) {
					int nextX = nowX + dx[i];
					int nextY = nowY + dy[i];
					
					if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y) continue;
					if (graph[nextY][nextX] == -1) continue;
					
					if (distOfFire[nextY][nextX] <= nowCost + 1) continue;
					
					if (distOfPlayer[nextY][nextX] > nowCost + 1) {
						distOfPlayer[nextY][nextX] = nowCost + 1;
						queue.offer(new int[] { nextX, nextY, distOfPlayer[nextY][nextX] });
					}
				}
			}
			
			int min = INF;
			// 상, 하
			for (int x = 0; x < X; x++) {
				min = Math.min(min, Math.min(distOfPlayer[0][x], distOfPlayer[Y - 1][x]));
			}
			// 좌, 우
			for (int y = 1; y < Y - 1; y++) {
				min = Math.min(min, Math.min(distOfPlayer[y][0], distOfPlayer[y][X - 1]));
			}
			
			sb.append(min == INF ? "IMPOSSIBLE" : min + 1).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}

}

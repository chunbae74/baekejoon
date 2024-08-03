import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int INF = Integer.MAX_VALUE >> 1;
		final int[] dx = new int[] { 0, 0, 1, -1 };
		final int[] dy = new int[] { 1, -1, 0, 0 };
		
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[][] map = new int[Y][X];
		int[][][] dist = new int[Y][X][2];

		for (int y = 0; y < Y; y++) {
			String input = br.readLine();
			for (int x = 0; x < X; x++) {
				Arrays.fill(dist[y][x], INF);
				map[y][x] = input.charAt(x) - '0';
			}
		}
		
		dist[0][0][0] = 1;
		
		// { x, y, idx, nowCost }
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0, 0, dist[0][0][0] });
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			int idx = queue.peek()[2];
			int nowCost = queue.peek()[3];
			queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y) continue;
				int nextCost = nowCost + 1;
				
				// 다음이 벽이고, 아직 안부쉈다면
				if (map[nextY][nextX] == 1 && idx == 0) {
					if (dist[nextY][nextX][1] > nextCost) {
						dist[nextY][nextX][1] = nextCost;
						queue.offer(new int[] { nextX, nextY, 1, nextCost });
					}
				} else if (map[nextY][nextX] == 0) {
					if (dist[nextY][nextX][idx] > nextCost) {
						dist[nextY][nextX][idx] = nextCost;
						queue.offer(new int[] { nextX, nextY, idx, nextCost });
					}
				}
			}
		}
		
		if (dist[Y - 1][X - 1][0] == INF && dist[Y - 1][X - 1][1] == INF) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(dist[Y - 1][X - 1][0], dist[Y - 1][X - 1][1]));
		}
	}

}

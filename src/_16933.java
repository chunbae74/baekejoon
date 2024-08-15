import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16933 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE >> 1;
		final int[] dx = new int[] { 0, 0, 1, -1 };
		final int[] dy = new int[] { 1, -1, 0, 0 };
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] graph = new int[Y][X];
		/*
		 * 0 : 낮
		 * 1 : 밤
		 */
		int[][][][] dist = new int[Y][X][K + 1][2];
		for (int y = 0; y < Y; y++) {
			String l = br.readLine();
			for (int x = 0; x < X; x++) {
				graph[y][x] = l.charAt(x) - '0';
				for (int k = 0; k <= K; k++) {
					Arrays.fill(dist[y][x][k], INF);
				}
			}
		}
		
		// { x, y, k, isNight, dist[y][x][k][isNight] }
		Queue<int[]> queue = new LinkedList<>();
		dist[0][0][0][0] = 1;
		queue.offer(new int[] { 0, 0, 0, 0, dist[0][0][0][0] });
		int min = INF;
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			int nowK = queue.peek()[2];
			int nowDay = queue.peek()[3];
			int nowCost = queue.peek()[4];
			queue.poll();
			if (dist[nowY][nowX][nowK][nowDay] < nowCost) continue;
			
			if (nowK > K) continue;
			
			if (nowX == X - 1 && nowY == Y - 1) {
				min = Math.min(min, nowCost);
				continue;
			}
			
			for (int i = 0; i < dx.length; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				int nextDay = (nowDay == 0) ? 1 : 0;
				int nextCost = nowCost + 1;
				
				if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y) continue;
				
				if (graph[nextY][nextX] == 0) {
					if (dist[nextY][nextX][nowK][nextDay] > nextCost) {
						dist[nextY][nextX][nowK][nextDay] = nextCost;
						queue.offer(new int[] { nextX, nextY, nowK, nextDay, nextCost });
					}
					
				} else if (graph[nextY][nextX] == 1) {
					// 지금이 밤이라면
					if (nowDay == 1) {
						dist[nowY][nowX][nowK][0] = nextCost;
						nextDay = 1;
						nextCost += 1;
					}
					int nextK = nowK + 1;
					if (nextK > K) continue;
					
					if (dist[nextY][nextX][nextK][nextDay] > nextCost) {
						dist[nextY][nextX][nextK][nextDay] = nextCost;
						queue.offer(new int[] { nextX, nextY, nextK, nextDay, nextCost });
					}
				}
			}
			
		}
		System.out.println(min == INF ? -1 : min);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4179 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final boolean isDebug = false;
		final int INF = Integer.MAX_VALUE >> 1;
		final int[] dx = { 1, -1, 0, 0 };
		final int[] dy = { 0, 0, 1, -1 };
		Queue<int[]> queue = new LinkedList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		/*
		 * -1 : 벽 (#) 0 : 빈공간 (.) 1 : 불이 난 공간(F)
		 */
		int[][] graph = new int[Y][X];
		int[][] distOfFire = new int[Y][X];
		int[][] distOfJihoon = new int[Y][X];
		int startX = -1;
		int startY = -1;
		for (int y = 0; y < Y; y++) {
			String l = br.readLine();
			for (int x = 0; x < X; x++) {
				distOfFire[y][x] = distOfJihoon[y][x] = INF;
				char c = l.charAt(x);
				if (c == '#') {
					graph[y][x] = -1;
				} else if (c == '.') {
					graph[y][x] = 0;
				} else if (c == 'J') {
					startX = x;
					startY = y;
					graph[y][x] = 0;
				} else if (c == 'F') {
					graph[y][x] = 1;
					distOfFire[y][x] = 0;
					queue.add(new int[] { x, y, distOfFire[y][x] });
				}
			}
		}

		// 불 번짐 계산
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			int nowCost = queue.peek()[2];
			queue.poll();

			if (distOfFire[nowY][nowX] < nowCost)
				continue;

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y)
					continue;

				if (graph[nextY][nextX] == -1)
					continue;
				if (distOfFire[nextY][nextX] > nowCost + 1) {
					distOfFire[nextY][nextX] = nowCost + 1;
					queue.offer(new int[] { nextX, nextY, nowCost + 1 });

				}
			}
		}

		queue.clear();
		distOfJihoon[startY][startX] = 0;
		queue.offer(new int[] { startX, startY, distOfJihoon[startY][startX] });
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			int nowCost = queue.peek()[2];
			queue.poll();

			if (distOfFire[nowY][nowX] < nowCost)
				continue;

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y)
					continue;

				if (graph[nextY][nextX] == -1)
					continue;
				// 불이 이미 번졌거나, 이번 턴에 붙을 예정인 곳은 갈 수 없다.
				if (distOfFire[nextY][nextX] <= nowCost + 1)
					continue;
				if (distOfJihoon[nextY][nextX] > nowCost + 1) {
					distOfJihoon[nextY][nextX] = nowCost + 1;
					queue.offer(new int[] { nextX, nextY, nowCost + 1 });

				}
			}
		}

		if (isDebug) {
			for (int y = 0; y < Y; y++) {
				for (int x = 0; x < X; x++) {
					int num = distOfJihoon[y][x];
					System.out.print(num == INF ? "-" : num);
				}
				System.out.println();
			}
		}

		int min = INF;
		// 상, 하
		for (int x = 0; x < X; x++) {
			min = Math.min(Math.min(distOfJihoon[Y - 1][x], distOfJihoon[0][x]), min);
		}
		// 좌, 우
		for (int y = 1; y < Y - 1; y++) {
			min = Math.min(Math.min(distOfJihoon[y][0], distOfJihoon[y][X - 1]), min);
		}

		System.out.println(min == INF ? "IMPOSSIBLE" : min + 1);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 반례ㅣ
 * https://www.acmicpc.net/board/view/110305
 * https://www.acmicpc.net/board/view/118858
 */
public class _16920 {
	final static boolean isDebug = false;

	static final int[] dx = new int[] { 1, -1, 0, 0 };
	static final int[] dy = new int[] { 0, 0, 1, -1 };

	static int X, Y, P;
	static int[] sArr;
	static int[][] dist;
	static int[] ans;
	static int left;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		sArr = new int[P + 1];
		dist = new int[Y][X];
		ans = new int[P + 1];
		left = X * Y;

		st = new StringTokenizer(br.readLine());
		for (int p = 1; p <= P; p++) {
			sArr[p] = Integer.parseInt(st.nextToken());
		}

		for (int y = 0; y < Y; y++) {
			String l = br.readLine();
			for (int x = 0; x < X; x++) {
				char c = l.charAt(x);
				if (c == '.') {
					dist[y][x] = 0;
				} else if (c == '#') {
					dist[y][x] = -1;
					left--;
				} else {
					int player = c - '0';
					dist[y][x] = player;
					ans[player]++;
					left--;
				}
			}
		}

		int nowPlayer = 1;
		int notMovingPlayerCount = 0;
		while (left > 0) {
			boolean result = bfs(nowPlayer);
			if (result) {
				notMovingPlayerCount = 0;
			} else {
				notMovingPlayerCount ++;
			}
			
			if (notMovingPlayerCount == P) break;
			
			nowPlayer++;
			if (nowPlayer > P)
				nowPlayer = 1;

			if (isDebug) {
				for (int y = 0; y < Y; y++) {
					for (int x = 0; x < X; x++) {
						int num = dist[y][x];
						if (num == -1) {
							System.out.print("# ");
						} else
							System.out.print((num == 0 ? "-" : num) + " ");
					}
					System.out.println();
				}
				System.out.println("\n\n");
			}
		}

		for (int p = 1; p <= P; p++) {
			sb.append(ans[p]).append(" ");
		}

		System.out.println(sb.toString());
	}

	public static boolean bfs(int player) {
		Queue<int[]> queue = new LinkedList<>();
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				if (dist[y][x] == player) {
					queue.offer(new int[] { x, y, 0 });
				}
			}
		}
		
		boolean isMove = false;
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			int nowCost = queue.peek()[2];
			queue.poll();

			if (nowCost >= sArr[player])
				continue;

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y)
					continue;

				if (dist[nextY][nextX] != 0)
					continue;

				dist[nextY][nextX] = player;
				left--;
				ans[player]++;
				isMove = true;
				if (nowCost + 1 < sArr[player]) {
					queue.offer(new int[] { nextX, nextY, nowCost + 1 });
				}
			}
		}
		
		return isMove;
	}
}

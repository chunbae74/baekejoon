import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _29733 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		final int[] dx = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
		final int[] dy = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };

		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] arr = new int[H][Y][X];
		// { x, y, h }
		Queue<int[]> queue = new LinkedList<>();

		for (int h = 0; h < H; h++) {
			for (int y = 0; y < Y; y++) {
				String input = br.readLine();
				for (int x = 0; x < X; x++) {
					char c = input.charAt(x);
					if (c == '*') {
						queue.offer(new int[] { x, y, h });
						arr[h][y][x] = -1;
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			int nowH = queue.peek()[2];
			queue.poll();

			for (int nextH = nowH - 1; nextH <= nowH + 1; nextH++) {
				for (int i = 0; i < dx.length; i++) {
					int nextX = nowX + dx[i];
					int nextY = nowY + dy[i];

					if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y || 0 > nextH || nextH >= H)
						continue;
					
					if (arr[nextH][nextY][nextX] != -1) {
						arr[nextH][nextY][nextX] = (arr[nextH][nextY][nextX] + 1) % 10;
					}
				}
			}
		}

		for (int h = 0; h < H; h++) {
			for (int y = 0; y < Y; y++) {
				for (int x = 0; x < X; x++) {
					sb.append(arr[h][y][x] == -1 ? "*" : arr[h][y][x]);
				}
				sb.append("\n");
			}
		}

		System.out.println(sb.toString());
	}

}

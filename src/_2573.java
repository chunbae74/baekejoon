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
 * 두 덩어리 이상으로 분리되는 최초의 시간 구하기
 * 전부 다 녹을 때까지 두 덩어리 이상으로 분리되지 않으면 0 출력
 */
public class _2573 {
	static int X, Y;
	static int[][] map;

	static final int[] dx = { 0, 0, 1, -1 };
	static final int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[Y][X];

		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		int day = 0;
		while (true) {
			int count = iceCount();
			if (count == 0) {
				System.out.println("0");
				break;
			} else if (count >= 2) {
				System.out.println(day);
				break;
			}
			
			day++;

			dfs();

		}
		
	}

	public static int iceCount() {
		boolean[][] visited = new boolean[Y][X];
		int count = 0;
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				if (map[y][x] < 1) {
					visited[y][x] = true;
				}
				
				if (visited[y][x])
					continue;
				
				count ++;
				Stack<int[]> stack = new Stack<>();
				stack.add(new int[] { x, y });
				visited[y][x] = true;
				while (!stack.isEmpty()) {
					int nowX = stack.peek()[0];
					int nowY = stack.peek()[1];
					stack.pop();

					for (int i = 0; i < 4; i++) {
						int nextX = nowX + dx[i];
						int nextY = nowY + dy[i];

						if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y)
							continue;
						if (visited[nextY][nextX])
							continue;
						if (map[nextY][nextX] < 1)
							continue;

						visited[nextY][nextX] = true;
						stack.add(new int[] { nextX, nextY });
					}
				}
			}
		}

		return count;
	}
	
	public static void dfs() {
		Stack<int[]> stack = new Stack<>();
		boolean[][] visited = new boolean[Y][X];
		
		// 얼음 좌표 방문처리 후 stack에 저장
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				if (map[y][x] > 0) {
					stack.add(new int[] { x, y });
					visited[y][x] = true;
				}
			}
		}

		while (!stack.isEmpty()) {
			int nowX = stack.peek()[0];
			int nowY = stack.peek()[1];
			stack.pop();
			
			// 바닷물과 접해있는 부분의 개수 구하기
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y)
					continue;
			
				if (visited[nextY][nextX])
					continue;
				
				if (map[nextY][nextX] == 0) {
					map[nowY][nowX] -= 1;
					if (map[nowY][nowX] <= 0) break;
				}
			}
		}
	}

}

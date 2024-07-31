import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 24.02.21;; 시간초과...
 * 두 덩어리 이상으로 분리되는 최초의 시간 구하기
 * 전부 다 녹을 때까지 두 덩어리 이상으로 분리되지 않으면 0 출력
 */
public class _2573 {
	static boolean isDebug = false;
	static int X, Y;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	
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
				// 바다이면은 queue에 저장
				if (map[y][x] == 0) {
					queue.offer(new int[] { x, y });
				} else if (map[y][x] > 0) {
				}
			}
		}
		
		int day = 0;
		int count = 0;
		while (true) {
			dayPassed();
			day ++;
			
			count = 0;
			visited = new boolean[Y][X];
			for (int y = 0; y < Y; y++) {
				for (int x = 0; x < X; x++) {
					if (visited[y][x]) continue;
					if (map[y][x] < 1) continue;
					dfs(x, y);
					count ++;
				}
			}
			
			if (isDebug) {
				// 긴급브레이크
				if (day > 10) {
					System.out.println("STH WENT WRONG");
					break;
				}
				System.out.printf("day = %d\tcount = %d\n", day, count);
				for (int y = 0; y < Y; y++) {
					for (int x = 0; x < X; x++) {
						System.out.print(map[y][x] + " ");
					}
					System.out.println();
				}	
				System.out.println();
				System.out.println("-".repeat(10));
			}
			
			// 두 덩어리 이상으로 분리되었다면
			if (count >= 2) {
				System.out.println(day);
				System.exit(0);
			}
			// 한 덩어리 혹은 다 녹아버렸다면
			else {
				// 빙산이 다 녹아버림
				if (count == 0) {
					System.out.println(0);
					System.exit(0);
				}			
				else continue;
			}
			
		}
	}
	
	public static void dayPassed() {
		for (int[] arr: queue) {
			int nowX = arr[0];
			int nowY = arr[1];
			queue.poll();
			
			boolean isAround = false;
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= X || nextY >= Y) continue;
				if (map[nextY][nextX] > 0) {
					isAround = true;
					map[nextY][nextX] --;
				}
			}
			
			if (!isAround) {
				continue;
			} else {
				queue.offer(new int[] { nowX, nowY });
			}
		}
	}
	
	
	public static void dfs(int x, int y) {
		Queue<int[]> miniQueue = new LinkedList<>();
		miniQueue.offer(new int[] { x, y });
		visited[y][x] = true;

		while (!miniQueue.isEmpty()) {
			int nowX = miniQueue.peek()[0];
			int nowY = miniQueue.peek()[1];
			miniQueue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= X || nextY >= Y) continue;
				if (visited[nextY][nextX]) continue;
				if (map[nextY][nextX] < 1) continue;
				
				visited[nextY][nextX] = true;
				miniQueue.offer(new int[] { nextX, nextY });
			}
		}
	}

}

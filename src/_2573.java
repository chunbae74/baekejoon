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
	static int[][] map2;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
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
				if (map[y][x] > 0) {
					queue.offer(new int[] { x, y, map[y][x] });
				}
			}
		}
		
		int day = 0;
		while (true) {
			map2 = new int[Y][X];
			dayPassed();
			map = map2;
			day ++;
			
			int count = 0;
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
				bw.write(day + "");
				break;
			}
			// 한 덩어리 혹은 다 녹아버렸다면
			else {
				// 빙산이 다 녹아버림
				if (count == 0) {
					bw.write(0 + "");
					break;
				}			
				else continue;
			}
			
		}
		bw.flush();
		bw.close();
	}
	
	public static void dayPassed() {
		// 삭제될 빙산들
		Queue<int[]> removed = new LinkedList<>();
		
		for (int[] arr: queue) {
			int nowX = arr[0];
			int nowY = arr[1];

			// 주변 바닷물 개수
			int count = 0;
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= X || nextY >= Y) continue;
				if (map[nextY][nextX] > 0) continue;
				
				count ++;
			}
			
			// map2에 최신 빙산정보 기록
			map2[nowY][nowX] = map[nowY][nowX] - count;
			
			// 빙산이 다 녹아버렸다면
			if (map2[nowY][nowX] < 1) {
				map2[nowY][nowX] = 0;
				// 빙산 remove 리스트에 추가
				removed.offer(new int[] { nowX , nowY });
			}
		}
		
		// 빙산 remove리스트에 추가된 빙산들 삭제
		queue.removeAll(removed);
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

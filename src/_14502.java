import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14502 {
	static int X, Y;
	static int[][] dist;
	static final int[] dx = new int[] { 0, 0, 1, -1 };
	static final int[] dy = new int[] { 1, -1, 0, 0 };
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		dist = new int[Y][X];
		
		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++) {
				dist[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		chunbae(0);
		
		System.out.println(max);
	}

	/**
	 * @param count: 세운 벽의 개수
	 */
	public static void chunbae(int count) {
		if (count == 3) {
			max = Math.max(max, getArea());
			return;
		}
		
		
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				if (dist[y][x] == 0) {
					dist[y][x] = 1;
					chunbae(count + 1);
					dist[y][x] = 0;
				}
			}
		}
	}
	
	
	/**
	 * @return 안전 영역의 크기
	 */
	public static int getArea() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] map = new boolean[Y][X];

		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				if (dist[y][x] == 2) {
					queue.offer(new int[] { x, y });
					map[y][x] = true;
				} else if (dist[y][x] == 1) {
					map[y][x] = true;
				}
			}
		}
		
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y) continue;
				
				if (!map[nextY][nextX]) {
					map[nextY][nextX] = true;
					queue.offer(new int[] { nextX, nextY });
				}
			}
			
		}
		
		int area = 0;
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				if (!map[y][x]) area ++;
			}
		}
		
		return area;
	}
}

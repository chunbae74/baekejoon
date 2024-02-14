import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 최소 1
 */
public class _2468 {
	static boolean isDebug = false;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
				
		map = new int[N][N];
		
		int minHeight = Integer.MAX_VALUE;
		int maxHeight = Integer.MIN_VALUE;
		for (int y = 0; y < N; y ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x ++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				minHeight = Math.min(minHeight, map[y][x]);
				maxHeight = Math.max(maxHeight, map[y][x]);
			}
		}
		
		int num = 1;
		for (int height = minHeight; height < maxHeight; height++) {
			int order = 0;
			visited = new boolean[N][N];
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (visited[y][x] || map[y][x] <= height) continue;
					bfs(x, y, height);
					order ++;
					if (isDebug && height == 6) {
						System.out.printf("x = %d\ty = %d\theight = %d\torder = %d\n", x, y, height, order);
						for (int i = 0; i < N; i++) {
							for (int j = 0; j < N; j++) {
								System.out.print(visited[i][j] + " ");
							}
							System.out.println();
						}
						System.out.println("-".repeat(15));
					}
				}
			}
			
			num = Math.max(num, order);
		}
		
		bw.write(num + "");
		bw.flush();
		bw.close();
	}
	
	
	/*
	 * height: 빗물의 높이
	 */
	public static void bfs(int x, int y, int height) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		visited[y][x] = true;
		
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
				if (visited[nextY][nextX] || map[nextY][nextX] <= height) continue;
				
				visited[nextY][nextX] = true;
				queue.offer(new int[] { nextX, nextY });
			}
		}
		
	}

}

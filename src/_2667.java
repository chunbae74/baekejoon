import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Input; 0: 집x / 1: 집o
 */
public class _2667 {
	static boolean isDebug = false;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int order = 1;
	
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				
			}
		}
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				// 이미 방문했거나 다른 집이라면
				if (visited[y][x] || map[y][x] == 0) continue;
				bfs(x, y, order);
				order ++;
				if (isDebug) {
					System.out.printf("x = %d\ty = %d\torder = %d\n", x, y, order);
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
							System.out.print(map[i][j] + " ");
						}
						System.out.println();
					}
					System.out.println("-".repeat(15));
				}
			}
		}
		
		int[] arr = new int[N * N];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] != 0) {
					arr[map[y][x]] ++;
				}
			}
		}
		
		Arrays.sort(arr);
		bw.write((order - 1) + "\n");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) continue;
			else bw.write(arr[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

	
	public static void bfs(int x, int y, int order) {		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		visited[y][x] = true;
		map[y][x] = order;
		
		while (!queue.isEmpty()) {
			int[] cor = queue.poll();
			int corX = cor[0];
			int corY = cor[1];
			
			for (int i = 0; i < 4; i++) {
				int nextX = corX + dx[i];
				int nextY = corY + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
				if (visited[nextY][nextX] || map[nextY][nextX] == 0) continue;
				
				visited[nextY][nextX] = true;
				map[nextY][nextX] = order;
				queue.offer(new int[] { nextX, nextY });
			}
		}
	}
}

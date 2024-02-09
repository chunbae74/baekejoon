import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * M : 가로
 * N : 세로
 * 1 : 익은 토마토
 * 0 : 익지 않은 토마토
 * -1 : 빈칸
 * 반례모음 : https://www.acmicpc.net/board/view/97467
 */
public class _7576 {
	static int M, N;
	static int[][] arr;
	static Queue<int[]> queue = new LinkedList<>();
	
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean debug = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];

		// 안익은 토마토 개수
		int notYummy = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) notYummy ++;
				else if (arr[i][j] == 1) {
					queue.offer(new int[] { j, i });
				}
			}
		}
		
		bfs();
		
		boolean isClear = true;
		int result = 0;
		
		Loop1: for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++ ) {
				if (arr[y][x] == 0) {
					isClear = false;
					break Loop1;
				} else if (arr[y][x] > 0) {
					result = Math.max(result, arr[y][x]);
				}
			}
		}
		
		bw.write((isClear) ? (result - 1 + "") : "-1");
		bw.flush();
		bw.close();
	}
	
	public static void bfs() {
		while (!queue.isEmpty()) {
			int[] cor = queue.poll();
			int x = cor[0];
			int y = cor[1];
			visited[y][x] = true;
			
			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
				// 안익은 토마토가 아니라면 건너뛰기
				if (visited[nextY][nextX] || arr[nextY][nextX] != 0) continue;

				arr[nextY][nextX] = arr[y][x] + 1;
				queue.offer(new int[] { nextX, nextY });
			}	
			
			if (debug) {
				for (int ii = 0; ii < N; ii++) {
					for (int jj = 0; jj < M; jj++) {
						System.out.print(arr[ii][jj] + " ");
					}
					System.out.println();
				}
				System.out.println("-".repeat(10));
			}
		}
	}
	
}
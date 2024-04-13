import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 아 진짜 모르겠다....
 */
public class _1890 {
	static int N;
	static int[][] arr;
	static int[][] dp;
	static boolean[][] visited;
	static boolean isDebug = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][N];
		visited = new boolean[N][N];
		
		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0, 0);
		
		if (isDebug) {
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					System.out.print(dp[y][x] + " ");
				}
				System.out.println();
			}
		}
		bw.write(dp[N - 1][N - 1] + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			queue.poll();
			
			// 오른쪽으로
			int nextX = nowX + arr[nowY][nowX];
			int nextY = nowY;

			if (isOkay(nowX, nowY, nextX, nextY)) {
				dp[nextY][nextX] ++;
				
				if (!(nextX == (N - 1) && nextY == (N - 1))) {
					queue.add(new int[] { nextX, nextY });
				}				
			}
			// 아래쪽으로
			nextX = nowX;
			nextY = nowY + arr[nowY][nowX];

			if (isOkay(nowX, nowY, nextX, nextY)) {
				dp[nextY][nextX] ++;
	
				if (!(nextX == (N - 1) && nextY == (N - 1))) {
					queue.add(new int[] { nextX, nextY });
				}
			}
		}
	}
	public static boolean isOkay(int nowX, int nowY, int nextX, int nextY) {
		if (nowX == nextX && nowY == nextY) return false;
		if (nextX >= N || nextY >= N) return false;
		return true;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11909 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE;
		final int[] dx = { 0, -1 };
		final int[] dy = { -1, 0 };
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N][N];
		int[][] graph = new int[N][N];
		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				dp[y][x] = INF;
				graph[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = graph[0][0];
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (x == 0 && y == 0) continue;
				for (int i = 0; i < 2; i++) {
					int preX = x + dx[i];
					int preY = y + dy[i];
					
					if (0 > preX || N >= preX || 0 > preY || N >= preY) continue;
					dp[y][x] = Math.min(dp[preY][preX], dp[y][x]);
				}
			}
		}
		System.out.println(dp[N - 1][N - 1]);
	}

}

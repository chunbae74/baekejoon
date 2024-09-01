import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1890 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] dp = new int[N][N];
		
		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = 1;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (dp[y][x] == 0) continue;
				if (x == N - 1 && y == N - 1) break;
				int nextX = x + map[y][x];
				int nextY = y;
				if (0 <= nextX && nextX < N) {
					dp[nextY][nextX]++;
				}
				
				nextX = x;
				nextY = y + map[y][x];
				if (0 <= nextY && nextY < N) {
					dp[nextY][nextX]++;
				}
			}
		}
		
		System.out.println(dp[N - 1][N - 1]);
	}

}

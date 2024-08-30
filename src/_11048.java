import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11048 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int[] dx = new int[] { 1, 0, 1 };
		final int[] dy = new int[] { 0, 1, 1 };
		
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[Y][X];
		int[][] graph = new int[Y][X];
		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++) {
				graph[y][x] = Integer.parseInt(st.nextToken());
			}
		} 

		dp[0][0] = graph[0][0];
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				for (int i = 0; i < dx.length; i++) {
					int nextX = x + dx[i];
					int nextY = y + dy[i];
					
					if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y) continue;
					dp[nextY][nextX] = Math.max(dp[y][x] + graph[nextY][nextX], dp[nextY][nextX]);
				}
			}
		}
		
		System.out.println(dp[Y - 1][X - 1]);
	}

}

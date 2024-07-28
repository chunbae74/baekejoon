import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1507 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dist = new int[N][N];
		boolean[][] notNecessary = new boolean[N][N];
		
		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				dist[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if (i == k || j == k || i == j) continue;
					
					// 최단거리가 아닌 값이 저장되어 있음.
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						System.out.println(-1);
						System.exit(0);
					}
					
					if (notNecessary[i][j] || notNecessary[i][k] || notNecessary[k][j]) continue;
					// i <-> j 사이의 길이 필요 없다면
					if (dist[i][j] == dist[i][k] + dist[k][j]) {
						notNecessary[i][j] = notNecessary[j][i] = true;
					}
				}
			}
		}
		
		int sum = 0;
		for (int y = 0; y < N; y++) {
			for (int x = y; x < N; x++) {
				if (y == x) continue;
				if (notNecessary[y][x]) continue;
				sum += dist[y][x];
			}
		}
		
		System.out.println(sum);
	}

}

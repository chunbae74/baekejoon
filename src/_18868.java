import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18868 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[M][N];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				map[m][n] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		for (int m1 = 0; m1 < M; m1++) {
			for (int m2 = m1 + 1; m2 < M; m2++) {
				boolean isMultiverse = true;
				for (int n1 = 0; n1 < N; n1++) {
					for (int n2 = 0; n2 < N; n2++) {
						if (map[m1][n1] < map[m1][n2]) {
							if (map[m2][n1] < map[m2][n2]) {
								continue;
							}
						} else if (map[m1][n1] > map[m1][n2]) {
							if (map[m2][n1] > map[m2][n2]) {
								continue;
							}
						} else if (map[m1][n1] == map[m1][n2]) {
							if (map[m2][n1] == map[m2][n2]) {
								continue;
							}
						}
						
						isMultiverse = false;
						break;
					}
				}
				
				if (isMultiverse) count++;
			}
		}
		
		System.out.println(count);
	}

}

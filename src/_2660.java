import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		final int INF = 100;
		
		int N = Integer.parseInt(br.readLine());
		int[][] dist = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				else dist[i][j] = INF;
			}
		}
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			if (a == -2 && b == -2) break;
			
			dist[a][b] = 1;
			dist[b][a] = 1;
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		int[] count = new int[N + 1];
		int min = N + 1;
		for (int i = 0; i < N; i++) {
			int max = 1;
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				max = Math.max(max, dist[i][j]);
			}
			min = Math.min(min, max);
			count[max] ++;
		}
		
		sb.append(min).append(" ").append(count[min]).append("\n");
		
		for (int i = 0; i < N; i++) {
			int max = 1;
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				max = Math.max(max,  dist[i][j]);
			}
			if (max == min) {
				sb.append(i + 1).append(" ");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		 
	}

}

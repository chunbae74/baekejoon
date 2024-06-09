import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _21940 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		final int INF = Integer.MAX_VALUE >> 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] dist = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				else dist[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			dist[A][B] = C;
		}
		
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		boolean[] arr = new boolean[N];
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(st.nextToken()) - 1;
			arr[num] = true;
		}
	
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) continue;
					else dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		// 만나려는 도시 x
		for (int x = 0; x < N; x++) {
			int sum = 0;
			// 친구들 집
			for (int i = 0; i < N; i++) {
				// 친구들이 살고있지 않은 집은 제외
				if (!arr[i]) continue;
				// 도로를 이용하여 갈 수 없는 도시는 제외
				if (dist[i][x] == INF || dist[x][i] == INF) continue;
				
				sum += dist[i][x] + dist[x][i];
			}
			
			System.out.println("x = " + x + "\tsum = " + sum);
			if (max == sum) {
				sb.append(x + 1).append(" ");
			} else if (max < sum) {
				max = sum;
				sb = new StringBuilder();
				sb.append(x + 1).append(" ");
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

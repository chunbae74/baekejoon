import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _13424 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		final int INF = 987654321;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
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
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				int cost = Integer.parseInt(st.nextToken());
				dist[a][b] = dist[b][a] = cost;
			}
			
			// 비밀모임에 참여하는 친구의 수
			int K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			boolean[] friendsArr = new boolean[N];
			for (int i = 0; i < K; i++) {
				int roomNum = Integer.parseInt(st.nextToken()) - 1;
				friendsArr[roomNum] = true;
			}
			
			// 플로이드-워셜
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (i == j) continue;
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			int room = -1;
			// i : 모임 후보 장소
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int f = 0; f < N; f++) {
					// 친구가 없는 빈방이면 건너뛰기
					if (!friendsArr[f]) continue;
					else sum += dist[f][i];
				}
				
				if (min > sum) {
					min = sum;
					room = i;
				}
			}
			
			sb.append(room + 1).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

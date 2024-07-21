import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node_10217 {
	int index;
	int cost;
	int time;
	
	Node_10217(int index, int cost, int time) {
		this.index = index;
		this.cost = cost;
		this.time = time;
	}
}

/*
 * 참고ㅣ
 * https://www.acmicpc.net/board/view/129181
 * https://roamingman.tistory.com/46
 */
public class _10217 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE >> 1;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 공항의 수
			int N = Integer.parseInt(st.nextToken());
			// 총 지원비용
			int M = Integer.parseInt(st.nextToken());
			// 티켓 정보의 수
			int K = Integer.parseInt(st.nextToken());
			
			ArrayList<Node_10217>[] graph = new ArrayList[N];
			int[][] dist = new int[N][M + 1];
			boolean[][] visited = new boolean[N][M + 1];
			
			for (int i = 0; i < N; i++) {
				graph[i] = new ArrayList<>();
				for (int j = 0; j < M + 1; j++) {
					dist[i][j] = INF;
				}
			}
			
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken()) - 1;
				int B = Integer.parseInt(st.nextToken()) - 1;
				int C = Integer.parseInt(st.nextToken());
				int D = Integer.parseInt(st.nextToken());
				graph[A].add(new Node_10217(B, C, D));
			}
			
			dist[0][0] = 0;
			for (int nowMoney = 0; nowMoney < M + 1; nowMoney++) {
				for (int nowNode = 0; nowNode < N; nowNode++) {
					for (Node_10217 next: graph[nowNode]) {
						int nextNode = next.index;
						int nextCost = next.cost;
						int nextTime = next.time;

						if (nowMoney + nextCost > M) continue;
						if (dist[nextNode][nowMoney + nextCost] > dist[nowNode][nowMoney] + nextTime) {
							dist[nextNode][nowMoney + nextCost] = dist[nowNode][nowMoney] + nextTime;
						}
					}
				}
			}
			
			int min = INF;
			for (int i = 0; i < M + 1; i++) {
				min = Math.min(min, dist[N - 1][i]);
			}
			
			System.out.println(min == INF ? "Poor KCM" : min);
		}
	}
}

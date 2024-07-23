import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _17940 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE >> 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] graph = new int[N][N];
		int[] firm = new int[N];
		// dist[i][j] = j번 환승을 통해 i역에 도착했을 떄의 소요시간
		int[][] dist = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], INF);
		}
		
		for (int i = 0; i < N; i++) {
			firm[i] = Integer.parseInt(br.readLine());
		}
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				graph[y][x] = Integer.parseInt(st.nextToken());
				if (graph[y][x] == 0) graph[y][x] = INF;
			}
		}
		
		// { node, transfer, dist[node][transfer] }
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> {
			if (e1[1] == e2[1]) {
				return Integer.compare(e1[2], e2[2]);
			} else {
				return Integer.compare(e1[1], e2[1]);
			}
		});	
		
		dist[0][0] = 0;
		pq.offer(new int[] { 0, 0, dist[0][0] });
		while (!pq.isEmpty()) {
			int nowNode = pq.peek()[0];
			int nowTransfer = pq.peek()[1];
			int nowCost = pq.peek()[2];
			pq.poll();
			
			if (dist[nowNode][nowTransfer] < nowCost) continue;
			
			if (nowNode == M) {
				System.out.println(nowTransfer + " " + nowCost);
				break;
			}
			
			for (int nextNode = 0; nextNode < N; nextNode++) {
				if (nowNode == nextNode) continue;
				// 길이 없음
				if (graph[nowNode][nextNode] == INF) continue;
				int nextTransfer = nowTransfer;
				
				// 회사가 다를 경우 환승횟수 + 1
				if (firm[nowNode] != firm[nextNode]) {
					nextTransfer += 1;
				}
				
				if (nextTransfer >= N) continue;
				
				int nextCost = nowCost + graph[nowNode][nextNode];
				
				if (dist[nextNode][nextTransfer] > nextCost) {
					dist[nextNode][nextTransfer] = nextCost;
					pq.offer(new int[] { nextNode, nextTransfer, dist[nextNode][nextTransfer] });
				}
			}
		}
	}

}

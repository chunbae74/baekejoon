import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_14431 {
	int index;
	int cost;
	
	Node_14431(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _14431 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE >> 1;
		
		boolean[] isNotSosu = new boolean[8_500];
		isNotSosu[0] = isNotSosu[1] = true;
		
		for (int i = 2; i <= Math.sqrt(8_500); i++) {
			if (isNotSosu[i]) continue;
			
			for (int j = i * i; j < 8_500; j += i) {
				isNotSosu[j] = true;
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 시작 노드 = 0
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		// 종료 노드 = N + 1
		int endX = Integer.parseInt(st.nextToken());
		int endY = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		int[][] cor = new int[N + 2][2];
		cor[0] = new int[] { startX, startY };
		cor[N + 1] = new int[] { endX, endY };
		
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			cor[n] = new int[] { x, y };
		}
		
		int[][] graph = new int[N + 2][N + 2];
		for (int i = 0; i < N + 2; i++) {
			for (int j = i + 1; j < N + 2; j++) {
				if (graph[i][j] != 0 || graph[j][i] != 0) continue;

				int cal = (int) (Math.sqrt(Math.pow(cor[i][0] - cor[j][0], 2) + Math.pow(cor[i][1] - cor[j][1], 2)));
				// 거리가 소수가 아닐 경우
				if (isNotSosu[cal]) {
					graph[i][j] = graph[j][i] = -1;
					continue;
				}
				
				graph[i][j] = graph[j][i] = cal;
			}
		}
		
		int[] dist = new int[N + 2];
		for (int n = 0; n < N + 2; n++) {
			dist[n] = INF;
		}
		
		PriorityQueue<Node_14431> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist[0] = 0;
		pq.offer(new Node_14431(0, dist[0]));
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			
			if (nowNode == N + 1) break;
			
			for (int nextNode = 0; nextNode < N + 2; nextNode++) {
				if (nowNode == nextNode) continue;
				if (graph[nowNode][nextNode] == -1 || graph[nowNode][nextNode] == INF) continue;
				
				int nextCost = graph[nowNode][nextNode];
				
				if (isNotSosu[nextCost]) continue;
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_14431(nextNode, dist[nextNode]));
				}
			}
		}
		
		System.out.println(dist[N + 1] == INF ? -1 : dist[N + 1]);
	}

}

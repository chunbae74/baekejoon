import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_17242 {
	int index;
	int kaka;
	int bebe;
	
	Node_17242(int index, int kaka, int bebe) {
		this.index = index;
		this.kaka = kaka;
		this.bebe = bebe;
	}
}

public class _17242 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE >> 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Node_17242>[] graph = new ArrayList[N];
		// dist[n][i][j] : 총 kaka i마리와 bebe j마리를 지나 노드 n에 도착하였을 떄의 스트레스 값
		int[][][] dist = new int[N][1_001][1_001];
		for (int n = 0; n < N; n++) {
			graph[n] = new ArrayList<>();
			for (int i = 0; i < 1_001; i++) {
				Arrays.fill(dist[n][i], INF);
			}
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int KAKA = Integer.parseInt(st.nextToken());
			int BEBE = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_17242(B, KAKA, BEBE));
			graph[B].add(new Node_17242(A, KAKA, BEBE));
		}
		
		dist[0][0][0] = 0;
		for (int kaka = 0; kaka < 1_001; kaka++) {
			for (int bebe = 0; bebe < 1_001; bebe++) {
				for (int nowNode = 0; nowNode < N; nowNode++) {
					for (Node_17242 next: graph[nowNode]) {
						int nextNode = next.index;
						int nextKaka = kaka + next.kaka;
						int nextBebe = bebe + next.bebe;
						
						if (nextKaka > 1_000 || nextBebe > 1_000) continue;
						
						int nextStress = nextKaka * nextBebe;
						
						if (dist[nextNode][nextKaka][nextBebe] > nextStress) {
							dist[nextNode][nextKaka][nextBebe] = nextStress;
						}
					}
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("i = %d\tj = %d\tdist[i][j] = %d\n", i, j, dist[0][i][j]);
			}
		}

		int min = INF;
		for (int i = 0; i < 1_001; i++) {
			for (int j = 0; j < 1_001; j++) {
				min = Math.min(dist[N - 1][i][j], min);
			}
		}

		System.out.println(min == INF ? -1 : min);
	}
}

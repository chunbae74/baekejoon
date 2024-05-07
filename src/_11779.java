import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_11779 {
	int index;
	int cost;
	
	Node_11779(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _11779 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Node_11779>[] graph = new ArrayList[N + 1];
		int[] dist = new int[N + 1];
		int[] arr = new int[N + 3];
		
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[s].add(new Node_11779(e, c));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int START = Integer.parseInt(st.nextToken());
		int END = Integer.parseInt(st.nextToken());
		
		dist[START] = 0;
		arr[0] = START;
		arr[1] = dist[START];
		arr[2] = 1;
		arr[3] = START;
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
		pq.offer(arr);
		
		while (!pq.isEmpty()) {
			int nowV = pq.peek()[0];
			int nowCost = pq.peek()[1];
			int size = pq.peek()[2];
			arr = pq.poll();
			
			if (dist[nowV] < nowCost) continue;
			
			if (nowV == END) break;
			
			for (Node_11779 nextNode: graph[nowV]) {
				int nextV = nextNode.index;
				int nextCost = nextNode.cost;
				if (dist[nextV] > dist[nowV] + nextCost) {
					dist[nextV] = dist[nowV] + nextCost;
					arr[0] = nextV;
					arr[1] = dist[nextV];
					arr[arr[2] + 2] = nextV;
					arr[2]++;
					pq.offer(arr);
				}
			}
		}
		
		sb.append(dist[END]).append("\n");
		sb.append((arr[2] - 1)).append("\n");
		for (int i = 3; i < (arr[2] + 3); i++) {
			sb.append(arr[i]).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

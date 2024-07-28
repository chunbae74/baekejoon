import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1810 {
	static ArrayList<int[]>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int size = 1000000 + 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int END = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[size];
		boolean[] visited = new boolean[N + 1];
		
		for (int i = 0; i < size; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new int[] { 0, 0 });
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[B].add(new int[] { A, i });
		}
		
		for (int i = 0; i < size; i++) {
			if (graph[i].size() < 1) continue;
			Collections.sort(graph[i], (e1, e2) -> Integer.compare(e1[1], e2[1]));
		}
		
		// { x, y, nowCost, node }
		PriorityQueue<double[]> pq = new PriorityQueue<>((e1, e2) -> Double.compare(e1[2], e2[2]));
		pq.offer(new double[] { 0, 0, 0, 0 });
		while (!pq.isEmpty()) {
			int nowX = (int)pq.peek()[0];
			int nowY = (int)pq.peek()[1];
			double nowCost = pq.peek()[2];
			int nowNode = (int)pq.peek()[3];
			pq.poll();
			
			if (visited[nowNode]) continue;
			visited[nowNode] = true;
			
			if (nowY >= END) {
				System.out.println(Math.round(nowCost));
				System.exit(0);
			}
			
			
			Loop1: for (int nextY = Math.max(0, nowY - 2); nextY <= Math.min(size - 1, nowY + 2); nextY++) {
				if (graph[nextY].size() < 1) continue;
				for (int i = 0; i < graph[nextY].size(); i++) {
					int nextX = graph[nextY].get(i)[0];
					if (Math.abs(nextX - nowX) > 2) continue;
					
					int nextNode = graph[nextY].get(i)[1];
					
					if (visited[nextNode]) continue;
					if (Math.abs(nextX - nowX) > 2) continue Loop1;
					 
					double nextCost = nowCost + Math.sqrt(Math.pow(nowX - nextX, 2) + Math.pow(nowY - nextY, 2));
					pq.offer(new double[] { nextX, nextY, nextCost, nextNode });
				}
			}
		}
		
		System.out.println(-1);
	}
}

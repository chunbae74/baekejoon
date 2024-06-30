import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node_13911 {
	int index;
	int cost;
	
	Node_13911(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _13911 {
	static int V;
	static int[] distFromMac;
	static int[] distFromStar;
	static ArrayList<Node_13911>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = 300_000 * 10_000 + 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 정점의 개수
		V = Integer.parseInt(st.nextToken());
		// 도로의 개수
		int E = Integer.parseInt(st.nextToken());
		
		distFromMac = new int[V];
		distFromStar = new int[V];
		graph = new ArrayList[V];
		
		for (int i = 0; i < V; i++) {
			distFromMac[i] = distFromStar[i] = INF;
			graph[i] = new ArrayList<>();
		}
		
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			
			graph[A].add(new Node_13911(B, C));
			graph[B].add(new Node_13911(A, C));
		}
		
		dijkstraForMac();
		dijkstraForStar();
		
	}

	public static void dijkstraForMac(int start) {
		
	}
}

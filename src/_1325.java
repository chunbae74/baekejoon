import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * A B = A가 B를 신뢰함 = B 해킹 시 A 해킹가능
 * 24.02.27 시관초과 미치겠네 진짜;;;
 */
public class _1325 {
	static int N, M;
	static ArrayList<Integer>[] al;
	static int[] result;
	static boolean[] visited;
	
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		al = new ArrayList[N];
		result = new int[N];
		
		for (int i = 0; i < N; i++) {
			al[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			
			al[B].add(A);
		}
		
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			bfs(i);
		}
		
		for (int i = 0; i < N; i++) {
			if (result[i] == max) sb.append((i + 1)).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void bfs(int idx) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(idx);
		visited[idx] = true;
		
		int count = 0;
		while (!queue.isEmpty()) {
			int num = queue.poll();
			
			for (int n: al[num]) {
				if (visited[n]) continue;
				
				queue.offer(n);
				count ++;
				visited[n] = true;
			}
		}
		
		if (max < count) max = count;
		result[idx] = count;
		return;
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _10819 {
	static int max = Integer.MIN_VALUE;
	static int N;
	static int[] num;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		arr = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		
		bw.write(max + "");
		bw.flush();
		bw.close();
	
	}

	
	public static void dfs(int depth) {
		if (depth == N) {
			int cal = 0;
			for (int i = 0; i < N - 1; i++) {
				cal += Math.abs(arr[i] - arr[i+1]);
			}
			
			max = Math.max(max, cal);
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = num[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}

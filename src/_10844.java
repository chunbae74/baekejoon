import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10844 {
	static int[] arr = new int[10];
	static boolean[] visited = new boolean[10];
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 1; i <= 10; i++) {
			count = 0;
			visited = new boolean[10];
			arr = new int[10];
			bfs(0, i);		
			System.out.printf("i = %d\tcount = %d\n", i, count);
		}
	}
	
	public static void bfs(int depth, int n) {
		if (depth == n) {
			count ++;
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if (depth == 0 && i == 0) continue;
			
			visited[i] = true;
			if (depth > 0) {
				if (Math.abs(arr[depth - 1] - i) == 1) {
					arr[depth] = i;
				} else {
					continue;
				}
			} else if (depth == 0) {
				arr[depth] = i;
			}
			bfs(depth + 1, n);
			visited[i] = false;
		}
	}

}

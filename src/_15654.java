import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * N : N개의 자연수
 * M : 자릿수
 */
public class _15654 {

	static int N, M;
	static int[] num;
	static int[] arr;
	static ArrayList<Integer> al = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		arr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);

		dfs(0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int depth) {
		if (depth == M) {
			for (int n: arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			int n = num[i];
			if (!al.contains(n)) {
				al.add(n);
				arr[depth] = n;
				dfs(depth + 1);
				al.remove(al.indexOf(n));
			}
		}
	}

}

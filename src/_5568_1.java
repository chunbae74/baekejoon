import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

/*
 * n : 카드 n장 (4 <= n <= 10)
 * 각 카드에는 1이상 99이하의 정수
 * k : 카드 k장 선택
 * 출력 : 만들 수 있는 정수의 개수
 */
public class _5568_1 {
	static int n, k;
	static int[] num, arr;
	static boolean[] visited;
	static HashSet<String> hs = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		num = new int[n];
		arr = new int[k];
		visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		chunbae(0);
		
		bw.write(hs.size() + "");
		bw.flush();
		bw.close();
	}
	
	
	public static void chunbae(int depth) {
		if (depth == k) {
			StringBuilder sb = new StringBuilder();
			for (int n: arr) sb.append(n);
			String s = sb.toString();
			if (!hs.contains(s)) hs.add(s);
			return;
		}
		
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = num[i];
				chunbae(depth + 1);
				visited[i] = false;
			}
		}
	}

}

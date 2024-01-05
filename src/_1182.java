import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 스위치 형식으로 풀었다. 
 * 0번째 스위치 -> on/off | 1번째 스위치 -> on/off ... N-1번째 스위치 -> on/off
 * 각각의 숫자를 끄고 킬 수 있는 스위치로 보고, 
 * 모든 경우의 수를 구한 뒤, 
 * 켜져 있는 스위치들을 더해 그 값이 S와 일치하는지 구하였다.
 */
public class _1182 {
	static int N, S;
	static int[] num;
	static boolean[] isOn;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		isOn = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(false, 0);
		dfs(true, 0);
		
		// 공집합은 count에서 제외한다.
		if (S == 0 && count != 0) count --;
		
		bw.write(count + "");
		bw.flush();
		bw.close();
	}
	
	
	public static void dfs(boolean on, int depth) {		
		isOn[depth] = on;

		// 마지막 스위치까지 모두 정했다면
		if (depth == N - 1) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (!isOn[i]) continue;
				sum += num[i];
			}
			
			if (sum == S) count ++;
			return;
		}
		
		// off
		dfs(false, depth + 1);				
		// on
		dfs(true, depth + 1);				
		
	}
}

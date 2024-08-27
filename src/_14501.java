import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 그냥 퇴사 안하면 안되냐 백준아;;;;
 * 해설: https://velog.io/@yoonuk/%EB%B0%B1%EC%A4%80-14501-%ED%87%B4%EC%82%AC-Java%EC%9E%90%EB%B0%94
 * 24.03.23 해설 확인
 */
public class _14501 {
	
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int[][] arr = new int[N + 1][2];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}
		
		br.close();
		
	}
	
}

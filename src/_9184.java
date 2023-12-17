import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제의 핵심 : 메모리제이션
 * 이미 계산한 값은 다시 게산하지 않고, 재사용하는 것이 키워드
 * 참고 : https://st-lab.tistory.com/190
 */
public class _9184 {
	
	static int[][][] dp = new int[21][21][21];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int a, b, c;
		dp[20][20][20] = 1048576;

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if (a == -1 && b == -1 && c == -1) break;
			sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a ,b ,c)).append('\n');
		}
		
		System.out.println(sb.toString());
	}
	
	public static int w(int a, int b, int c) {
		
		// a, b, c가 범위를 벗어나지 않으면서 메모리제이션이 되어있는 경우
		if (inRange(a, b, c) && dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		if (a > 20 || b > 20 || c > 20) {
			return 1048576;
		}
		
		if (a < b && b < c) {
			return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		}
		
		else {
			return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
		}
	}

	/*
	 * 배열을 참조하려 할 때, a, b, c 중 하나라도 범위 밖의 변수가
	 * 나올 수 있기 때문에 이를 체크해 주기 위한 함수
	 */
	public static boolean inRange(int a, int b, int c) {
		return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
	}
}

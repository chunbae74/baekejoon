import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 참고: 10844_쉬운 계단 수 (https://st-lab.tistory.com/134)
 * 반례모음: https://www.acmicpc.net/board/view/93128
 */
/*
 * 75539399ㅣ재귀 (Top-Down)
 * 75539867ㅣ반복문 (Bottom-Up)
 */
public class _11057 {
	static int N;
	static Integer[][] dp;
	
	static int mod = 10_007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		dp = new Integer[N + 1][10];
		// 1의 자리 수 초기화
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		long count = 0L;
		/*
		 * i: 10^(i-1)번 째 자리 수
		 * j: 10^(i-1)번 째 자리에 오는 값
		 * k: 10^i 번 째 자리에 올 수 있는 값
		 */
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				dp[i][j] = 0;
				for (int k = 0; k <= j; k++) {
					dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
				}
				if (i == N) {
					count = (count + dp[i][j]) % mod;
				}
			}			
		}
		
		if (N == 1) count = 10L;
		
		bw.write(count + "");
		bw.flush();
		bw.close();
		br.close();
	}
}

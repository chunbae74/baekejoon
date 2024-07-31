import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _31395 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		// 오름차순 숫자가 몇 개가 있는지.
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 1;
		long ans = 0;
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			if (i > 0) {
				// 이전 숫자보다 지금 숫자가 더 크다면
				if (input[i - 1] < input[i]) {
					count ++;
				// 오름차순이 끊겼을때 (i번째 수 부터 다시 초기화)
				} else {
					count = 1;
				}
				ans += count;
			} else if (i == 0) {
				ans += 1;
			}
		}
		
		System.out.println(ans);
	}

}

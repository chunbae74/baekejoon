import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10973 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		// 이미 사용한 숫자를 담는 배열
		boolean[] isUsed = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		boolean gettingBigger = true;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i > 0) {
				if (arr[i] < arr[i - 1]) {
					gettingBigger = false;
				}
			}
		}

		if (gettingBigger) {
			System.out.println("-1");
			System.exit(0);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = N - 1; i > 0; i--) {
			// 앞의 자리 수가 더 크다면
			if (arr[i] < arr[i - 1]) {
				// i-1자리 앞의 수들은 그대로 유지
				for (int j = 0; j < i - 1; j++) {
					sb.append(arr[j]).append(" ");
					isUsed[arr[j]] = true;
				}
				
				// i-1자리는 남은 수 중 가장 큰 수
				int max = 1;
				for (int k = 1; k <= N; k++) {
					if (isUsed[k]) continue;
					if (arr[i - 1] > k && k > max) {
						max = k;
					}
				}
				isUsed[max] = true;
				sb.append(max).append(" ");
				
				// i - 1 뒤의 수들은 내림차순으로 재정렬
				int[] order = new int[N];
				int idx = 0;
				// 사용하지 않은 수들을 order배열에 넣기
				for (int k = 1; k <= N; k++) {
					if (isUsed[k]) continue;
					order[idx++] = k;
				}
				
				Arrays.sort(order);
				
				for (int k = order.length - 1; k >= 0; k--) {
					if (order[k] == 0) continue;
					sb.append(order[k]).append(" ");
				}
				break;
			} 
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

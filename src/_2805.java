import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * N: 나무의 수
 * M: 가져가야 할 최소 길이(합)
 * 2% 반례: https://www.acmicpc.net/board/view/133188
 */
public class _2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		int low = 0;
		int high = max;
		int res = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			
			long sum = 0;
			for (int i = 0; i < N; i++) {
				sum += Math.max(0, arr[i] - mid);
			}
			
			// 개수가 충분하다면 길이 증가
			if (sum >= M) {
				res = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		bw.write(res + "");
		bw.flush();
		bw.close();
		br.close();
	}

}

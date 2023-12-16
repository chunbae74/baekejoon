import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2559 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 1 <= K <= N
		st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		int count = 0;
		int sum = 0;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken()); // -100 <= N <= 100
			arr[i] = num;
			sum += num;
			count ++;
			if (count > K) {
				count --;
				sum -= arr[i - K];
			}
			
			if (max < sum && count == K) max = sum;
		}
		bw.write(max + "");
		bw.flush();
		bw.close();
	}

}

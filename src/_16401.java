import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _16401 {

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math .max(max, arr[i]);
		}
		
		int min = 1;
		int res = 0;
		while (min <= max) {
			int mid = (min + max) / 2;
			
			// 계산
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += (arr[i] / mid);
			}
			
			if (sum >= M) {
				res = mid;
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		
		bw.write(res + "");
		bw.flush();
		bw.close();
		br.close();
	}

}

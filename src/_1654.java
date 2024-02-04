import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * K : 이미 가지고 있는 랜선의 개수
 * N : 필요한 랜선의 개수
 */
public class _1654 {
	static int[] arr;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] > max) max = arr[i];
		}
		
		long start = 1;
		long end = max;
		long mid;
		
		while (start <= end) {
			mid = (start + end) / 2;
			
			if (check(mid))
				start = mid + 1;
			else
				end = mid - 1;		
			
		}
		
		bw.write(end + "");
		bw.flush();
		bw.close();
	}
	
	
	public static boolean check(long num) {
		long count = 0;
		
		for (int n: arr) {
			count += n / num;
		}
		
		return count >= N;
	}
}

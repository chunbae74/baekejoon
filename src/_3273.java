import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3273 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		int X = Integer.parseInt(br.readLine());

		Arrays.sort(arr);
		
		int count = 0;
		int l = 0;
		int r = N - 1;
		while (l < r) {
			int sum = arr[r] + arr[l];

			if (sum == X) count ++;
			
			if (sum < X) {
				l++;
			} else {
				r--;
			}
		}

		System.out.println(count);
	}
}

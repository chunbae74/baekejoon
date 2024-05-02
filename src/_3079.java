import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _3079 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		int timeMax = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			timeMax = Math.max(timeMax, arr[i]);
		}
		
		int min = 0;
		int max = M;
		int Time = M * timeMax;
		while (min <= max) {
			int mid = (min + max) / 2;
			
			int sum = mid * timeMax;
			for (int i = 0; i < M; i++) {
			}
		}
	}

}

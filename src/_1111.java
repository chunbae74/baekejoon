import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 반례모음: https://www.acmicpc.net/board/view/74391
 */
public class _1111 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		long A, B;
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if (N == 1) {
			System.out.print("A");
			System.exit(0);				
		}
		else if (N == 2) {
			if (arr[0] == arr[1]) {
				System.out.print(arr[0]);
			} else {
				System.out.print("A");
			}
			System.exit(0);
		}
	
		if (arr[1] == arr[0]) A = 0;
		else A = (arr[2] - arr[1]) / (arr[1] - arr[0]);
	
		B = arr[1] - (arr[0] * A);
		
		for (int i = 1; i < N; i++) {
			long cal = arr[i - 1] * A + B;
			if (cal != arr[i]) {
				System.out.print("B");
				System.exit(0);
			}
		}
		
		bw.write((arr[N - 1] * A + B) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}

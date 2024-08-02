import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10804 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int size = 20;
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = (i + 1);
		}
		
		for (int t = 0; t < 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			for (int i = 0; i <= (end - start) / 2; i++) {
				int tmp = arr[start + i];
				arr[start + i] = arr[end - i];
				arr[end - i] = tmp;
			}
			
		}

		for (int n: arr) {
			System.out.print(n + " ");
		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (i == j) continue;
				
				StringBuilder sb = new StringBuilder();
				int sum = 0;
				// 계산
				for (int k = 0; k < 9; k++) {
					if (k == i || k == j) continue;
					sum += arr[k];
					sb.append(arr[k]).append("\n");
				}
				
				if (sum == 100) {
					System.out.println(sb.toString());
					System.exit(0);
				}
				
			}
		}
	}

}

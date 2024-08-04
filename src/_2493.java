import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Loop1: for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			if (i == 0) {
				sb.append("0 " );
				continue Loop1;
			} else {
				for (int j = i - 1; j >= 0; j--) {
					if (arr[j] >= num) {
						sb.append(j + 1).append(" ");
						continue Loop1;
					}
				}
				
				sb.append("0 ");
			}
		}
		
		System.out.println(sb.toString());
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1969 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		final char[] charArr = new char[] { 'A', 'C', 'G', 'T' };
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] input = new String[N];
		
		for (int n = 0; n < N; n++) {
			input[n] = br.readLine();
		}
		
		int sum = 0;
		for (int m = 0; m < M; m++) {
			int[] count = new int[4];
			for (int n = 0; n < N; n++) {
				for (int i = 0; i < charArr.length; i++) {
					if (charArr[i] != input[n].charAt(m)) {
						count[i] ++;
					}
				}
			}
			
			int min = N + 1;
			char c = ' ';
			for (int i = 0; i < 4; i++) {
				if (min > count[i]) {
					min = count[i];
					c = charArr[i];
				}
			}
			
			sb.append(c);
			sum += min;
		}
		
		System.out.println(sb.toString());
		System.out.println(sum);
	}

}

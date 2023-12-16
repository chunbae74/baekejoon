import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 10n + 1, 10n + 4, 10n + 7
public class _27913 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int count = (N / 10) * 3;

		// 대문자면 true, 소문자면 false로 구현
		boolean[] B = new boolean[N + 1];
		
		boolean[] A = new boolean[10];
		A[0] = A[3] = A[6] = true;
		
		for (int i = 0; i < N % 10; i++) {
			if (A[i]) count ++;
		}
		
		for (int i = 1; i < B.length; i++) {
			int order = i % 10;
			if (order == 1 || order == 4 || order == 7) B[i] = true;
		}
		
		int Q = Integer.parseInt(st.nextToken());
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			int num = Integer.parseInt(br.readLine());
			// 대문자일 경우
			if (B[num]) {
				B[num] = false;
				count --;
			}
			// 소문자일 경우
			else {
				B[num] = true;
				count ++;
			}
			answer.append(count).append("\n");
		}
		
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}

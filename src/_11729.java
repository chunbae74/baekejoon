import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 해설: https://st-lab.tistory.com/96
 */
public class _11729 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		/*
		 * 1에서 2로 N-1개 원판 옮기는 경우의 수: recur(N - 1)
		 * 맨 마지막 원판: 1
		 * 2에서 3으로 N-1개 원판 옮기는 경우의 수: recur(N - 1)
		 * An+1 = 2*An + 1; A1 = 1
		 * An+1 + 1 = 2*(An + 1),
		 * if Bn = An + 1 then Bn+1 = 2*Bn; B1 = 2
		 * Bn = 2^n = An + 1, An = 2^n - 1
		 */
		int K = (int)(Math.pow(2,N) - 1);
		sb.append(K).append("\n");
		
		recur(N, 1, 2, 3);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void recur(int N, int start, int mid, int to) {
		if (N == 1) {
			sb.append(start).append(" ").append(to).append("\n");
			return;
		}
		
		// 1에서 2로 이동하기
		recur(N - 1, start, to, mid);
		
		// 맨 마지막 원판 이동하기
		sb.append(start).append(" ").append(to).append("\n");
		
		// 2에서 3으로 이동하기
		recur(N - 1, mid, start, to);
	}
}

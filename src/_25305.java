import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 응시자의 수 N, 상을 받는 사람의 수 K
 *
 */
public class _25305 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] score = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i<N; i++) score[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(score);
		bw.write(score[score.length - K] + "");
		bw.flush();
		bw.close();
	}

}

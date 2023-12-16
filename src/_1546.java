/**
 * 최대값 M
 * 모든 점수를 점수/M * 100으로 함
 * 첫째 줄에 시험 본 과목의 개수 N이 주어짐
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1546 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		double[] score = new double[N];
		double max = 0.0;
		for (int i = 0; i<N; i++) {
			double order = Double.parseDouble(st.nextToken());
			score[i] = order;
			if (order > max) max = order;
		}
		double avg = 0.0;
		for (int i = 0; i<N; i++) {
			score[i] = score[i] / max * 100;
			avg += score[i];
		}
		bw.write(avg/N + "");
		bw.flush();
		bw.close();
	}

}

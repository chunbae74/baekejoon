package 파댕이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A번 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 돌봐야 하는 시간
		int T = Integer.parseInt(br.readLine());
		// 가지고 있는 사탕 총 개수
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int time = 0;
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			time += num;
		}
		
		if (T <= time) {
			bw.write("Padaeng_i Happy");
		} else {
			bw.write("Padaeng_i Cry");
		}
		
		bw.flush();
		bw.close();
	}

}

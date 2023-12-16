package BuSanContest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int preNum = 0;
		int nowNum = preNum;
		int count = 0;
		for(int i = 0; i < N; i++) {
			nowNum = Integer.parseInt(st.nextToken());
			if (preNum <= nowNum) count ++;
			preNum = nowNum;
		}
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}

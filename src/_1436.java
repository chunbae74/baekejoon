import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 종말의 수 : 6이 적어도 3개 이상 연속으로 들어가는 수.
 * 크기 : 666 < 1666 < 2666 ...
 * N번째로 작은 수는 ?
 * 
 * 나중에 다시 풀어보기. 158, 500 이상하게 나옴.
 */
public class _1436 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int count = 0, i;
		StringBuilder chunbae = new StringBuilder();
		for(i = 666;; i++) {
			chunbae.delete(0, chunbae.length());
			chunbae.append(Integer.toString(i));
			if (chunbae.toString().contains("666")) count++;
			if (count == N) break;
		}
		bw.write(i + "");
		bw.flush();
		bw.close();
	}

}

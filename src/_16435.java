import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _16435 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 과일 개수
		int L = Integer.parseInt(st.nextToken()); // 초기 뱀 길이
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			al.add(num);
		}
		Collections.sort(al);
		for (int n: al) {
			if (n <= L) L++;
		}
		bw.write(L + "");
		bw.flush();
		bw.close();
	}
}

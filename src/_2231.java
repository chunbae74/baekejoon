import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 함.
 * 어떤 자연수의 경우에는 생성자가 없을수도 있고, 생성자가 여러 개일 수 도 있다.
 *
 */
public class _2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String N2 = Integer.toString(N);
		boolean noValue = true;
		int start = N - 9 * N2.length();
		if (start < 0) start = 0;
		for (long i = start; i<N; i++) {
			String[] sl = Long.toString(i).split("");
			long num = i;
			for (String s: sl) num += Long.parseLong(s);
			if (num == N) {
				bw.write(i + "");
				noValue = false;
				break;
			} else continue;
		}
		if (noValue) bw.write("0");
		bw.flush();
		bw.close();
	}
	
	public static Long powerOfTen(int n) {
		return (long)Math.pow(10,  n);
	}
}

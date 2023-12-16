import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2839 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		int three = N / 3 + 1;
		while(three >= 0) {
			int five = 0;
			while(five <= N/5 + 1) {
				if (three * 3 + five * 5 == N) {
					if (min > three + five) min = three + five;
				}
				five ++;
			}
			three--;
		}
		if (min == Integer.MAX_VALUE) bw.write("-1");
		else bw.write(min + "");
		bw.flush();
		bw.close();
	}

}

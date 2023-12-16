import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _8958 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String s;
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			int score = 0, sum = 0;
			char pre = 'O';
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == 'O') {
					if (pre == 'O') score++;
					sum += score;
				} else score = 1;
				pre = s.charAt(j);
			}
			bw.write(sum + "\n");
		}
		bw.flush();
		bw.close();
	}

}

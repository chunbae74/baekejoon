import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10162 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		if (T % 10 != 0) bw.write("-1");
		else {
			int[] arr = {300, 60, 10};		
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				sb.append(T / arr[i]).append(" ");
				T %= arr[i];
			}
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}

}

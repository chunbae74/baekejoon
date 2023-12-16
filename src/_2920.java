import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[8];
		for (int i = 0; i < 8; i++) arr[i] = Integer.parseInt(st.nextToken());
		boolean up = true, down = true;
		for (int i = 0; i < 7; i++) {
			if (up) {
				if (arr[i+1] - arr[i] != 1) {
					up = false;
					continue;
				}
			}
			if (down) {
				if (arr[i] - arr[i+1] != 1) {
					down = false;
					continue;
				}
			}
		}
		if (up) bw.write("ascending");
		else if (down) bw.write("descending");
		else bw.write("mixed");
		bw.flush();
		bw.close();
	}
}

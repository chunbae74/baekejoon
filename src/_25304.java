import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _25304 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int totalPrice = Integer.parseInt(br.readLine());
		int howMany = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 1; i<= howMany; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			sum += cost * count;
		}
		if (sum == totalPrice) bw.write("Yes");
		else bw.write("No");
		bw.flush();
		bw.close();
	}
}

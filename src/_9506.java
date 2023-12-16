import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _9506 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean isDone = false;
		int n;
		while (!isDone) {
			n = Integer.parseInt(br.readLine());
			if (n == -1) {
				isDone = true;
				break;
			} else {
				ArrayList<String> al = new ArrayList<>();
				al.add("1");
				int sum = 1;
				for (int i = 2; i<n; i++) {
					if (n%i == 0) {
						al.add(Integer.toString(i));
						sum += i;
					}
					else continue;
				}
				if (sum == n) { // 완전수인 경우
					bw.write(n + " = " + String.join(" + ", al));
				} else {
					bw.write(n + " is NOT perfect.");
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}
}

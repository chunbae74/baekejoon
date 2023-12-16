import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1259 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean isDone = false;
		String n;
		while (!isDone) {
			n = br.readLine();
			if (Integer.parseInt(n) == 0) {
				isDone = true;
				break;
			}
			boolean isYes = true;
			// 글자개수 짝수개일시
			if (n.length() % 2 == 0) {
				for (int i = 0; i < n.length()/2; i++) {
					if (Integer.parseInt(n.split("")[i]) != Integer.parseInt(n.split("")[n.length()-1-i])) {
						isYes = false;
					} else continue;
				}
			}
			else { // 글자개수 홀수개일시
				for (int i = 0; i < (n.length()-1)/2; i++) {
					if (Integer.parseInt(n.split("")[i]) != Integer.parseInt(n.split("")[n.length()-1-i])) {
						isYes = false;
					} else continue;
				}
			}
			if (isYes) bw.write("yes");
			else bw.write("no");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}

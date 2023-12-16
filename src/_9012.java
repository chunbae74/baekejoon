import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		line: for (int i = 0; i < num; i++) {
			String s = br.readLine();
			int n = 0;
			wordCheck: for (int j = 0; j < s.length(); j++) {
				if (s.split("")[j].equals("(")) n ++;
				else if (s.split("")[j].equals(")")) n--;
				if (n < 0) {
					bw.write("NO\n");
					continue line;
				}
			}
//			System.out.println(n);
			if (n == 0) bw.write("YES");
			else bw.write("NO");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}

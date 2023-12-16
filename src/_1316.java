import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class _1316 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<String> hs = new HashSet<>();
		int N = Integer.parseInt(br.readLine());
		String pre = "";
		String input;
		int count = 0;
		line: for (int i = 0; i < N; i++) {
			hs.clear();
			input = br.readLine();
			if (input.length() == 1) {
				count ++;
				continue line;
			}
			pre = input.split("")[0];
			hs.add(pre);
			word: for (int j = 1; j < input.length(); j++) {
				String s = input.split("")[j];
				if (hs.contains(s)) { // 이미 해당 값이 나온 적이 있다면
					if (!pre.equals(s)) { // 이전 글자와 연속되지 않은 글자라면
						continue line;
					}
				} else { // 처음 나오는 값이라면
					hs.add(s);
				}
				pre = s;
			}
			count++;
		}
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}

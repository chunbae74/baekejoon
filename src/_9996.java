import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 반례(65%)ㅣ
 * https://www.acmicpc.net/board/view/125380
 */
public class _9996 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] l = br.readLine().split("\\*");
		for (int n = 0; n < N; n++) {
			String input = br.readLine();
			if (input.startsWith(l[0]) && input.endsWith(l[1])) {
				if (input.length() >= l[0].length() + l[1].length()) {
					sb.append("DA\n");
				} else {
					sb.append("NE\n");
				}
			} else {
				sb.append("NE\n");
			}
		}
		
		br.close();
		System.out.println(sb.toString());
	}

}

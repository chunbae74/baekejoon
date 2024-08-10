import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 테케모음ㅣ
 * https://www.acmicpc.net/board/view/102902
 */
public class _1251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String ans = input;
		boolean isChanged = false;
		final int len = input.length();
		// a b^c d^e f (2, 4)
		for (int a = 1; a < len - 1; a++) {
			for (int b = a + 1; b < len; b++) {
				StringBuilder sb = new StringBuilder();
				for (int i = a - 1; i >= 0; i--) {
					sb.append(input.charAt(i));
				}
				for (int i = b - 1; i >= a; i--) {
					sb.append(input.charAt(i));
				}
				for (int i = len - 1; i >= b; i--) {
					sb.append(input.charAt(i));
				}
				String tc = sb.toString();
				if (!isChanged) {
					ans = tc;
					isChanged = true;
				}
				if (ans.compareTo(tc) > 0) {
					ans = tc;
				}
			}
		}
		
		System.out.println(ans);
	}

}

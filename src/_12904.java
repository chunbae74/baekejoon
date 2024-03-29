import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 문자열의 뒤에 A를 추가한다.
 * 문자열을 뒤집고 뒤에 B를 추가한다.
 */
public class _12904 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		String t = br.readLine();
		
		while (s.length() < t.length()) {
			// A로 끝난다면 A 삭제
			if (t.endsWith("A")) {
				t = t.substring(0, t.length() - 1);
			}
			// B로 끝난다면 B 삭제 후 뒤집기
			else if (t.endsWith("B")) {
				StringBuilder sb = new StringBuilder(t.substring(0, t.length() - 1));
				t = sb.reverse().toString();
			}
		}
		
		if (s.equals(t)) bw.write("1");
		else bw.write("0");
		
		bw.flush();
		bw.close();
	}

}

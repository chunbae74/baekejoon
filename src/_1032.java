import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * dir a?b.exe : 첫 번째 글자가 a가, 세 번째 글자가 b이고, 확장자가 exe.
 * 두번째 글자는 아무거나 와도 됨. ex) acb.exe
 * 가능하면 ?를 적게 써야 함
 * 파일 이름의 길이는 모두 같음
 */
public class _1032 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String[] input = new String[N];
		for (int i = 0; i < N; i++) input[i] = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input[0].length(); i++) {
			boolean isSame = true;
			char c = input[0].charAt(i);
			for (int j = 1; j < input.length; j++) {
				if (input[j].charAt(i) != c) {
					isSame = false;
					break;
				}
			}
			if (!isSame) {
				sb.append("?");
			}
			else {
				sb.append(c);
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}

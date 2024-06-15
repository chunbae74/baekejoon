import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

// 앞뒤 글자가 같은 단어가 여러 개 주어지는 경우도 고려해서 작성할것.
// 24.6.15 귀찮아서 지금 말고 나중에 ㅋㅋ

public class _25957 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		HashMap<String, String> hs = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			String key = input.charAt(0) + "" + input.charAt(input.length() - 1);
			hs.put(key, input);
		}
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			String input = st.nextToken();
			String key = input.charAt(0) + "" + input.charAt(input.length() - 1);
			sb.append(hs.get(key)).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

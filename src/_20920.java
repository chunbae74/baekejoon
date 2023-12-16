import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _20920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			if (input.length() < M) continue;
			hm.put(input, hm.getOrDefault(input, 0) + 1);
		}
		
		List<String> list = hm.keySet().stream().collect(Collectors.toList());
		
		list.sort((e1, e2) -> {
			int c1 = hm.get(e1);
			int c2 = hm.get(e2);
			if (c1 == c2) { // 만약 빈도수 같다면
				if (e1.length() == e2.length()) { // 단어 길이 같다면
					return e1.compareTo(e2); // 사전순으로 정렬
				}
				else { // 단어 길이 다르다면
					return e2.length() - e1.length(); // 단어 길이로 정렬
				}
			} else { // 빈도수 다르다면
				return c2 - c1; // 빈도수 높은것부터 정렬
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (String s: list) sb.append(s).append("\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}

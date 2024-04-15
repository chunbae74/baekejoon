import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] arr = new char[600_000];

		String input = br.readLine();
		int idx = 0;
		for (; idx < input.length(); idx++) {
			arr[idx] = input.charAt(idx);
		}
		
		// 글자 개수
		int len = idx;
		// 입력할 명령어의 개수
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char command = st.nextToken().charAt(0);

			switch(command) {
			case 'L' : // 왼쪽으로
				if (idx >= 0) idx --;
				break;
				
			case 'D': // 오른쪽으로
				if (idx < len) idx ++;
				break;
				
			case 'B': // 왼쪽문자 삭제
				if (idx < 0) break;
				
				for (int j = idx; j < len - 1; j++) {
					arr[j] = arr[j + 1];
				}
				len --;
				break;
				
			case 'P': // 문자 왼쪽에 추가
				text = s.charAt(2);
				stack.add(index++, text);
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Character s: stack) sb.append(s);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}

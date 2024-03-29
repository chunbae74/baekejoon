import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1343 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		// 연속된 X의 길이
		int len = 0;
		for (int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			// X의 길이 업데이트
			if (c == 'X') len ++;
			// 만약 . 또는 마지막 글자라면
			if (c == '.' || j == s.length() - 1) {
				// .이 연속된 상황이면 .만 찍고 탈출
				if (len == 0) {
					sb.append(c);
					continue;
				}
				
				// AAAA, BB로 만들 수 있는지 확인
				boolean isPossible = false;
				// i : AAAA의 최대 개수
				int i = len / 4;
				Loop2: for (; i >= 0; i--) {
					// 이 케이스에서는 조합이 불가능하다면 건너뛰기
					if ((len - 4 * i) % 2 != 0) {
						continue Loop2;
					// 구현 가능한 케이스
					} else {
						isPossible = true;
						break Loop2;
					}
					
				}

				// AAAA, BB로 조합이 가능하다면
				if (isPossible) {
					sb.append("AAAA".repeat(i)).append("BB".repeat((len - 4 * i) / 2));
				// AAAA, BB로 조합이 불가능하다면 -1 출력 후 프로그램 종료
				} else {
					System.out.println("-1");
					System.exit(0);
				}
				
				// 만약 .일 경우
				if (c == '.') {
					sb.append(".");					
				}
				
				// 연속된 X 길이 초기화
				len = 0;
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}

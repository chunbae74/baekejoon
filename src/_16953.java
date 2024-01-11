import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		int count = 0;
		int intA = Integer.parseInt(A);
		
		while (true) {
			int intB = Integer.parseInt(B);
			
			if (intA == intB) {
				count += 1;
				break;
			}
			
			// 만약 B가 1로 끝나고 두 자리 수 이상의 수라면
			if (B.endsWith("1") && B.length() > 1) {
				// 맨 뒤에 1 빼고도 크다면
				if (intA <= Integer.parseInt(B.substring(0, B.length() - 1))) {
					B = B.substring(0, B.length() - 1);
					count ++;
					continue;
				}
				// 아니면 컷
				else {
					count = -1;
					break;
				}
			}
			// 1을 뺄 수 없는 상황이라면
			else {
				// 2로 나눌 수 있는 상황이라면
				if (intB % 2 == 0) {
					if (intA <= intB / 2) {
						B = Integer.toString(intB / 2);
						count ++;
						continue;
					} else {
						count = -1;
						break;
					}					
				}
				// 2로 나눌수도 없는 상황이라면
				else {
					count = -1;
					break;
				}
			}
		}
		
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}

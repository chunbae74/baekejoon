import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 테케모음 : https://www.acmicpc.net/board/view/88287
 */
public class _5525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		// Pn의 길이
		int pLen = 2 * N + 1;
		int strLen = Integer.parseInt(br.readLine());
		char[] strArr = br.readLine().toCharArray();
		// 연속되는 IOIO..길이를 차례로 담을 배열
		int[] arr = new int[strLen];
		int idx = 0;
		
		// 첫 번째 글자가 I로 시작하면 true, O로 시작하면 false
		boolean isGood = (strArr[0] == 'I');
		// 첫 번째 글자가 I로 시작하면 길이 1로 시작, O로 시작하면 길이 0으로 시작
		int len = isGood ? 1 : 0;

		// Let's go
		for (int i = 1; i < strLen; i++) {
			char preChar = strArr[i - 1];
			char nowChar = strArr[i];
			// 계속 이어지는거라면
			if (isGood) {
				// IOI.. 연속이 아니라면
				if (preChar == nowChar) {
					// 지금까지의 len 길이 기록 후 초기화
					if (len >= pLen) {
						arr[idx++] = len;
					}
					
					if (nowChar == 'I') {
						len = 1;
					} else {
						// len길이 초기화
						len = 0;
						// isGood 초기화
						isGood = false;
					}
					continue;
				}
				// IOI.. 연속이라면
				else {
					len ++;
					// 마지막 문자열이라면 arr배열에 len길이 업데이트
					if (i == strLen - 1) arr[idx++] = len;
					else continue;
				}
			}
			// 계속 이어지는 것이 아니라면
			else {
				// I로 시작한다면 len, isGood 초기화
				if (nowChar == 'I') {
					len = 1;
					isGood = true;
				} else {
					continue;
				}
			}	
		}
		
		int count = 0;
		for (int i = 0; i < idx; i++) {
			int nowLen = arr[i];
			// nowLen길이가 홀수라면
			if (nowLen % 2 == 1) {
				int cal = ((nowLen + 1) / 2) - N;
				count += Math.max(cal, 0);
			}
			// nowLen길이가 짝수라면
			else {
				int cal = ((nowLen) / 2) - N;
				count += Math.max(cal, 0);
			}
		}
		bw.write(count + "");
		bw.flush();
		bw.close();
		br.close();
	}

}

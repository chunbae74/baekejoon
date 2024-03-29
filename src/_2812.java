import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 못풀겠다 시발
 * 반례모음 : https://www.acmicpc.net/board/view/85578
 */
public class _2812 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;
		
		String s = br.readLine();
		
		char c = s.charAt(0);
		int minNum = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			char cc = s.charAt(i);
			if (minNum > cc) minNum = cc;
			if (i <= K && c < cc) c = cc;
		}
		
		int idx = s.indexOf(c);
		s = s.substring(idx);
		count += idx;
		
		boolean[] isNotOkay = new boolean[s.length()];
		
		// 비교하는 데 기준이 될 숫자
		char standardNum = s.charAt(0);
		for (int i = 1; i < s.length() && count < K; i++) {
			// 현재 숫자
			char nowNum = s.charAt(i);
			if (nowNum == minNum || standardNum > nowNum) {
				isNotOkay[i] = true;
				count ++;
			} else if (standardNum < nowNum) {
				standardNum = nowNum;
			}
			System.out.printf("standardNum = %c\tnowNum = %c\tisNotOkay = %bcount = %d\n", standardNum, nowNum, isNotOkay[i], count);
		}
		
		System.out.println("-".repeat(10));
		
		
		for (int i = 0; (i < s.length() - 1) && count < K; i++) {
			if (isNotOkay[i] || isNotOkay[i+1]) continue;
			char nowNum = s.charAt(i);
			char nextNum = s.charAt(i + 1);
			if (nowNum <= nextNum) {
				isNotOkay[i] = true;
				count ++;
			}
			System.out.printf("nowNum = %c\tnextNum = %c\tisNotOkay = %bcount = %d\n", nowNum, nextNum, isNotOkay[i], count);
		}
		
		/*
		for (int i = s.length() - 1; (i > 0) && count < K; i--) {
			if (isNotOkay[i]) continue;
			char nowNum = s.charAt(i);
			char preNum = s.charAt(i - 1);
			if (nowNum <= preNum) {
				isNotOkay[i] = true;
				count ++;
			}
//			System.out.printf("nowNum = %c\tpreNum = %c\tisNotOkay = %bcount = %d\n", nowNum, preNum, isNotOkay[i], count);
		}
		
		for (int i = isNotOkay.length - 1; (i >= 0) && count < K; i--) {
			if (!isNotOkay[i]) {
				isNotOkay[i] = true;
				count ++;
			}
		}
		*/

		for (int i = 0; i < s.length(); i++) {
			if (!isNotOkay[i]) bw.write(s.charAt(i));
		}
		bw.flush();
		bw.close();
	}

}

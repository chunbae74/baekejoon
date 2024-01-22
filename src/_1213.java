import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1213 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		// 알파벳.
		int[] arr = new int[26];
		char[] result = new char[s.length()];
		
		for (char c: s.toCharArray()) {
			arr[c - 'A'] ++;
		}
		
		// result 배열 시작지점
		int idx = 0;
		// 홀수개인 알파벳 존재여부
		boolean isOdd = false;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) continue;
			// 만약 알파벳의 개수가 홀수개라면
			if (arr[i] % 2 != 0) {
				// 만약 주어진 문자열이 짝수개의 단어로 이루어져있다면
				if (result.length % 2 == 0) {
					System.out.println("I'm Sorry Hansoo");
					System.exit(0);
				}
				// 만약 이미 홀수개인 알파벳이 존재한다면
				if (isOdd) {
					System.out.println("I'm Sorry Hansoo");
					System.exit(0);
				}
				
				isOdd = true;
			}
			
			// 해당 알파벳을 다 사용할때까지 반복하기
			while (arr[i] > 0) {
				// 만약 알파벳이 한 개만 남았다면 가운데에 배치하기
				if (arr[i] == 1) {
					result[result.length/2] = (char)(i + 'A');
					arr[i] --;
				// 만약 알파벳이 두 개 이상 남았다면 양쪽 끝에 배치하기
				} else if (arr[i] > 1) {
					result[idx] = result[result.length - idx - 1] = (char)(i + 'A');
					idx ++;
					arr[i] -= 2;
				}
			}
		}
		
		// array to string
		StringBuilder sb = new StringBuilder();
		for (char c: result) {
			sb.append(c);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * L : 암호길이
 * C : 주어진 C개의 알파벳
 * 암호는 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성됨
 */
public class _1759 {
	
	static int L, C;
	static char[] alphabet;
	static char[] arr;
	static char[] moeum = {'a', 'e', 'i', 'o', 'u'};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[L];
		alphabet = new char[C];
		
		String s = br.readLine();
		for (int i = 0; i < C; i++) {
			alphabet[i] = s.charAt(i * 2);
		}
		
		Arrays.sort(alphabet);
		
		dfs(0, 0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void dfs (int startIdx, int depth) {
		if (depth == L) {
			if (!isSatisfied()) return;
			for(char c: arr) {
				sb.append(c);
			}
			sb.append("\n");
			return;
		}
		
		for (int i = startIdx; i < C; i++) {
			arr[depth] = alphabet[i];
			dfs(i + 1, depth + 1);
		}
	}
	
	/*
	 * 모음 최소 1개 이상
	 * 자음 최소 2개 이상
	 */
	public static boolean isSatisfied() {
		// 모음의 개수
		int count = 0; 		
		for (char c: arr) {
			for (char m: moeum) {
				if (c == m) count ++;
			}
		}

		return count >= 1 && (L - count) >= 2;
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[26];
		for (int i = 0; i<arr.length; i++) arr[i] = -1;
		
		String s = br.readLine();
		for (int i = 0; i<s.length(); i++) {
			if (arr[s.charAt(i) - 'a'] == -1) arr[s.charAt(i)-'a'] = i;
			else continue;
		}
		for (int n: arr) bw.write(n + " ");
		bw.flush();
		bw.close();
	}
}
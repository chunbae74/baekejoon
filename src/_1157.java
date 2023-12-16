import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[26];
		String s = br.readLine();
		for (int i = 0; i<s.length(); i++) {
			if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') { // 대문자인 케이스
				arr[s.charAt(i) - 'A'] ++;
			} else if ('a' <= s.charAt(i) & s.charAt(i) <= 'z') { // 소문자인 케이스
				arr[s.charAt(i) - 'a'] ++;
			}
		}
		int max = -1, count = 0, index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				index = i;
				count = 0;
			} else if (max == arr[i]) count++;
		}
		if (count != 0) bw.write("?");
		else {
            String str = new Character((char)(index + 'A')).toString();
	    	bw.write(str);
        }
        bw.flush();
		bw.close();
	}

}

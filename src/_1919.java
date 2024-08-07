import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1919 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int[] arr1 = new int[26];
		int[] arr2 = new int[26];
		for (char c: s1.toCharArray()) {
			arr1[c - 'a'] ++;
		}
		for (char c: s2.toCharArray()) {
			arr2[c - 'a'] ++;
		}
		
		int count = 0;
		for (int i = 0; i < 26; i++) {
			count += Math.abs(arr1[i] - arr2[i]);
		}
		
		System.out.println(count);
	}

}

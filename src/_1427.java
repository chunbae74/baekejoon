import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int[] count = new int[10];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - '0'] ++;
		}
		for (int i = 9; i >=0; i--) {
			while(count[i]-- > 0) bw.write(i + "");
		}
		/*
		char[] arr = br.readLine().toCharArray();
		Arrays.sort(arr);
		for (int i = arr.length-1; i>=0; i--) bw.write((arr[i] - '0') + "");
		*/
		
		/*
		String s = br.readLine();
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i<s.length(); i++) {
			al.add(s.charAt(i) - '0');
		}
		Collections.sort(al);
		for (int i = al.size() - 1; i >=0; i--) {
			bw.write(al.get(i) + "");
		}
		*/
		bw.flush();
		bw.close();
	}

}

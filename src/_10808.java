import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine().toUpperCase();
		int[] arr = new int[26];
		for (char c: s.toCharArray()) arr[(c - 65)] ++;
		for (int num: arr) bw.write(num + " ");
		bw.close();
	}

}

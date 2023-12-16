import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1475 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[10];
		String s = br.readLine();
		for (char c: s.toCharArray()) arr[c - '0'] ++;
		
		arr[6] = arr[9] = (int) Math.ceil(((double)arr[6] + arr[9]) / 2);

		int max = 0;
		for (int num: arr) {
			if (max < num) max = num;
		}
		
		bw.write(max + "");
		bw.close();
	}

}

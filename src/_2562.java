import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class _2562 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[9];
		int max = 0;
		for (int i = 0; i<9; i++) {
			int order = Integer.parseInt(br.readLine());
			if (max < order) max = order;
			arr[i] = order;
		}
		
		int index = 0;
		for (int i = 0; i<arr.length; i++) {
			if (max == arr[i]) index = i+1;
			else continue;
		}
		bw.write(max + "\n" + index);
		bw.flush();
		bw.close();
	}

}

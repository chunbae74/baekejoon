import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class _2217 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> al = new ArrayList<>();
		for (int i= 0; i < N; i++) {
			al.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(al, Collections.reverseOrder());
		int max, sum;
		max = sum = al.get(0);
		for (int i = 2; i <= N; i++) {
			sum = al.get(i - 1) * i;
			if (sum > max) max = sum;
		}
		
		bw.write(max + "");
		bw.flush();
		bw.close();
	}

}

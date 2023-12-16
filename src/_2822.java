import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class _2822 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, Integer> hm = new HashMap<>();
		int idx = 1;
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			int num = Integer.parseInt(br.readLine());
			al.add(num);
			hm.put(num, idx ++);
		}
		Collections.sort(al, Collections.reverseOrder());
		int sum = 0;
		ArrayList<Integer> index = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			sum += al.get(i);
			index.add(hm.get(al.get(i)));
		}
		
		Collections.sort(index);
		StringBuilder sb = new StringBuilder();
		sb.append(sum).append("\n");
		for(int n: index) sb.append(n).append(" ");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}

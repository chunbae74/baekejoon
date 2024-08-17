import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _2754 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		HashMap<String, Double> hm = new HashMap<>();
		hm.put("A+", 4.3);
		hm.put("A0", 4.0);
		hm.put("A-", 3.7);
		hm.put("B+", 3.3);
		hm.put("B0", 3.0);
		hm.put("B-", 2.7);
		hm.put("C+", 2.3);
		hm.put("C0", 2.0);
		hm.put("C-", 1.7);
		hm.put("D+", 1.3);
		hm.put("D0", 1.0);
		hm.put("D-", 0.7);
		hm.put("F", 0.0);
		System.out.println(hm.get(s));
	}

}

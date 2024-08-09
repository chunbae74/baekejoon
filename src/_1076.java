import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _1076 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, int[]> hm = new HashMap<>();
		hm.put("black", new int[] { 0, 1 });
		hm.put("brown", new int[] { 1, 10 });
		hm.put("red", new int[] { 2, 100 });
		hm.put("orange", new int[] { 3, 1_000 });
		hm.put("yellow", new int[] { 4, 10_000 });
		hm.put("green", new int[] { 5, 100_000 });
		hm.put("blue", new int[] { 6, 1_000_000 });
		hm.put("violet", new int[] { 7, 10_000_000 });
		hm.put("grey", new int[] { 8, 100_000_000 });
		hm.put("white", new int[] { 9, 1_000_000_000 });
		
		String input1 = Integer.toString(hm.get(br.readLine())[0]);
		String input2 = Integer.toString(hm.get(br.readLine())[0]);
		int b = hm.get(br.readLine())[1];
		long a = Long.parseLong(input1.concat(input2));
		System.out.println(a * b);
	}

}

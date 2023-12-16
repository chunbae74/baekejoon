import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _3047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[3];
		for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());
		String input = br.readLine();
		Arrays.sort(arr);
		HashMap<Character, Integer> hm = new HashMap<>();
		hm.put('A', arr[0]);
		hm.put('B', arr[1]);
		hm.put('C', arr[2]);
		StringBuilder sb = new StringBuilder();
		for(char c: input.toCharArray()) {
			sb.append(hm.get(c)).append(" ");
		}		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}

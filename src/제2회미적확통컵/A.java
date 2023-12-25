package 제2회미적확통컵;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());

		HashMap<String, Integer> hm = new HashMap<>();
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int cost = Integer.parseInt(st.nextToken());
			hm.put(s, cost);
			arr[i] = cost;
		}
		
		Arrays.sort(arr);
		
		int howmuch = hm.get("jinju");
		int count = 0;
		for (int n: arr) {
			if (n > howmuch) count ++;
		}
		bw.write(howmuch + "\n" + count);
		bw.flush();
		bw.close();
	}

}

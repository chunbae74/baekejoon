import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _27892 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Long, Long> hm = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken());
		long N = Long.parseLong(st.nextToken());
		br.close();
		
		for (int i = 1; i <= N; i++) {
			long pre = x;
			if (hm.get(x) != null) {
				x = hm.get(x);
				if (x == pre) break;
			} else {
				if (x % 2 == 0) {
					x = (x >> 1) ^ 6;
				} else {
					x = (x << 1) ^ 6;
				}
				if (pre == x) break;
				else hm.put(pre, x);
			}
		}
		
		System.out.println(x);
	}

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _7568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
//		 0 : 몸무게, 1 : 키
		int[][] origin = new int[N][2];
		String[] difShape = new String[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			origin[i][0] =  Integer.parseInt(st.nextToken());
			origin[i][1] = Integer.parseInt(st.nextToken());
			difShape[i] = origin[i][0] + "-" + origin[i][1];
		}
		
		// difShape, rank
		HashMap<String, Integer> hm = new HashMap<>();

		for (int[] a: origin) {
			int x = a[0];
			int y = a[1];
			int rank = 1;
			for (int[] aa: origin) {
				if (aa[0] > x && aa[1] > y) {
					rank++;
				}
			}
			hm.put(x + "-" + y, rank);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (String s: difShape) {
			sb.append(hm.get(s)).append(" ");
		}
		System.out.println(sb.toString());
	}

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _7785 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		HashSet<String> hs = new HashSet<>();
		String name, status;
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			name = st.nextToken();
			status = st.nextToken();
			
			if (status.equals("enter")) hs.add(name);
			else if (status.equals("leave")) {
				if (hs.contains(name)) hs.remove(name);
			}
		}
		
		String[] arr = hs.toArray(new String[hs.size()]);
		Arrays.sort(arr, (e1, e2) -> {
			return e2.compareTo(e1);
		});
//		Arrays.sort(arr, Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(String s: arr) sb.append(s).append("\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}

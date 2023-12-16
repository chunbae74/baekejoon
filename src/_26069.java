import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 총총이 귀여워...
 *
 */
public class _26069 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean isStarted = false;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String s1, s2;
		HashSet<String> hs = new HashSet<>();
		hs.add("ChongChong");
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s1 = st.nextToken();
			s2 = st.nextToken();
			if (hs.contains(s1) || hs.contains(s2)) {
				hs.add(s1);
				hs.add(s2);
			}
		}
		
		bw.write(hs.size() + "");
		bw.flush();
		bw.close();
	}

}

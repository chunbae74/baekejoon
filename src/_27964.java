import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _27964 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		if (N < 4) bw.write("sad");
		else {
			HashSet<String> hs = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s;
			boolean canMake = false;
			for (int i = 0; i < N; i++) {
				s = st.nextToken();
				if (s.endsWith("Cheese")) {
					if (!hs.contains(s)) {
						hs.add(s);
					}
					
					if (hs.size() >= 4) {
						canMake = true;
						break;
					}
				}
			}
			
			bw.write(canMake?"yummy":"sad");
		}
		bw.flush();
		bw.close();
	}

}

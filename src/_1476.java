import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 1 ≤ E ≤ 15
 * 1 ≤ S ≤ 28 
 * 1 ≤ M ≤ 19 
 */
public class _1476 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		while (true) {
			if (E == S && S == M) break;
			
			// E가 가장 작을 때
			if (E <= S && E <= M) {
				E += 15;
			}
			// S가 가장 작을 때
			else if (S <= E && S <= M) {
				S += 28;
			}
			// M이 가장 작을 때
			else if(M <= S && M <= E) {
				M += 19;
			}
		}
		
		bw.write(E + "");
		bw.flush();
		bw.close();
	}

}

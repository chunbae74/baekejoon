import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2675 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st; 
		int num;
		char[] s;
		for (int i = 0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			s = st.nextToken().toCharArray();
			for (int j = 0; j<s.length; j++) {
				for (int k = 0; k<num; k++) bw.write(s[j]+"");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}

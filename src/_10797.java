import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _10797 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()) % 10;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num;
		int count = 0;
		int loop = st.countTokens();
		for (int i = 0; i < loop; i++) {
			num = Integer.parseInt(st.nextToken()) % 10;
			if (N == num) count ++;
		}
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}

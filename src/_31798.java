import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _31798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
	
		int result;
		if (a == 0) {
			result = (int)Math.pow(c, 2) - b;
		} else if (b == 0) {
			result = (int)Math.pow(c, 2) - a;
		} else {
			result = (int)Math.sqrt(a + b);
		}
		
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}

}

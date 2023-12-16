import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _27959 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double N = Double.parseDouble(st.nextToken());
		double M = Double.parseDouble(st.nextToken()) / 100;
		bw.write((N>=M)?"Yes":"No");
		bw.flush();
		bw.close();
	}

}

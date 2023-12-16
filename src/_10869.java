import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _10869 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		bw.write((num1 + num2) + "\n");
		bw.write((num1 - num2) + "\n");
		bw.write((num1 * num2) + "\n");
		bw.write((num1 / num2) + "\n");
		bw.write((num1 % num2) + "\n");
		bw.flush();
		bw.close();
	}

}

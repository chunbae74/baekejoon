import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _9086 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int order = Integer.parseInt(br.readLine());
		String st;
		for (int i = 0; i<order; i++) {
			st = br.readLine();
			bw.write(st.split("")[0] + st.split("")[st.length()-1] + "\n");
		}
		bw.flush();
		bw.close();
	}

}

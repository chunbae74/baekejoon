import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2908 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		/*
		 * StringBuffer Name = new StringBuffer("abc");
		 * Name.append("hi"); // abchi
		 * Name.insert(1, "123"); // a123bchi
		 * Name.reverse(); // ihcb321a
		 * Name.deleteChar(1); // a23bchi
		 * Name.delete(1,3); // abchi
		 * Name.replace(3, 5, "de"); // abcde
		 */
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer(st.nextToken());

		int n1 = Integer.parseInt(sb.reverse().toString());
		sb = new StringBuffer(st.nextToken());
		int n2 = Integer.parseInt(sb.reverse().toString());
		bw.write((n1>n2?n1:n2) + "");
		bw.flush();
		bw.close();
	}

}

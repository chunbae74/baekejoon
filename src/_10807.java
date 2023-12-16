import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _10807 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int order = Integer.parseInt(br.readLine());
		String[] strArr = br.readLine().split(" ");
		int targetorder = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i<strArr.length; i++) {
			if (Integer.parseInt(strArr[i]) == targetorder) count++;
			else continue;
		}
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}

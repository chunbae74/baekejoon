import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _15727 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int L = Integer.parseInt(br.readLine());
		
		int result = L / 5;
		
		if (L % 5 != 0) result += 1;
		
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}

}

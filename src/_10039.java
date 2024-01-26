import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10039 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int sum = 0;
		for (int i = 0; i < 5; i ++) {
			int num = Integer.parseInt(br.readLine());
			sum += (num<40)?40:num;
		} 
		bw.write((sum / 5) + "");
		bw.flush();
		bw.close();
	}

}

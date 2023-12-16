import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class test {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int count = 0;
		while (s.contains("DKSH")) {
			count ++;
			s.replace("DKSH", "");
			if (!s.contains("DKSH") || s.trim().equals("")) break;
		}
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}
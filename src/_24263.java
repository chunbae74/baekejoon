/**
 * 상수 시간이 소요되면 0,
 * n에 비례하면 1, n^2에 비례하면 2, ...
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _24263 {

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		bw.write(n + "\n");
		bw.write("1");
		bw.flush();
		bw.close();
	}

}

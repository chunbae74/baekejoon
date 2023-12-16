import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _5597 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] arr = new boolean[30];
		for (int i = 0; i < 28; i++) { // 일단 상자에 다 담고
			int order = Integer.parseInt(br.readLine()) - 1;
			arr[order] = true;
		}
		for (int i = 0; i < 30; i++) {
			if (arr[i] != true) bw.write(i + 1 + "\n");
		}
		bw.flush();
		bw.close();
	}

}
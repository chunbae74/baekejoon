import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * NumberFormat 오류
 *
 */
public class _9527 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = 0;
		for (char i = A; i <= B; i++) {
			long mask = 1;
			while (mask != 0) {
				if ((i & mask) != 0) count ++;
				mask = mask << 1;				
			}
		}
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}

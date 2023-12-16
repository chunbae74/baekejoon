import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 둘 중 한 명만 맞힌 표적은 다 맞힘
 * 둘 다 못 맞히거나 둘 다 맞힌 것은 전부 안맞힘
 *
 */
public class _27960 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int mask = 1;
		int sum = 0;
		while (mask != 0) {
			if ((mask & A) != (mask & B)) sum += mask;
			mask = mask << 1;
		}
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}

}

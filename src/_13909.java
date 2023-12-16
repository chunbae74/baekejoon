import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 열려있는 창문 갯수 = n*n (n >= 1인 자연수)
 *
 */
public class _13909 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int count = 1;
		for(int i = 2; i*i <= N; i++, count++);
		bw.write(count + "");
		bw.flush();
		bw.close();
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1748 {

   public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	   int N = Integer.parseInt(br.readLine());
	   int count = 0;
	   int len = 1;
	   int 기준 = 10;
	   for (int i = 1; i <= N; i++) {
		   if (i % 기준 == 0) {
			   기준 *= 10;
			   len ++;
		   }
		   count += len;
	   }
	   bw.write(count + "");
	   bw.flush();
	   bw.close();
   }
}

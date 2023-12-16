import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2577 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		String[] result = Integer.toString(A * B * C).split("");
		
		int[] numList = new int[10];
		int index;
		for (int i = 0; i < result.length; i++) {
			index = Integer.parseInt(result[i]);
			numList[index] ++;
		}
		for (int j = 0; j < numList.length; j++) bw.write(numList[j] + "\n");
		bw.flush();
		bw.close();
	}

}

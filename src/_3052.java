import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _3052 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i<10; i++) {
			int order = Integer.parseInt(br.readLine()) % 42;
			if (!al.contains(order)) al.add(order);
		}
		bw.write(al.size() + "");
		bw.flush();
		bw.close();
	}

}

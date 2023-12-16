import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _3009 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> x_left = new ArrayList<>();
		ArrayList<Integer> y_left = new ArrayList<>();
		int x, y;
		StringTokenizer st;
		for(int i = 0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			if(x_left.contains(x)) x_left.remove(x_left.indexOf(x));
			else x_left.add(x);
			if(y_left.contains(y)) y_left.remove(y_left.indexOf(y));
			else y_left.add(y);
		}
		bw.write(x_left.get(0) + " " + y_left.get(0));
		bw.flush();
		bw.close();
	}

}

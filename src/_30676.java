import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _30676 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int x = Integer.parseInt(br.readLine());
		if (620 <= x && x <= 780) bw.write("Red");
		else if (590 <= x && x < 620) bw.write("Orange");
		else if (570 <= x && x < 590) bw.write("Yellow");
		else if (495 <= x && x < 570) bw.write("Green");
		else if (450 <= x && x < 495) bw.write("Blue");
		else if (425 <= x && x < 450) bw.write("Indigo");
		else if (380 <= x && x < 425) bw.write("Violet");
		
		bw.flush();
		bw.close();
	}

}

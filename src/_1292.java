import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1292 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()) - 1;
		int B = Integer.parseInt(st.nextToken());
		
		int sector1 = 0;
		while (true) {
			int preSec = (sector1 + 1) * (sector1 + 2) / 2;
			if (preSec > A) break;
			else if (preSec == A) {
				sector1 ++;
				break;
			} else sector1 ++;
		}
		
		int sector2 = 1;
		while (true) {
			int preSec = (sector2 + 1) * (sector2 + 2) / 2;
			if (preSec > B) break;
			else if (preSec == B) {
				sector2 ++;
				break;
			} else sector2 ++;
		}
		
		long part1 = sector1 * (sector1 + 1) * (sector1 * 2 + 1) / 6;
		int order1 = sector1 * (sector1 + 1) / 2;
		
		part1 += (A - order1) * (sector1 + 1);

		long part2 = sector2 * (sector2 + 1) * (sector2 * 2 + 1) / 6;
		int order2 = sector2 * (sector2 + 1) / 2;
		
		part2 += (B - order2) * (sector2 + 1);

		System.out.println(part2 - part1);
	}

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _1924 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int month = Integer.parseInt(st.nextToken());
		int date = Integer.parseInt(st.nextToken());
		
		LocalDate Date = LocalDate.of(2007, month, date);
		DayOfWeek dayOfWeek = Date.getDayOfWeek();
		
		int dayOfWeekNumber = dayOfWeek.getValue();
		
		HashMap<Integer, String> hm = new HashMap<>() {{
			put(1, "MON");
			put(2, "TUE");
			put(3, "WED");
			put(4, "THU");
			put(5, "FRI");
			put(6, "SAT");
			put(7, "SUN");
		}};
		
		bw.write(hm.get(dayOfWeekNumber));
		bw.flush();
		bw.close();
	}

}

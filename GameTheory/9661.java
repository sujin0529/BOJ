import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 9661] 돌 게임 7

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			long stone = Long.parseLong(br.readLine());
			String result = "";
			long remain = stone%5;
			
			if(remain == 0 || remain == 2) {
				result = "CY";
			}
			else {
				result = "SK";
			}
			
			bw.write(result+"\n");
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}

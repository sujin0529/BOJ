import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 12847] 꿀 아르바이트

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String[] token = br.readLine().split(" ");
			int day = Integer.parseInt(token[0]);
			int maxWork = Integer.parseInt(token[1]);
			
			long[] salary = new long[day+1];
			token = br.readLine().split(" ");
			
			for(int i=1; i<=day; i++) {
				salary[i] = salary[i-1] + Integer.parseInt(token[i-1]);
			}
			
			long maxSalary = 0;
			int start = 1;
			int end = maxWork;
			for(; end<=day; start++, end++) {
				long _salary = salary[end] - salary[start-1];
				maxSalary = maxSalary < _salary ? _salary : maxSalary;
			}
			
			bw.write(maxSalary+"\n");
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}

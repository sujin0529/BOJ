package multiple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String[] s = br.readLine().split(" ");
			int base = Integer.parseInt(s[0]);
			int mul = Integer.parseInt(s[1]);
			int div = Integer.parseInt(s[2]);

			long result = multiplier(base, mul, div);
			bw.write(result + "\n");
			br.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static long multiplier(int base, int mul, int div) {
		if (mul == 1) {
			return base%div;
		}
		else if(mul%2 == 0){
			long tmp = multiplier(base, mul/2, div) % div;
			return (tmp * tmp) % div;
		}
		else{
			long tmp = multiplier(base, mul/2, div) % div;
			return ((base % div) * ((tmp * tmp) % div)) % div;
		}
	}
}
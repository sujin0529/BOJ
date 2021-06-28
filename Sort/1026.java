import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// [백준 1026] 보물

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int num = Integer.parseInt(br.readLine());
			int[] a = new int[num];
			int[] b = new int[num];

			String[] s1 = (br.readLine()).split(" ");
			String[] s2 = (br.readLine()).split(" ");
			for (int i = 0; i < num; i++) {
				a[i] = Integer.parseInt(s1[i] + "");
				b[i] = Integer.parseInt(s2[i] + "");
			}
			
			Arrays.parallelSort(a);
			Arrays.parallelSort(b);
			
			int min = 0;
			for (int i = 0; i < num; i++) {
				min += (a[i]*b[num-i-1]);
			}
			bw.write(min+"\n");
			bw.close();

		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


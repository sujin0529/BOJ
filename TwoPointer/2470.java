import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// [백준 2470] 두 용액

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int num = Integer.parseInt(br.readLine());
			int[] solution = new int[num];

			String[] token = br.readLine().split(" ");
			for (int i = 0; i < num; i++) {
				solution[i] = Integer.parseInt(token[i]);
			}
			Arrays.parallelSort(solution);

			int absolute0 = Integer.MAX_VALUE; // 절댓값으로 비교해서 작은 값을 찾을 것
			int start = 0;
			int end = num - 1;

			int minSolution1 = 0;
			int minSolution2 = 0;

			while (true) {
				if (start >= end) {
					break;
				}

				int sum = solution[start] + solution[end];
				boolean negative = false;
				if (sum < 0) {
					sum = (-1) * sum;
					negative = true;
				}

				if (sum < absolute0) {
					minSolution1 = start;
					minSolution2 = end;
					absolute0 = sum;
				}

				if (negative) {
					start++;
				} else {
					end--;
				}
			}

			bw.write(solution[minSolution1] + " " + solution[minSolution2] + "\n");
			bw.close();
			br.close();

		} catch (Exception e) {

		}
	}
}

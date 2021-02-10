import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// [백준 1654] 랜선 자르기
// https://blog.naver.com/tnwls0529/222214951188

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String[] s = br.readLine().split(" ");
			int currentCount = Integer.parseInt(s[0]);
			int targetCount = Integer.parseInt(s[1]);
			int[] cable = new int[currentCount];
			for (int i = 0; i < currentCount; i++) {
				cable[i] = Integer.parseInt(br.readLine());
			}
			Arrays.parallelSort(cable);
			long length = cuttingLength(cable, 1, Integer.MAX_VALUE, targetCount);
			bw.write(length + "\n");

			br.close();
			bw.close();

		} catch (Exception e) {

		}
	}

	static long cuttingLength(int[] cable, long start, long end, int targetCount) {
		long length = 0;
		long currentLengthCount = 0;
		while (start <= end) {
			currentLengthCount = 0;
			length = (start + end) / 2;
			for (int i = 0; i < cable.length; i++) {
				currentLengthCount += (cable[i] / length);
			}
			if(targetCount == currentLengthCount) {
				break;
			}
			if (targetCount > currentLengthCount) {
				end = length - 1;
			}
			else {
				start = length + 1;
			}
		}
		
		return findMaxLength(cable, length-1, Integer.MAX_VALUE, targetCount);
	}

	static long findMaxLength(int[] cable, long start, long end, int targetCount) {
		long length = 0;
		long maxLength = 0;
		while (start <= end) {
			length = (start + end) / 2;
			long currentLengthCount = 0;
			for (int i = 0; i < cable.length; i++) {
				currentLengthCount += (cable[i] / length);
			}
			if(targetCount > currentLengthCount) {
				end = length - 1;
			}
			else {
				maxLength = length > maxLength ? length : maxLength;
				start = length + 1;
			}
		}
		return maxLength;
	}
}
package stair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int N = Integer.parseInt(br.readLine());
			int[][] stair = new int[N + 1][10];

			for (int i = 1; i < 10; i++) {
				stair[1][i] = 1;
			}

			for (int i = 2; i < N + 1; i++) {
				stair[i][0] = stair[i - 1][1];
				stair[i][9] = stair[i - 1][8];
				for (int j = 1; j < 9; j++) {
					stair[i][j] += ((stair[i - 1][j - 1] + stair[i - 1][j + 1]) % 1000000000);
				}
			}

			int sum = 0;
			for (int i = 0; i < 10; i++) {
				sum = (sum + stair[N][i]) % 1000000000;
			}

			System.out.println(sum);

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
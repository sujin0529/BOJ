package matrixSquare;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String[] tmp = br.readLine().split(" ");
			int size = Integer.parseInt(tmp[0]);
			long iter = Long.parseLong(tmp[1]);

			int[][] matrix = new int[size][size];
			for (int i = 0; i < size; i++) {
				tmp = br.readLine().split(" ");
				for (int j = 0; j < size; j++) {
					matrix[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			br.close();

			int[][] result = matrixSquare(matrix, size, iter);
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					bw.write(result[i][j] + " ");
				}
				bw.write("\n");
			}
			bw.close();

		} catch (Exception e) {

		}
	}

	static int[][] matrixSquare(int[][] matrix, int size, long iter) {
		int[][] result = new int[size][size];
		if (iter == 1) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					result[i][j] = matrix[i][j] % 1000;
				}
			}
			return result;
		}
		else {
			if (iter % 2 == 1) {
				int[][] tmp = matrixSquare(matrix, size, iter / 2);
				tmp = square(tmp, tmp, size);
				result = square(matrix, tmp, size);
			} else {
				int[][] tmp = matrixSquare(matrix, size, iter / 2);
				result = square(tmp, tmp, size);
			}
		}
		return result;
	}

	static int[][] square(int[][] first, int[][] second, int size) {
		int[][] result = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				int sum = 0;
				for (int j = 0; j < size; j++) {
					sum += ((first[row][j] * second[j][col]) % 1000);
				}
				result[row][col] = sum % 1000;
			}
		}
		return result;
	}
}
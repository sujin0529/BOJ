import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 2468] 안전 영역
// https://blog.naver.com/tnwls0529/222244158678

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int size = Integer.parseInt(br.readLine());
			int[][] matrix = new int[size][size];
			boolean[][] visited;
			int height = 0;
			for (int i = 0; i < size; i++) {
				String[] token = br.readLine().split(" ");
				for (int j = 0; j < size; j++) {
					matrix[i][j] = Integer.parseInt(token[j]);
					height = height > matrix[i][j] ? height : matrix[i][j];
				}
			}
			// 지역 높이 입력 초기화

			int max = 1;

			while (height > 0) {
				visited = new boolean[size][size];
				int label = 0;
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						if (!visited[i][j] && matrix[i][j] > height) {
							label++;
							visited[i][j] = true;
							dfs(matrix, visited, height, i, j);
						}
					}
				}
				max = max < label ? label : max; // 안전 영역 최대 개수 찾기
				height--;
			}

			bw.write(max + "\n");
			bw.close();
			br.close();

		} catch (Exception e) {

		}
	}

	static void dfs(int[][] matrix, boolean[][] visited, int height, int y, int x) {
		int[] _dx = { -1, 1, 0, 0 };
		int[] _dy = { 0, 0, 1, -1 };
		for (int i = 0; i < 4; i++) {
			int dx = x + _dx[i];
			int dy = y + _dy[i];
			if (dx < 0 || dy < 0 || dx >= matrix[0].length || dy >= matrix[0].length) {
				continue;
			}
			if (!visited[dy][dx] && matrix[dy][dx] > height) {
				visited[dy][dx] = true;
				dfs(matrix, visited, height, dy, dx);
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// [백준 15652] N과 M (4)

public class Main {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		try {
			s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			br.close();

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			boolean visit[][] = new boolean[M][N + 1];
			dfs(1, N, M, 0, visit);
			bw.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void print(int n, int m, boolean visit[][]) {
		try {
			for (int i = 0; i < m; i++) {
				for (int j = 1; j <= n; j++) {
					if (visit[i][j]) {
						bw.write(j + " ");
						break;
					}
				}
			}
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void dfs(int start, int n, int m, int count, boolean visit[][]) {

		if (m == count) {
			print(n, m, visit);
		}

		for (int i = start; i <= n; i++) {
			if (m > count && !visit[count][i]) {
				visit[count][i] = true;
				dfs(i, n, m, count + 1, visit);
				visit[count][i] = false;
			}
		}
	}

}

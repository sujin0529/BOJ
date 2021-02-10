import java.util.Arrays;
import java.util.Scanner;

// [백준 1916] 최소비용 구하기
// https://blog.naver.com/tnwls0529/222069483823

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int city = sc.nextInt();
		int bus = sc.nextInt();

		int matrix[][] = new int[city + 1][city + 1];
		boolean visit[] = new boolean[city + 1];
		int cost[] = new int[city + 1];

		for (int i = 1; i <= city; i++) {
			Arrays.fill(matrix[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < bus; i++) {
			int head = sc.nextInt();
			int tail = sc.nextInt();
			int weight = sc.nextInt();

			if (weight < matrix[head][tail]) {
				// 이미 같은 노선의 더 빠른 weight를 입력받았을 경우
				matrix[head][tail] = weight;
			}

		}

		int source = sc.nextInt();
		int dest = sc.nextInt();

		visit[source] = true;

		for (int i = 1; i <= city; i++) {
			// cost 초기화
			cost[i] = matrix[source][i];
		}

		for (int i = 1; i < city; i++) {
			// 횟수 제한
			int min_city = minCity(city, cost, visit);
			visit[min_city] = true; // 방문으로 바꾸기
			for (int j = 1; j <= city; j++) {
				if (visit[j]) {
					// 이미 방문했다면, 건너뛰어도 됨.
					continue;
				}
				if (matrix[min_city][j] != Integer.MAX_VALUE && cost[j] > cost[min_city] + matrix[min_city][j]) {
					// j로 가는데 min_city를 거쳐 가는 것이 더 가깝다면
					cost[j] = cost[min_city] + matrix[min_city][j];
				}
			}
		}

		System.out.println(cost[dest]);

	}

	static int minCity(int city, int cost[], boolean visit[]) {
		int min = Integer.MAX_VALUE; // 가장 작은 cost 찾을 것
		int index = 0;

		for (int i = 1; i <= city; i++) {
			if (!visit[i]) {
				// 아직 방문하지 않음
				if (min > cost[i]) {
					// 더 적은 비용
					min = cost[i];
					index = i;
				}
			}
		}

		return index;
	}

}

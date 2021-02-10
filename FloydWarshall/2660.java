import java.util.Arrays;
import java.util.Scanner;

// [백준 2660] 회장뽑기
// https://blog.naver.com/tnwls0529/222059745087

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int member = sc.nextInt();

		int membership[][] = new int[member + 1][member + 1];
		for (int i = 1; i <= member; i++) {
			Arrays.fill(membership[i], Integer.MAX_VALUE);
		}

		int first = sc.nextInt();
		int second = sc.nextInt();

		while (first != -1 && second != -1) {
			membership[first][second] = 1;
			membership[second][first] = 1;
			first = sc.nextInt();
			second = sc.nextInt();
		}

		for (int i = 1; i <= member; i++) {
			for (int j = 1; j <= member; j++) {
				for (int k = 1; k <= member; k++) {
					if (membership[i][k] != Integer.MAX_VALUE && membership[k][j] != Integer.MAX_VALUE) {
						if (membership[i][j] > (membership[i][k] + membership[k][j])) {
							// k를 거쳐 친구. 가장 가까운 사이를 기준으로 따지는 것이므로, 최소값으로 볼 것
							membership[i][j] = (membership[i][k] + membership[k][j]);
							membership[j][i] = (membership[i][k] + membership[k][j]);
						}
					}

					if (membership[member - i + 1][k] != Integer.MAX_VALUE
							&& membership[k][member - j + 1] != Integer.MAX_VALUE) {
						if (membership[member - i + 1][member - j + 1] > (membership[member - i + 1][k]
								+ membership[k][member - j + 1])) {
							// k를 거쳐 친구. 가장 가까운 사이를 기준으로 따지는 것이므로, 최소값으로 볼 것
							membership[member - i + 1][member - j + 1] = (membership[member - i + 1][k]
									+ membership[k][member - j + 1]);
							membership[member - j + 1][member - i + 1] = (membership[member - i + 1][k]
									+ membership[k][member - j + 1]);
						}
					}
				}
			}
		}

		int min_member = 0;
		int candidate_membership = Integer.MAX_VALUE; // 가장 유력한 회장 후보의 max_membership 값
		int max_membership = 0; // 가장 큰 관계가 곧 점수. 단, MAX_VALUE는 안됨
		String result = ""; // 회장 후보 모을 변수
		for (int i = 1; i <= member; i++) {
			max_membership = 0;
			for (int j = 1; j <= member; j++) {
				if (i == j) {
					continue;
				}
				if (max_membership < membership[i][j]) {
					max_membership = membership[i][j];
				}
			}
			if (candidate_membership > max_membership) {
				// 더 작은 값인 경우, 초기화 한 후 다시 출력 준비
				min_member = 1;
				candidate_membership = max_membership;
				result = "";
				result += (i + " ");
			} else if (candidate_membership == max_membership) {
				min_member++;
				result += (i + " ");
			}

		}

		System.out.println(candidate_membership + " " + min_member);
		System.out.println(result);

	}

}

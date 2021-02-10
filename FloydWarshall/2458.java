import java.util.Scanner;

// [백준 2458] 키 순서
// https://blog.naver.com/tnwls0529/222060118984

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int student = sc.nextInt();
		int compare = sc.nextInt();
		
		int height[][] = new int[student+1][student+1];
		
		for(int i=0; i<compare; i++) {
			int _s = sc.nextInt(); // 키 작은 친구
			int _l = sc.nextInt(); // 키 큰 친구
			height[_s][_l] = 1;
		}
		
		// 자신이 시작으로 있거나, 자신으로 오거나 하는 게 모든 vertex에 대해서 있으면
		// 자신의 키 순서를 알 수 있음.
		
		for(int i=1; i<=student; i++) {
			for(int j=1; j<=student; j++) {
				for(int k=1; k<=student; k++) {
					if(i==j) {
						// 최대 500*500 번의 연산 횟수 감소
						break;
					}
					if(height[i][k] == 1 && height[k][j] == 1) {
						height[i][j] = 1; // i는 j보다 작음
					}
					if(height[student-i+1][k] == 1 && height[k][student-j+1] == 1) {
						height[student-i+1][student-j+1] = 1;
					}
				}
			}
		}
		
		int count = 0;
		for(int i=1; i<=student; i++) {
			int connect = 0;
			for(int j=1; j<=student; j++) {
				if(height[i][j] == 1 || height[j][i] == 1) {
					// j에 대해서 i가 작거나 크다는 것을 알 수 있음
					connect++;
				}
			}
			if(connect == (student-1)) {
				// 자신을 제외한 나머지 학생들에 대해 자신이 어디에 위치하는지를 안다는 의미
				count++;
			}
		}
		
		System.out.println(count);

	}

}

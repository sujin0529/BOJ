import java.util.Scanner;

// [백준 14503] 로봇 청소기
// https://blog.naver.com/tnwls0529/221823159392

public class Main {
	static int N;
	static int M;
	static int count; // 청소한 영역의 개수 -> 연산할 때 덧셈을 하는 게 더 정확해서 static으로 둠
	
	static int[] cleaning(int matrix[][], int x, int y, int dir, int clear) {
		// 배열과 현재 바라보는 방향을 파라미터로 받음. (+ 현재 좌표)
		// 네 방향 모두 이동할 수 없는 경우에는 clear 값으로 1을 받음
		
		int[] clean = new int[4]; // x, y, dir, 청소 가능 여부를 담은 배열
		
		if(clear == 0) {
			if(matrix[y][x]==0) {
				count++;
			}
			matrix[y][x] = 2; // 1. 현재 위치 청소 (청소된 곳은 2로 표시)
			
			// 2-a 체크
			if(dir == 0) {
				// 북쪽이라면
				if(x>0 && matrix[y][x-1]==0) {
					// 청소할 수 있으면
					clean[0] = x-1; // x좌표
					clean[1] = y; // y좌표
					clean[2] = 3; // 방향
					clean[3] = 1; // 왼쪽 방향 청소 가능
				}
				else {
					clean[0] = x;
					clean[1] = y;
					clean[2] = 3;
					clean[3] = 0; // 왼쪽 청소 못해서 회전만 함.
				}
			}
			else if(dir == 1) {
				// 동쪽이라면
				if(y>0 && matrix[y-1][x]==0) {
					// 청소할 수 있으면
					clean[0] = x; // x좌표
					clean[1] = y-1; // y좌표
					clean[2] = 0; // 방향
					clean[3] = 1; // 왼쪽 방향 청소 가능
				}
				else {
					clean[0] = x;
					clean[1] = y;
					clean[2] = 0;
					clean[3] = 0; // 왼쪽 청소 못해서 회전만 함.
				}
				
			}
			else if(dir == 2) {
				// 남쪽이라면
				if(x<(M-1) && matrix[y][x+1]==0) {
					// 청소할 수 있으면
					clean[0] = x+1; // x좌표
					clean[1] = y; // y좌표
					clean[2] = 1; // 방향
					clean[3] = 1; // 왼쪽 방향 청소 가능
				}
				else {
					clean[0] = x;
					clean[1] = y;
					clean[2] = 1;
					clean[3] = 0; // 왼쪽 청소 못해서 회전만 함.
				}
			}
			else {
				// 서쪽이라면
				if(y<(N-1) && matrix[y+1][x]==0) {
					// 청소할 수 있으면
					clean[0] = x; // x좌표
					clean[1] = y+1; // y좌표
					clean[2] = 2; // 방향
					clean[3] = 1; // 왼쪽 방향 청소 가능
				}
				else {
					clean[0] = x;
					clean[1] = y;
					clean[2] = 2;
					clean[3] = 0; // 왼쪽 청소 못해서 회전만 함.
				}
			}
		}
		else if(clear == 1) {
			// 네 방향 모두 청소가 되었거나 1이라는 의미
			if(dir == 0) {
				// 북쪽이라면
				if(y<(N-1) && matrix[y+1][x]!=1) {
					// 후진 할 수 있으면
					clean[0] = x; // x좌표
					clean[1] = y+1; // y좌표
					clean[2] = 0; // 방향
					clean[3] = 2; // 후진이 가능 -> clear 0으로 두고 다시 연산 수행하면 될 듯
				}
				else {
					clean[0] = x;
					clean[1] = y;
					clean[2] = 0;
					clean[3] = 3; // 벽이라서 후진 불가능 -> 작동 종료
				}
			}
			else if(dir == 1) {
				// 동쪽이라면
				if(x>0 && matrix[y][x-1]!=1) {
					// 청소할 수 있으면
					clean[0] = x-1; // x좌표
					clean[1] = y; // y좌표
					clean[2] = 1; // 방향
					clean[3] = 2; // 후진이 가능
				}
				else {
					clean[0] = x;
					clean[1] = y;
					clean[2] = 1;
					clean[3] = 3; // 벽이라서 후진 불가능 -> 작동 종료
				}
				
			}
			else if(dir == 2) {
				// 남쪽이라면
				if(y>0 && matrix[y-1][x]!=1) {
					// 청소할 수 있으면
					clean[0] = x; // x좌표
					clean[1] = y-1; // y좌표
					clean[2] = 2; // 방향
					clean[3] = 2; // 후진이 가능
				}
				else {
					clean[0] = x;
					clean[1] = y;
					clean[2] = 2;
					clean[3] = 3; // 벽이라서 후진 불가능 -> 작동 종료
				}
			}
			else {
				// 서쪽이라면
				if(x<(M-1) && matrix[y][x+1]!=1) {
					// 청소할 수 있으면
					clean[0] = x+1; // x좌표
					clean[1] = y; // y좌표
					clean[2] = 3; // 방향
					clean[3] = 2; // 후진이 가능
				}
				else {
					clean[0] = x;
					clean[1] = y;
					clean[2] = 3;
					clean[3] = 3; // 벽이라서 후진 불가능 -> 작동 종료
				}
			}
			
		}

		// 다음 청소할 곳이 있는지를 확인하고 반환해주자.
		return clean;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		int matrix[][] = new int[N][M];
		
		int y = sc.nextInt(); // y좌표 입력 -> N위치
		int x = sc.nextInt(); // x좌표 입력 -> M위치
		
		int dir = sc.nextInt(); // 방향
		// 0 : 북 / 1 : 동 / 2 : 남 / 3 : 서/
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		int[] clean = cleaning(matrix, x, y, dir, 0);
		
		while(clean[3] != 3) {
			int impossible = 0; // 4구역 돌아서 불가능이면 다른 방법 찾아야 하니까
			while(impossible < 4) {
				clean = cleaning(matrix, clean[0], clean[1], clean[2], 0);
				
				if(clean[3]==0) {
					// 회전을 못함
					impossible++;
				}
				else {
					impossible = 0;
				}
			}
			clean = cleaning(matrix, clean[0], clean[1], clean[2], 1); // 후진
		}
		
		// 작동 종료되면 나옴
		System.out.println(count);
	}

}

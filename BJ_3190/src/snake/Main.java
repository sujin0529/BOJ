package snake;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 보드의 크기 입력
		int board[][] = new int[N+2][N+2]; // 벽 공간까지 고려한 할당
		
		for(int i=0; i<N+2; i++) {
			board[0][i] = 4;
			board[i][0] = 4;
			board[N+1][i] = 4;
			board[i][N+1] = 4;
		}
		// 벽 세우기
		
		int K = sc.nextInt(); // 사과의 개수
		
		for(int i=0; i<K; i++) {
			int y = sc.nextInt(); // 행
			int x = sc.nextInt(); // 열
			board[y][x] = 1; // 사과있는 칸은 1로 표시
		}
		
		int L = sc.nextInt(); // 방향 변환 횟수
		int remember[][] = new int[L+1][2];
		// 초, 방향에 대한 인덱스 기억할 배열 <- 머리와 꼬리에서 지나는 시간이 달라야 함.
		// 방향은 굳이 기억할 필요가 없음
		
		int dx[] = {1,0,-1,0};
		int dy[] = {0,-1,0,1};
		// left 회전을 기준으로 dx, dy 설정해둠 (인덱스로 접근하게 하기 위함)
			
		int X=0;
		int direc = 0; // 정수형으로 저장하고, 비교는 char형으로 할 수 있음
		int direc_index = 0; // 뱀이 나아가는 방향
		
		for(int i=0; i<L; i++) {
			X = sc.nextInt();
			direc = sc.next().charAt(0); // String에서 char로 바로 변환
			if(direc=='L') {
				// 왼쪽 회전이면
				direc_index = (direc_index+1)%4;
			}
			else if(direc=='D') {
				// 오른쪽 회전이면
				direc_index = (direc_index+3)%4;
				// -1+4 = 3 -> 음수 안나오게 하려고
			}
			remember[i][0] = X;
			remember[i][1] = direc_index;
			// 초, 인덱스 순으로 저장
		}
		remember[L][0] = Integer.MAX_VALUE;
		// 배열 범위 넘어서는 것을 막기 위함임.
		
		direc_index = 0;
		int direc_x = dx[direc_index];
		int direc_y = dy[direc_index];
		// 초기 뱀이 향하는 방향
		
		int time = 0;
		int tail_time = time; // 뱀의 꼬리 시간도 봐야 함.
		
		board[1][1] = 2; // 뱀 위치 초기상태
		
		
		int snakeHead_x = 1;
		int snakeHead_y = 1;
		// 초기 뱀의 머리 위치
		
		int snakeTail_x = 1;
		int snakeTail_y = 1;
		// 초기 뱀의 꼬리 위치
		
		int r_index = 0; // remember 배열 인덱스
		X = remember[r_index][0];
		
		int r_tail = 0; // tail에 대한 remember 배열 인덱스
		int direc_tail = direc_index; // 초기 꼬리의 방향
		
		while(true) {
			
			if(tail_time==remember[r_tail][0]) {
				// 꼬리에서 생각해야하는 시간 변경
				direc_tail = remember[r_tail][1];
				r_tail++;
			}
			
			if(time<X) {
				time++;
				tail_time++;
				if(board[snakeHead_y+direc_y][snakeHead_x+direc_x]==1) {
					// 만약 사과가 있으면
					tail_time--; // 꼬리의 시간은 변하지 않음
					
					snakeHead_y = snakeHead_y+direc_y;
					snakeHead_x = snakeHead_x+direc_x;
					// 머리 위치 조정
					board[snakeHead_y][snakeHead_x] = 2;		
				}
				else if(board[snakeHead_y+direc_y][snakeHead_x+direc_x]==4) {
					// 벽을 만났으면
					break;
				}
				else if(board[snakeHead_y+direc_y][snakeHead_x+direc_x]==2) {
					// 자기 자신과 부딪히면
					break;
				}
				else {
					// 아무것도 없으면
					snakeHead_y = snakeHead_y+direc_y;
					snakeHead_x = snakeHead_x+direc_x;
					// 머리 위치 조정
					
					board[snakeHead_y][snakeHead_x] = 2;		
					board[snakeTail_y][snakeTail_x] = 0;
					// 뱀 이동했으므로 board에도 반영
					
					snakeTail_y = snakeTail_y+dy[direc_tail];
					snakeTail_x = snakeTail_x+dx[direc_tail];
					// 꼬리 위치도 조정
					
				}
			}
			else if(time==X) {
					direc_index = remember[r_index][1]; // 방향을 바꾸고
					direc_y = dy[direc_index];
					direc_x = dx[direc_index];
					r_index++;	
					X = remember[r_index][0]; // 시간도 그 다음 시간으로 바꿔줌
			}	
		}
		
		System.out.println(time);
	}
}

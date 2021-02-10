import java.util.Scanner;

// [백준 14891] 톱니바퀴
// https://blog.naver.com/tnwls0529/221828067499

public class Main {
	
	static void rotate(int[] first, int[] second, int[] third, int[] fourth, int num, int direc) {
		if(num==1) {
			int check = 0; // 1만 회전
			if(first[2]!=second[6]) {
				check = 1; // 1-2만 회전
			}
			if(check==1 && second[2]!=third[6]) {
				check = 2; // 1-2-3번 회전
			}
			if(check==2 && third[2]!=fourth[6]) {
				check = 3; // 전부 회전
			}
			// 회전 여부 따지기
			
			clockOrAnticlock(first, direc);
			if(check == 1) {
				clockOrAnticlock(second, -direc);
			}
			else if(check == 2) {
				clockOrAnticlock(second, -direc);
				clockOrAnticlock(third, direc);
			}
			else if(check == 3) {
				clockOrAnticlock(second, -direc);
				clockOrAnticlock(third, direc);
				clockOrAnticlock(fourth, -direc);
			}
			
		}
		else if(num==2){
			int check = 0; // 2만 회전
			int last_check = 0; // 3-4 회전 체크
			if(first[2]!=second[6] || second[2]!=third[6]) {
				if(first[2]!=second[6] && second[2]!=third[6]) {
					check = 3; // 1-2, 2-3 회전
				}
				else if(first[2]!=second[6]) {
					check = 1; // 1-2만 회전
				}
				else {
					check = 2; // 2-3만 회전
				}
			}
			if(check > 1 && third[2]!=fourth[6]) {
				last_check = 1;
			}
			// 회전 여부 따지기
			
			clockOrAnticlock(second, direc);
			if(check == 1) {
				clockOrAnticlock(first, -direc);
			}
			else if(check == 2) {
				clockOrAnticlock(third, -direc);
			}
			else if(check == 3) {
				clockOrAnticlock(first, -direc);
				clockOrAnticlock(third, -direc);
			}
			
			if(last_check == 1) {
				clockOrAnticlock(fourth, direc);
			}
		}
		else if(num==3) {
			int check = 0; // 3만 회전
			int last_check = 0; // 1-2 회전 체크
			
			if(second[2]!=third[6] || third[2]!=fourth[6]) {
				if(second[2]!=third[6] && third[2]!=fourth[6]) {
					check = 3; // 2-3, 3-4 회전
				}
				else if(third[2]!=fourth[6]) {					
					check = 1; // 3-4만 회전
				}
				else {
					check = 2; // 2-3만 회전
				}
			}
			if(check > 1 && first[2]!=second[6]) {
				last_check = 1;
			}
			// 회전 여부 따지기
			
			clockOrAnticlock(third, direc);
			if(check == 1) {
				clockOrAnticlock(fourth, -direc);
			}
			else if(check == 2) {
				clockOrAnticlock(second, -direc);
			}
			else if(check == 3) {
				clockOrAnticlock(second, -direc);
				clockOrAnticlock(fourth, -direc);	
			}
			
			if(last_check == 1) {
				clockOrAnticlock(first, direc);
			}
		}
		else {
			int check = 0; // 4만 회전
			if(third[2]!=fourth[6]) {
				check = 1; // 3-4만 회전
			}
			if(check==1 && second[2]!=third[6]) {
				check = 2; // 2-3-4 회전
			}
			if(check==2 && first[2]!=second[6]) {
				check = 3; // 전부 회전
			}
			// 회전 여부 따지기
			
			clockOrAnticlock(fourth, direc);
			if(check == 1) {
				clockOrAnticlock(third, -direc);
			}
			else if(check == 2) {
				clockOrAnticlock(third, -direc);
				clockOrAnticlock(second, direc);
			}
			else if(check == 3) {
				clockOrAnticlock(third, -direc);
				clockOrAnticlock(second, direc);
				clockOrAnticlock(first, -direc);
			}
		}
	}
	
	static void clockOrAnticlock(int[] wheel, int direc) {
		// 1인 경우 시계, -1인 경우 반시계
		if(direc == 1) {
			// call by value 형태이기 때문에, wheel 배열 값을 일일히 변경해줘야 함.
			// clone이 안됨
			int temp = wheel[7];
			for(int i=7; i>0; i--) {
				wheel[i] = wheel[i-1];
			}
			wheel[0] = temp;
			
		}
		else if(direc == -1) {
			int temp = wheel[0];
			for(int i=0; i<7; i++) {
				wheel[i] = wheel[i+1];
			}
			wheel[7] = temp;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int wheel[][] = new int[4][8]; // 4개의 톱니바퀴에 대해 톱니의 극을 저장할 배열
		
		for(int i=0; i<4; i++) {
			String temp = sc.nextLine();
			for(int j=0; j<8; j++) {
				wheel[i][j] = Integer.parseInt(temp.charAt(j)+"");
			}
		}
		
		int K = Integer.parseInt(sc.nextLine()); // 회전 횟수
		for(int i=0; i<K; i++) {
			String s = sc.nextLine();
			String[] token = s.split(" ");
			int number = Integer.parseInt(token[0]); // 회전시킬 바퀴 번호
			int direction = Integer.parseInt(token[1]); // 방향 -> 1 : 시계, -1 : 반시계
			rotate(wheel[0], wheel[1], wheel[2], wheel[3], number, direction);
		}
		
		int score = 0;
		if(wheel[0][0] == 1) {
			score += 1;
		}
		if(wheel[1][0] == 1) {
			score += 2;
		}
		if(wheel[2][0] == 1) {
			score += 4;
		}
		if(wheel[3][0] == 1) {
			score += 8;
		}

		System.out.println(score);
	}
}
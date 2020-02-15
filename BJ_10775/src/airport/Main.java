package airport;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int gate = sc.nextInt(); // 게이트 수
		int airplane = sc.nextInt(); // 비행기 수
		int docking[] = new int[gate+1]; // 게이트 번호랑 맞추기 위해서 +1
		
		for(int i=0; i<airplane; i++) {
			int _gate = sc.nextInt();
			int check = 0; // 넣는 것에 성공했는지 아닌지를 확인
			for(int j=_gate; j>0; j--) {
				// 뒤에서부터 확인하면서 도킹되지 않은 게이트가 있는지를 확인하기 위함
				if(docking[j]==0) {
					// 도킹되지 않은 게이트
					docking[j] = 1; // 도킹
					check = 1; // 넣는 것에 성공
					break;
				}
			}
			if(check==0) {
				// 만약 넣는 것에 성공하지 못했다면, 더 이상 비행기가 도킹될 수 없으므로 break
				break;
			}
		}
		
		int count = 0;
		for(int i=1; i<=gate; i++) {
			// 도킹에 성공한 비행기의 수 카운트
			count += docking[i];
		}
		
		System.out.println(count);
	}
}

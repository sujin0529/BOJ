import java.util.Scanner;

// [백준 1436] 영화감독 숌
// https://blog.naver.com/tnwls0529/221845076616

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // N번째 종말의 수
		
		String number = "666";
		int int_num = 0;
		
		for(int i=2; i<=N; i++) {
			
			// 우선 더하고 계산해야 할 듯
			int_num = Integer.parseInt(number); // 원래 값
			int_num += 1000;
			number = int_num+""; // string 형태로 변환하여 다시 저장
			
			
			int six = 0;
			int index = 0; // 연속된 6의 시작점
			for(int j=0; j<number.length(); j++) {
				if(six==0 && number.charAt(j)=='6') {
					// 시작점 기억
					index = j;
					six++;
				}
				else if(number.charAt(j)=='6') {
					six++;
				}
				else if(six<4 && number.charAt(j) !='6'){
					six = 0;
					// six 값 초기화 (연속된 4개 이상의 6이 있는지를 찾고자 하는 것이므로)
				}
				
			}
			if(six>3) {
				// 4개 이상이라면
				String temp = number.substring(index);
				int_num = Integer.parseInt(temp); // 정수형으로 변환
				int sub = int_num/1000; // 뺄 값 정하기
				int_num = Integer.parseInt(number); // 원래 값
				int_num -= sub; // 연속된 666만 남기기
				
				int iter = 0;
				while(sub>10) {
					sub/= 10;
					iter++;
				}
				// 6이 많은 구역을 벗어나기 위해서 얼만큼을 반복해야하는지를 계산함
				
				iter = 10*((int)Math.pow(10, iter));
				// 값이 6인 경우에는 0~9, 66인 경우에는 0~99까지 반복해야 하기 때문임.

				for(int k=0; k<iter; k++) {
					if(N==i) {
						// 만약 찾고자 하는 번호의 종말의 숫자라면
						System.out.println(int_num);
						System.exit(0);
					}
					int_num++;
					i++;
				}
				
				int_num = Integer.parseInt(number); // 원래 값
				int_num += 1000;
				number = int_num+""; // string 형태로 변환하여 다시 저장
				// 1000을 증가시켜 6이 연속해서 4개 이상 나온 경우의 다음  숫자를 찾아주기 위함임.
			}
		}
		System.out.println(number);
		

	}

}

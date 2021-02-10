import java.util.Scanner;

// [백준 1138] 한 줄로 서기
// https://blog.naver.com/tnwls0529/222036371763

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] people = new int[N];
		for(int i=0; i<N; i++) {
			people[i] = sc.nextInt();
		}
		
		int[] line = new int[N]; // 한 줄로 섰을 때 정렬된 위치
		// 더 키가 큰 애한테는 작은 애들의 수는 영향을 주지 않으므로, 오른쪽으로 이동하며 자리를 찾는다.
		
		for(int i=0; i<N; i++) {
			int index = people[i]; // 사람을 놓으려고 하는 위치
			for(int j=0; j<index; j++) {
				if(line[j] != 0) {
					// 나보다 작은 애가 이전에 있다는 것은,
					// 나의 순서가 더 밀려야 한다는 뜻
					index++;
				}
			}
			
			if(line[index] == 0) {
				// 아직 해당 자리가 차지 않았다는 의미
				line[index] = i+1; // 사람 번호
			}
			else {
				while(line[index] != 0) {
					index++;
				}
				line[index] = i+1;
			}
		}
		for(int i=0; i<N; i++) {
			System.out.print(line[i]+" ");
		}
		

	}

}

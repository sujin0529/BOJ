package bracket;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String temp = sc.nextLine(); // 수식 입력
		int sum = 0;
		
		if(temp.contains("-")) {
			String[] s = temp.split("\\-"); // - 연산으로 나누기
			
			for(int i=0; i<s.length; i++) {
				if(s[i].contains("+")) {
					String[] adder = s[i].split("\\+");
					int add = Integer.parseInt(adder[0]);
					for(int j=1; j<adder.length; j++) {
						add += Integer.parseInt(adder[j]);
					}
					// A+B 형태를 C의 하나 값으로 만들고
					s[i] = add+""; // 위의 값을 스트링 형태로 만들어 다시 저장
				}
			}
			
			sum = Integer.parseInt(s[0]);
			for(int i=1; i<s.length; i++) {
				sum -= Integer.parseInt(s[i]);
			}
		}
		else if(temp.contains("+")) {
			// 만약 -를 포함하지 않고, +를 포함할 때
			String[] s = temp.split("\\+"); // - 연산으로 나누기
			
			sum = Integer.parseInt(s[0]);
			for(int i=1; i<s.length; i++) {
				sum += Integer.parseInt(s[i]);
			}
			
		}
		else {
			// 아무 연산도 포함하지 않는다면
			sum = Integer.parseInt(temp);
		}
		
		
		System.out.println(sum);

	}

}

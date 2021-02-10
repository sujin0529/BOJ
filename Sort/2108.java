import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

// [백준 2108] 통계학

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> number = new ArrayList<>();
		HashMap<Integer, Integer> fre = new HashMap<>();
		// 빈도 계산하기 위한  맵
		
		int num = sc.nextInt(); // 수의 개수
		int sum = 0;
		for(int i=0; i<num; i++) {
			int temp = sc.nextInt();
			sum += temp;
			number.add(temp);
			if(!fre.containsKey(temp)) {
				fre.put(temp, 1);
			}
			else {
				fre.put(temp, fre.get(temp)+1);
			}
		}
		System.out.println((int)Math.round((double)sum/num)); // 산술 평균
		
		Collections.sort(number); // 소팅
		System.out.println(number.get((num-1)/2)); // 중앙값 출력
		
		int max = 0;
		ArrayList<Integer> key_arr = new ArrayList<>();
		
		Iterator<Integer> iter = fre.keySet().iterator();
		while(iter.hasNext()) {
			int key = iter.next();
			if(fre.get(key)>max) {
				key_arr.clear(); // 배열 클리어하고
				key_arr.add(key); // 새로 추가
				max = fre.get(key);
			}
			else if(fre.get(key) == max) {
				key_arr.add(key);
			}
		}
		
		Collections.sort(key_arr);
		
		if(key_arr.size()>1) {
			System.out.println(key_arr.get(1)); // 최빈값 출력 -> 두 번째로 작은 값 출력
		}
		else {
			System.out.println(key_arr.get(0)); // 최빈값 출력
		}
		
		System.out.println(number.get(num-1) - number.get(0)); // 범위 출력 
	}
}

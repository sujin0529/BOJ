package strange_person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> strange_person = new HashMap<>(); // 듣도 못한 사람을 미리 담아둘 map
		ArrayList<String> sort = new ArrayList<>(); // 듣보잡에 속하는 사람 정렬을 위해서
		
		
		String s = sc.nextLine();
		String[] sp = s.split(" ");
		int first = Integer.parseInt(sp[0]); // 듣도 못한 사람 수
		int second = Integer.parseInt(sp[1]); // 보도 못한 사람 수
		
		
		for(int i=0; i<first; i++) {
			String tmp = sc.nextLine();
			strange_person.put(tmp, 1);
		}
		
		for(int i=0; i<second; i++) {
			String tmp = sc.nextLine();
			if(strange_person.containsKey(tmp)) {
				sort.add(tmp);
			}
		}
		
		Collections.sort(sort);
		System.out.println(sort.size());
		for(int i=0; i<sort.size(); i++) {
			System.out.println(sort.get(i));
		}

	}

}

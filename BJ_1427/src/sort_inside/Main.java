package sort_inside;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String number = sc.nextLine();
		ArrayList<Integer> sort = new ArrayList<>();
		
		for(int i=0; i<number.length(); i++) {
			sort.add(Integer.parseInt(number.charAt(i)+""));
		}
		
		Collections.sort(sort);
		
		for(int i=number.length()-1; i>=0; i--) {
			System.out.print(sort.get(i));
		}

	}

}

package suffix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		ArrayList<String> suffix_arr = new ArrayList<>();;
		
		for(int i=0; i<str.length(); i++) {
			suffix_arr.add(str.substring(i)); // Á¢¹Ì»ç 
		}
		
		Collections.sort(suffix_arr);
		
		for(int i=0; i<str.length(); i++) {
			System.out.println(suffix_arr.get(i));
		}
	}
}
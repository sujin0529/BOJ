import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// [백준 11656] 접미사 배열
// https://blog.naver.com/tnwls0529/222070791597

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		ArrayList<String> suffix_arr = new ArrayList<>();;
		
		for(int i=0; i<str.length(); i++) {
			suffix_arr.add(str.substring(i)); // 접미사 
		}
		
		Collections.sort(suffix_arr);
		
		for(int i=0; i<str.length(); i++) {
			System.out.println(suffix_arr.get(i));
		}
	}
}
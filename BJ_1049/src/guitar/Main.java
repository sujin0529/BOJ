package guitar;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		String[] tmp = s.split(" ");
		int string= Integer.parseInt(tmp[0]);
		int brand = Integer.parseInt(tmp[1]);
		
		int price_6[] = new int[brand];
		int price_1[] = new int[brand];
		
		for(int i=0; i<brand; i++) {
			s = sc.nextLine();
			tmp = s.split(" ");
			price_6[i] = Integer.parseInt(tmp[0]);
			price_1[i] = Integer.parseInt(tmp[1]);
		}
		
		Arrays.sort(price_6);
		Arrays.sort(price_1);
		
		int price = 0;
		while(string > 0) {
			if(string <= 6) {
				if(price_6[0] < price_1[0]*string) {
					price += price_6[0];
					break;
				}
				else {
					price += price_1[0]*string;
					break;
				}
			}
			else {
				if(price_6[0] < price_1[0]*6) {
					price += price_6[0];
					string -= 6;
				}
				else {
					price += (price_1[0]*6);
					string -= 6;
				}
			}
		}
		
		System.out.println(price);
	}
}
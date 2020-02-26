package sort2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> num = new ArrayList<Integer>();
		
		
		try {
			int number = Integer.parseInt(br.readLine());
			for(int i=0; i<number; i++) {
				num.add(Integer.parseInt(br.readLine()));
			}
			
			Collections.sort(num);
			for(int i=0; i<number; i++) {
				System.out.println(num.get(i));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

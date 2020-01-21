package floyd;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int country = sc.nextInt();
		int bus = sc.nextInt();
		int matrix[][] = new int[country+1][country+1];
		for(int[] row:matrix) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		sc.nextLine(); // 정수 입력 후 엔터 제거
		for(int i=0; i<bus; i++) {
			String temp = sc.nextLine();
			String temp_arr[] = temp.split(" ");
			int start = Integer.parseInt(temp_arr[0]);
			int end = Integer.parseInt(temp_arr[1]);
			int cost = Integer.parseInt(temp_arr[2]);
			if(matrix[start][end]>cost) {
				// 더 작은 값을 찾아주기
				matrix[start][end] = cost;
			}
		}
		// 입력
		for(int k=1; k<country+1; k++) {
			for(int i=1; i<country+1; i++) {
				for(int j=1; j<country+1; j++) {
					if(matrix[i][j]>matrix[i][k]+matrix[k][j] && matrix[i][k]!=Integer.MAX_VALUE && matrix[k][j]!=Integer.MAX_VALUE) {
						matrix[i][j] = matrix[i][k]+matrix[k][j];
					}
				}
			}
		}
		
		for(int i=1; i<country+1; i++) {
			for(int j=1; j<country+1; j++) {
				if(i==j) {
					System.out.print(0+" ");
				}
				else if(matrix[i][j]==Integer.MAX_VALUE) {
					System.out.print(0+" ");
				}
				else{
					System.out.print(matrix[i][j]+" ");
				}
			}
			System.out.println("");
		}

	}

}
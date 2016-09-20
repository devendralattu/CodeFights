package numbers;

import java.util.Scanner;

public class ClosestSeq {

	public int closestSequence(int a[], int b[]) {
		int lenA = a.length;
		int lenB = b.length;
		
		int totalDiff = 0;
		int index = 0;
		
		for (int i = 0; i < lenA; i++) {
			int minDiff = Integer.MAX_VALUE;

			for (int j = index; j <= lenB - lenA + i; j++) {
				int diff = Math.abs(a[i] - b[j]);
				
				// if difference is 0, don't look further in array
				if(diff == 0){
					index = j + 1;
					minDiff = 0;
					break;
				}
				
				if(diff < minDiff){
					minDiff = diff;
					index = j + 1;
				}
			}
			totalDiff = totalDiff + minDiff; 
		}

		return totalDiff;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = 0;

		System.out.println("Enter length of first array = ");
		int lenA = in.nextInt();

		System.out.println("Enter first array = ");
		int a[] = new int[lenA];
		while (i != lenA) {
			a[i++] = in.nextInt();
		}

		i = 0;

		System.out.println("Enter length of second array = ");
		int lenB = in.nextInt();
		System.out.println("Enter second array = ");
		int b[] = new int[lenB];
		while (i != lenB) {
			b[i++] = in.nextInt();
		}

		ClosestSeq cs = new ClosestSeq();
		int minDiffInSeq = cs.closestSequence(a, b);
		System.out.println("minimum difference in sequence = " + minDiffInSeq);
	}

}

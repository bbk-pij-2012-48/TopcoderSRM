package SRM150;

import java.util.ArrayList;
import java.util.List;

public class InterestingDigits {

	public static int[] digits(int base) {
		List<Integer> result = new ArrayList<Integer>();
		for(int i=2 ; i<base ; i++) {
			boolean interesting = true;
			int[] tmp = new int[4];
			tmp = increment(tmp,base,i);
			while (tmp != null) {
				if(sum(tmp) % i != 0) {
					interesting = false;
				}
				tmp = increment(tmp,base,i);
			}
			if(interesting) {
				result.add(i);
			}
		}
		int[] output = new int[result.size()];
		for (int i=0 ; i<result.size() ; i++) {
			output[i] = result.get(i);
		}
		return output;

	}


	private static int[] increment(int[] src, int base, int amount) {
		int position = 0;
		for(int i=src.length-1 ; i>=0 ; i--) {
			if(src[i]!=0) {
				position = i;
				break;
			}
		}
		src[position] += amount;
		if(src[position] >= base) {
			if(position==src.length-1) {
				return null;
			} else {
				src[position] -= base;
				src[position+1]++;
			}
		}
		return src;
	}

	private static int sum(int[] src) {
		int total = 0;
		for(int i=0 ; i<src.length ; i++) {
			total += src[i];
		}
		return total;
	}

	public static void main(String[] args) {
		int[] output = digits(26);
		for(int i=0 ; i<output.length ; i++) {
			System.out.print(output[i] + " ");
		}
		System.out.println();
	}

}

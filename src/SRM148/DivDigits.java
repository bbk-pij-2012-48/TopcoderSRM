package SRM148;

import java.util.ArrayList;
import java.util.List;

public class DivDigits {
	
	public static int howMany(int number) {
		List<Integer> digit = new ArrayList<Integer>();
		int originalNumber = number;
		while(number!=0) {
			digit.add(number%10);
			number /= 10;
		}
		int count = 0;
		for(int i=0 ; i<digit.size(); i++) {
			if(digit.get(i) != 0) {
				if(originalNumber % digit.get(i) == 0) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(howMany(12345));
		System.out.println(howMany(661232));
		System.out.println(howMany(52527));
		System.out.println(howMany(730000000));

	}

}

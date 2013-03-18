package SRM158;

import java.util.ArrayList;
import java.util.List;

public class BaseMystery {

	public static int[] getBase(String equation) {

		String[] tmp = equation.split("\\+");
		String[] tmp2 = tmp[1].split("=");
		String[] numbers = new String[3];
		numbers[0] = tmp[0];
		numbers[1] = tmp2[0];
		numbers[2] = tmp2[1];
		List<Integer> output = new ArrayList<Integer>();

		for(int i=2 ; i<=20 ; i++) {
			int[] value = new int[3];
			boolean valid = true;
			for(int j=0 ; j<3 ; j++) {
				for(int k=0 ; k<numbers[j].length(); k++) {
					if(Character.isDigit(numbers[j].charAt(k))) {
						if((numbers[j].charAt(k)-'0') >= i){
							System.out.println("here 1");
							valid = false;
							break;
						}
						value[j] += (numbers[j].charAt(k)-'0') * Math.pow(i, numbers[j].length()-1-k);
					} else {
						if((numbers[j].charAt(k)-55) >= i) { 

							valid = false;
							break;
						}
						value[j] += (numbers[j].charAt(k)-55) * Math.pow(i, numbers[j].length()-1-k);
					}
					System.out.println(value[j]);
				}
				if(!valid) {
					break;
				}
			}

			if(valid) {
				if(value[0]+value[1]==value[2]) {
					output.add(i);
				}
			}
		}
		int[] output2 = new int[output.size()];
		for(int i=0 ; i<output.size() ; i++) {
			output2[i] = output.get(i);
		}
		return output2;
	}

	public static void main(String[] args) {
		int[] tmp = getBase("ABCD+211=B000");
		for(int i=0 ; i<tmp.length ; i++) {
			
		System.out.println(tmp[i]);
		
		}
	}

}

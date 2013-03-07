package SRM149;

import java.util.ArrayList;
import java.util.List;

public class FormatAmt {

	public static String amount(int dollars, int cents) {
		String result = "$";
		if(dollars == 0) {
			return result + "0." + cents;
		}
		
		List<Integer> tmp = new ArrayList<Integer>();
		while(dollars != 0) {
			tmp.add(dollars % 1000);
			dollars /= 1000;
		}
		
		for(int i=tmp.size()-1 ; i>=0 ; i--) {
			result += tmp.get(i) + ",";
		}
		
		result = result.substring(0,result.length()-1);
		
		if(cents<10) {
			return (result += ".0" + cents);
		} else {
			return (result += "." + cents);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(amount(123456,67));

	}

}

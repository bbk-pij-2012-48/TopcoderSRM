package SRM147;

import java.util.ArrayList;
import java.util.List;

public class PeopleCircle {
	
	public static String order(int numMales, int numFemales, int K) {
		int total = numMales + numFemales;
		int[] position = new int[numFemales];
		for(int i=0 ; i<numFemales ; i++) {
			if(i==0) {
				position[i] = (K-1) % total;
				total --;
			} else {
				position[i] = (position[i-1] + K - 1) % total;
				total--;
			}
		}
		
		List<String> tmp = new ArrayList<String>();
		for(int i=0 ; i<numMales ; i++) {
			tmp.add("M");
		}
		
		for (int j=numFemales-1 ; j>=0 ; j--) {
			tmp.add(position[j],"F");
		}
		
		String output = "";
		for(int i=0 ; i<numMales+numFemales ; i++) {
			output += tmp.get(i);
		}
		
		return output;
	}
	
	public static void main(String[] args) {
		System.out.println(order(25,25,1000));
	}
}

package SRM574;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CityMap {
	
	public static String getLegend(String[] cityMap, int[] POIs) {
		String out = "";
		Set<Character> letters = new HashSet<Character>();
		for(int i=0 ; i<cityMap.length ; i++) {
			for(int j=0 ; j<cityMap[i].length() ; j++) {
				if(cityMap[i].charAt(j) != '.') {
					letters.add(cityMap[i].charAt(j));
				}
			}
		}
		String letters2 = "";
		Iterator<Character> itr = letters.iterator();
		while(itr.hasNext()) {
			letters2+=itr.next();
		}
		for(int i=0 ; i<POIs.length ; i++) {
			
			for(int j=0 ; j<letters2.length() ; j++) {
				int count = 0;
				for(int k=0 ; k<cityMap.length ; k++) {
					for(int m=0 ; m<cityMap[k].length() ; m++) {
						if(cityMap[k].charAt(m)==letters2.charAt(j)) {
							count++;
						}
					}
				}
				if(count==POIs[i]) {
					out +=letters2.charAt(j);
				}
			}
			
		}
		return out;
	}

}

package TCO13_1A;

import java.util.ArrayList;
import java.util.List;

public class HouseBuilding {
	
	public static int getMinimum(String[] area) {
		List<Integer> height = new ArrayList<Integer>();
		for(int i=0 ; i< area.length ; i++) {
			for(int j=0 ; j<area[i].length() ; j++) {
				height.add(Integer.parseInt(new String(new char[] {area[i].charAt(j)})));
			}
		}
		int min = 1000000;
		for(int i=1 ; i<=9 ; i++) {
			int count = 0;
			for(int j=0 ; j<height.size(); j++) {
				if(Math.abs(height.get(j) - i) > Math.abs(height.get(j) - (i - 1))) {
					count+=Math.abs(height.get(j) - (i - 1));
				} else {
					count += Math.abs(height.get(j) - i);
				}
			}
			if(count<min) {
				min = count;
			}
		}
		return min;
	}
	
}

package SRM155;

public class Quipu {

	public static int readKnots(String knots) {
		String output = "";
		int xCount = 0;
		int dashCount = 0;
		for(int i=0 ; i<knots.length(); i++) {
			if(knots.charAt(i)=='-') {
				if(xCount!=0) {
					output += xCount;
					xCount = 0;
				}
				dashCount++;
			} else {
				if(dashCount>1) {
					for(int j=0 ; j<dashCount-1 ; j++) {
						output += 0;
					}
				}
				dashCount = 0;
				xCount++;
			}
		}
		for(int j=0 ; j<dashCount-1 ; j++) {
			output += 0;
		}
		return Integer.parseInt(output);
	}
	
	public static void main(String[] args) {

		System.out.println(readKnots("-X-------"));
	}

}

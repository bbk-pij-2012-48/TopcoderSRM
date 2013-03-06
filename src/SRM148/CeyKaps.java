package SRM148;

public class CeyKaps {
	
	public static String decipher(String typed, String[] switches) {
		String result = "";
		for(int i=0 ; i<typed.length() ; i++) {
			result += original(typed.charAt(i), switches);
		}
		return result;		
	}

	private static char original(char first, String[] switches) {
		for(int i=0 ; i<switches.length ; i++) {
			if(switches[i].charAt(0) == first) {
				first = switches[i].charAt(2);
			} else if(switches[i].charAt(2) == first) {
				first = switches[i].charAt(0);
			}
		}
		return first;
	}


	public static void main(String[] args) {
		String[] tmp = {"W:O","W:I"};
		System.out.println(decipher("IHWSIOTCHEDMYKEYCAPSARWUND",tmp));
	}

}

package SRM158;

public class TireRotation {

	public static int getCycle(String initial, String current) {
		
		for(int i=0 ; i<4 ; i++) {
			if(initial.equals(current)) {
				return i + 1;
			}
			initial = cycle(initial);
		}
		return -1;		
	}
	
	private static String cycle(String initial) {
		String output = "";
		output += initial.charAt(3);
		output += initial.charAt(2);
		output += initial.charAt(0);
		output += initial.charAt(1);
		return output;
	}
	
	public static void main(String[] args) {
		System.out.println(getCycle("ZAXN","XNAZ"));
	}

}

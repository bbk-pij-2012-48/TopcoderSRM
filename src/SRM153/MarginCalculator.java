package SRM153;

public class MarginCalculator {

	public static int percent(String[] items) {
		double paid = 0;
		double cost = 0;
		
		for(int i=0 ; i<items.length ; i++) {
			double a = items[i].charAt(0)-48;
			double b = items[i].charAt(1)-48;
			double c = items[i].charAt(2)-48;
			double d = items[i].charAt(4)-48;
			double e = items[i].charAt(5)-48;
			
			paid += 100*a + 10*b + c + d/10 + e/100;
		}
		
		for(int i=0 ; i<items.length ; i++) {
			double a = items[i].charAt(7)-48;
			double b = items[i].charAt(8)-48;
			double c = items[i].charAt(9)-48;
			double d = items[i].charAt(11)-48;
			double e = items[i].charAt(12)-48;
			
			cost += 100*a + 10*b + c + d/10 + e/100;
		}
		return (int)((100 * (paid - cost)) / paid);
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(percent(new String[] {"822.77 704.86","829.42 355.45","887.18 949.38"}));
	}

}

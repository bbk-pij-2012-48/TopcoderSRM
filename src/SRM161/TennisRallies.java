package SRM161;

public class TennisRallies {
	public static int output = 0;

	public static int howMany(int numLength, String[] forbidden, int allowed) {
		generate("",numLength,forbidden,allowed);
		return output;
	}

	private static void generate(String initial, int numLength, String[] forbidden, int allowed) {
		if(initial.length()==numLength){
			output++;
			System.out.println(initial);
		}
		else {
			int tmp2 = allowed;
			String tmp = initial;

			initial += "d";
			for(int i=0 ; i<forbidden.length ; i++) {
				if(initial.length() >= forbidden[i].length()) {
					if(initial.substring(initial.length() - forbidden[i].length()).equals(forbidden[i])){
						allowed--;
					}
				}
			}
			if(allowed>0) {
				generate(initial,numLength,forbidden,allowed);
			}

			allowed = tmp2;
			initial =  tmp + "c";
			for(int i=0 ; i<forbidden.length ; i++) {
				if(initial.length() >= forbidden[i].length()) {
					if(initial.substring(initial.length() - forbidden[i].length()).equals(forbidden[i])){
						allowed--;
					}
				}
			}

			if(allowed>0) {
				generate(initial,numLength,forbidden,allowed);
			}
		}

	}

	public static void main(String[] args) {

		System.out.println(howMany(3,new String[] {"cc","dd"},1));
	}

}

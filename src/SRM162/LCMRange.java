package SRM162;

public class LCMRange {
	
	public static int lcm(int first, int last) {
		for(int i=1 ; i>0 ; i++) {
			boolean lcm = true;
			for(int j=first ; j<=last ; j++) {
				if(i%j != 0) {
					lcm = false;
					break;
				}
			}
			if(lcm) {
				return i;
			}
		}
		return 0;
	}

}

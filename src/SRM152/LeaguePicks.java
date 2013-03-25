package SRM152;

public class LeaguePicks {

	public static int[] returnPicks(int position, int friends, int picks) {
		int max = friends / picks;
		if(max % 2 == 0) {
			if(position <= (picks % friends)) {
				max++;
			}
		} else if (position >= (picks % friends)) {
			max++;			
		}
		
		int[] output = new int[max];
		int count = 0;
		
		for(int i=0 ; i>0 ; i++) {			
			if(position + 2*friends*i > picks) {
				break;
			} else {
				output[count] = position + 2*friends*i;
				count++;
			}
			
			if(1 - position + 2*friends*i > picks) {
				break;
			} else {
				output[count] = 1 - position + 2*friends*i;
				count++;
			}
		}
		return output;
	}
}

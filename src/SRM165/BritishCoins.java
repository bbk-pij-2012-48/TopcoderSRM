package SRM165;

public class BritishCoins {
	
	public static int[] coins(int pence) {
		int[] output = new int[3];
		int tmp = pence - (pence % (12*20));
		if(tmp>0) {
			output[0] = tmp / (12*20);
			pence = pence % (12*20);
		} else {
			output[0] = 0;
		}
		
		tmp = pence - (pence % 12);
		if(tmp>0) {
			output[1] = tmp / 12;
			pence = pence % 12;
		} else {
			output[1] = 0;
		}
		
		output[2] = pence;
		return output;
	}

	public static void main(String[] args) {
		int[] tmp = coins(0);
		for(int value : tmp) {
			System.out.println(value);
		}
	}

}

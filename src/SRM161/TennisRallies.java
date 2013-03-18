package SRM161;

public class TennisRallies {

	public static int howMany(int numLength, String[] forbidden, int allowed) {
		int output = 0;
		String[] forbiddenBin = new String[forbidden.length];
		for(int i=0 ; i<forbidden.length ; i++) {
			forbiddenBin[i] = forbidden[i].replace('c','0');
			forbiddenBin[i] = forbiddenBin[i].replace('d','1');
		}
		for(int i=0 ; i<Math.pow(2,numLength) ; i++) {
			String tmp = Integer.toBinaryString(i);
			int tmp2 = tmp.length();
			int count = 0;
			boolean valid = true;
			for(int j=0 ; j<numLength-tmp2 ; j++) {
				tmp = "0" + tmp;
			}
			for(int j=0 ; j<forbiddenBin.length ; j++) {
				for(int k=0 ; k<tmp.length() - forbiddenBin[j].length()+1 ; k++) {
					if(tmp.substring(k,forbiddenBin[j].length()+k).equals(forbiddenBin[j])) {
						count++;
						if(count >= allowed){
							valid = false;
							break;
						}
					}
				}
				if(!valid) {
					break;
				}
			}
			if(valid) {
				output++;
			}
		}
		return output;
	}

	public static void main(String[] args) {

		System.out.println(howMany(18,new String[] {"c","cc","ccc","cccc","ccccc","cccccc","ccccccc",
				 "cccccccc","ccccccccc","cccccccccc"},100));
	}

}

package SRM172;

public class BadClock {
	
	public static double nextAgreement(String trueTime, String skewTime, int hourlyGain) {
		int[] real = toArray(trueTime);
		int[] skew = toArray(skewTime);
		
		int difference = (real[2] + 60*real[1] + 60*60*real[0])-(skew[2] + 60*skew[1] + 60*60*skew[0]);
		
		if(hourlyGain<0) {
			difference = -1 * difference;
		}
		
		if(difference<0) {
			difference = 60*60*12 + difference;
		}
		
		return (double)difference/Math.abs(hourlyGain);
	}
	
	private static int[] toArray(String time) {
		String[] tmp = time.split(":");
		int[] out = new int[3];
		for(int i=0 ; i<3 ; i++) {
			out[i] = Integer.parseInt(tmp[i]);
		}
		return out;
	}

}

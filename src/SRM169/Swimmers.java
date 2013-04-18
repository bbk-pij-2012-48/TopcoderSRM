package SRM169;

public class Swimmers {

	public static int[] getSwimTimes(int[] distances, int[] speeds, int current) {
		int[] out = new int[distances.length];

		for(int i=0 ; i<distances.length ; i++) {
			if(distances[i]==0) {
				out[i] = 0;
			} else if(speeds[i]<=current) {
				out[i] = -1;
			} else {
				double time = ((distances[i]*1.0)/(speeds[i]+current)) + ((distances[i]*1.0)/(speeds[i]-current));
				out[i] = (int)time;
			}
		}
		return out;
	}
}

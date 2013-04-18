package SRM170;

public class LevelUp {
	
	public static int toNextLevel(int[] expNeeded, int received) {
		for(int i=0 ; i<expNeeded.length ; i++) {
			if(received<expNeeded[i]) {
				return expNeeded[i]-received;
			}
		}
		return 0;
	}

}

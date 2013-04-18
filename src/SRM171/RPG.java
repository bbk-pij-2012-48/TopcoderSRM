package SRM171;

public class RPG {
	
	public static int[] dieRolls(String[] dice) {
		int[] out = new int[3];
		int min = 0, max=0;
		double average = 0;
		for(int i=0 ; i<dice.length ; i++) {
			String[] tmp = dice[i].split("d");
			int tmp1 = Integer.parseInt(tmp[0]);
			int tmp2 = Integer.parseInt(tmp[1]);
			min += tmp1;
			max += tmp1*tmp2;
			average += tmp1*(tmp2+1.0)/2;
		}
		out[0] = min;
		out[1] = max;
		out[2] = (int)average;
		return out;
	}

}

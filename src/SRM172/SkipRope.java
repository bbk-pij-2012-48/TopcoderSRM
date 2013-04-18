package SRM172;

public class SkipRope {

	public static int[] partners(int[] candidates, int height) {
		int best = Math.abs(candidates[0]-height);
		int choice1 = 0, choice2 = 0;

		for(int i=0 ; i<candidates.length ; i++) {
			if(Math.abs(candidates[i]-height)==best) {
				if(candidates[i]>candidates[choice1]) {
					choice1 = i;
					best = Math.abs(candidates[i]-height);
				}
			} else if(Math.abs(candidates[i]-height)<best) {
				choice1 = i;
				best = Math.abs(candidates[i]-height);
			}
		}

		if(choice1!=0) {
			best = Math.abs(candidates[0]-height);
		} else {
			best = Math.abs(candidates[1]-height);
			choice2 = 1;
		}

		for(int i=0 ; i<candidates.length ; i++) {
			if(i!=choice1) {
				if(Math.abs(candidates[i]-height)==best) {
					if(candidates[i]>candidates[choice2]) {
						choice2 = i;
						best = Math.abs(candidates[i]-height);
					}
				} else if(Math.abs(candidates[i]-height)<best) {
					choice2 = i;
					best = Math.abs(candidates[i]-height);
				}
			}
		}
		if(candidates[choice1]<candidates[choice2]) {
			int[] out = {candidates[choice1],candidates[choice2]};
			return out;
		} else {
			int[] out = {candidates[choice2],candidates[choice1]};
			return out;
		}
	}

}

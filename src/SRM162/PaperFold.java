package SRM162;

public class PaperFold {
	
	public static int numFolds(int[] paper, int[] box) {
		int best;
		int folds = 0;
		
		//test as is
		int tmp = box[0];
		while(tmp < paper[0]) {
			tmp *= 2;
			folds++;
		}
		tmp = box[1];
		while(tmp < paper[1]) {
			tmp *= 2;
			folds++;
		}
		best = folds;
		
		//test rotated
		folds = 0;
		tmp = box[1];
		while(tmp < paper[0]) {
			tmp *= 2;
			folds++;
		}
		tmp = box[0];
		while(tmp < paper[1]) {
			tmp *= 2;
			folds++;
		}
		best = Math.min(folds, best);
		if(best>8) {
			return -1;
		}
		return best;
	}

}

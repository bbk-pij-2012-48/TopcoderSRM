package SRM146;

public class YahtzeeScore {

	public static int maxPoints(int[] toss) {
		int best = 0;
		int tmp = 0;
		for(int i=1 ; i<=6 ; i++) {
			tmp = 0;
			for(int score : toss) {
				if(score == i) {
					tmp += i;
				}
			}
			if(tmp > best) {
				best = tmp;
			}
		}
		return best;
	}
	
	public static void main(String[] args) {
		int[] tmp = {2,2,3,5,4};
		System.out.println(maxPoints(tmp));
	}
}

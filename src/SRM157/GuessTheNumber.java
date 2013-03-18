package SRM157;

public class GuessTheNumber {

	public static int noGuesses(int upper, int answer) {
		int lower = 1;
		int x=(upper+lower)/2;
		int n=1;

		while(x!=answer) {
			if(x<answer) {
				lower = x+1;
			} else {
				upper = x-1;
			}
			x=(upper+lower)/2;
			n++;
		}
		return n;
	}
	
	public static void main(String[] args) {
		System.out.println(noGuesses(1000,750));
		System.out.println(noGuesses(9,6));
		System.out.println(noGuesses(643,327));
		System.out.println(noGuesses(157,157));
		System.out.println(noGuesses(1000,750));

	}

}

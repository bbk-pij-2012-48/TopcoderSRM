package SRM171;

public class CrossCountry {
	
	public static String scoreMeet(int numTeams, String finishOrder) {
		int[] scores = new int[numTeams];
		char[] names = new char[numTeams];
		for(int i=0 ; i<numTeams ; i++) {
			scores[i] = score(finishOrder,(char)(65+i));
			names[i] = (char)(65+i);
		}
		for(int i=0 ; i<numTeams-1 ; i++) {
			for(int j=0 ; j<numTeams-1-i ; j++) {
				if(scores[j]>scores[j+1] || 
						(scores[j]==scores[j+1] && sixth(finishOrder,names[j])>sixth(finishOrder,names[j+1]))){
					int tmp = scores[j];
					scores[j] = scores[j+1];
					scores[j+1] = tmp;
					char tmp2 = names[j];
					names[j] = names[j+1];
					names[j+1] = tmp2;
				}
			}
		}
		String out = "";
		for(int i=0 ; i<numTeams ; i++) {
			if(scores[i]!=-1) {
				out+=names[i];
			}
		}
		return out;
	}
	
	private static int score(String finishOrder, char team) {
		int count = 0;
		int score = 0;
		for(int i=0 ; i<finishOrder.length() ; i++) {
			if(finishOrder.charAt(i)==team) {
				score += i+1;
				count++;
				if(count==5) {
					return score;
				}
			}
		}
		return -1;
	}
	
	private static int sixth(String finishOrder, char team) {
		int count = 0;
		for(int i=0 ; i<finishOrder.length(); i++) {
			if(finishOrder.charAt(i)==team) {
				count++;
				if(count==6) {
					return i+1;
				}
			}
		}
		return 10000;
	}

}

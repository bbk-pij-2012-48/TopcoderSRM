package SRM161;

public class CardCount {

	public static String[] dealHands(int numPlayers, String deck) {
		int tmp = deck.length() % numPlayers;
		deck = deck.substring(0,deck.length()-tmp);
		String[] output = new String[numPlayers];
		for(int i=0 ; i<output.length ; i++) {
			output[i] = "";
		}
		for(int i=0 ; i<deck.length(); i++) {
			output[i%numPlayers] += deck.charAt(i);
		}
		return output;
	}
}

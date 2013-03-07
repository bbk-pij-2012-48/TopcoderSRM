package SRM151;

public class PrefixCode {
	
	public static String isOne(String[] words) {
		for(int i=0 ; i<words.length ; i++) {
			for(int j=0 ; j<words.length ; j++) {
				if(i!=j) {
					if(words[j].startsWith(words[i])) {
						return ("No, " + i);
					}
				}
			}
		}
		return "Yes";
	}
	
	public static void main(String[] args) {
		System.out.println(isOne(new String[] {"trivial"}));
	}

}

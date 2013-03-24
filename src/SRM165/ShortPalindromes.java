package SRM165;

import java.util.ArrayList;
import java.util.List;

// The idea - take each letter in turn, and make it the 'middle' of the palindrome.
// This splits the word in two. Any duplicate orderings on each side don't need repeating. The remainder do.
public class ShortPalindromes {

	public static String shortest(String base) {
		int shortest = 2*base.length() - 1;
		List<Integer> centre = new ArrayList<Integer>();
		centre.add(0);
		centre.add(base.length()-1);
		for(int i=1 ; i<base.length()-1 ; i++) {
			String front = base.substring(0,i);
			String back = base.substring(i+1);
		}
		return null;
	}

	private static List<Character> maxOrdered(List<Character> matched, String front, String back) {
		List<Character> best = matched;
		if(matched == null) {
			best = new ArrayList<Character>();
		}
		if(front.length()>back.length()) {
			String tmp = front;
			front = back;
			back = tmp;
		}

		for(int i=0 ; i<front.length() ; i++) {
			for(int j=0 ; j<back.length(); j++) {
				if(front.charAt(i)==back.charAt(j)) {
					List<Character> matched2 = new ArrayList<Character>();
					if(matched != null) {
						for(Character c : matched) {
							matched2.add(c);
						}
					}
					matched2.add(front.charAt(i));
					List<Character> tmp = maxOrdered(matched2,front.substring(i+1),back.substring(j+1));
					if(tmp.size()>best.size()){
						best = tmp;
					}
				}
			}
		}
		return best;
	}

	public static void main(String[] args) {

		List<Character> tmp = maxOrdered(null,"aebcd","abcde");
		for(Character c : tmp) {
			System.out.println(c);
		}

	}

}

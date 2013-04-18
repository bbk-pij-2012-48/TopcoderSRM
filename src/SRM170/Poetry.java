package SRM170;

public class Poetry {

	public static String rhymeScheme(String[] poem) {
		int n = poem.length;
		String[] words = new String[n];
		for(int i=0 ; i<n ; i++) {
			String tmp2 = poem[i].trim();
			if(tmp2.length()==0){
				words[i]=" ";
			}else{
				String[] tmp = poem[i].split(" ");
				if(spaces(tmp)){
					words[i] = " ";
				} else {
					words[i] = tmp[tmp.length-1].toLowerCase();
				}
			}
			boolean voweler = false;
			int last=0;
			if(!words[i].equals(" ")){
				for(int j=0 ; j<words[i].length() ; j++) {
					if(isVowel(words[i],j)) {
						if(!voweler) {
							last = j;
							voweler = true;
						}
					} else {
						voweler = false;
					}
				}
				words[i] = words[i].substring(last);
			}
		}

		int next = 97;
		char[] out = new char[n];
		for(int i=0 ; i<n ; i++) {
			out[i] = '!';
		}
		for(int i=0 ; i<n ; i++) {
			if(out[i]=='!'){
				if(words[i].equals(" ")) {
					out[i] = ' ';
				}else{
					out[i]=(char)next;
					for(int j=i+1 ; j<n ; j++) {
						if(words[i].equals(words[j])){
							out[j]=(char)next;
						}
					}
					next++;
					if(next>122){
						next = 65;
					}
				}
			}
		}
		return new String(out);
	}

	private static boolean isVowel(String word, int n) {
		char tmp = word.charAt(n);
		if(n==0||n==word.length()-1){
			if(tmp=='a'||tmp=='e'||tmp=='i'||tmp=='o'||tmp=='u') {
				return true;
			}
			return false;
		} else {
			if(tmp=='a'||tmp=='e'||tmp=='i'||tmp=='o'||tmp=='u'||tmp=='y') {
				return true;
			}
			return false;
		}
	}

	private static boolean spaces(String[] words) {

		for(int i=0 ; i<words.length ; i++) {
			if(!words[i].equals(" ")) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char tmp = (char)97;
		System.out.println(tmp);
	}
}

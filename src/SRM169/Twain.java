package SRM169;

public class Twain {
	
	public static String getNewSpelling(int year, String phrase) {
		if(phrase.length()==0) {
			return "";
		}
		switch(year) {
		case 0: 
			return phrase;
		case 1:
			return year1(phrase);
		case 2:
			return year2(year1(phrase));
		case 3:
			return year3(year2(year1(phrase)));
		case 4:
			return year4(year3(year2(year1(phrase))));
		case 5:
			return year5(year4(year3(year2(year1(phrase)))));
		case 6:
			return year6(year5(year4(year3(year2(year1(phrase))))));
		case 7:
			return year7(year6(year5(year4(year3(year2(year1(phrase)))))));
		}
		return "";
	}
	
	private static String year1(String phrase) {
		StringBuilder out = new StringBuilder(phrase);
		if(out.charAt(0)=='x') {
			out.setCharAt(0,'z');
		}
		for(int i=1 ; i<out.length() ; i++) {
			if(out.charAt(i)=='x') {
				out.setCharAt(i,'k');
				out.insert(i+1,'s');
			}
		}
		return new String(out);
	}
	
	private static String year2(String phrase) {
		StringBuilder out = new StringBuilder(phrase);
		for(int i=0 ; i<out.length(); i++) {
			if(out.charAt(i)=='y'){
				out.setCharAt(i,'i');
			}
		}
		return new String(out);
	}
	
	private static String year3(String phrase) {
		StringBuilder out = new StringBuilder(phrase);
		for(int i=0 ; i<out.length()-1 ; i++) {
			if(out.charAt(i)=='c' && (out.charAt(i+1)=='e' || out.charAt(i+1)=='i')) {
				out.setCharAt(i,'s');
			}
		}
		return new String(out);
	}

	private static String year4(String phrase) {
		StringBuilder out = new StringBuilder(phrase);
		for(int i=1 ; i<out.length() ; i++) {
			if(out.charAt(i)=='k'){
				while(i-1>=0 && out.charAt(i-1)=='c'){
					out.deleteCharAt(i-1);
					i--;
				}
			}
		}
		return new String(out);
	}
	

	private static String year5(String phrase) {
		StringBuilder out = new StringBuilder(phrase);
		if(out.length()>=3 && out.substring(0,3).equals("sch")) {
			out.setCharAt(1,'k');
			out.deleteCharAt(2);
		}
		for(int i=0 ; i<out.length()-2 ; i++) {
			if(out.substring(i,i+2).equals("ch") && out.charAt(i+2)=='r') {
				out.setCharAt(i,'k');
				out.deleteCharAt(i+1);
			}
		}
		for(int i=0 ; i<out.length()-1 ; i++) {
			if(out.charAt(i)=='c' && out.charAt(i+1)!='h') {
				out.setCharAt(i,'k');
			}
		}
		if(out.charAt(out.length()-1)=='c') {
			out.setCharAt(out.length()-1,'k');
		}
		return new String(out);	
	}

	private static String year6(String phrase) {
		StringBuilder out = new StringBuilder(phrase);
		if(out.length()>=2 && out.substring(0,2).equals("kn")){
			out.deleteCharAt(0);
		}
		return new String(out);
	}

	private static String year7(String phrase) {
		StringBuilder out = new StringBuilder(phrase);
		for(int i=1 ; i<out.length() ; i++) {
			if(out.charAt(i)==out.charAt(i-1)) {
				out.deleteCharAt(i);
				i--;
			}
		}
		return new String(out);
	}
	
	public static void main(String[] args) {
		System.out.println(year1("xerox"));
	}

}

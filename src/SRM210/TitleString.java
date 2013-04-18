package SRM210;

public class TitleString {
	
	public static String toFirstUpperCase(String title) {
		StringBuilder tmp = new StringBuilder(title);
		tmp.replace(0, 1, String.valueOf(Character.toUpperCase(tmp.charAt(0))));
		for(int i=0 ; i<tmp.length()-1 ; i++) {
			if(tmp.charAt(i)==' ')
				tmp.replace(i+1, i+2, String.valueOf(Character.toUpperCase(tmp.charAt(i+1))));
		}
		return new String(tmp);
	}
	
	public static void main(String[] args) {
		System.out.println(toFirstUpperCase("  lord of the rings   the fellowship of the ring  "));
	}

}

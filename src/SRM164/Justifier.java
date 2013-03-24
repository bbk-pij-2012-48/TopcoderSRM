package SRM164;

public class Justifier {

	public static String[] justify(String[] textIn) {
		int max = 0;
		for(String text : textIn) {
			max = Math.max(max,text.length());
		}
		for(int i=0 ; i<textIn.length ; i++) {
			int tmp = textIn[i].length();
			for(int j=0 ; j<max - tmp ; j++) {
				textIn[i] = " " + textIn[i];
			}
		}
		return textIn;
	}
}

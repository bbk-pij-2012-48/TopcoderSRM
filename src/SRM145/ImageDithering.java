package SRM145;

public class ImageDithering {
	
	public static int count(String dithered, String[] screen) {
		int result = 0;
		
		for(int i=0 ; i<screen.length ; i++) {
			for(int j=0 ; j<screen[i].length(); j++) {
				for(int k=0 ; k<dithered.length(); k++) {
					if(screen[i].charAt(j) == dithered.charAt(k)) {
						result++;
						break;
					}
				}
			}
		}
		return result;
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] tmp = {"AAAAAAAA", "ABWBWBWA", "AWBWBWBA", "ABWBWBWA", "AWBWBWBA", "AAAAAAAA"};
		System.out.println(count("BW", tmp ));

	}

}

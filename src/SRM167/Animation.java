package SRM167;

import java.util.ArrayList;
import java.util.List;

public class Animation {

	public static String[] animate(int speed, String init) {
		List<String> output = new ArrayList<String>();
		int[][] all = new int[init.length()][2];
		for(int i=0 ; i<init.length() ; i++) {
			if(init.charAt(i)=='L') {
				all[i][0] = 1;
			} else if(init.charAt(i)=='R') {
				all[i][1] = 1;
			}
		}
		int max = init.length();
		String template = "";
		for(int i=0 ; i<init.length(); i++) {
			template += ".";
		}
		String current = init;
		output.add(current);
		while(true){
			StringBuilder tmp = new StringBuilder(template);
			for(int i=0 ; i<max ; i++) {
				if(all[i][0]!=0 || all[i][1]!=0) {
					tmp.replace(i,i+1,"X");
				}
			}
			current = new String(tmp);
			output.add(current);
			if(current.equals(template)) {
				break;
			}
			all = update(all,speed);
		}
		String[] output2 = new String[output.size()];
		for(int i=0 ; i<output.size(); i++) {
			output2[i] = output.get(i);
		}
		return output2;
	}
	
	private static int[][] update(int[][] current, int speed) {
		int[][] output = new int[current.length][2];
		for(int i=0 ; i<current.length ; i++) {
			if(current[i][0]!=0) {
				if(i-speed>=0){
					output[i-speed][0] = 1;
				}
			}
			if(current[i][1]!=0) {
				if(i+speed<=current.length-1) {
					output[i+speed][1] = 1;
				}
			}
		}
		return output;
	}

}

package SRM166;

import java.util.Arrays;

public class Workshop {
	
	public static int pictureFrames(int[] pieces) {
		int count = 0;
		for(int i=0 ; i<pieces.length-2 ; i++) {
			for(int j=i+1 ; j<pieces.length-1 ; j++) {
				for(int k=j+1 ; k<pieces.length ; k++) {
					int[] tmp = new int[3];
					tmp[0] = pieces[i];
					tmp[1] = pieces[j];
					tmp[2] = pieces[k];
					Arrays.sort(tmp);
					if(tmp[0]+tmp[1]>tmp[2]) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(pictureFrames(new int[] {100}));
	}
}

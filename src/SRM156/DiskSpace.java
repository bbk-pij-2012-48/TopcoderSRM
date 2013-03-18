package SRM156;

import java.util.Arrays;

public class DiskSpace {
	
	public static int minDrives(int[] used, int[] total) {
		int totalUsed = 0;
		for(int i=0 ; i<used.length ; i++) {
			totalUsed += used[i];
		}
		Arrays.sort(total);
		int runningTotal = 0;
		for(int i=total.length-1 ; i>=0 ; i--) {
			runningTotal += total[i];
			if(runningTotal >= totalUsed) {
				return total.length-i;
			}
		}
		return total.length;
	}
	
	public static void main(String[] args) {
		System.out.println(minDrives(new int[] {331,242,384,366,428,114,145,89,381,170,329,190,482,246,2,38,220,290,402,385}, new int[] {992,509,997,946,976,873,771,565,693,714,755,878,897,789,969,727,765,521,961,906}));
	}

}

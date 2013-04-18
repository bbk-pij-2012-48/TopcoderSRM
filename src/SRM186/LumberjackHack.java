package SRM186;

public class LumberjackHack {
	
	public static int timeToShore(String[] riverMap) {
		
		
		return 0;
	}
	
	private static int bestTime(String[] riverMap, boolean[][] visited, int x, int y, boolean water, int last) { // last: 0=up, 1=right, 2=down, 3=left
		int best = -1;
		int tmp;
		if(y==0 || y==riverMap[0].length()-1) {
			return 0;
		}
		//try up
		if(y!=0 && last!=2 && !visited[x][y-1]) {
			if(!(riverMap[y-1].charAt(x)=='.')) {
				tmp = bestTime(riverMap, )
			}
		}
		
		
		
		return best;
	}

}

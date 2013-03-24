package SRM167;

public class Orchard {
	
	public static int[] nextTree(String[] orchard) {
		int n = orchard.length ;
		int[] output = new int[2];
		int best = -1;
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(orchard[i].charAt(j)!='T') {
					int tmp = distance(orchard,i,j);
					if(tmp>best) {
						best = tmp;
						output[0] = i+1;
						output[1] = j+1;
					}
				}
			}
		}
		return output;		
	}
	
	private static int distance(String[] orchard, int x, int y) {
		int n = orchard.length;
		int best = Math.min(x+1,n-x);
		best = Math.min(best, y+1);
		best = Math.min(best, n-y);
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(!(i==x && j==y)) {
					if(orchard[i].charAt(j)=='T') {
						best = Math.min(best, Math.abs(i-x) + Math.abs(j-y));
					}
				}
			}
		}
		return best;		
	}

}

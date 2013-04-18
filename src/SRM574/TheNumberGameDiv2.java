package SRM574;

public class TheNumberGameDiv2 {
	
	public static int minimumMoves(int A, int B) {
		int[] a = toArray(A);
		int[] b = toArray(B);
		boolean forwards = false, backwards = false;
		int front = -1, back = -1;
	
		if(b.length > a.length) {
			return -1;
		}
		
		for(int i=0 ; i<a.length-b.length+1 ; i++) {
			if(a[i] == b[0]) {
				boolean match = true;
				for(int j=0 ; j<b.length ; j++) {
					if(a[i+j]!=b[j]) {
						match = false;
						break;
					}
				}
				if(match) {
					forwards = true;
					front = i;
					break;
				}
			}
		}
		
		for(int i=a.length-1 ; i>=b.length-1 ; i--) {
			if(a[i]==b[0]) {
				boolean match = true;
				for(int j=0 ; j<b.length ; j++) {
					if(a[i-j]!=b[j]) {
						match = false;
						break;
					}
				}
				if(match) {
					backwards = true;
					back = i;
					break;
				}
			}
		}
		
		if(!forwards && !backwards) {
			return -1;
		}
		
		if(forwards && front==0){
			return a.length-b.length;
		}
		if(backwards && back==a.length-1){
			return a.length-b.length+1;
		}
		if(backwards) {
			return a.length-b.length+1;
		}
		return a.length-b.length+2;
		
	}
	
	private static int[] toArray(int a) {
		String tmp = Integer.toString(a);
		int[] out =  new int[tmp.length()];
		
		for(int i=out.length-1 ; i>=0 ; i--) {
			int tmp2 = a%10;
			out[i]=tmp2;
			a/=10;
		}
		return out;
	}
	
	

}

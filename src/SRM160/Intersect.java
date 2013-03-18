package SRM160;

public class Intersect {

	public static int area(int[] x, int[] y) {
		for(int i=0 ; i<x.length ; i=i+2) {
			if(x[i+1]<x[i]) {
				int tmp = x[i];
				x[i] = x[i+1];
				x[i+1] = tmp;
			}
			if(y[i+1]<y[i]) {
				int tmp = y[i];
				y[i] = y[i+1];
				y[i+1] = tmp;
			}
		}
		int[] xOut = new int[2];
		int[] yOut = new int[2];
		xOut[0] = x[0];
		xOut[1] = x[1];
		yOut[0] = y[0];
		yOut[1] = y[1];
		
		for(int i=2 ; i<x.length ; i=i+2) {
			if(x[i] >= xOut[1] || y[i] >= yOut[1] || x[i+1] <= xOut[0] || y[i+1] <= yOut[0]) {
				return 0;
			}
			xOut[0] = Math.max(xOut[0], x[i]);
			xOut[1] = Math.min(xOut[1], x[i+1]);
			yOut[0] = Math.max(yOut[0], y[i]);
			yOut[1] = Math.min(yOut[1], y[i+1]);
		}
		
		return (xOut[1] - xOut[0]) * (yOut[1] - yOut[0]);

		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

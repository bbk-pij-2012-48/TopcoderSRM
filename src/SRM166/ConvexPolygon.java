// Based on surveyors area formula

package SRM166;

public class ConvexPolygon {
	
	public static double findArea(int[] x, int[] y) {
		int det = 0;
		for(int i=0 ; i<x.length-1 ; i++) {
			det += x[i]*y[i+1];
			det -= x[i+1]*y[i];
		}
		det += x[x.length-1]*y[0];
		det -= x[0]*y[y.length-1];
		det = Math.abs(det);
		
		return 0.5*det;
	}
}

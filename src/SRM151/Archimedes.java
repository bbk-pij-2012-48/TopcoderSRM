package SRM151;

public class Archimedes {
	
	public static double approximatePi(int numSides) {
		double num = numSides;
		return (num * Math.sin(Math.PI/num));
	}

}

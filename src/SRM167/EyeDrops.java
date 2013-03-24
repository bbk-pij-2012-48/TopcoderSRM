package SRM167;

public class EyeDrops {
	
	public static double closest(int sleepTime, int k) {
		if(sleepTime<=24.0/k) {
			return (24.0/k)*60;
		}
		if(k==1) {
			return 24*60;
		}
		return 60*(24.0-sleepTime)/(k-1);
	}
	
	public static void main(String[] args) {
		System.out.println(closest(8,2));
		System.out.println(closest(9,3));

		System.out.println(closest(23,1));
		System.out.println(closest(9,8));
		System.out.println(closest(8,2));

	}

}

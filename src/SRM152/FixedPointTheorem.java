package SRM152;

public class FixedPointTheorem {
	
	public static double cycleRange(double R) {
		double tmp = F(0.25,R);
		for(int i=1 ; i<200000 ; i++) {
			tmp = F(tmp,R);
		}
		//200,001
		tmp = F(tmp,R);
		
		double highest = tmp;
		double lowest =  tmp;
		
		for(int i=1 ; i<1000 ; i++) {
			tmp = F(tmp,R);
			if(tmp>highest) {
				highest = tmp;
			}
			if(tmp<lowest) {
				lowest = tmp;
			}
		}
		return highest - lowest;
	}

	private static double F(double X, double R) {
		return R * X * (1-X);
	}


	public static void main(String[] args) {
		System.out.println(cycleRange(0.1));
		System.out.println(cycleRange(3.05));

		System.out.println(cycleRange(3.4499));

		System.out.println(cycleRange(3.55));

		System.out.println(cycleRange(3.565));

		System.out.println(cycleRange(3.5689));		
		System.out.println(cycleRange(3.00005));


		
	}

}

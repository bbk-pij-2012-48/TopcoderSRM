package SRM161;

public class StringTrain {

	public static String buildTrain(String[] cars) {
		String train = cars[0];
		for(int i=1 ; i<cars.length ; i++) {
			int tmp = prefix(cars[i], train); // tmp gives length of prefix
			if(tmp != -1) {
				train += cars[i].substring(tmp);
			}
		}
		int length = train.length();
		String cropTrain = "";
		for(int i=train.length()-1 ; i>=0 ; i--) {
			char tmp2 = train.charAt(i);
			boolean used = false;
			for(int j=cropTrain.length()-1 ; j>=0 ; j--) {
				if(cropTrain.charAt(j)==tmp2) {
					used = true;
					break;
				}
			}
			if(!used) {
				cropTrain = tmp2 + cropTrain;
			}
		}
		return length + " " + cropTrain;
	}
	
	private static int prefix(String car, String train) {
		int max = Math.min(car.length()-1, train.length()-1);
		for(int i=max ; i>=1 ; i--) {
			if(car.substring(0, i).equals(train.substring(train.length()-i))) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {

		System.out.println(buildTrain(new String[] {"ABCDE","CDFFF","CDE","CDEGG","GABC"}));

	}

}

package SRM164;

import java.util.Arrays;

public class PartySeats {

	public static String[] seating(String[] attendees) {
		if(attendees.length<4){
			return new String[0];
		}
		
		String[][] details = new String[attendees.length][];
		for(int i=0 ; i<attendees.length ; i++) {
			details[i] = attendees[i].split(" ");
		}

		String[] boys = new String[attendees.length/2];
		String[] girls = new String[attendees.length/2];
		int boyCount = 0, girlCount = 0;

		for(int i=0 ; i<details.length ; i++) {
			if(details[i][1].equals("boy")){
				boys[boyCount] = details[i][0];
				boyCount++;
			} else {
				girls[girlCount] = details[i][0];
				girlCount++;
			}
		}
		if(boyCount != girlCount || boyCount%2 != 0) {
			return new String[0];
		}

		Arrays.sort(boys);
		Arrays.sort(girls);

		String[] output = new String[boyCount+girlCount+2];
		output[0] = "HOST";
		for(int i=0 ; i<boyCount/2 ; i++) {
			output[2*i+1] = girls[i];
			output[2*i+2] = boys[i];
		}
		output[boyCount+1] = "HOSTESS";
		for(int i=boyCount/2 ; i<boyCount ; i++) {
			output[2*i+2] = boys[i];
			output[2*i+3] = girls[i];			
		}
		return output;
	}

	public static void main(String[] args) {
		String[] tmp = seating(new String[] {"BOB boy","SUZIE girl","DAVE boy","JO girl",
				"AL boy","BOB boy","CARLA girl","DEBBIE girl"}
);
		for(String name: tmp) {
			System.out.println(name);
		}
	}

}

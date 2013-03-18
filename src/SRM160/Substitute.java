package SRM160;

public class Substitute {

	public static int getValue(String key, String code) {
		StringBuffer newCode = new StringBuffer(code);
			for(int i=0 ; i<newCode.length() ; i++) {
				for(int j=0 ; j<key.length() ; j++) {
					if(newCode.charAt(i) == key.charAt(j)) {
						newCode.replace(i,i+1,Integer.toString((j+1)%10));
						break;
					}
				}
			}
			for(int i=newCode.length()-1 ; i>=0 ; i--) {
				if(!Character.isDigit(newCode.charAt(i))) {
					newCode.delete(i, i+1);
				}
			}
			return Integer.parseInt(newCode.toString());
	}
	
	public static void main(String[] args) {

		System.out.println(getValue("TRADINGFEW","LGXWEV"));

	}

}

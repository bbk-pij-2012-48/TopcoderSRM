package SRM149;

public class FormatAmt {

	public static String amount(int dollars, int cents) {
		
		String result = Integer.toString(dollars);
		StringBuffer tmp = new StringBuffer(result);
		for(int i=result.length()-3 ; i>0 ; i=i-3) {
			tmp.insert(i,',');
		}
		tmp.insert(0,'$');
		tmp.append('.');
		if(cents>=10) {
			tmp.append(cents);
		} else {
			tmp.append('0');
			tmp.append(cents);
		}
		return tmp.toString();
	}
	public static void main(String[] args) {
		System.out.println(amount(123456,67));

	}

}

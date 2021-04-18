package Pack2_Programming;

public class FindFirstNLastDigit {

	public static void main(String[] args) {
		int number = 502356997;
		int firstDigit = 0;
		int lastDigit = 0;

		lastDigit = number%10;
		System.out.println("Last digit: "+lastDigit);

		//here looping till number is not equal to 0( any value like 0.7,0.9 etc are considered 0 only as it is stored in int type.)
		while(number!=0) { 
			firstDigit = number%10;
			number /= 10;
			
		}
		System.out.println("First digit: "+firstDigit);
	
	
	//////////////////////////////////////////////////////////////////////
	//method2
	int num=502356997;
	String st=String.valueOf(num);
	System.out.println("first digit= "+st.charAt(0));
	System.out.println("Last digit= "+st.charAt(st.length()-1));
	

	}
}



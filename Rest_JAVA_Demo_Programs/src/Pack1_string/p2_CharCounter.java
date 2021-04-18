package Pack1_string;

import java.math.BigInteger;

public class p2_CharCounter {

	public static void main(String[] args) {
		//String str= "addddtyaddutd"
		//In this string we have to count  ,how many times "dd" has occurred
	
		String s = "addddtyaddutd";

		String m = "dd";
		int count = 0;
		for(int i=0; i<s.length()-1; i++)
		{
			
			String x = ""+s.charAt(i)+s.charAt(i+1);
			if(x.equals(m))
				++count;
		}
		System.out.println("count of 'dd' = "+count);
		
		//to work with really large numbers use BigInteger class
		// int size--32 bits,  Large size--36 bits,  BigInteger size depends on memory available.
		BigInteger bigInteger=new BigInteger("48277428773656130918742873472665658219187318743276487676587264319818701740317401");
		System.out.println(bigInteger);
	}

	
}

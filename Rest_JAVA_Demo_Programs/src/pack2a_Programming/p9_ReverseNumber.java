package pack2a_Programming;

public class p9_ReverseNumber {

	public static void main(String[] args) {
		int a=543;
		int reverse=0;
		while(a!=0)
		{
			//modulus of number gives remainder which is noting but last digit of the number
			int digit=a%10;

			//remember this formula to create new reversed number
			reverse=digit+reverse*10;

			//divide number by 10 to get remaining number after last digit is removed and then updating the number with this new number
			a=a/10;
		}
		System.out.println("reversed number is= "+reverse);



		//2nd method

		int b=543;
		String num=String.valueOf(b);	
		String reversedNum="";
		for(int i=num.length()-1 ; i>=0 ; i--)
		{
			reversedNum=reversedNum+num.charAt(i);
		}
		
		System.out.println("reversed Num using  2nd method= "+Integer.valueOf(reversedNum));
		System.out.println("reversed Num using  2nd method= "+Integer.parseInt(reversedNum));

		//rotate the string
		/*String s="VERIFONE";
		String temp1="";
		String temp2="";
		for(int i=s.length()-1; i>=0 ;i--){
			temp1=temp1+s.charAt(i);
			temp2=s.substring(0, s.length());
		temp2=temp2+temp1;
			System.out.println(temp2);*/
		
		}

	}


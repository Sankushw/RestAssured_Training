package pack2a_Programming;

public class p7_PrimeNumber {

	public static void main(String[] args) {
		//to check if number is prime
		//logic1: if number divided by any number before itself doesn't leave 0 remainder then it is prime.
		//logic2: if number divided by any number before half of itself doesn't leave 0 remainder then it is prime.
		
		Boolean flag=false;
		int val=15;
		for(int i=2;i<val;i++)
		{
			//keep dividing given number by every number till itself or till its half is also fine.
			if (val%i==0)
			{
				flag=true;	
			}
		}
		if(flag)
			System.out.println("given number "+val+" is a not prime number");
		else
			System.out.println("Given Number "+val+" is a prime number");

	}
}

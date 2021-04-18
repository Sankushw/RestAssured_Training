package pack2a_Programming;

public class p6_FibanocciSeries {

	public static void main(String[] args) {
		//print Fibanocci series till 8 members
		//series: 0,1,1,2,3,5,8,13,21,34	
		//1st iteration:-----------------------
		//a-->0
		//b--->1
		//sum--->0+1=1
		//2nd Iteration:-----------------------
		//swap-->make b as a and sum as b.
		int a=0;
		int b=1;
		int sum=0;
		int i=1;
		while(i<9)
		{
			sum=a+b;
			System.out.println(sum);
			//swap
			a=b;
			b=sum;
			i++;
		}
	}

}

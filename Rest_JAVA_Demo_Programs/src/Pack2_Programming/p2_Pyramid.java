package Pack2_Programming;

public class p2_Pyramid {
	static int k=1;
	public static void main(String args[])
	{
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<4-i; j++) 
			{
				System.out.print(k); //print k instead of j so that value keeps incrementing continuously after every loop
				System.out.print("\t");//enter the space between numbers in a row
				k++;
			}
			System.out.println(""); //enter new line after every row
		}
	}
}

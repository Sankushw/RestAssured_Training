package Pack2_Programming;

public class p4_InvertedPyramidWithSpecificNumbers {
	static int k=3;
	public static void main(String args[])
	{
		for(int i=1; i<5; i++)
		{
			for(int j=0; j<i; j++)
			{
				System.out.print(k); //print j if you want every row starting with 0,1,2 or print k if want number in continuous fashion 
				System.out.print("\t");//enter the space between numbers in a row
				k=k+3;
			}
			System.out.println(""); //enter new line after every row
		}
	}
}

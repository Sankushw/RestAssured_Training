package Pack2_Programming;

public class p3_InvertedPyramid {
	static int k=1;
	public static void main(String args[])
	{
		for(int i=1; i<5; i++)
		{
			for(int j=0; j<i; j++)
			{
				System.out.print(j); //print j if you want every row starting with 0,1,2 or print k if want number in continuous fashion 
				System.out.print("\t");//enter the space between numbers in a row
				k++;
			}
			System.out.println(""); //enter new line after every row
		}
	}
}

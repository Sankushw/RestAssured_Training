package pack6_array;

import org.testng.annotations.Test;

public class Arrays {
	/*Arrays--containers to store and manipulate data of same data type.
	single dim array:
	int a[]=new int[3]; ----declaration
	a[0]=4;-----initializations
	a[1]=9;
	a[2]=7;
	or
	int a[]={4,9,7};----------declaration and initialization in same step

	multi dim aray:
	int a[][]=new int[2][3]----declaration
	a[0][0]=4;------initialization
	a[0][1]=7;
	a[0][2]=0;
	a[1][0]=3;
	a[1][1]=9;
	a[1][2]=6;
	or
	int a[][]={{4,7,0},{3,9,6}};----------declaration and initialization in same step*/

	@Test(priority=0)
	public  void SingleDimArray() {
		// TODO Auto-generated method stub

		int a[] = {1,4,3,5,7,8};

		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]);

		}
		System.out.println("");//so that  statements in below methods are printed in new line
	}

	@Test(priority=1)
	public  void MultiDimArray() {
		//Multi Dimensional array
		int b[][] = new int[2][3];
		b[0][0]=2;
		b[0][1]=4;
		b[0][2]=5;
		b[1][0]=3;
		b[1][1]=4;
		b[1][2]=7;
		System.out.println(b[1][0]);
	}
	@Test(priority=2)
	public  void LeastNum_in_MultiDimArray() {
		int c[][]= {{2,4,5},{3,4,7},{5,2,1}};
		System.out.println(c[2][1]);
		int smallestNum=c[0][0];
		for(int i=0;i<c.length;i++)  //row
		{
			for(int j=0;j<3;j++)   //coloumn
			{
				System.out.print(c[i][j]);//print the array
				System.out.print("\t");

				//interview question----find the least number in array
				if(c[i][j]<smallestNum)
					smallestNum=c[i][j];

			}
			System.out.println("");
		}
		System.out.println("smallest number in array is= "+smallestNum);
	}

	@Test(priority=3)
	public  void MaxNum_in_givenColumn_MultiDimArray() {
		/*step1 find least number
		step2 get column of minimum number
		step3 find max number in identified column*/

		int c[][]= {{2,4,5},{3,4,7},{5,2,1}};
		int smallestNum=c[0][0];
		int columnOfMinNum = 0;
		for(int i=0;i<c.length;i++)
		{
			for(int j=0;j<3;j++)
			{
				//step1--find the least number in array
				if(c[i][j]<smallestNum){
					smallestNum=c[i][j];
					//step 2--get column of min number
					columnOfMinNum=j;
				}
			}

		}
		System.out.println("column index of smallest number "+smallestNum+" is= "+columnOfMinNum);
		
		//step 3--find the max number in identified column
		int maxNum=c[0][columnOfMinNum];
		int k=0;
		while(k<3)
		{
			if(c[k][columnOfMinNum]>maxNum)
			{maxNum=c[k][columnOfMinNum];
			}
			k++;
		}
		
		System.out.println("max number in identified column "+columnOfMinNum+" is "+maxNum);
	}
}



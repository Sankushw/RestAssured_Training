package pack2a_Programming;

public class p5_SortArrays {

	public static void main(String[] args) {


		//to print array values in ascending order/////////////////////////////////////////////////////////////////////
		int[]a={6,2,9,0,7,2,5,8,1};

		for(int i=0; i<a.length-1; i++)
		{

			for(int j=i+1; j<a.length;j++)
			{
				if(a[i]>a[j])
				{
					//then swap
					int temp=a[j];
					a[j]=a[i];
					a[i]=temp;	

				}
			}
		}
		//print the values in new ordered arrray
		for(int i=0; i<a.length; i++)
		{
			System.out.println(a[i]);
		}

		//to print array values in descending order/////////////////////////////////////////////////////////////////////	
		int[]b={6,2,9,0,7,2,5,8,1};

		for(int i=0; i<b.length-1; i++)
		{

			for(int j=i+1; j<b.length;j++)
			{
				if(b[i]<b[j])
				{
					//then swap
					int temp=b[j];
					b[j]=b[i];
					b[i]=temp;	

				}
			}
		}
		//print the values in new ordered arrray
		for(int i=0; i<b.length; i++)
		{
			System.out.println(b[i]);
		}
	}

}

package Pack2_Programming;

public class sortingArray {

	public static void main(String[] args) {

		int temp;
		int a[]={2,5,9,0,3,8,6,1,4};
		//outer loop for pointing 1st number for comparing
		for(int i=0;i<a.length;i++)
		{
			//inner loop for pointing 2nd number for comparing
			for(int j=i+1;j<a.length;j++)
			{
				//swap if 2ns number is bigger than 1st number
				if(a[i]>a[j])
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;

				}
			}
		}
		//print the sorted array
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);

	}

}

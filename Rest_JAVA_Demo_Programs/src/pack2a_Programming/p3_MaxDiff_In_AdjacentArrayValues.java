package pack2a_Programming;

public class p3_MaxDiff_In_AdjacentArrayValues {
	//WAP to find max difference between adjacent numbers in given array
	public static void main(String[] args) {

		int diff=0;
		int[] a={1,4,8,15,17};
		for(int i=0;i<a.length-1;i++)// use i>a.length-1  otherwise it throws inexOutOfBound exception if  i>a.length
		{
			if(a[i+1]-a[i]>diff)// compare with temporary variable  diff
			{
				diff=a[i+1]-a[i];	
			}
		}
		System.out.println(diff);
	}

}

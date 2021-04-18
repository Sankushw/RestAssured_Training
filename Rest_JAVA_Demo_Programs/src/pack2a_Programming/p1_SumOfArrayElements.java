package pack2a_Programming;

public class p1_SumOfArrayElements {
	//WAp which accepts an array and returns sum
	public static void main(String[] args) {

		int[] a={1,2,3,4,5};
		//calling the Method and proving array as argument
		int sum=sumArray(a);
		System.out.println("sum of elements of array= "+sum);	
	}
	//making the method static so it can be called without making object of class
	public static int sumArray(int[] a) {
		int sum=0;
		for(int i=0;i<a.length;i++)
		{
			sum=sum+a[i];
		}
		return sum;
	}

}

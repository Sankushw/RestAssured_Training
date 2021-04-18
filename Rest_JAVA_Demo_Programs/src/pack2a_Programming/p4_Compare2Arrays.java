package pack2a_Programming;

import java.awt.List;
import java.util.ArrayList;

public class p4_Compare2Arrays {
	//WAP to compare same indexes of 2 diff arrays and create a 3rd array for matching values
	public static void main(String[] args) {
		int[]a={1,2,8,1,5,6,3,8,9,0};
		int[]b={7,2,9,2,5,6,3,8,1,0};

		//call CompareIndexes() method and pass the 2 arrays as arguments. Store the output in Object[] as this is return type of method.

		Object[] c=CompareIndexes(a,b);
		for(int i=0;i<c.length;i++)
		{
			System.out.println(c[i]);	
		}
	}

	public static Object[] CompareIndexes(int[]a, int[]b) {
		ArrayList<Integer> al=new ArrayList<Integer>();
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==b[i])
			{
				//We can't store in array as we are not sure of the size of the array that will be created.So we are using ArrayList.
				al.add(a[i]);
			}
		}

		//converting the arraylist to Array as per the question asked. return type of al.toArray is Object[].
		Object[] ArrObj=al.toArray();
		return ArrObj;
	}

}

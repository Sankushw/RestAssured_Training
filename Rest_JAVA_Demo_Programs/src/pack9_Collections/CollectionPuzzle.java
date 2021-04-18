package pack9_Collections;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class CollectionPuzzle {

	//	Identify all unique numbers in given array and find number of times they occur in the array
	@Test
	public void Test()
	{
		int a[] ={3,5,3,7,1,5,6,3,0,3,7,5,1,7,4,9,3,6,8,3,7,1,2,3,4,5,8,3,1,8,5,2};

		//step1: make an empty arraylist
		//Step2: check if element is not present in List--->add the element.
		//step3: scan all elements of array to count the number of occurences of that element
		//repeat same for all elements

		ArrayList<Integer>al=new ArrayList<>();
		for(int i=0;i<a.length;i++)
		{
			int k=0;
			if(!al.contains(a[i]))
			{
				al.add(a[i]);
				k++;

				for(int j=i+1;j<a.length;j++)
				{
					if(a[i]==a[j])
					{
						k++;
					}
				}
				System.out.println("count of number "+a[i]+" is= "+k);
				if(k==1)
					System.out.println(a[i]+" is unique number in the array");
			}
			
		}
	}


}

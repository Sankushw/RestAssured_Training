package pack9_Collections;

import java.util.HashSet;
import java.util.Iterator;

import org.testng.annotations.Test;

public class C2_HashSet_Example {
	// HasSet, TreeSet, LinkedHAshSet implements Set interface
	//doesn't accept duplicate values
	//Elements are stored in random order(not sequestial)
	//Set allows only one null value.
	
	//HashSet internally uses data structure like a hash table for storage using hashing technique
	
	@Test
	public void hashSet_ex(){

		HashSet<String> ha=new HashSet<String>();
		ha.add("Sanjay");
		ha.add("Sadhana");
		ha.add("Subham");
		ha.add("Sanjay");
		
		System.out.println(ha);
		ha.remove("Subham");
		ha.add("Shivani");

		ha.add("Ragini");

		System.out.println(ha);
		System.out.println(ha.isEmpty());
		System.out.println(ha.size());

		//interate through set and print values in it
		Iterator<String>it=ha.iterator();
		//System.out.println(it.next());
		while(it.hasNext())
		{
			System.out.println(it.next());
		}

	}
}

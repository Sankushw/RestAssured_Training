package pack9_Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

public class C3_HasMap_Example {

	@Test
	public void HasMapTest()
	{
		/*3 Map- A Map is an object that maps keys to values.The Map interface includes methods for:
			basic operations (such as put , get , remove , containsKey , containsValue , size , and empty ),
			bulk operations (such as putAll and clear ), 
			and collection views (such as keySet , entrySet , and values )
			Map contains unique keys.
Map allows duplicate values.
			*
			*/
		
		HashMap<Integer, String> ha=new HashMap<Integer, String>();
		ha.put(1, "Hello");
		ha.put(12, "Morning");
		ha.put(15, "Bye");
		ha.put(5, "evening");
		System.out.println(ha.get(12));
		ha.remove(12);//removing value--prints null when sysout is done
		System.out.println(ha.get(12));

		ha.put(12, "Sun");//again assigning a value in that key
		System.out.println(ha.get(12));

		ha.put(12, "moon");//replacing the existing key with new value---overwrites the value
		System.out.println(ha.get(12));

		//interview--create a HasMap and pass the map to Set table and print the keys and values using Iterator
		Set<Entry<Integer, String>> s= ha.entrySet();
		Iterator<Entry<Integer, String>> it=s.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());	
			/*Entry<Integer, String>e=it.next();//to print  keys or values separately
			System.out.println(e.getKey());*/
		}
		
	}

}

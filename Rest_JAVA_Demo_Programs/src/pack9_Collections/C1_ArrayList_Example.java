package pack9_Collections;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class C1_ArrayList_Example {
	/*Collection:
		collection framework is collection of interfaces and classes which helps in storing and processing the data more efficiently.It has several useful classes
		which have tons of methods which makes programmer task very easy.
		1 list-is a ordered collection(called sequential).may contain duplicate elements.It is implimented by
		ArrayList
		LinkedList
		Vectors
		2 Set- is unordered collection of data.Can't have duplicate elements. It is implemented by
		HashSet
		LinkedHashSet
		TreeSet
		3 Map- A Map is an object that maps keys to values.implemented by :
		HashMap, 
		LinkedHashMap.
		HashTable
		Treemap
		The Map interface includes methods for:
		basic operations (such as put , get , remove , containsKey , containsValue , size , and empty ),
		bulk operations (such as putAll and clear ), 
		and collection views (such as keySet , entrySet , and values )

	 */
	@Test
	public void arrays()
	{
		ArrayList<String> a=new ArrayList<String>();
		a.add("Rahul");
		a.add("Sanjay");
		a.add("sadhana");
		System.out.println(a);
		a.add(1, "Java");
		a.add(4, "Priya");
		System.out.println(a);
		a.remove(4);
		
		System.out.println(a);
		a.add("Sanjay");
		System.out.println(a);

		System.out.println(a.get(3));
		System.out.println(a.indexOf("sadhana"));
		System.out.println(a.contains("Java"));
		System.out.println(a.size());
		

	}
	//1 arrayList-no need to declare size;
	//2 no need to use for loop to print. directly pass object in sysout().
	//3 we can add remove the values  at any index
	//4 we use .size() to get size unlike in array where we use .length()
	//both arrays and arraylist accept duplicate values. All classes implementing List accept duplicates
	// Elements stored in sequential order in both arrays and arraylist--ie. not stored randomly like in sets

	//concept: final keyword---->is used to put restriction
	//final variable is constant.It can't be changed again
	//final class can't be inherited by child class(can't be extended)
	//final method can't be overriden by method in child class.

	//There are few inbuilt packages in java like--java, lang, awt, javax, swing, net, io, util, sql etc.
	//java.lang is inbuilt package ..thats why we can directly use commands like system.out.println, String class etc without any import.
	//java/Util package--all Collection classes and other classes come from this package but we need to import it.
}

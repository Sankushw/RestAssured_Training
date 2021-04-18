package Pack1_string;

public class p1_Strings {

	public static void main(String[] args )
	{
		//String : it is one of the prebuilt class in java--coming from java.lang package---2 ways to declare
		//1.String literal-->new string created check if object is available in String pool and points to same object if found
		//2.by creating object of string-->every time creates new object
		// when we create string using new Keyword, it creates object in Heap memory and reference var points to it. And also checks if String is present in SCP(String
		//constant pool). If not present , then it creates 1 more object in SCP also.
		//Creating string  directly by string literal, checks if String is present in SCP. if not present, it creates 1 in SCP and points to it.
		// Objects in SCP are not eligible for garbage collection unlike in HEAP memory.
		
		//concatanation of strings is from left to  right
		long t=322342432;
		String p="welcome";
		String q="home";
		int r=5;
		int s=9;

		System.out.println(p+q);
		System.out.println(r+s);
		System.out.println(p+q+r);
		System.out.println(p+q+r+s);//left to right
		System.out.println(p+q+(r+s));

		String a= "javatrainingTesting ";
		//charAt(index), contains(char seq),concat(string),contentEquals(StringBuffer/StringBuilder),EqualsIgnoreCase(String),indexOf(),
		//lastIndexOf(), length(),startsWith(String),endswith(String), replace(),subString(),toUpperCAse(),toLowerAcse(),trim().
		//st.contentEquals(StringBuffer/StringBuilder)---> to compare String with StringBuilder or String buffer
		//st.equals(char seq..)---> to compare String with String or String Object
		// equals method is also present in Object class which compares references not content. Equals method in string class overrides this to compare content

		System.out.println(a.charAt(2));
		System.out.println(a.indexOf("a"));
		System.out.println(a.substring(3, 6));
		System.out.println(a.substring(5));
		System.out.println(a.concat("rahul teaches"));
		System.out.println(a.replace("in", ""));//replace in with no character(delete)
		
		System.out.println(a.trim());
		System.out.println(a.toUpperCase());
		System.out.println(a.toLowerCase());
		//split
		String []arr =a.split("t");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(a.replace("t", "s"));

		//concept: final keyword---->is used to put restriction
		//final variable is constant.It can't be changed again
		//final class can't be inherited by child class(can't be extended)
		//final method can't be overriden by method in child class.

		//There are few inbuilt packages in java like--java, lang, awt, javax, swing, net, io, util, sql etc.
		//java.lang is inbuilt package ..thats why we can directly use commands like system.out.println, String class etc without any import.
		//java/Util package--all Collection classes and other classes come from this package but we need to import it.

		/*access modifiers:---for variables and methods
	 public--access through out project in all packages, sub packages
	 protected--access in same package and sub classes of different packages also.
	 Default--access only in same package
	 private--access only inside same class
	 protected = default + subclass of other packages(using extends)
	 public= protected + Other packages

		 */

	}
}
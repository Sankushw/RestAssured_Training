package Pack2_Programming;

public class Swap {
	//concept: final keyword---->is used to put restriction
	//final variable is constant.It can't be changed again
	//final class can't be inherited by child class(can't be extended)
	//final method can't be overriden by method in child class.

	//There are few inbuilt packages in java like--java, lang, awt, javax, swing, net, io, util, sql etc.
	//java.lang is inbuilt package ..thats why we can directly use commands like system.out.println, String class etc without any import.
	//java/Util package--all Collection classes and other classes come from this package but we need to import it.

	public static void main(String[] args) {
		// swap with temp variable
		int a=5;
		int b=4;
		int temp;
		temp=a;
		a=b;
		b=temp;
		System.out.println("swapped a= "+a+ " swapped b= "+b);

		//swap without temp variable
		int c=5;
		int d=4;
		c=c+d;
		d=c-d;
		c=c-d;
		System.out.println("swapped c= "+c+ " swapped d= "+d);


	}

}

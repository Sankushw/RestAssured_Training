package pack3_Interfaces;

/*
abstraction-process of hiding or not providing the implementation details to user and only providing the functionality.
abstract class-	class declared with abstract keyword. It can have abstract and concrete methods.
-abstract class provide partial abstraction. Interfaces provide 100% abstraction
-if even 1 method is marked abstract then eclipse forces to mark class as abstract.and when child class extends to it, eclipse forces
 it to implement abstract method like in interfaces.
-abstraction eg:
	There is parent class which defines aeroplane body construction rules.All child classes(companies) have to inherit 
 	parent class and use those methods to build their own aeroplane.
	But there is a methd aeroplane color which can be unique to a company depending on their logo.
	So color method is not implemented(abstracted) in parent class.Child class have to provide the implementation.
-If there is even 1 abstract method in class then it is called abstract class.	
-Differences Interfaces and Abstract classes.
Interfaces:
	-have only abstract methods(100% abstraction)
	-access specifier of method must be public
	-access specifier of variables can be public static or final
	-to implement interface use implements keyword
Abstract class:
	-have both concrete and abstract methods(partial abstraction)
	-access modifier of methods can be anything except private
	-access modifier of variables can be anything except private
	-to implement abstract class use extends keyword

 */
public class IndainTraffic implements CentralTraffic_Interf,ContinentalTraffic_Interf { 

	public static void main(String[] args) {

		IndainTraffic it=new IndainTraffic();//can access only methods in child class;
		it.FlashYellow();
		it.greenGo();
		it.walkonsymbol();
		it.Conti_Trainsymbol();

		CentralTraffic_Interf a= new IndainTraffic();//can access methods only in parent interface
		a.redStop();
		a.FlashYellow();		
		a.greenGo();
		System.out.println(a.a);

		ContinentalTraffic_Interf ct=new IndainTraffic();//can access methods only in parent interface
		ct.Conti_Trainsymbol();
		System.out.println(ct.s1);


	}

	@Override
	public void redStop() {
		// TODO Auto-generated method stub
		System.out.println(" redstop implementation");
	}
	public void walkonsymbol()
	{
		System.out.println("walking");
	}
	@Override
	public void FlashYellow() {
		// TODO Auto-generated method stub
		System.out.println(" flash yellow implementation");
		//code
	}

	@Override
	public void greenGo() {
		// TODO Auto-generated method stub
		System.out.println(" Green go implementation");
	}


	@Override
	public void Conti_Trainsymbol() {
		// TODO Auto-generated method stub
		System.out.println("train is coming");
	}


}

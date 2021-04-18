package pack4_Inheritence_N_super_this;

public class Child extends Parent{
	String name ="QAClickAcademy";
	//usage of super keyword with variables, methods and constructor
	public Child()
	{
		super();// this should be always be at first line
		System.out.println("child class construtor");

	}
	public void getStringdata()
	{
		//	if Child class also has same Variable name then, complier gives preference to child var.
		// to get the varibale from parent in such cases use super keyword
		System.out.println(name);
		System.out.println(super.name);
	}


	public void display()
	{
		super.display();//calls parent dsiplay()
		System.out.println("I am display method in child class");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Child cd = new Child();
		cd.getStringdata();
		cd.display();
/*Rules:
	1 If same variable is present in both Parent and child, Preference is given to child.
	2 If same method is present in both Parent and child, Preference is given to child.
	3 if variable/method is present only in parent, it is picked from parent
	4 if variable/method is present only in child, it is picked from child
	5

*/
	}

}




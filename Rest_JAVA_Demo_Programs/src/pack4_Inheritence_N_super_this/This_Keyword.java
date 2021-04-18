package pack4_Inheritence_N_super_this;

public class This_Keyword {
	int a=12;
	//interview question: get sum of local and global integers referenced by same variable name
	//this keyword indicates to global variable.	
	//super keyword functionality is shown in parent and child classes scripts created 
	public void getsum(){
		int a=5;
		int sum=this.a+a;
		System.out.println(sum);
	}
	public static void main(String[] args) {

		This_Keyword key=new This_Keyword();
		key.getsum();
	}
	//note about exceptions:try() and catch()
	//in Try catch, we can have multiple catch blocked to catch specific exceptions.
	//finally block --can be  used to clear cache when a test case pass or fails so that other test cases are not affected.
	// finally block always executes even if you have exception or return statement in try block except in case of:
	/*1 System.exit() is called...forcefully exit
      2The JVM crashes.
      3The try{} block never ends (e.g. endless loop).*/

	//we can have try without catch..ie we can have try with finally block. and whether exception occurs
	//or not finally will be executed.
	
	//top 50 JAVA interview questions: https://java2blog.com/core-java-interview-questions-and-answers/

}

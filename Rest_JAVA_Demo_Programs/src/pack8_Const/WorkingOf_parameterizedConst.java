package pack8_Const;

import org.testng.annotations.AfterGroups;

public class WorkingOf_parameterizedConst {

	String name;
	int t;

	public WorkingOf_parameterizedConst(String name, int t)
	{
		this.name=name;
		this.t=t;
	}

	public static void main(String []args){
		//if we have multiple parameterized constructor then while creating object we have to give arguments to match the constructor
		//If we have declared any constructor, complier will not call implicit/default constructor
		WorkingOf_parameterizedConst p=new WorkingOf_parameterizedConst("sanjay", 100);
		System.out.println(p.name);
		System.out.println(p.t);
	}
}

package pack8_Const;

public class WorkingOf_DefautlConst {

	int i;
	public void display()
	{
		System.out.println("I am in display method");
	}
	
	public static void main(String[] args) {
		//compiler calls default constructor when we have not declare one---purpose of def constructor is to initialize vars with default values eg; 0 for int, null for string etc.
		//like methods only but donot have any return type
		WorkingOf_DefautlConst con=new WorkingOf_DefautlConst();
		con.display();
		System.out.println(con.i);
	}

}

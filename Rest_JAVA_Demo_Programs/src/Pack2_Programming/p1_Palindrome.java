package Pack2_Programming;

public class p1_Palindrome {

	public static void main(String[] args) {

		String name="MADAM";
		String reverseName="";
		for(int i=name.length()-1; i>=0; i--)
		{
			reverseName=reverseName+name.charAt(i);
		}

		System.out.println("reversed name= "+reverseName);
		if(reverseName.equalsIgnoreCase(name))
			System.out.println("string is a palindrome");
		else 
			System.out.println("String is not palindrome");
	}

}

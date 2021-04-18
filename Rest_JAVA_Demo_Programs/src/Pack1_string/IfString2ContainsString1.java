package Pack1_string;

public class IfString2ContainsString1 {
//check if 1st string is contained in the 2nd and remove it from 2ns string.
	public static void main(String[] args) {
		String s1="the";
		String s2="another";
		String commonChars="";
		for(int i=0; i<s2.length(); i++){

			for(int j=0; j<s1.length(); j++){
				if(s2.charAt(i)==s1.charAt(j))
				{
					commonChars= commonChars+s2.charAt(i);
				}
			}
		}
		System.out.println("common Chars in the Strings= "+commonChars);
		for(int i=0; i<commonChars.length(); i++){
			
			//convert char to be replaced  to string so that we can use it in replace() method.
			String CharToReplace=commonChars.charAt(i)+"";
			s2=s2.replace(CharToReplace, "");//replace and assign updated value to s2
			
			}
		System.out.println("String s2 after common chars deleted= "+s2);
		
	}
	
}
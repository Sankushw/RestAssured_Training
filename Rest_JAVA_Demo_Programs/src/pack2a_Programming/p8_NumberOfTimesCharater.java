package pack2a_Programming;

public class p8_NumberOfTimesCharater {

	public static void main(String[] args) {

		//find number of times "a" appears
		int Lettercount=CharCounter("aaadhuasad",'a');
		System.out.println("count of letter a is= "+Lettercount);
	}

	public static int CharCounter(String word, char letter) {
		int count=0;
		for(int i=0;i<word.length();i++)
		{

			if(word.charAt(i)==letter)
				count++;
		}
		return count;
	}


}

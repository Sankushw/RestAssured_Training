package pack7_Date;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

public class Dates {
	
	@Test
	public void Dates()
	{
		Date date=new Date();
		System.out.println(date.toString());
	}
	@Test
	public void Formated_date_Using_SimpleDateFormat1()
	{
	//formatter class is used to format Date or Calendar
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("d/M/Y");//google for all formats
		System.out.println(sdf.format(date));

		SimpleDateFormat sdf1=new SimpleDateFormat("E MM.dd.YYYY 'at' hh:mm:ss a z");
		System.out.println(sdf1.format(date));
	}

	 @Test
	 public void Formated_date_Using_CalenderObject()
	 {
		 Calendar cal=Calendar.getInstance();//Calendar is abstract class so creating object using .getInstance()
		 //formatter class is used to format Date or Calendar
		 SimpleDateFormat sdf=new SimpleDateFormat("MM.dd.YYYY 'at' hh:mm:ss");
		 System.out.println(sdf.format(cal.getTime()));//gets date and/or time as per above format

		 //calendar has other methods which Date class doesn't have so it is better.
		 System.out.println(cal.get(Calendar.AM_PM));
		 System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		 System.out.println(cal.get(Calendar.MINUTE));
		 System.out.println(cal.get(Calendar.YEAR));
		 System.out.println(cal.get(Calendar.WEEK_OF_MONTH));
		 System.out.println(cal.get(Calendar.WEEK_OF_YEAR));
		 System.out.println("Calendar.MONTH "+cal.get(Calendar.MONTH));


	 }
}

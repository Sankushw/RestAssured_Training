package pack9_Collections;

import org.testng.annotations.Test;

public class C4_HashTable_Example {
	@Test
	public void HashTableTest()
	{

		/*HasTable is mostly same as HashMap.
		Differences:
			1 Synchronization and thread safe- HasMap is not thread safe and non synchronized whereas HasTable is Thread-safe and synchronized.
			--use HasMap for non-threading application
			--use Hashtable for multi-threading application. Other threads wait untill active thread completes process with HashTable.
			2 HashMap allows 1 null key and any number of null values whereas HasTable doesn't allow null values for key and values.
			3HashMap object uses Iterator to iterate through values whereas Hastable uses enumerator  to iterate the value.

		 */
	}

}

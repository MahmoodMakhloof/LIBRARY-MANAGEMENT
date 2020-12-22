/**************************************************************/
/* Author  : Mahmoud Abbas Makhlouf                           */
/* Date    : 19 DEC 2020                                      */
/* Version : V01                                              */
/* Des     : Person Class                                     */
/**************************************************************/

package PKG;


public class Today
{
	public static String [] Operations = {"Unknown","Rent","Retrive"};

	public String operation;
	public String book;
	public String client;
	public String employee;
	public String time;


	public Today()
	{
		operation = Operations[0];
		book = "Unknown";
		client ="Unknown";
		employee ="Unknown";
		time = "Unknown";
	}
}



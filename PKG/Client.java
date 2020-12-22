/**************************************************************/
/* Author  : Mahmoud Abbas Makhlouf                           */
/* Date    : 19 DEC 2020                                      */
/* Version : V01                                              */
/* Des     : Client Class                                     */
/**************************************************************/

package PKG;
public class Client extends Person 
{
	
	/* Client Attributes */
	private String code;


	/* Setter Methods */
	public void setCode(String c)
	{
		code = c;
	}



	/* Getter methods */
	public String getCode()
	{
		return code;
	}
	
	public void PrintAllClientData()
	{
		System.out.println("Name   : "+name);
		System.out.println("Code   : "+code);
		System.out.println("Age    : "+age);
		System.out.println("Gender : "+gender);
		System.out.println("Phone  : "+phoneNumber);
		System.out.println("Email  : "+email);
	}


	/* constructor */
	public Client()
	{
		name = "Unknown";
		age = "0";
		gender ="0";
		phoneNumber = "Unknown";
		email = "Unknown";
		code = "0";
	}



}
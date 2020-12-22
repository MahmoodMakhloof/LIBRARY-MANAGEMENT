/**************************************************************/
/* Author  : Mahmoud Abbas Makhlouf                           */
/* Date    : 19 DEC 2020                                      */
/* Version : V01                                              */
/* Des     : Person Class                                     */
/**************************************************************/

package PKG;


public class Person 
{
	/* Person Attributes */
	
	protected String name;
	protected String age;
	protected String gender;
	protected String phoneNumber;
	protected String email;




	/* Setter Methods */
	public void setName(String n)
	{
		name = n;
	}
	public void setAge(String a)
	{
		age = a;
	}
	public void setGender(String g)
	{
		gender = g;
	}
	public void setPhoneNumber(String ph)
	{
		phoneNumber = ph;
	}
	public void setemail(String e)
	{
		email = e;
	}





	/* Getter Methods */
	public String getName()
	{
		return name;
	}
	public String getAge()
	{
		return age;
	}
	public String getGender()
	{
		return gender;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public String getemail()
	{
		return email;
	}

	


	/* Constructor */
	public Person()
	{
		name = "Unknown";
		age = "0";
		gender = "0";
		phoneNumber = "Unknown";
		email = "Unknown";
	}
}
/**************************************************************/
/* Author  : Mahmoud Abbas Makhlouf                           */
/* Date    : 19 DEC 2020                                      */
/* Version : V01                                              */
/* Des     : Employee Class                                   */
/**************************************************************/

package PKG;
public class Employee extends Person 
{
	/* Employee Attributes */
	private String salary;
	private String job;
	private String id;
	private String password;




	/* Setter Methods */
	public void setJob(String j)
	{
		job = j;
	}
	public void setSalary(String s)
	{
		salary = s;
	}
	public void setId(String i)
	{
		id = i;
	}
	public void setPassword(String pass)
	{
		password = pass;
	}



	/* Getter methods */
	public String getJob()
	{
		return job;
	}
	public String getSalary()
	{
		return salary;
	}
	public String getId()
	{
		return id;
	}
	public String getPassword()
	{
		return password;
	}

	public void PrintAllEmployeesData()
	{
		System.out.println("Name      : "+name);
		System.out.println("ID        : "+id);
		System.out.println("Job       : "+job);
		System.out.println("salary    : "+salary);
		System.out.println("Password  : "+password);
		
	}

	/* constructor */
	public Employee()
	{
		name = "Unknown";
		age = "0";
		gender = "0";
		phoneNumber = "Unknown";
		email = "Unknown";
		job = "Unknown";
		salary = "0";
		id ="0";
		password = "0";
	}



}
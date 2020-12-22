/**************************************************************/
/* Author  : Mahmoud Abbas Makhlouf                           */
/* Date    : 19 DEC 2020                                      */
/* Version : V01                                              */
/* Des     : Book Class                                       */
/**************************************************************/

package PKG;

public class Book
{

	/* Book Attributes */
	private String code;
	private String title;
	private String price;
	private String category;
	private String author;
	private String rate;
	private static int numberofallbooks;




	/* Setter Methods */
	public void setCode(String code)
	{
		this.code = code;
	}
	public void setTitle(String title)
	{
		this.title =title;
	}
	public void setPrice(String price)
	{
		this.price = price;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public void setRate(String rate)
	{
		this.rate = rate;
	}





	/* Getter methods */
	public String getCode()
	{
		return code;
	}
	public String getTitle()
	{
		return title;
	}
	public String getPrice()
	{
		return price;
	}
	public String getCategory()
	{
		return category;
	}
	public String getAuthor()
	{
		return author;
	}
	public String getRate()
	{
		return rate;
	}
	public int getNumberOfAllBooks()
	{
		return numberofallbooks;
	}

	public void PrintAllBookData()
	{
		System.out.println("Title    : "+title);
		System.out.println("Code     : "+code);
		System.out.println("Price    : "+price +" LE");
		System.out.println("Category : "+category);
		System.out.println("Author   : "+author);
		System.out.println("Rate     : "+rate);
	}


	/* constructor */
	public Book()
	{
		code = "0";
		title = "Unknown";
		price = "0";
		category = "0";
		author = "0";
		rate = "0";
		numberofallbooks ++;
	}


}
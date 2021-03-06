/***********************************************************************/
/* Author  : Mahmoud Abbas Makhlouf                                    */
/* Date    : 19 DEC 2020                                               */
/* Version : V01                                                       */
/* Des     : Library management project                                */
/***********************************************************************/

package PKG;

/* libraries */
import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;


/* main class */
public class Library
{
    final static int WAITFACTOR = 3;
    

    /* Array of char for Print "EnterChoice" function */
    static char enterchoice[] = new char [] {'E','n','t','e','r',' ','C','h','o','i','c','e',' ','N','u','m','b','e','r',' ',':',' '};
    static Scanner input = new Scanner(System.in);

    static InputStreamReader ir = new InputStreamReader(System. in );
    static BufferedReader br = new BufferedReader(ir);
    


    /* Array Lists */
    static ArrayList <Book> AllBooks = new ArrayList <Book> (20);
    static ArrayList <Client> AllClients = new ArrayList <Client> (20);
    static ArrayList <Employee> AllEmployees = new ArrayList <Employee> (20);
    static ArrayList <Today> AllOperations = new ArrayList<Today>(20);
    
    /* number of login tries */
    static int numoflogin=0;





    public static void main(String []args)
    {
        /* manger data */
        Employee bob = new Employee();
        bob.setId("bob");
        bob.setName("Bob");
        bob.setJob("Manger");
        bob.setSalary("9999999");
        bob.setPassword("000");
        AllEmployees.add(bob);
        

        WELCOME();
        LOGIN();
    }



    public static void ADD_OPERATION()
    {
        boolean flag;
        flag =true;
        PrintAddOperationTab();
        

        String o ;
        do
        {
            PrintStr("\nRent Or Retrive : ");      
            o = input.next();
        } 
        while( (! (o.equalsIgnoreCase("rent"))) && (!(o.equalsIgnoreCase("retrive")))  );
        if(o.equalsIgnoreCase("retrive"))
        {
            o="Retrive";
        }
        else if (o.equalsIgnoreCase("rent"))
        {
            o="Rent";
        }
       

        String b;
        do
        {
            PrintStr("\nBook Title : ");
            b = input.next();

            //check if book existed
            for(int i=0;i<AllBooks.size();i++)
            {
                if(b.equals(AllBooks.get(i).getTitle()))
                {
                    flag = false;
                    break;
                }
            
            }
            if(flag==true)
            {
                if(AllBooks.isEmpty())
                {
                    ClearScreen();
                    for(int k=0;k<55;k++)
                    {
                        PrintStr("-");
                        Wait(WAITFACTOR);
                    }
                    System.out.println(                                                         );                       
                    System.out.println("------------------  No Books Here !  ------------------");
                    for(int k=0;k<55;k++)
                    {
                        PrintStr("-");
                        Wait(WAITFACTOR);
                    }
                    System.out.println(                                                         );
                    PrintStr("\nAdd Or Back ? (A/B) : ");
                    String ab = input.next();
                    if(ab.equals("A") || ab.equals("a"))
                    {
                        ClearScreen();
                        ADD_BOOK();
                    }
                    else 
                    {
                        ClearScreen();
                        TODAY();
                    }
                }
                else
                {
                    PrintStr("NOT EXISTED! Try Again ..\n");
                }
                

            }
            
        }
        while(flag == true);
        flag =true;       
       

        
        String c ;
        do
        {
            PrintStr("\nClient Name : ");
            c = input.next();

            //check if clint existed
            for(int i=0;i<AllClients.size();i++)
            {
                if(c.equals(AllClients.get(i).getName()))
                {
                    flag = false;
                    break;
                }
            
            }
            if(flag==true)
            {
                if(AllClients.isEmpty())
                {
                    ClearScreen();
                    for(int k=0;k<55;k++)
                    {
                        PrintStr("-");
                        Wait(WAITFACTOR);
                    }
                    System.out.println(                                                         );                       
                    System.out.println("-----------------  No Clients Here !  -----------------");
                    for(int k=0;k<55;k++)
                    {
                        PrintStr("-");
                        Wait(WAITFACTOR);
                    }
                    System.out.println(                                                         );
                    PrintStr("\nAdd Or Back ? (A/B) : ");
                    String ab = input.next();
                    if(ab.equals("A") || ab.equals("a"))
                    {
                        ClearScreen();
                        ADD_CLIENT();
                    }
                    else 
                    {
                        ClearScreen();
                        TODAY();
                    }
                }
                else
                {
                    PrintStr("NOT EXISTED! Try Again ..\n");
                }
                

            }
            
        }
        while(flag == true);
        flag =true;       
       



        String e ;
        do
        {
            PrintStr("\nEmployee Name : ");
            e = input.next();

            //check if Employee existed
            for(int i=0;i<AllEmployees.size();i++)
            {
                if(e.equals(AllEmployees.get(i).getName()))
                {
                    flag = false;
                    break;
                }
            
            }
            if(flag==true)
            {
                if(AllEmployees.isEmpty())
                {
                    ClearScreen();
                    for(int k=0;k<55;k++)
                    {
                        PrintStr("-");
                        Wait(WAITFACTOR);
                    }
                    System.out.println(                                                         );                       
                    System.out.println("----------------  No Employees Here !  ----------------");
                    for(int k=0;k<55;k++)
                    {
                        PrintStr("-");
                        Wait(WAITFACTOR);
                    }
                    System.out.println(                                                         );
                    PrintStr("\nAdd Or Back ? (A/B) : ");
                    String ab = input.next();
                    if(ab.equals("A") || ab.equals("a"))
                    {
                        ClearScreen();
                        ADD_EMPLOYEE();
                    }
                    else 
                    {
                        ClearScreen();
                        TODAY();
                    }
                }
                else
                {
                    PrintStr("NOT EXISTED! Try Again ..\n");
                }
                

            }
            
        }
        while(flag == true);
        flag =true;       

        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String timenow;
        timenow = time.format(formatter);

        Today newtoday = new Today();
        newtoday.book= b;
        newtoday.client = c;
        newtoday.employee =e;
        newtoday.operation = o;
        newtoday.time = timenow;

        AllOperations.add(newtoday);

        ClearScreen();
        PrintSucess();
        Wait(1000);
        ClearScreen();
        PrintStr("\nAdd Again Or Back ? (A/B) : ");
        String ab = input.next();
        if(ab.equals("A") || ab.equals("a"))
        {
            ClearScreen();
            ADD_OPERATION();
        }
        else 
        {
            ClearScreen();
            TODAY();
        }


    }
    public static void DISPLAY_OPERATION()
    {
        if(AllOperations.isEmpty())
        {
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );                       
            System.out.println("-----------------  No Operation Yet !  ----------------");
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );
            PrintStr("\nAdd Or Back ? (A/B) : ");
            String ab = input.next();
            if(ab.equals("A") || ab.equals("a"))
            {
                ClearScreen();
                ADD_OPERATION();
            }
            else 
            {
                ClearScreen();
                TODAY();
            }
        }

        PrintDisplayOperationsTab();

        String bo ;
        String cl ;
        String em ;
        String op ;
        int len;

        for(int i=0;i<AllOperations.size();i++)

        {
            bo = AllOperations.get(i).book;
            cl = AllOperations.get(i).client;
            em = AllOperations.get(i).employee;
            op = AllOperations.get(i).operation;

            if(op.length()==4)
            {
                op=op.concat("    ");
            }
            else if(op.length()==7)
            {
                op = op.concat(" ");
            }

            if(bo.length()>=10)
            {
                bo = bo.substring(0,10);
            }
            else
            {
                len = bo.length();
                for(int g=0;g<(10-len);g++)
                {
                    bo = bo.concat(" ");
                }
            }

            if(cl.length()>=12)
            {
                cl = cl.substring(0, 12);
            }
            else
            {
                len = cl.length();
                for(int g=0;g<(12-len);g++)
                {
                    cl = cl.concat(" ");
                }
            }

            if(em.length()>=12)
            {
                em = em.substring(0, 12);
            }
            else
            {
                len = em.length();
                for(int g=0;g<(12-len);g++)
                {
                    em = em.concat(" ");
                }
            }

            //System.out.println("I |  Oper  |   Book   |   Client   |  Employee  |  Time");
            PrintStr((i+1)+" |");
            PrintStr(op+"|");
            PrintStr(bo+"|");
            PrintStr(cl+"|");
            PrintStr(em+"|");
            PrintStr(AllOperations.get(i).time +"\n");
            
        }
        System.out.println(                                                         );
        for(int k=0;k<55;k++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );

        PrintStr("\nAdd Or Back ? (A/B) : ");
        String ab = input.next();
        if(ab.equals("A") || ab.equals("a"))
        {
            ClearScreen();
            ADD_OPERATION();
        }
        else 
        {
            ClearScreen();
            TODAY();
        }        
        

        
        

        
    }
    public static void TODAY()
    {
        PrintTodayOperationsTab();
        String ch = input.next();
        ClearScreen();
        switch (ch)
        {
            case "1":
                ADD_OPERATION();
                break;
            case "2":
                DISPLAY_OPERATION();
                break;
            case "3":
                HOME();
                break;
        
            default:
                PrintError();
                Wait(1000);
                ClearScreen();
                TODAY();
                break;
        }
    }



    public static void SEARCH_BOOK()
    {
        /* true if book not exsisted */
        boolean flag;
        flag = true;

        if(AllBooks.isEmpty())
        {
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );                       
            System.out.println("------------------  No Book Here !  -------------------");
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );
            PrintStr("\nAdd Or Back ? (A/B) : ");
            String ab = input.next();
            if(ab.equals("A") || ab.equals("a"))
            {
                ClearScreen();
                ADD_BOOK();
            }
            else 
            {
                ClearScreen();
                BOOKS();
            }
        }


        PrintSearchBookTab();
        PrintStr("                 1) Search By Book Title\n                 2) Search By Book Code\n\n");

        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );

        PrintEnterChoiceNumber();       
        int ch = input.nextInt();
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );

        

        switch(ch)
        {
            case 1:
                PrintStr("Book Title : ");
                String s = input.next();
                for(int i=0;i<AllBooks.size();i++)
                {
                    if(s.equals(AllBooks.get(i).getTitle()))
                    {
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         ); 

                        AllBooks.get(i).PrintAllBookData();

                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         ); 
                        flag = false;                   
                    }
    
                }
                if(flag == true)
                {
                    PrintStr("NOT EXISTED !\n");
                }

                PrintStr("\nSearch Again Or Back ? (S/B) : ");
                String as = input.next();
                if(as.equals("S") || as.equals("s"))
                {
                    ClearScreen();
                    SEARCH_BOOK();
                }
                else 
                {
                    ClearScreen();
                    BOOKS();
                }                       
                break;
            case 2:
                flag = true;
                PrintStr("Book Code  : ");
                String c = input.next();
                for(int i=0;i<AllBooks.size();i++)
                {
                    if(c.equals( AllBooks.get(i).getCode()))
                    {
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         );                       
                        AllBooks.get(i).PrintAllBookData();
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         );                      
                        flag = false;
                    }
                    
                }
                if(flag == true)
                {
                    PrintStr("NOT EXISTED !\n");
                }

                PrintStr("\nSearch Again Or Back ? (S/B) : ");
                String an = input.next();
                if(an.equals("S") || an.equals("s"))
                {
                    ClearScreen();
                    SEARCH_BOOK();
                }
                else 
                {
                    ClearScreen();
                    BOOKS();
                }                     
                
                break;

            default:
                ClearScreen();
                PrintError();
                Wait(1000);
                ClearScreen();
                SEARCH_BOOK();
                break;
        } 
        

    }



    public static void ADD_BOOK()
    {
        
        PrintAddBookTab();

        String t;
        PrintStr("\nBook Title    : ");
        t = input.next();

        String c;       
        PrintStr("\nBook Code     : ");
        c = input.next();

        String p;
        PrintStr("\nBook Price    : ");
        p = input.next();
        

        String cat;
        PrintStr("\nBook Category : ");
        cat = input.next();
        
        
          
     
        String auth;
        
        PrintStr("\nBook Author   : ");
        auth = input.next();
        

        String r;
        do
        {
            PrintStr("\nBook Rate 0~5 : ");
            r = input.next();
        }
        while(!( r.equals("0") || r.equals("1") ||r.equals("2") ||r.equals("3") ||r.equals("4") ||r.equals("5") ));           
        

        Book newbook = new Book();
        newbook.setTitle(t);
        newbook.setCode(c);
        newbook.setPrice(p);
        newbook.setCategory(cat);
        newbook.setAuthor(auth);
        newbook.setRate(r+ " Stars");

        AllBooks.add(newbook);
        ClearScreen();
        PrintSucess();
        Wait(1000);
        ClearScreen();
        PrintStr("\nAdd Again Or Back ? (A/B) : ");
        String ab = input.next();
        if(ab.equals("A") || ab.equals("a"))
        {
            ClearScreen();
            ADD_BOOK();
        }
        else 
        {
            ClearScreen();
            BOOKS();
        }

    }




    public static void EDIT_BOOK()
    {
        if(AllBooks.isEmpty())
        {
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );                       
            System.out.println("------------------  No Book Here !  -------------------");
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );
            PrintStr("\nAdd Or Back ? (A/B) : ");
            String ab = input.next();
            if(ab.equals("A") || ab.equals("a"))
            {
                ClearScreen();
                ADD_BOOK();
            }
            else 
            {
                ClearScreen();
                BOOKS();
            }
        }


        PrintEditBookTab();
        PrintStr("                 1) Search  To Edit By Book Title\n                 2) Search To Edit By Book Code\n\n");

        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );

        PrintEnterChoiceNumber();       
        String ch = input.next();
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );

        switch(ch)
        {
            case "1":
                PrintStr("Book Title : ");
                String s = input.next();
                for(int i=0;i<AllBooks.size();i++)
                {
                    if(s.equals(AllBooks.get(i).getTitle()))
                    {
                        ClearScreen();
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         ); 

                        AllBooks.get(i).PrintAllBookData();

                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         );


                        String t;
                        PrintStr("\nNeW Book Title    : ");
                        t = input.next();
                
                        String c;       
                        PrintStr("\nNew Book Code     : ");
                        c = input.next();
                
                        String p;
                        PrintStr("\nNew Book Price    : ");
                        p = input.next();
                        
                
                        String cat;
                        
                        PrintStr("\nNew Book Category : ");
                        cat = input.next();
                        
                        
                          
                     
                        String auth;
                        
                        PrintStr("\nNew Book Author   : ");
                        auth = input.next();
                        
                
                        String r;
                        do
                        {
                            PrintStr("\nNew Book Rate 0~5 : ");
                            r = input.next();
                        }
                        while( !(r.equals("0")||r.equals("1")||r.equals("2")||r.equals("3")||r.equals("4")||r.equals("5")));           
                        
                
                        Book newbook = new Book();
                        newbook.setTitle(t);
                        newbook.setCode(c);
                        newbook.setPrice(p);
                        newbook.setCategory(cat);
                        newbook.setAuthor(auth);
                        newbook.setRate(r+" Stars");
                
                        AllBooks.set(i,newbook);
                        ClearScreen();
                        PrintSucess();
                        Wait(1000);
                        ClearScreen();
                        PrintStr("\nEdit Again Or Back ? (E/B) : ");
                        String ab = input.next();
                        if(ab.equals("E") || ab.equals("e"))
                        {
                            ClearScreen();
                            EDIT_BOOK();
                        }
                        else 
                        {
                            ClearScreen();
                            BOOKS();
                        }


                    }
                    
                }
                
                
                PrintStr("NOT EXISTED !\n");
                Wait(1000);
                ClearScreen();
                EDIT_BOOK();
                break;


            case "2":
                PrintStr("Book Code  : ");
                String c = input.next();
                for(int i=0;i<AllBooks.size();i++)
                {
                    if(c.equals(AllBooks.get(i).getCode()) )
                    {
                        ClearScreen();
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         );                       
                        AllBooks.get(i).PrintAllBookData();
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         );  
                        String t;
                        PrintStr("\nNeW Book Title    : ");
                        t = input.next();
                
                        String co;       
                        PrintStr("\nNew Book Code     : ");
                        co = input.next();
                
                        String p;
                        PrintStr("\nNew Book Price    : ");
                        p = input.next();
                        
                
                        String cat;
                        PrintStr("\nNew Book Category : ");
                        cat = input.next();
            
                          
                     
                        String auth;
                        PrintStr("\nNew Book Author   : ");
                        auth = input.next();
                        
                
                        String r;
                        do
                        {
                            PrintStr("\nNew Book Rate 0~5 : ");
                            r = input.next();
                        }
                        while( !(r.equals("0")||r.equals("1")||r.equals("2")||r.equals("3")||r.equals("4")||r.equals("5")));           
                        
                
                        Book newbook = new Book();
                        newbook.setTitle(t);
                        newbook.setCode(co);
                        newbook.setPrice(p);
                        newbook.setCategory(cat);
                        newbook.setAuthor(auth);
                        newbook.setRate(r+" Stars");
                
                        AllBooks.set(i,newbook);
                        ClearScreen();
                        PrintSucess();
                        Wait(1000);
                        ClearScreen();
                        PrintStr("\nEdit Again Or Back ? (E/B) : ");
                        String ab = input.next();
                        if(ab.equals("E") || ab.equals("e"))
                        {
                            ClearScreen();
                            EDIT_BOOK();
                        }
                        else 
                        {
                            ClearScreen();
                            BOOKS();
                        }                        


                    }
           
                }

                PrintStr("NOT EXISTED !\n");
                Wait(1000);
                ClearScreen();
                EDIT_BOOK();
                break;


            default:
                ClearScreen();
                PrintError();
                Wait(1000);
                ClearScreen();
                EDIT_BOOK();
                break;
        } 
        


    }
    public static void REMOVE_BOOK()
    {
        if(AllBooks.isEmpty())
        {
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );                       
            System.out.println("------------------  No Book Here !  -------------------");
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );
            PrintStr("\nAdd Or Back ? (A/B) : ");
            String ab = input.next();
            if(ab.equals("A") || ab.equals("a"))
            {
                ClearScreen();
                ADD_BOOK();
            }
            else 
            {
                ClearScreen();
                BOOKS();
            }
        }


        PrintRemoveBookTab();
        PrintStr("                 1) Search To Remove By Book Title\n                 2) Search To Remove By Book Code\n\n");

        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );

        PrintEnterChoiceNumber();       
        String ch = input.next();
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        boolean flag ;
        flag = false;
        switch(ch)
        {
            case "1":
                PrintStr("Book Title : ");
                String s = input.next();
                for(int i=0;i<AllBooks.size();i++)
                {
                    if(s.equals(AllBooks.get(i).getTitle()))
                    {
                        AllBooks.remove(i);
                        ClearScreen();
                        PrintSucess();
                        Wait(1000);
                        ClearScreen();
                        PrintStr("\nRemove Again Or Back ? (R/B) : ");
                        String ab = input.next();
                        if(ab.equals("R") || ab.equals("r"))
                        {
                            ClearScreen();
                            REMOVE_BOOK();
                        }
                        else 
                        {
                            ClearScreen();
                            BOOKS();
                        }
                        flag = false;

                    }
                     
                }
                if(flag == true)
                {
                    PrintStr("NOT EXISTED !\n");
                    Wait(1000);
                    ClearScreen();
                    REMOVE_BOOK();
                }                

                break;

            case "2":
                flag = true;
                PrintStr("Book Code  : ");
                String c = input.next();
                for(int i=0;i<AllBooks.size();i++)
                {
                    if(c.equals(AllBooks.get(i).getCode()) )
                    {
                        AllBooks.remove(i);
                        ClearScreen();
                        PrintSucess();
                        Wait(1000);
                        ClearScreen();
                        PrintStr("\nRemove Again Or Back ? (R/B) : ");
                        String ab = input.next();
                        if(ab.equals("R") || ab.equals("r"))
                        {
                            ClearScreen();
                            REMOVE_BOOK();
                        }
                        else 
                        {
                            ClearScreen();
                            BOOKS();
                        }                       

                        flag = false;
                    }
                    
                }
                if(flag == true)
                {
                    PrintStr("NOT EXISTED !\n");
                    Wait(1000);
                    ClearScreen();
                    REMOVE_BOOK();
                }
                       
                break;
            default:
                ClearScreen();
                PrintError();
                Wait(1000);
                ClearScreen();
                REMOVE_BOOK();
                break;
        } 
        

    }
    public static void BOOKS()
    {
        PrintBookTab();
        String ch = input.next();
        ClearScreen();
        switch (ch) {
            case "1":
                SEARCH_BOOK();
                break;
            case "2":
                ADD_BOOK();
                break;
            case "3":
                EDIT_BOOK();
                break;
            case "4":
                REMOVE_BOOK();
                break;
            case "5":
                HOME();
                break;
            default:
                PrintError();
                Wait(1000);
                ClearScreen();
                BOOKS();
                break;
        }
    }







    public static void SEARCH_CLIENT()
    {
        boolean flag;
        flag = true;
        
        if(AllClients.isEmpty())
        {
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );                       
            System.out.println("-----------------  No Clients Here !  -----------------");
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );
            PrintStr("\nAdd Or Back ? (A/B) : ");
            String ab = input.next();
            if(ab.equals("A") || ab.equals("a"))
            {
                ClearScreen();
                ADD_CLIENT();
            }
            else 
            {
                ClearScreen();
                CLIENTS();
            }
        }


        PrintSearchClientTab();
        PrintStr("                 1) Search By Client Name\n                 2) Search By Client Code\n\n");

        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );

        PrintEnterChoiceNumber();       
        String ch = input.next();
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );

        switch(ch)
        {
            case "1":
                PrintStr("Client Name : ");
                String s = input.next();
                for(int i=0;i<AllClients.size();i++)
                {
                    if(s.equals(AllClients.get(i).getName()))
                    {
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         ); 

                        AllClients.get(i).PrintAllClientData();

                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         );                      
                        flag=false;
                    }
                    
                }
                if(flag==true)
                {
                    PrintStr("NOT EXISTED !\n");
                } 

                PrintStr("\nSearch Again Or Back ? (S/B) : ");
                String as = input.next();
                if(as.equals("S") || as.equals("s"))
                {
                    ClearScreen();
                    SEARCH_CLIENT();
                }
                else 
                {
                    ClearScreen();
                    CLIENTS();
                }                       
                break;
            case "2":
                flag = true;
                PrintStr("Client Code  : ");
                String c = input.next();
                for(int i=0;i<AllClients.size();i++)
                {
                    if(c.equals(AllClients.get(i).getCode()) )
                    {
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         );                       
                        AllClients.get(i).PrintAllClientData();
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         );                      
                        flag = false;
                    }
                }
                if(flag == true)
                {
                    PrintStr("NOT EXISTED !\n");
                }

                PrintStr("\nSearch Again Or Back ? (S/B) : ");
                String an = input.next();
                if(an.equals("S") || an.equals("s"))
                {
                    ClearScreen();
                    SEARCH_CLIENT();
                }
                else 
                {
                    ClearScreen();
                    CLIENTS();
                }                     
            
                break;
            default:
                ClearScreen();
                PrintError();
                Wait(1000);
                ClearScreen();
                SEARCH_CLIENT();
                break;
        } 
        

    }
    public static void ADD_CLIENT()
    {
        PrintAddClientTab();

        String n;
        PrintStr("\nClient Name    : ");
        n = input.next();

        String c;       
        PrintStr("\nClient Code       : ");
        c = input.next();

        String a;
        PrintStr("\nClient Age        : ");
        a = input.next();
        

        String gen;
        do
        {
            PrintStr("\nMale Or Female");
            PrintStr("\nClient Gender : ");
            gen = input.next();
        }
        while(!(gen.equalsIgnoreCase("male")||gen.equalsIgnoreCase("female")) );

        if(gen.equalsIgnoreCase("male"))
        {
            gen="Male";
        }
        else
        {
            gen="Female";
        }
          
        String em;
        PrintStr("\nClient Email      : ");
        em =input.next();
           
        String ph;
        PrintStr("\nClient Phone      : ");
        ph =input.next();
        

        Client newclient = new Client();
        newclient.setName(n);
        newclient.setAge(a);
        newclient.setCode(c);
        newclient.setGender(gen);
        newclient.setPhoneNumber(ph);
        newclient.setemail(em);


        AllClients.add(newclient);
        ClearScreen();
        PrintSucess();
        Wait(1000);
        ClearScreen();
        PrintStr("\nAdd Again Or Back ? (A/B) : ");
        String ab = input.next();
        if(ab.equals("A") || ab.equals("a"))
        {
            ClearScreen();
            ADD_CLIENT();
        }
        else 
        {
            ClearScreen();
            CLIENTS();
        }

    }
    public static void EDIT_CLIENT()
    {
        if(AllClients.isEmpty())
        {
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );                       
            System.out.println("-----------------  No Clients Here !  -----------------");
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );
            PrintStr("\nAdd Or Back ? (A/B) : ");
            String ab = input.next();
            if(ab.equals("A") || ab.equals("a"))
            {
                ClearScreen();
                ADD_CLIENT();
            }
            else 
            {
                ClearScreen();
                CLIENTS();
            }
        }


        PrintEditClientTab();
        PrintStr("                 1) Search To Edit By Client Name\n                 2) Search To Edit By Client Code\n\n");

        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );

        PrintEnterChoiceNumber();       
        String ch = input.next();
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );

        switch(ch)
        {
            case "1":
                PrintStr("Client Name : ");
                String s = input.next();
                for(int i=0;i<AllClients.size();i++)
                {
                    if(s.equals(AllClients.get(i).getName()))
                    {
                        ClearScreen();
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         ); 

                        AllClients.get(i).PrintAllClientData();

                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         );

                        String n;
                        PrintStr("\nNew Client Name    : ");
                        n = input.next();
                
                        String c;       
                        PrintStr("\nNew Client Code       : ");
                        c = input.next();
                
                        String a;
                        PrintStr("\nNew Client Age        : ");
                        a = input.next();
                        
                
                        String gen;
                        do
                        {
                            PrintStr("\nMale Or Female ? ");
                            PrintStr("\nNew Client Gender : ");
                            gen = input.next();
                        }
                        while(!(gen.equalsIgnoreCase("male")||gen.equalsIgnoreCase("female")) );
                
                        if(gen.equalsIgnoreCase("male"))
                        {
                            gen="Male";
                        }
                        else
                        {
                            gen="Female";
                        }
                          
                        String em;
                        PrintStr("\nNew Client Email      : ");
                        em =input.next();
                           
                        String ph;
                        PrintStr("\nNew Client Phone      : ");
                        ph =input.next();
                        
                
                        Client newclient = new Client();
                        newclient.setName(n);
                        newclient.setAge(a);
                        newclient.setCode(c);
                        newclient.setGender(gen);
                        newclient.setPhoneNumber(ph);
                        newclient.setemail(em);

                        AllClients.set(i, newclient);
                        ClearScreen();
                        PrintSucess();
                        Wait(1000);
                        ClearScreen();
                        PrintStr("\nEdit Again Or Back ? (E/B) : ");
                        String ab = input.next();
                        if(ab.equals("E") || ab.equals("e"))
                        {
                            ClearScreen();
                            EDIT_CLIENT();
                        }
                        else 
                        {
                            ClearScreen();
                            CLIENTS();
                        }      

                    }
                }
                
                PrintStr("NOT EXISTED !\n");
                Wait(1000);
                ClearScreen();
                EDIT_CLIENT();                
                break;


            case "2":
                PrintStr("Client Code  : ");
                String c = input.next();
                for(int i=0;i<AllClients.size();i++)
                {
                    if(c.equals(AllClients.get(i).getCode()) )
                    {
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         );                       
                        AllClients.get(i).PrintAllClientData();
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         );
                        String n;
                        PrintStr("\nNew Client Name       : ");
                        n = input.next();
                
                        String co;       
                        PrintStr("\nNew Client Code       : ");
                        co = input.next();
                
                        String a;
                        PrintStr("\nNew Client Age        : ");
                        a = input.next();
                        
                
                        String gen;
                        do
                        {
                            PrintStr("\nMale Or Female ?");
                            PrintStr("\nNew Client Gender : ");
                            gen = input.next();
                        }
                        while(!(gen.equalsIgnoreCase("male")||gen.equalsIgnoreCase("female")) );
                
                        if(gen.equalsIgnoreCase("male"))
                        {
                            gen="Male";
                        }
                        else
                        {
                            gen="Female";
                        }
                          
                        String em;
                        PrintStr("\nNew Client Email      : ");
                        em =input.next();
                           
                        String ph;
                        PrintStr("\nNew Client Phone      : ");
                        ph =input.next();
                        
                
                        Client newclient = new Client();
                        newclient.setName(n);
                        newclient.setAge(a);
                        newclient.setCode(co);
                        newclient.setGender(gen);
                        newclient.setPhoneNumber(ph);
                        newclient.setemail(em);

                        AllClients.set(i, newclient);
                        ClearScreen();
                        PrintSucess();
                        Wait(1000);
                        ClearScreen();
                        PrintStr("\nEdit Again Or Back ? (E/B) : ");
                        String ab = input.next();
                        if(ab.equals("E") || ab.equals("e"))
                        {
                            ClearScreen();
                            EDIT_CLIENT();
                        }
                        else 
                        {
                            ClearScreen();
                            CLIENTS();
                        }                                              
                    }
                
                    
                }

                PrintStr("NOT EXISTED !\n");
                Wait(1000);
                ClearScreen();
                EDIT_CLIENT();               
                break;


            default:
                ClearScreen();
                PrintError();
                Wait(1000);
                ClearScreen();
                EDIT_CLIENT();
                break;
        }
    }
    public static void REMOVE_CLIENT()
    {
        if(AllClients.isEmpty())
        {
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );                       
            System.out.println("-----------------  No Clients Here !  -----------------");
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );
            PrintStr("\nAdd Or Back ? (A/B) : ");
            String ab = input.next();
            if(ab.equals("A") || ab.equals("a"))
            {
                ClearScreen();
                ADD_CLIENT();
            }
            else 
            {
                ClearScreen();
                CLIENTS();
            }
        }


        PrintRemoveClientTab();
        PrintStr("                 1) Search To Remove By Client Name\n                 2) Search To Remove By Client Code\n\n");

        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );

        PrintEnterChoiceNumber();       
        String ch = input.next();
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        boolean flag ;
        flag = true;
        switch(ch)
        {
            case "1":
                PrintStr("Client Name : ");
                String s = input.next();
                for(int i=0;i<AllClients.size();i++)
                {
                    if(s.equals(AllClients.get(i).getName()))
                    {
                        AllClients.remove(i);
                        ClearScreen();
                        PrintSucess();
                        Wait(1000);
                        ClearScreen();
                        PrintStr("\nRemove Again Or Back ? (R/B) : ");
                        String ab = input.next();
                        if(ab.equals("R") || ab.equals("r"))
                        {
                            ClearScreen();
                            REMOVE_CLIENT();
                        }
                        else 
                        {
                            ClearScreen();
                            CLIENTS();
                        }      
                        flag = false;
                    }
                    
                } 
                if(flag == true)
                {
                    PrintStr("NOT EXISTED !\n");
                    Wait(1000);
                    ClearScreen();
                    REMOVE_CLIENT();
                }                                     
                break;


            case "2":
                flag = true;
                PrintStr("Client Code  : ");
                String c = input.next();
                for(int i=0;i<AllClients.size();i++)
                {
                    if(c.equals( AllClients.get(i).getCode()))
                    {
                        AllClients.remove(i);
                        ClearScreen();
                        PrintSucess();
                        Wait(1000);
                        ClearScreen();
                        PrintStr("\nRemove Again Or Back ? (R/B) : ");
                        String ab = input.next();
                        if(ab.equals("R") || ab.equals("r"))
                        {
                            ClearScreen();
                            REMOVE_CLIENT();
                        }
                        else 
                        {
                            ClearScreen();
                            CLIENTS();
                        }      
                        flag=false;
                    }
                    
                    
                    
                }
                if(flag==true)
                {
                    PrintStr("NOT EXISTED !\n");
                    Wait(1000);
                    ClearScreen();
                    REMOVE_CLIENT();
                }              
                break;
            default:
                ClearScreen();
                PrintError();
                Wait(1000);
                ClearScreen();
                EDIT_CLIENT();
                break;
        }
    }
    public static void CLIENTS()
    {
        PrintClientTab();
        String ch = input.next();
        ClearScreen();
        switch (ch) {
            case "1":
                SEARCH_CLIENT();
                break;
            case "2":
                ADD_CLIENT();
                break;
            case "3":
                EDIT_CLIENT();
                break;
            case "4":
                REMOVE_CLIENT();
                break;
            case "5":
                HOME();
                break;
            default:
                PrintError();
                Wait(1000);
                ClearScreen();
                CLIENTS();
                break;
        }
    }





     public static void SEARCH_EMPLOYEE()
    {
        boolean flag;
        flag = true;
        
        if(AllEmployees.isEmpty())
        {
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );                       
            System.out.println("----------------  No Employees Here !  ----------------");
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );
            PrintStr("\nAdd Or Back ? (A/B) : ");
            String ab = input.next();
            if(ab.equals("A") || ab.equals("a"))
            {
                ClearScreen();
                ADD_EMPLOYEE();
            }
            else 
            {
                ClearScreen();
                EMPLOYEES();
            }
        }


        PrintSearchClientTab();
        PrintStr("                 1) Search By Employee Name\n                 2) Search By Employee ID\n\n");

        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );

        PrintEnterChoiceNumber();       
        String ch = input.next();
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );

        switch(ch)
        {
            case "1":
                PrintStr("Employee Name : ");
                String s = input.next();
                for(int i=0;i<AllEmployees.size();i++)
                {
                    if(s.equals(AllEmployees.get(i).getName()))
                    {
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         ); 

                        AllEmployees.get(i).PrintAllEmployeesData();

                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         );                      
                        flag=false;
                    }
                    
                }
                if(flag==true)
                {
                    PrintStr("NOT EXISTED !\n");
                } 

                PrintStr("\nSearch Again Or Back ? (S/B) : ");
                String as = input.next();
                if(as.equals("S") || as.equals("s"))
                {
                    ClearScreen();
                    SEARCH_EMPLOYEE();
                }
                else 
                {
                    ClearScreen();
                    EMPLOYEES();
                }                       
                break;
            case "2":
                flag = true;
                PrintStr("Employee ID  : ");
                String id = input.next();
                for(int i=0;i<AllEmployees.size();i++)
                {
                    if(id.equals(AllEmployees.get(i).getId()) )
                    {
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         );                       
                        AllEmployees.get(i).PrintAllEmployeesData();
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         );                      
                        flag = false;
                    }
                }
                if(flag == true)
                {
                    PrintStr("NOT EXISTED !\n");
                }

                PrintStr("\nSearch Again Or Back ? (S/B) : ");
                String an = input.next();
                if(an.equals("S") || an.equals("s"))
                {
                    ClearScreen();
                    SEARCH_EMPLOYEE();
                }
                else 
                {
                    ClearScreen();
                    EMPLOYEES();
                }                     
            
                break;
            default:
                ClearScreen();
                PrintError();
                Wait(1000);
                ClearScreen();
                SEARCH_EMPLOYEE();
                break;
        } 
    }
    public static void ADD_EMPLOYEE()
    {
        PrintAddEmployeeTab();

        String n;
        PrintStr("\nEmployee Name      : ");
        n = input.next();

        String id;       
        PrintStr("\nEmployee id        : ");
        id = input.next();
        
          
        String j;
        PrintStr("\nEmployee Job       : ");
        j =input.next();

        String s;
        PrintStr("\nEmployee Salary    : ");
        s = input.next();
           
        String pass;
        PrintStr("\nEmployee Password  : ");
        pass =input.next();

        Employee newemployee = new Employee();
        newemployee.setId(id);
        newemployee.setJob(j);
        newemployee.setName(n);
        newemployee.setSalary(s);
        newemployee.setPassword(pass);


        AllEmployees.add(newemployee);
        ClearScreen();
        PrintSucess();
        Wait(1000);
        ClearScreen();
        PrintStr("\nAdd Again Or Back ? (A/B) : ");
        String ab = input.next();
        if(ab.equals("A") || ab.equals("a"))
        {
            ClearScreen();
            ADD_EMPLOYEE();
        }
        else 
        {
            ClearScreen();
            EMPLOYEES();
        }
    }
    public static void EDIT_EMPLOYEE()
    {
        if(AllEmployees.isEmpty())
        {
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );                       
            System.out.println("----------------  No Employees Here !  ----------------");
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );
            PrintStr("\nAdd Or Back ? (A/B) : ");
            String ab = input.next();
            if(ab.equals("A") || ab.equals("a"))
            {
                ClearScreen();
                ADD_EMPLOYEE();
            }
            else 
            {
                ClearScreen();
                EMPLOYEES();
            }
        }


        PrintEditEmployeeTab();
        PrintStr("            1) Search To Edit By Employee Name\n            2) Search To Edit By Employee ID\n\n");

        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );

        PrintEnterChoiceNumber();       
        String ch = input.next();
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );

        switch(ch)
        {
            case "1":
                PrintStr("Employee Name : ");
                String s = input.next();
                for(int i=0;i<AllEmployees.size();i++)
                {
                    if(s.equals(AllEmployees.get(i).getName()))
                    {
                        ClearScreen();
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         ); 

                        AllEmployees.get(i).PrintAllEmployeesData();

                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         );

                        String n;
                        PrintStr("\nNew Employee Name      : ");
                        n = input.next();
                
                        String id;       
                        PrintStr("\nNew Employee id        : ");
                        id = input.next();
                        
                          
                        String j;
                        PrintStr("\nNew Employee Job       : ");
                        j =input.next();
                
                        String sa;
                        PrintStr("\nNew Employee Salary    : ");
                        sa = input.next();
                           
                        String pass;
                        PrintStr("\nNew Employee Password  : ");
                        pass =input.next();
                
                        Employee newemployee = new Employee();
                        newemployee.setId(id);
                        newemployee.setJob(j);
                        newemployee.setName(n);
                        newemployee.setSalary(sa);
                        newemployee.setPassword(pass);
                        
                        
                        AllEmployees.set(i, newemployee);
                        ClearScreen();
                        PrintSucess();
                        Wait(1000);
                        ClearScreen();
                        PrintStr("\nEdit Again Or Back ? (E/B) : ");
                        String ab = input.next();
                        if(ab.equals("E") || ab.equals("e"))
                        {
                            ClearScreen();
                            EDIT_EMPLOYEE();
                        }
                        else 
                        {
                            ClearScreen();
                            EMPLOYEES();
                        }      

                    }
                } 
                PrintStr("NOT EXISTED !\n");
                Wait(1000);
                ClearScreen();
                EDIT_EMPLOYEE();                               
                break;


            case "2":
                PrintStr("Employee ID : ");
                String c = input.next();
                for(int i=0;i<AllEmployees.size();i++)
                {
                    if(c.equals(AllEmployees.get(i).getId()) )
                    {
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         );                       
                        AllEmployees.get(i).PrintAllEmployeesData();
                        for(int k=0;k<55;k++)
                        {
                            PrintStr("-");
                            Wait(WAITFACTOR);
                        }
                        System.out.println(                                                         );
                        String n;
                        PrintStr("\nNew Employee Name      : ");
                        n = input.next();
                
                        String id;       
                        PrintStr("\nNew Employee id        : ");
                        id = input.next();
                        
                          
                        String j;
                        PrintStr("\nNew Employee Job       : ");
                        j =input.next();
                
                        String sa;
                        PrintStr("\nNew Employee Salary    : ");
                        sa = input.next();
                           
                        String pass;
                        PrintStr("\nNew Employee Password  : ");
                        pass =input.next();
                
                        Employee newemployee = new Employee();
                        newemployee.setId(id);
                        newemployee.setJob(j);
                        newemployee.setName(n);
                        newemployee.setSalary(sa);
                        newemployee.setPassword(pass);
                        
                        
                        AllEmployees.set(i, newemployee);
                        ClearScreen();
                        PrintSucess();
                        Wait(1000);
                        ClearScreen();
                        PrintStr("\nEdit Again Or Back ? (E/B) : ");
                        String ab = input.next();
                        if(ab.equals("E") || ab.equals("e"))
                        {
                            ClearScreen();
                            EDIT_EMPLOYEE();
                        }
                        else 
                        {
                            ClearScreen();
                            EMPLOYEES();
                        }                                                              
                    }
            
                    
                }

                PrintStr("NOT EXISTED !\n");
                Wait(1000);
                ClearScreen();
                EDIT_EMPLOYEE();      
                break;


            default:
                ClearScreen();
                PrintError();
                Wait(1000);
                ClearScreen();
                EDIT_EMPLOYEE();
                break;
        }
    }
    public static void REMOVE_EMPLOYEE()
    {
        if(AllEmployees.isEmpty())
        {
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );                       
            System.out.println("----------------  No Employees Here !  ----------------");
            for(int k=0;k<55;k++)
            {
                PrintStr("-");
                Wait(WAITFACTOR);
            }
            System.out.println(                                                         );
            PrintStr("\nAdd Or Back ? (A/B) : ");
            String ab = input.next();
            if(ab.equals("A") || ab.equals("a"))
            {
                ClearScreen();
                ADD_EMPLOYEE();
            }
            else 
            {
                ClearScreen();
                EMPLOYEES();
            }
        }


        PrintRemoveEmployeeTab();
        PrintStr("                 1) Search To Remove By Employee Name\n                 2) Search To Remove By Employee ID\n\n");

        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );

        PrintEnterChoiceNumber();       
        String ch = input.next();
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        boolean flag;
        flag = true;
        switch(ch)
        {
            case "1":
                PrintStr("Employee Name : ");
                String s = input.next();
                for(int i=0;i<AllEmployees.size();i++)
                {
                    if(s.equals(AllEmployees.get(i).getName()))
                    {
                        AllEmployees.remove(i);
                        ClearScreen();
                        PrintSucess();
                        Wait(1000);
                        ClearScreen();
                        PrintStr("\nRemove Again Or Back ? (R/B) : ");
                        String ab = input.next();
                        if(ab.equals("R") || ab.equals("r"))
                        {
                            ClearScreen();
                            REMOVE_EMPLOYEE();
                        }
                        else 
                        {
                            ClearScreen();
                            EMPLOYEES();
                        }      
                        flag = false;
                    }
                    
                } 
                if(flag==true)
                {
                    PrintStr("NOT EXISTED !\n");
                    Wait(1000);
                    ClearScreen();
                    REMOVE_EMPLOYEE();
                }                                
                break;


            case "2":
                flag = true;
                PrintStr("Employee ID : ");
                String c = input.next();
                for(int i=0;i<AllEmployees.size();i++)
                {
                    if(c.equals( AllEmployees.get(i).getId()))
                    {
                        AllEmployees.remove(i);
                        ClearScreen();
                        PrintSucess();
                        Wait(1000);
                        ClearScreen();
                        PrintStr("\nRemove Again Or Back ? (R/B) : ");
                        String ab = input.next();
                        if(ab.equals("R") || ab.equals("r"))
                        {
                            ClearScreen();
                            REMOVE_EMPLOYEE();
                        }
                        else 
                        {
                            ClearScreen();
                            EMPLOYEES();
                        }
                        flag = false;                                                              
                    }
                   
                    
                }
                if(flag==true)
                {
                    PrintStr("NOT EXISTED !\n");
                    Wait(1000);
                    ClearScreen();
                    REMOVE_EMPLOYEE();
                }        
                break;
            default:
                ClearScreen();
                PrintError();
                Wait(1000);
                ClearScreen();
                REMOVE_EMPLOYEE();
                break;
        }
    }
    public static void EMPLOYEES()
    {
        PrintEmployeeTab();
        String ch = input.next();
        ClearScreen();
        switch (ch) {
            case "1":
                SEARCH_EMPLOYEE();
                break;
            case "2":
                ADD_EMPLOYEE();
                break;
            case "3":
                EDIT_EMPLOYEE();
                break;
            case "4":
                REMOVE_EMPLOYEE();
                break;
            case "5":
                HOME();
                break;
            default:
                PrintError();
                Wait(1000);
                ClearScreen();
                EMPLOYEES();
                break;
        }
    }


    /* main tabs */
    public static void HOME()
    {
        ClearScreen();
        PrintHomeTab();
        String ch = input.next();
        ClearScreen();
        switch (ch) {
            case "1" :
                TODAY();
                break;
            case "2":
                BOOKS();
                break;
            case "3":
                CLIENTS();
                break;
            case "4":
                EMPLOYEES();
                break;
            case "5":
                LOGIN();
                break;
            case "6":
                System.exit(0);
                break; 
        
            default:
                PrintError();
                Wait(1000);
                ClearScreen();
                HOME();
                break;
        }

    }
  
    public static void LOGIN()
    {

        PrintLoginTab();

        PrintStr("Employee ID : ");
        Scanner input = new Scanner(System.in);
        String id = input.next();
        PrintStr("Password    : ");
        String pass = input.next();

        int v = 0;
        boolean flag = true;

        for(int i=0;i<AllEmployees.size();i++)
        {
            if(AllEmployees.get(i).getId().equals(id)  && AllEmployees.get(i).getPassword().equals(pass))
            {
                flag = false;
                v=i;
            }
        }

        if( flag == false )
        {
            numoflogin=0;
            ClearScreen();
            PrintStr("Hello "+AllEmployees.get(v).getName()+" ^_^");
            Wait(1000);
            ClearScreen();
            // PrintSucess();
            // Wait(1000);
            // ClearScreen();
            HOME();
        }
        else
        {
            numoflogin++;
            if(numoflogin>=3)
            {
                ClearScreen();
                PrintStr("You Can't Try More Than 3 Times , Bye !\n");
                Wait(1000);
                System.exit(0);
            }
            ClearScreen();
            PrintFailed();
            Wait(500);
            ClearScreen();
            LOGIN();

        }
    }

    public static void WELCOME()
    {
        ClearScreen();
        for (int r=0, s =0;r<12;r=r+3,s=s+8)
        {
            Newlines(r);
            PrintMyName();
            Wait(s);
            ClearScreen(); 
                      
        }
        Newlines(12);
        PrintMyName();
        Wait(1000);
        ClearScreen();

        for (int r=0,s=0;r<12;r=r+3,s=s+8)
        {
            Newlines(r);
            PrintWelcomeTab();
            Wait(s);
            ClearScreen(); 
                      
        }
        Newlines(12);
        PrintWelcomeTab();
        Wait(1000);
        ClearScreen();


    }






    /* new lines function */
    public static void Newlines(int n)
    {
        for(int i =0;i<n;i++)
        {
            PrintStr("\n");
        }
    }
    /* Wait */
    public static void Wait(int seconds)
    {
        try 
        {
            Thread.sleep(seconds);
        }
        catch (Exception e) {
            PrintStr("Wait Exception");
        }
    }
    /* Clear Screen */
    public static void ClearScreen()
    {
      // System.out.print("\033[H\33[2J");
      // System.out.flush();
      
       try 
       {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();    
       }
       catch (Exception e) 
       {
           System.out.println(e);
       }
    }
    /* Print String */
    public static void PrintStr(String str )
    {
        System.out.print(str);
    }






    /* GUI Tabs */
    public static void PrintHomeTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        Wait(10);
        System.out.println("--------------------------- H -------------------------");
        Wait(10);
        System.out.println("--------------------------- O -------------------------");
        Wait(10);
        System.out.println("--------------------------- M -------------------------");
        Wait(10);
        System.out.println("--------------------------- E -------------------------");
        Wait(10);
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );
        System.out.println("                     1) TODAY OPERATION                ");
        System.out.println("                     2) BOOKS                          ");
        System.out.println("                     3) CLIENTS                        ");
        System.out.println("                     4) EMPLOYEE                       ");
        System.out.println("                     5) LOG OUT                        ");
        System.out.println("                     6) EXIT                           ");
        System.out.println(                                                         ); 
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        PrintEnterChoiceNumber();        
        
    }
    public static void PrintEnterChoiceNumber()
    {
        System.out.print("                  ");
        for(int  i=0;i<enterchoice.length;i++)
        {
            System.out.print(enterchoice[i]);
            Wait(20);
        }        
    }
    public static void PrintError()
    {
        
        for(int i=0;i<55;i++)
        {
            PrintStr("!");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!   ERROR   !!!!!!!!!!!!!!!!!!!!!!");
        for(int i=0;i<55;i++)
        {
            PrintStr("!");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );
        /* tune function to make error alert */
    }
    public static void PrintSucess()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("--------------------   SUCCESS     --------------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );
    }
    public static void PrintFailed()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("---------------------  FAILED !!  ---------------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );
    }
    public static void PrintDone ()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("-----------------------   DONE   ----------------------");

        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );
    }
    public static void PrintWelcomeTab()
    {
        System.out.println("-------------------------------------------------------");
        System.out.println("----------------------   WELCOME   --------------------");
        System.out.println("----------------------     TO      --------------------");
        System.out.println("----------------------     MY      --------------------");
        System.out.println("----------------------   LIBRARY   --------------------");
        System.out.println("-------------------------------------------------------");
       
    }
    public static void PrintMyName()
    {
        System.out.println("-------------------------------------------------------");
        System.out.println("----------------------     BY      --------------------");
        System.out.println("----------------------   MAHMOUD   --------------------");
        System.out.println("----------------------    ABBAS    --------------------");
        System.out.println("----------------------   MAKHLOUF  --------------------");
        System.out.println("-------------------------------------------------------");       
    }
    public static void PrintLoginTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("-----------------------   LOGIN   ---------------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );
            
    }
    public static void PrintBookTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("------------------  CHOOSE WHAT YOU   -----------------");
        System.out.println("------------------   WANNA DO WITH    -----------------");
        System.out.println("------------------       BOOKS        -----------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );
        System.out.println("                     1) SEARCH Book                    ");
        System.out.println("                     2) ADD Book                       ");
        System.out.println("                     3) EDIT Book                      ");
        System.out.println("                     4) REMOVE Book                    ");
        System.out.println("                     5) BACK                           ");
        System.out.println(                                                         ); 
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        PrintEnterChoiceNumber();        
        
    }
    public static void PrintAddBookTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("---------------------  ADD BOOK  ----------------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );  
    }
    public static void PrintSearchBookTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("--------------------  SEARCH BOOK  --------------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );  
    }
    public static void PrintEditBookTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("---------------------  EDIT BOOK  ---------------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );  
    }
    public static void PrintRemoveBookTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("--------------------  REMOVE BOOK  --------------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );  
    }
    public static void PrintClientTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("------------------  CHOOSE WHAT YOU   -----------------");
        System.out.println("------------------   WANNA DO WITH    -----------------");
        System.out.println("------------------      CLIENTS       -----------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );
        System.out.println("                     1) SEARCH Client                  ");
        System.out.println("                     2) ADD Client                     ");
        System.out.println("                     3) EDIT Client                    ");
        System.out.println("                     4) REMOVE Client                  ");
        System.out.println("                     5) BACK                           ");
        System.out.println(                                                         ); 
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        PrintEnterChoiceNumber();        
        
    }
    public static void PrintAddClientTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("--------------------  ADD CLIENT  ---------------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );  
    }
    public static void PrintSearchClientTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("-------------------  SEARCH CLIENT  -------------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );  
    }
    public static void PrintEditClientTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("--------------------  EDIT CLIENT  --------------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );  
    }
    public static void PrintRemoveClientTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("-------------------  REMOVE CLIENT  -------------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );  
    }
    public static void PrintEmployeeTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("------------------  CHOOSE WHAT YOU   -----------------");
        System.out.println("------------------   WANNA DO WITH    -----------------");
        System.out.println("------------------     EMPLOYEES      -----------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );
        System.out.println("                     1) SEARCH Employee                ");
        System.out.println("                     2) ADD Employee                   ");
        System.out.println("                     3) EDIT Employee                  ");
        System.out.println("                     4) REMOVE Employee                ");
        System.out.println("                     5) BACK                           ");
        System.out.println(                                                         ); 
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        PrintEnterChoiceNumber();        
        
    }
    public static void PrintAddEmployeeTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("-------------------  ADD Employee  --------------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );  
    }
    public static void PrintSearchEmployeetTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("------------------  SEARCH Employee  ------------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );  
    }
    public static void PrintEditEmployeeTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("-------------------  EDIT Employee  -------------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );  
    }
    public static void PrintRemoveEmployeeTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("------------------  REMOVE Employee  ------------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );  
    }
    public static void PrintTodayOperationsTab()
    {
        LocalDate date = LocalDate.now(); 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String today ;
        today = date.format(formatter);

        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("---------------------    TODAY     --------------------");
        System.out.println("---------------------  OPERATIONS  --------------------");
        System.out.println("---------------------  " + today + "  --------------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );
        System.out.println("                     1) ADD Operation                  ");
        System.out.println("                     2) Display Today Operation        ");
        System.out.println("                     3) BACK                           ");
        System.out.println(                                                         );

        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        PrintEnterChoiceNumber(); 

    }
    public static void PrintAddOperationTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("-------------------  ADD OPERATION  -------------------");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println(                                                         );  
    }
    public static void PrintDisplayOperationsTab()
    {
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );
        System.out.println("-----------------  DISPLAY OPERATIONS  ----------------");
        

        Newlines(3);
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );

        System.out.println("I |  Oper  |   Book   |   Client   |  Employee  |  Time");
        for(int i=0;i<55;i++)
        {
            PrintStr("-");
            Wait(WAITFACTOR);
        }
        System.out.println(                                                         );    
    }

}


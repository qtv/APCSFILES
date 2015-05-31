/**
 * This program calculates the library fines for any given book and displays the output
 * in an easy to copy-and-paste format
 * @author 
 * 11/26/2014
 */
import java.util.Scanner;
public class Fines 
{
public static void main(String [ ] args)
    {
        String userName = "Mona";       //library staff name
        
        //construct a Scanner object with two lines
        Scanner in;
        in = new Scanner(System.in);
        
       System.out.println("Enter name (Last, First) and Social Security Number(####-##-####): ");
       
       String nameLast = in.next();
       String nameFirst = in.next();
       String soc = in.next();
       
       nameLast = nameLast.replaceAll(",","");
       
       
       // social calculations
       soc = soc.replaceAll("-", "");
       String soc1 = soc.substring(0,3);
       String soc2 = soc.substring(3,5);
       String soc3 = soc.substring(6,10);
       
       // account calculations
       String nameFirstAbbrev = nameFirst.substring(0,3);
       
       String accountName = nameLast + nameFirstAbbrev + soc3;
       
       // book title
       System.out.println();
       in.nextLine();
       
       System.out.println("Enter the title of the book: ");
       String bookTitle = in.nextLine();
       
       // date 
       System.out.println();
       System.out.println("Enter the date checked out (mm/dd/yyyy): ");
       
       String date = in.nextLine();
       System.out.println();
       
       // days late 
       
       System.out.println("Days late: ");
       
       String daysLate = in.next();
       Integer intDaysLate = Integer.parseInt(daysLate);
       
       // fine 
       
       System.out.println("Daily fine: ");
       
       String dailyFine = in.next();
       Double dDailyFine = Double.parseDouble(dailyFine);
       
       // date calculations
       // AUTOMATIC processing - at first, I did this before realizing it asked for the person to enter the amount of days late
       
       //today's date
       // int todayMonth = 11;
       //int todayDay = 26;
       // int todayYear = 2014;
       
       // String newDate = date.replaceAll("/","");
       
     
       // int newMonth = Integer.parseInt(newDate.substring(0,2));
       // int newDay = Integer.parseInt(newDate.substring(2,4));
       // int newYear = Integer.parseInt(newDate.substring(4,8));
    
       // date difference
       //int yearDifference = (todayYear - newYear) * 365;
       
       // int dayDifference = todayDay - newDay; 
       
      // int monthDifference = (todayMonth - newMonth) * 30;
       
       // int totalDays = yearDifference + dayDifference + monthDifference;
       
       
       // calculate daily fine
       
       double fineAmount = dDailyFine * intDaysLate;
       
       // other prints
       
       System.out.println();
       System.out.println();
       
       System.out.print("To: " + nameLast + ", " + nameFirst);
       
       System.out.println("           Account: " + accountName);
       
       System.out.println("From: " + userName);
       
       System.out.println("Subject: Overdue Notice");
       
       System.out.println("========================================");
       
       System.out.println(bookTitle + " was checked out on: " + date);
       System.out.println("This book is currently " + intDaysLate + " days late");
       System.out.println("Your fine has accumulated to: " + fineAmount);
       
    }
}    


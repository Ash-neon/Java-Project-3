package Default;
import java.util.Scanner;

public class TestAVG {

	public static void main(String[] args) 
	
	{
		Scanner sc = new Scanner(System.in);
				
			double grade1 = getGrades(sc);
			double grade2 = getGrades(sc);
			double grade3 = getGrades(sc);
			double grade4 = getGrades(sc);
			double grade5 = getGrades(sc);
		
			
			double avg = calcAverage(grade1,grade2,grade3,grade4,grade5);
			System.out.println("Here is your Average grade in Numbers: " + avg);
			
			char letter = determineGrade(avg);
			System.out.println("Here is your Average grade in Letters: " + letter); 

			sc.close();
    }
	
	public static double getGrades(Scanner sc)
	{
		double grade;
		
		System.out.println("Enter a Five grades between 0 and 100");

		do 
			{
		
				grade = sc.nextDouble();
			
				if(grade < 0 || grade > 100) System.out.println("\n Wrong Input - Please Enter Grades from 0 to 100 \n");

		
			} while (grade < 0 || grade > 100);
	
		return grade ;
	}
	
	public static double calcAverage(double grade1, double grade2, double grade3, double grade4, double grade5)
	{
		double avg;
		avg = (grade1+grade2+grade3+grade4+grade5)/5.0;
		
		return avg;
		
	}
	
	public static char  determineGrade(double avg)
	{
		char letter = 0;
		
	    if(avg >= 90.0)
	    {
		   letter = 'A';
	    }
	    else if(avg>=80.0)
	    {
			letter = 'B';
		}
	    else if(avg>=70.0)
	    {
			letter = 'C';
		}
	    else if (avg>=60.0)
	    {
			letter = 'D';
		}
	    else if (avg < 60.0)
	    {
				letter = 'F';
		}
		
		return letter;
	}
	
}

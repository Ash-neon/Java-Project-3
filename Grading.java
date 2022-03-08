package Default;
import java.util.Scanner;

public class Grading {

	public static void main(String[] args) 
	{
		final int NUMBEROFTESTS = 5;
		
		Scanner sc = new Scanner (System.in);
		
		Grades gr = new Grades();
		
		int totalGrades = 0;
		
		for(int grades = 1; grades <= NUMBEROFTESTS; grades++)
		{
			totalGrades += getGrades(sc);
			
		}
		
		gr.totalGradePoints(totalGrades);
		gr.numberOfGrades(NUMBEROFTESTS);
		
		System.out.printf("\n\n Your Average is %.2f \n your grade is %s\n\n", gr.calculateAverage(), gr.determineGrade());
		
		

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

}

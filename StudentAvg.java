package Default;
import java.util.Scanner;
import java.io.*;


public class StudentAvg {

	public static void main(String[] args) throws IOException 
	{

		final String FILE = "/Users/ashutoshchalise/Desktop/Java/studentgrades.txt";
		File fn = new File (FILE);
		Scanner inputFile = new Scanner(fn);
				
		String [] student = new String[4];
		double [] avg = new double[4];
		
		
		fillArray(inputFile, student, avg);
	
		displaystudent(student,avg);
		
	
		
		inputFile.close();
	}
	
	public static void fillArray(Scanner sc, String[]student, double[]avg)
	{
		
		int i = 0;
		double grade = 0;
		
		while(sc.hasNext()) {
		
			student[i]= sc.nextLine();
			if(student[i].equals("")) student[i]= sc.nextLine();
			
				grade = 0;
			
			
			for(int j = 1; j <= 3; j++)
			grade += sc.nextInt(); 
						
		
				avg[i] = grade/3.0;
			
				i++;
		}
	}
	
	public static void displaystudent(String[]student, double[]avg)
	{
		for(int i = 0; i < student.length;i++)
		{
			System.out.printf("%-15s  %5.2f  %1s  %-15s\n\n",student[i],avg[i],displaylettergrade(avg[i]),gradecomment((avg[i])));
		}
	}
	
	public static char displaylettergrade(double avg)
	{
		
		char letter = 0;
		
	    if(avg >= 90.0)
	    {
		   letter = 'A';
	    }
	    else if(avg >= 80.0)
	    {
			letter = 'B';
		}
	    else if(avg >= 70.0)
	    {
			letter = 'C';
		}
	    else if (avg >= 60.0)
	    {
			letter = 'D';
		}
	    else if (avg < 60.0)
	    {
				letter = 'F';
		}
		
		return letter;
	}
	
	public static String gradecomment(double avg)
	{
		
		String letter = "";
		
	    if(avg >= 90.0)
	    {
		   letter = "Excellent Work";
	    }
	    else if(avg >= 80.0)
	    {
			letter = "Good Work";
		}
	    else if(avg >= 70.0)
	    {
			letter = "Average Work";
		}
	    else if (avg >= 60.0)
	    {
			letter = "Poor Work";

		}
	
		
		return letter;
	}
	
	
		
}



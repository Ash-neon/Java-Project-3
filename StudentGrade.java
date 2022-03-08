import java.io.*;
import java.util.Scanner;

public class StudentGrade {

	public static void main(String[] args) throws IOException 
	{
		final String INPUT_FILE = "/Users/ashutoshchalise/Desktop/Java/studentgrades.txt"; 
		final int STUDENTCNT = 5; 
		File fn = new File(INPUT_FILE);
		Scanner inputFile = new Scanner(fn);
		
		
		
		String [] student = new String[STUDENTCNT];
		int [] id = new int [STUDENTCNT];
		double [] grade1 = new double[STUDENTCNT];
		char [] letterGrade = new char[STUDENTCNT];
		
		fillArray(inputFile, student,id,grade1,letterGrade);
	
		displaystudent(student,id,grade1,letterGrade);
		
		demosort(student, id, grade1, letterGrade);
		
		infoByName(inputFile, student, id, grade1, letterGrade);
		infoByStudentId(inputFile, student, id, grade1, letterGrade);

		
		inputFile.close();
		
		
	}
	

	public static void fillArray(Scanner inFile,String[] student, int[] id, double[] grade1, char[] lettergrade)
	{     
		int indx = 0;    
		
		while(inFile.hasNext())
		
		{      student[indx] = inFile.nextLine();   
				if(student[indx].equals("")) student[indx] = inFile.nextLine();    
				id[indx] = inFile.nextInt();  
				
				grade1[indx] = (inFile.nextDouble() + inFile.nextDouble() + inFile.nextDouble()) / 3.0;  
				lettergrade[indx] = displaylettergrade(grade1[indx]);    
				indx++;   }
	}
	


	public static void displaystudent( String[]student, int[]id,double[]grade1, char []lettergrade)
	{
		String fmt = "%-15s  %5d  %6.2f   %s\n";
		for(int indx = 0; indx < student.length;indx++)
			System.out.printf(fmt,student[indx], id[indx],grade1[indx],lettergrade[indx]);
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
	
	public static int findStudent(int svalue, int[] id) 
	{
		int retIndx = -1;
		
		for(int i = 0; i < id.length;i++)
		{
			if(id[i]==svalue)
				retIndx = i; break;
		}
		
		return retIndx;
		
	}
	public static int findStudent(String info, String [] student) 
	{
		int retIndx = -1;
		
		for(int i = 0; i < student.length;i++)
		{
			if(student[i].equalsIgnoreCase(info))
			{
				retIndx = i;break;
			}
				
		}

		return retIndx;
		
		
	}
	public static void displaystudentinfo(int i,String[]student, int[]id,double[]grade1, char []lettergrade)
	{
		
		String fmt = "%-8s   %5d   %6.2f   %3s";
		System.out.println("");
		System.out.printf(fmt,student[i],id[i],grade1[i],lettergrade[i]);

	}
	
	public static void infoByStudentId(Scanner sc,String[]student, int[]id,double[]grade1, char []lettergrade)
	{
		int searchID = 0;
		do{    System.out.print("Enter the Student ID to search for ");
		searchID = sc.nextInt();
		} while(searchID <= 0); 
		sc.nextLine(); 
		int indxReturned  = findStudent(11111,id);
		
        if(indxReturned != -1)        
        	
        	displaystudentinfo(indxReturned,student,id,grade1,lettergrade);       
        else         
        	System.out.println("Student is not on file");	
		
	}
	
	public static void infoByName(Scanner sc,String[]student, int[]id,double[]grade1, char []lettergrade)
	{
		String searchname;
		
		do
		{
			System.out.println("Enter the student id: ");
			searchname = sc.nextLine();
			
			if(searchname.equals("")) System.out.println();

		} while(searchname.equals(""));
		
		int indxReturn1 = findStudent("Joaquin Phoenix",student);
		
		if(indxReturn1 != -1)
		{
			displaystudentinfo(indxReturn1,student,id,grade1,lettergrade);
		}
		else
			System.out.println("Student is not on file");		

	}
	
	public static void demosort(String[] name, int[]id,double[]grade1, char []lettergrade)
	{
		String tempStr;
		int tempint;
		double tempDouble;
		char tempChar;
		
		for(int i = 0; i < name.length; i++)
		{
			System.out.println(name[i]);
		}
			for(int j= 0; j < name.length; j++)
			{
				for(int i = j+1; i < name.length; i++)
				{
					if(name[i].compareToIgnoreCase(name[i]) > 0)
					{
						tempStr = name[i];
						name[i]=name[j];
						name[j]=tempStr;
						
						tempint= id[i];
						id[i] = id[j];
						id[j]=tempint;
						
						tempDouble = grade1[i];
						grade1[i]= grade1[j];
						grade1[j] = tempDouble;
						
						tempChar = lettergrade[i];
						lettergrade[i]= lettergrade[j];
						lettergrade[j] = tempChar;
						
					}
				}
				
			}
		}
		
		
	}

	



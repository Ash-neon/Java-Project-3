import java.util.Scanner;
public class DriverExam
{
	public static void main(String[] args) 
	{
		char [] answer = {'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A','C','D','B','C','D','A','D','C','C','B','D','A'};

		char [] studentAns = {'C', 'F', 'B', 'C', 'C', 'A', 'B', 'G','C','D','B','B','A','A','D','C','C','B','D','A'};

		int [] questionMissed = new int [20];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Answers Accordinly"); 

		for(int i = 0; i< studentAns.length; i++) 
			studentAns[i] = getAnswer(sc,i+1);
		
	
		passed(answer,studentAns,questionMissed);
		
		
		System.out.println("\nTotal Correct Answers: "+ totalCorrect(answer,studentAns,questionMissed));

		
		displayMissedQuestions(answer,studentAns,questionMissed);
		
		
	}
	
	public static boolean passed(char[] answer, char [] studentAns,int[ ]Mquestion)
	{
		double count = totalCorrect(answer,studentAns,Mquestion);
		
		boolean passed = false;
		
		for(int i = 0; i < answer.length; i++ )
		{
			if(answer[i] == studentAns[i] )
			{
				count++;
			}
			
			passed = count/answer.length >= 0.7;
	}
		if(passed)
		{
			System.out.println("\n\nCongratulations!!! You Passed The Test!");
		}
		else 
			System.out.println("\n\nYou Failed The Test!");
		
		
		return passed;
		
	}
	
	public static int totalCorrect(char[] answer, char [] studentAns,int[ ]Mquestion)
	{
		int count = 0;
		int j = 0;
		
		for(int i = 0; i < answer.length; i++ )
		{
			if(answer[i] == studentAns[i] )
			{
				count++;
			}
			else
				Mquestion[j] = i + 1;
				j++;
		}
		return count;
	}
		
	

	public static void displayMissedQuestions(char[] answer, char [] studentAns,int[ ]Mquestion)
	{
		System.out.printf("\n%8s    %10s    %13s\n\n","Question No.","Your Answer","Correct Answer");

		for(int i = 0; i < Mquestion.length; i++)
		{
			if(Mquestion[i] != 0)
			{
				System.out.printf("%8s    %10s    %13s\n\n",Mquestion[i],studentAns[Mquestion[i]-1],answer[Mquestion[i]-1]);
			}
				
		}
		
	}
	
	public static char getAnswer(Scanner sc, int questionNum)
	{
		char retValue;   
		boolean valid = false;
		
		System.out.print("Answer Question " + questionNum + " :"); 
		
		do
		{    
			retValue = sc.nextLine().toUpperCase().charAt(0);
			
			valid = retValue == 'A' || retValue == 'B' || retValue == 'C' || retValue =='D'; 
			
			if(!valid) System.out.println("\nEntry must be A,B,C or D\n");  
			
		} while (!valid);  
		
		return retValue;
		
	}
	

}





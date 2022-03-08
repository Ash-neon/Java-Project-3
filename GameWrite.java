package Default;
import java.util.Scanner;

public class GameWrite {

	public static void main(String[] args)

	{
	    Scanner sc = new Scanner(System.in); 

	  
	    int user;
		do {
	    System.out.println("Let's play Rock, Paper, Scissors!\n" + 
	                       "Please Enter your move.\n" + "Rock = 1, Paper = 2" + 
	                       ", or Scissors = 3");

	    System.out.println();
	    
	   
	    String person = getUserChoice(sc);
	    
	    String computer = generateChoice();
	  
	    check(person,computer);
	    
	    System.out.println("\nDO you want to play again?" + "\nYes = 1, No = 2\n");
	    user = sc.nextInt();
	    
	    if(user == 2)
	    {
	    	System.out.println("Thank You for Playing!!!");
	    }

	    } while (user == 1);
	  
	    sc.close();
	    
		
	}
	
	public static String getUserChoice(Scanner sc)
	{
		String person = "";
		int num;
	
		System.out.println("Enter your play: "); 
		num = sc.nextInt();
	   
		if (num == 1) 
		       person = "Rock"; 
		    else if (num == 2) 
		       person = "Paper"; 
		    else if (num == 3) 
		       person = "Scissor"; 
 
		return person;
		
	}
	
	
	public static String generateChoice()
	{
		int num;
		 String comp ="";
		 
		  num = (int) (Math.random () * 3 +1); 
		  
		 if (num == 1) 
		       comp = "Rock"; 
		    else if (num == 2) 
		       comp = "Paper"; 
		    else if (num == 3) 
		       comp = "Scissor"; 
		 
		    System.out.println("\nComputer play is: " + comp); 

		 return comp;

	}
	
	public static void check (String person, String comp)
	{
		if (person.equals(comp)) 
		       System.out.println("It's a tie!"); 
		  
		else if (person.equals("Rock") && comp.equals("Scissor")) 
		          System.out.println("Rock crushes scissors. You win!!");
		else if (person.equals("Rock") && comp.equals("Paper")) 
		            System.out.println("Paper eats rock. You lose!!"); 
		   
		else if (person.equals("Paper") && comp.equals("Scissor")) 
		       System.out.println("Scissor cuts paper. You lose!!"); 
		else if (person.equals("Paper") && comp.equals("Rock")) 
		            System.out.println("Paper eats rock. You win!!"); 
		 
		else if (person.equals("Scissor") && comp.equals("Paper")) 
		         System.out.println("Scissor cuts paper. You win!!"); 
		   
		else if (person.equals("Scissor") && comp.equals("Rock")) 
		            System.out.println("Rock breaks scissors. You lose!!"); 
		    else 
		         System.out.println("Invalid user input."); 
	}
	


}



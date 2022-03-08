package Default;

import java.util.Scanner;
public class Calculator {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		char selection;
		int num1 = 0;
		int num2 ;
		
		boolean done = false;
		
		do 
	 {
		
			displayMenu();
			
			selection = getselection(sc);
		
				if (selection != 'X')
				{
					System.out.println("Enter the first number: "); 
					num1 =  getnumber1(sc);
		
					System.out.println("Enter the Second number: "); 
					num2 = sc.nextInt();
					sc.nextLine();
					
					System.out.println(""); 

		
					process(selection,num1,num2);
		
				}
				else
					done = true;
	
		} while(!done);
		
		System.out.println("--- END PROGRAM ---");
		sc.close();
	
	} // end main
	
	public static void displayMenu()
	{
		System.out.println("     MENU");
		System.out.println(" ---------------");
		System.out.println(" A - Add");
		System.out.println(" S - subtract");
		System.out.println(" M - Multiply");
		System.out.println(" D - Divide ");
		System.out.println(" X - Exit ");
		System.out.println(" -----------------\n");
		
	}
	
	public static void process(char selection, int num1 , int num2)
	{
		switch (selection)
		{
			case 'A' : add(num1,num2); 
					   break;
			case 'S' : substract(num1,num2);
			           break;
			case 'M' : multiply(num1,num2);
			           break;
			case 'D' : division(num1,num2);
			           break;	
			case 'X':  
					   break;
						
		}
		
	}
	
	public static void add(int num1, int num2)
	{
		int result;
		
		result = num1 + num2;
		System.out.println("The result is: "+ result+"\n");
		
		
	}
	
	public static void substract(int num1, int num2)
	{
		int result;
		
		result = num1 - num2;
		System.out.println("The result is: "+ result +"\n");

	}
	
	public static void multiply(int num1, int num2)
	{
		int result;
		
		result = num1 * num2;
		System.out.println("The result is: "+ result +"\n");

	}
	
	public static void division(int num1, int num2)
	{
		int result;
		
		result = num1 / num2;
		System.out.println("The result is: "+ result +"\n");

	}
	
	public static char getselection(Scanner sc )
	{
		char sel;
		boolean done;
		
		do {
				sel = sc.nextLine().toUpperCase().charAt(0);
		
				done = sel == 'A' ||sel == 'S'|| sel == 'M'|| sel == 'D' || sel == 'X';
		
			if (!done)
			{
				System.out.println("Invalid Selection - Please Try Again");
			}
		
			} while (!done);
		
		return sel;

	}
	
	public static int getnumber1(Scanner sc)
	{
		int result;
        boolean done;
		
		do {
				result = sc.nextInt();
				
		
				done = result > 0 ;
				
				if (!done)
				{
					System.out.println("Invalid Input - Please enter number greater than 0");
				}

		
			} while (!done);
		
		
		return result;
		
	}
	
	

}

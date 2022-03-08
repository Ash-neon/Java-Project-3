import java.io.*;
import java.util.Scanner;

public class LabQuiz2 {

	public static void main(String[] args) throws IOException 
	{
		//final String FILE = "/Users/ashutoshchalise/Desktop/Java/LQ2DataA-1.txt";
		//final String OUTPUT = "result.txt";
		
		//File fn = new File (FILE);
		
		final int NUMBEROFRECORD = 5;
		
		//Scanner inputFile = new Scanner(fn);
		Scanner sc = new Scanner(System.in);
		
		PrintWriter reportfile = new PrintWriter ("result.txt");


		String [] symbol = {"s","r","d","h","e"};
		String [] company  = {"test1","test2","test3","test4","test5"};
		
		double [] low =  {23.44,54,76,23,54};
		double [] high = {56,98,345,75,89};
		
		double [] close = {34,66,74,54,76};
		double [] pclose = {33,59,78,66,56};
	
		double [] profit = new double[NUMBEROFRECORD];
		
		String [] Lossgain = new String [NUMBEROFRECORD];

		System.out.println("1 - Print to Screen");
		System.out.println("2 - Print to File");
		System.out.println("3 - Print to Both");
		
		System.out.println("\nStock Report By Ashutosh Chalise Version A\n");
		
	//	fillArray(sc,symbol, company, low,high,close,pclose,profit,Lossgain);
		displayResult(reportfile, sc, symbol, company, low,high,close,pclose,profit,Lossgain);
		
		
	//	inputFile.close();
		sc.close();
		reportfile.close();

	}
	
	public static void fillArray(Scanner inFile,String[] symbol,String[]company, double[] low, double[] high, double[]close, double [] pclose, double [] profit, String [] lg)
	{     
		int indx = 0;    
		
		while(inFile.hasNext())
		
		{      symbol[indx] = inFile.nextLine();   
				if(symbol[indx].equals("")) symbol[indx] = inFile.nextLine();    
				
				company[indx] = inFile.nextLine();   
				if(company[indx].equals("")) company[indx] = inFile.nextLine();  
				
				low[indx] = inFile.nextDouble();  
				high[indx]= inFile.nextDouble();
				
				close[indx] = inFile.nextDouble();
				pclose[indx] = inFile.nextDouble();
				
				
				profit[indx] = (close[indx] - pclose[indx] ) * 100;
				
				lg[indx] = displaylg(profit[indx]);    
				
				indx++;   
				}
	}
	
	public static void displayResult(PrintWriter reportfile,Scanner sc,String[] symbol,String[]company, double[] low, double[] high, double[]close, double [] pclose, double [] profit, String[]lg)
	{
		String head ="%-7s   %13s   %8s   %8s   %6s   %14s   %15s\n";
		String fmt = "\n%4s   %13s   %5.2f   %5.2f   %5.2f   %5.2f   %4.2f\n\n";
		
		String ostr= "";
		
		ostr = String.format(head, "Symbol","Company","Low Price", "High price", "Close", "Previous Close","Profit Per 100" );
		reportfile.print(ostr);
		System.out.print(ostr);
		

		for(int indx = 0; indx < symbol.length;indx++)
		{		
		ostr = String.format(fmt,symbol[indx], company[indx],low[indx],high[indx],close[indx],pclose[indx],profit[indx],lg[indx]);
		reportfile.print(ostr);
		System.out.print(ostr);
		}
		
		ostr = String.format("\nThe Stock with greatest gain is: %s\n",symbol[findgreatestgain(profit)]);
		reportfile.print(ostr);
		System.out.print(ostr);
		
		ostr = String.format("\nThe Stock with smallest gain is: %s\n",symbol[findsmallestgain(profit)]);
		reportfile.print(ostr);
		System.out.print(ostr);
	}
	
	public static String displaylg(double profit)
	{
		String result ="";
		
		if(profit > 0)
		{
			result = "Gain";
			
		}
		else
		{
			result = "Loss";
		}
		
		return result;
	}

	
				
	public static int findgreatestgain(double[] profit)
	{   
		int retIndx = 0;    
		for(int indx = 0; indx < profit.length;indx++) 
		if(profit[retIndx] > profit[indx]) retIndx = indx;  
		return retIndx;
	}
	
	public static int findsmallestgain(double[] profit)
	{   
		int retIndx = 0;
		for(int indx = 0; indx<profit.length;indx++)  
    	if(profit[retIndx] < profit[indx]) retIndx = indx;  
		return retIndx;
}
}

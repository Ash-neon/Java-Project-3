package Default;

import java.util.Scanner;
import java.io.*;
public class SalesReporting {

	public static void main(String[] args) throws IOException 
	{

		final String FILE = "/Users/ashutoshchalise/Desktop/Java/first test/sales.txt";
		
		File fn = new File (FILE);
		Scanner inputFile = new Scanner(fn);
				
		PrintWriter reportfile = new PrintWriter ("/Users/ashutoshchalise/Desktop/Java/first test/sales.txt");
		
		Scanner sc = new Scanner(System.in);
		
		String region ;
		int units ;
		double totalsales ;
		
		int totunits = 0;
		double totsales = 0.0;
		
		
		String fmt = "%-20s  %5d   $%14.2f   $15.2f\n";  

		
		char rptselection = getReportSelection(sc);
		
		displayHead(reportfile, rptselection);
		
		while (inputFile.hasNext())
	{
		region = inputFile.nextLine();
		if(region.equals("")) region = inputFile.nextLine();
		
		units = inputFile.nextInt();
	    totalsales = inputFile.nextDouble();
	    
		 
	    totunits += units;
	    totsales += totalsales;
	   		 
		displayDetail(reportfile,rptselection,region,units,totalsales, totsales/totunits);
		 
	}
		displayDetail(reportfile,rptselection, fmt, totunits,totsales, totsales/totunits);
		 
		sc.close();
		inputFile.close();
		reportfile.close();
		
	}



		public static void displayHead(PrintWriter outputFile, char action)
		
		{
			String ostr;
	
			String head = "%-20s  %-5s   %-14s      %-15s\n\n";
	
				ostr = String.format(head, "Region","Units","Total Sales","Per Unit Sales");
				if ( action == 'B'|| action == 'F') outputFile.print(ostr);
				if ( action == 'B' || action =='S') System.out.print(ostr);
	
				ostr = String.format(head+'\n', "-------","------","---------","---------------");
				if ( action == 'B'|| action == 'F') outputFile.print(ostr);
				if ( action == 'B' || action =='S') System.out.print(ostr);
	
				
		}

		public static char getReportSelection(Scanner sc)
		
		{
			boolean done =true;
			char rptselection;
		do 
	
		{
			System.out.print("Send report to (s)creen, (f)iles, (b)oth");
			rptselection = sc.nextLine().toUpperCase().charAt(0);
		
			done = rptselection == 'B' || rptselection =='S' || rptselection == 'F';
		
			if(!done) System.out.println("Invalid Selection");
		
		} while(!done);
	
			return rptselection;
	
	}

		public static void displayDetail(PrintWriter outputFile, char action, String region, int units, double totalsales, double d)
		{
			String ostr;
	
			String fmt = "%-20s  %5d   $%14.2f   $15.2f\n";  

				ostr = String.format(fmt,region,units,totalsales,totalsales/units);
				if ( action == 'B'|| action == 'F') outputFile.print(ostr);
				if ( action == 'B' || action =='S') System.out.print(ostr);
	
		}
}

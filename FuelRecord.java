import java.util.Scanner;
import java.io.*;

public class FuelRecord 
{

	public static void main(String[] args) throws IOException 
	{

		final String FILE = "/Users/ashutoshchalise/Desktop/Java/fuelrecord.txt";
		File fn = new File (FILE);
		final int NUMBEROFRECORD = 5;
		Scanner inputFile = new Scanner(fn);
		Scanner sc = new Scanner(System.in);
		
		PrintWriter reportfile = new PrintWriter ("printfuelrecord.txt");


		String [] name = new String[NUMBEROFRECORD];
		int [] miles = new int[NUMBEROFRECORD];
		double [] gas =  new double [NUMBEROFRECORD];
		double [] mpg = new double[NUMBEROFRECORD];
		
		System.out.println("1 - Print to Screen");
		System.out.println("2 - Print to File");
		System.out.println("3 - Print to Both");

		
		
		fillArray(inputFile, name, miles, gas);
		calculatempg(name, miles, gas,mpg);
		displayoutput(reportfile,sc, name, miles, gas, mpg);
	
		
		inputFile.close();
		sc.close();

	}
	
	public static void fillArray(Scanner sc, String [] name, int[ ]miles, double [] gas)
	{
		int i = 0;
		
		while(sc.hasNext()) {
		
			name[i]= sc.nextLine();
			if(name[i].equals("")) name[i]= sc.nextLine();
			miles[i]= sc.nextInt(); 
			gas[i] = sc.nextDouble(); 
					
				i++;
	
		}
		
	}
	
	public static void calculatempg(String[]name, int[] miles, double[]gas, double[]mpg)
	{
		
		for(int i = 0; i < name.length; i++)
		{
			mpg[i] = miles[i]/gas[i];

		}
		
	}
	
	public static void displayoutput(PrintWriter reportfile,Scanner sc,String[]name, int[] miles, double[]gas, double[]mpg) 
	{
		String head = "%-10s  %8d  %8.2f  %9.2f\n\n ";
		String ostr= "";
		int printSelection;
		
		printSelection = sc.nextInt();
		
		for(int i = 0; i < name.length; i++)
		{
			ostr = String.format(head, name[i], miles[i], gas[i], mpg[i]);
			if (printSelection == 2 || printSelection == 3) reportfile.print(ostr);
			if (printSelection == 1 || printSelection == 3) System.out.print(ostr);
		
		}
		
		ostr = String.format("\n\nThe car with the best MPG is: %s\n", name[findbestcar(mpg)]);
		
		if (printSelection == 2 || printSelection == 3) reportfile.print(ostr);
		if (printSelection == 1 || printSelection == 3) System.out.print(ostr);
	
		
		
		ostr = String.format("\n\nThe car with the Wrost MPG is: %s\n", name[findwrostcar(mpg)]);
		if (printSelection == 2 || printSelection == 3) reportfile.print(ostr);
		if (printSelection == 1 || printSelection == 3) System.out.print(ostr);
	
		
		
		ostr = String.format("\n\nLongest Trip is: %s\n", name[longestTrip(miles)]);
		if (printSelection == 2 || printSelection == 3) reportfile.print(ostr);
		if (printSelection == 1 || printSelection == 3) System.out.print(ostr);
	
		
		ostr = String.format("\n\nShortest Trip is: %s\n", name[ShortestTrip(miles)]);
		if (printSelection == 2 || printSelection == 3) reportfile.print(ostr);
		if (printSelection == 1 || printSelection == 3) System.out.print(ostr);
	
		
		ostr = String.format("\n\nMost Fuel Used is: %s\n", name[mostfuel(gas)]);
		if (printSelection == 2 || printSelection == 3) reportfile.print(ostr);
		if (printSelection == 1 || printSelection == 3) System.out.print(ostr);
	
		
		ostr = String.format("\n\nLeast Fuel Used is: %s\n", name[leastfuel(gas)]);
		if (printSelection == 2 || printSelection == 3) reportfile.print(ostr);
		if (printSelection == 1 || printSelection == 3) System.out.print(ostr);
	
		
	}
	


	public static int findbestcar(double []mpg)
	{
		int i = 0;

		
		for(int j= 0; j < mpg.length; j++)
		{
			 if(mpg[i] < mpg[j])
				 
				 i = j;
		}
		
		return i;
	}
	
	public static int findwrostcar(double []mpg)
	{
		int i = 0;

		
		for(int j= 0; j < mpg.length; j++)
		{
			 if(mpg[i] > mpg[j])
				 
				 i = j;
		}
		
		return i;
	}
	
	public static int longestTrip (int[] miles)
	{
		int i = 0;

		
		for(int j= 0; j < miles.length; j++)
		{
			 if(miles[i] < miles[j])
				 
				 i = j;
		}
		
		return i;
	}
	public static int ShortestTrip(int [] miles)
	{
		int i = 0;

		
		for(int j= 0; j < miles.length; j++)
		{
			 if(miles[i] > miles[j])
				 
				 i = j;
		}
		
		return i;
	}
	
	public static int mostfuel(double [] gas)
	{
		int i = 0;

		
		for(int j= 0; j < gas.length; j++)
		{
			 if(gas[i] < gas[j])
				 
				 i = j;
		}
		
		return i;
	}
	
	public static int leastfuel(double [] gas)
	{
		int i = 0;

		
		for(int j= 0; j < gas.length; j++)
		{
			 if(gas[i] > gas[j])
				 
				 i = j;
		}
		
		return i;
	}
	
	
	
	
		
}



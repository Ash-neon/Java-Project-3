import java.io.*;
import java.util.Scanner;

public class PeriodicTable {

	public static void main(String[] args) throws IOException 
	{
		final int NUMBEROFRECORD = 9;

		
		 final String INPUT_FILE = "/Users/ashutoshchalise/Desktop/Java/elements.txt"; 
		 final String OUTPUT_FILE = "/Users/ashutoshchalise/Desktop/Java/result.txt"; 
		 Scanner sc = new Scanner(System.in); 
		 PrintWriter reportfile = new PrintWriter(OUTPUT_FILE); 
		 File fn = new File(INPUT_FILE);  
		 Scanner dataIn = new Scanner(fn); 

		String [] symbol = new String[NUMBEROFRECORD];
		String [] name = new String[NUMBEROFRECORD];
		int [] AtomicNum =  new int [NUMBEROFRECORD];
		int [] AtomicMass = new int [NUMBEROFRECORD];
		
		fillArray(sc,NUMBEROFRECORD,symbol,name,AtomicNum,AtomicMass);
		
		 char reportSel = getReportSelection(sc); 
		 displayReportHeader(reportfile,reportSel);  
		 displayReportBody(reportfile,reportSel,symbol,name,AtomicNum,AtomicMass);
		
		infoByAtomicNumber(reportfile,reportSel , sc,symbol,name,AtomicNum,AtomicMass);
		infoByName(reportfile, reportSel, sc,symbol,name,AtomicNum,AtomicMass);
		
	     sortElements(symbol,name,AtomicNum,AtomicMass);
		
		
	    dataIn.close();
	    reportfile.close();
		sc.close();
	}
	
	public static void fillArray(Scanner sc, int limit,String [] symbol, String [] name,int[ ]num1, int[] num2)
	{
		int indx = 0;    
		while(sc.hasNext() && indx<limit)   
		{    
			symbol[indx] = sc.nextLine();  
			if(symbol[indx].equals("")) symbol[indx] = sc.nextLine();  
			
			name[indx] = sc.nextLine();  
			num1[indx] = sc.nextInt();  
			num2[indx] = sc.nextInt();     
				
			System.out.println(symbol[indx]);
	       
			indx++;    
		}
		
		
	}
	
	public static void  displayReportHeader(PrintWriter rpt, char sel)
	{       
		String formatStr = "%-6s   %-15s   %6s   %6s\n";   
		output(rpt,sel,String.format(formatStr,"Symbol","Name","Number","Weight"));    
		output(rpt,sel,String.format(formatStr+"\n","======","==============","======","======"));  
		
	}
	
	public static void  displayReportBody(PrintWriter rpt, char sel, String[] symbol, String[] name, int[] number, int[] weight)
	{        String formatStr = "%6s   %-15s   %6d   %6d\n";      
	for(int indx=0; indx<symbol.length;indx++)
		output(rpt,sel,String.format(formatStr,symbol[indx],name[indx],number[indx],weight[indx]));
	}
	
	
	public static void output(PrintWriter r, char s, String oStr)
	{            
		if(s == 'S' || s == 'B') System.out.print(oStr);  
		if(s == 'F' || s == 'B') r.print(oStr);
	}

	
	
	public static char getReportSelection(Scanner kbd)
	{
		char retValue;
		boolean valid = false;
		
		do
		{  
			System.out.print("Send report to S)creen, F)ile, B)oth "); 
			retValue = kbd.nextLine().toUpperCase().charAt(0);
			valid = retValue == 'S' || retValue == 'F' || retValue == 'B'; 
			if (!valid) System.out.println("Invalid entry"); 
			
		} while (!valid); 
		
		System.out.println();   
		return retValue;
		
	}
	
	public static int findElement(int svalue, int[] id) 
	{
		int retIndx = -1;
		
		for(int i = 0; i < id.length;i++)
		{
			if(id[i]==svalue)
				retIndx = i; break;
		}
		
		return retIndx;
		
	}
	
	public static int findsymbol(String info, String [] symbol) 
	{
		int retIndx = -1;
		
		for(int i = 0; i < symbol.length;i++)
		{
			if(symbol[i].equalsIgnoreCase(info))
			{
				retIndx = i;break;
			}
				
		}

		return retIndx;
		
		
	}
	
	public static void infoByAtomicNumber(PrintWriter rpt, char sel,Scanner sc, String [] symbol, String [] name,int[ ]num1, int[] num2)
	{
		int num = 0;
		
		do
		{    
			System.out.print("Enter the number to search for ");
		num = sc.nextInt();
		} while(num <= 0); 
		sc.nextLine(); 
		
		int indxReturned  = findElement(11111,num1);
		
        if(indxReturned != -1)        
        	
        	displayReportBody( rpt,sel,symbol,name,num1,num2);       
        else         
        	System.out.println("Element not on file");	
		
	}
	
	public static void infoByName(PrintWriter rpt, char sel,Scanner sc, String [] symbol, String [] name,int[ ]num1, int[] num2)
	{
		String searchname;
		
		do
		{
			System.out.println("Enter the Symbol: ");
			searchname = sc.nextLine();
			
			if(searchname.equals("")) System.out.println();

		} while(searchname.equals(""));
		
		int indxReturn1 = findElement(4, num1);
		
		if(indxReturn1 != -1)
		{
        	displayReportBody( rpt,sel,symbol,name,num1,num2);       
			}
		else
			System.out.println("Element not on file");		

	}
	
	public static void sortElements(String[] symbol, String[] name, int[] number,int[] weight)
	{
		String tStr;
		int tInt;
		for(int indx = 0; indx<name.length-1;indx++) 
			for(int indx1 = indx+1; indx1<name.length;indx1++)   
				if(weight[indx]<weight[indx1])
				{   
					tStr = symbol[indx];  
					symbol[indx] = symbol[indx1];  
					symbol[indx1] = tStr;  
				
					tStr = name[indx];  
					name[indx] = name[indx1]; 
					name[indx1] = tStr; 
				
					tInt = number[indx];   
					number[indx] = number[indx1]; 
					number[indx1] = tInt;  
				
					tInt = weight[indx];  
					weight[indx] = weight[indx1];  
					weight[indx1] = tInt;    
					}
		}

}

import java.util.Scanner;
import java.io.*;
public class Elements {

	public static void main(String[] args) throws IOException {
		 final int COUNT = 9; 
		 final String INPUT_FILE = "/Users/ashutoshchalise/Desktop/Java/elements.txt"; 
		 final String OUTPUT_FILE = "/Users/ashutoshchalise/Desktop/Java/result.txt"; 
		
		 Scanner sc = new Scanner(System.in); 
		 PrintWriter reportFile = new PrintWriter(OUTPUT_FILE); 
		 File fn = new File(INPUT_FILE);  
		 Scanner dataIn = new Scanner(fn); 
		 
		 String[] symbol = new String[COUNT];  
		 String[] name = new String[COUNT];  
		 int[] AtomicNum = new int[COUNT]; 
		 int[] AtomicMass = new int[COUNT];
		
		 fillArray(dataIn,COUNT,symbol,name,AtomicNum,AtomicMass);   
		 
		 char reportSel = getReportSelection(sc);     
		 sortElements(symbol,name,AtomicNum,AtomicMass);    
		 displayReportHeader(reportFile,reportSel); 
		 
		 displayReportBody(reportFile,reportSel,symbol,name,AtomicNum,AtomicMass); 
		 System.out.println();    
		 
		searchEngine(sc,symbol,name,AtomicNum,AtomicMass);
		 
	      reportFile.close();    
	      dataIn.close();    
	      sc.close();  
	      
	} 
	
	public static void searchEngine(Scanner sc,String[] symbol, String[] name, int[] num,int[] mass)
	{
		int theIndx;    
		 
		 theIndx = findElement(getNumber(sc),num);    
		 
		 if(theIndx>-1) System.out.printf("\n\n%s %s\n\n",symbol[theIndx],name[theIndx]);   
		 else System.out.println("Not Found");     
		 
		 String sVal = getSymbol(sc);  
		 theIndx = findElement(sVal,symbol);    
		 if(theIndx>-1) System.out.printf("\n\n%s %s\n\n",symbol[theIndx],name[theIndx]);   
		 else System.out.println("Not Found");     
		 System.out.println();
	}
	
	public static void sortElements(String[] symbol, String[] name, int[] number,int[] weight)
	{
		String tStr;int tInt;for(int indx = 0; indx<name.length-1;indx++) 
			for(int indx1 = indx+1; indx1<name.length;indx1++)   
				if(weight[indx]<weight[indx1])
				
				{   tStr = symbol[indx];
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
					weight[indx1] = tInt;     }
		}
	
	public static void fillArray(Scanner dataIn,int limit, String[] symbol, String[] name, int[] num,int[] mass)
	{  
		int i  = 0;    
		while(dataIn.hasNext() && i <limit)   
		{    
			symbol[i] = dataIn.nextLine();  
			if(symbol[i].equals("")) symbol[i] = dataIn.nextLine();  
			
			name[i] = dataIn.nextLine();  
			num[i] = dataIn.nextInt();  
			mass[i] = dataIn.nextInt();     
				
			System.out.println(symbol[i]);
	       
			i++;    
		}
		
	}
	
	public static char getReportSelection(Scanner kbd)
	{
		char retValue;
		boolean valid = false;
		
		do{   
			System.out.print("Send report to S)creen, F)ile, B)oth ");  
		
			retValue = kbd.nextLine().toUpperCase().charAt(0);  
			valid = retValue == 'S' || retValue == 'F' || retValue == 'B';  
			if (!valid) System.out.println("Invalid entry");   
		
		}while (!valid); 
		System.out.println();   
		
		return retValue;}
	
	public static String getSymbol(Scanner kbd)
	{
		String retValue;
		boolean valid = false;
			
		do
		{  
				System.out.print("Enter the Symbol for the search ");  
				retValue = kbd.nextLine().toUpperCase();  
				valid = ! retValue.equals("");  
				if (!valid) System.out.println("Invalid entry"); 
				
			} while (!valid);   
			System.out.println();
			return retValue;
			
	}
	
	public static int getNumber(Scanner kbd)
	{
		int retValue;boolean valid = false;
		
			do
			{   
			System.out.print("Enter the Atomic Number for the search ");
			
			retValue = kbd.nextInt(); 
			kbd.nextLine(); 
			valid = !(retValue < 0);
			
			if (!valid) System.out.println("Invalid entry");   
			
			} while (!valid);   System.out.println();   
			
			return retValue;
			
	}
	
	public static int findElement(int numberIn,int[] num)
	{
		int retValue = -1; 
		for(int indx = 0; indx<num.length; indx++) 
			if(num[indx] == numberIn){ retValue = indx; break;} 
		
		return retValue;
		
	}
	
	public static int findElement(String symIn,String[] sym)
	
	{
		int retValue = -1;  
		
		for(int indx = 0; indx<sym.length; indx++)  
			
			if(sym[indx].equalsIgnoreCase(symIn))
			
			{ retValue = indx; break;} 
		
		return retValue;
		
	}
	
	public static void  displayReportHeader(PrintWriter rpt, char sel)
	{
	       
	String formatStr = "%-6s   %-15s   %12s   %12s\n";       
	output(rpt,sel,String.format(formatStr,"Symbol","Name","Atomic Number","Atomic Mass"));
	output(rpt,sel,String.format(formatStr+"\n","======","==============","============","============"));   
	
	}
	
	public static void  displayReportBody(PrintWriter rpt, char sel, String[] symbol, String[] name, int[] number, int[] weight)
	{      
		String formatStr = "%-6s   %-15s   %-12d   %-12d\n";     
		for(int indx=0; indx<symbol.length;indx++)
			output(rpt,sel,String.format(formatStr,symbol[indx],name[indx],number[indx],weight[indx]));  
		
	}
	
	public static void output(PrintWriter report, char s, String oStr)
	{         
		
		if(s == 'S' || s == 'B') System.out.print(oStr);     
		if(s == 'F' || s == 'B') report.print(oStr);    
		
	}

	}



package Default;

public class Grades {
	
	private int totalGradePoints ;
	private int numberOfGrades;

	public Grades()
	{
		totalGradePoints = 0;
		numberOfGrades = 0;
		
	}
	

	public double totalGradePoints()
	{
		return totalGradePoints;
	}
	
	public int numberOfGrades()
	{
		return numberOfGrades;
	}
	
//*************************************************************************************************************	
//*************************************************************************************************************	

	
	public void totalGradePoints(int tgp)
	{
		totalGradePoints = tgp;
	}
	
	public void numberOfGrades(int nog)
	{
		numberOfGrades = nog;
	}
	
//*************************************************************************************************************	
//*************************************************************************************************************	

	public double calculateAverage()
	{
		return totalGradePoints / (numberOfGrades * 1.0);
	}
	
	public char  determineGrade()
	{
		double avg = calculateAverage();
	
		char letter = 0;
		
	    if(avg >= 90.0)
	    {
		   letter = 'A';
	    }
	    else if(avg>=80.0)
	    {
			letter = 'B';
		}
	    else if(avg>=70.0)
	    {
			letter = 'C';
		}
	    else if (avg>=60.0)
	    {
			letter = 'D';
		}
	    else if (avg < 60.0)
	    {
				letter = 'F';
		}
		
		return letter;
		
	}
}
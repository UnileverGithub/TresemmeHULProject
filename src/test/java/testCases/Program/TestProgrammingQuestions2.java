package testCases.Program;

public class TestProgrammingQuestions2 {
	public static void main(String[] args)
	{
		int i = 0;
		int j =5;
		for(i=0;i<5;i++)
		{
			for(j=5-i; j>0;j--)
			{
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}


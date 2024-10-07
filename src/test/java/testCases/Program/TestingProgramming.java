package testCases.Program;

public class TestingProgramming {
	public static void main(String[] args)
	{
		String word = "hello";
		//reverse it
		String reverse1 = ""; //intialization is must
		for(int i=word.length()-1;i>=0;i--)
		{
			reverse1+= word.charAt(i);
		}
		System.out.print(reverse1);
	}

}

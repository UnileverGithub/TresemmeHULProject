package testCases.Program;
import java.util.HashMap;
import java.util.Map;

public class TestOccuranceString {
	public static void main(String[] args)
	{
		String value = "Ashishh";
		char[] charArr = value.toCharArray();
	    HashMap<Character,Integer> map= new HashMap<>();
	    for(char entry : charArr)
	    {
	    if(!(map.containsKey(entry)))
	    {
	    	map.put(entry, 1);
	    }
	    else
	    	map.put(entry, map.get(entry)+1);
	    }
	    for(Map.Entry<Character, Integer> entry : map.entrySet())
	    {
	    	if(entry.getValue()>1)
	    	{
	    		System.out.println("character: " +entry.getKey()+" is occuring "+entry.getValue()+ " times");
	    	}
	    }
	}

}

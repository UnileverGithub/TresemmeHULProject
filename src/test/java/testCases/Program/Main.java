package testCases.Program;

/******************************************************************************

Online Java Compiler.
Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.ArrayList;
import java.util.List;
public class Main
{
public static void main(String[] args) {
List<String> list1 = new ArrayList<String>();
list1.add("Hello11");
list1.add("Mumbaiibaacbbxcvvviijnmnkikkkmnjjg");
list1.add("test1");
List<Integer> list3=minimalOperation(list1);
//list3.forEach(System.out::print);
}

public static List<Integer> minimalOperation(List<String> words)
{
List<Integer> list2 = new ArrayList<Integer>();
List<String> list1 = words;
int count=0;
boolean result= false;
for(String li : list1)
{
for(int i=0;i<li.length()-1;i++)
{
if(li.charAt(i)==li.charAt(i+1))
{
System.out.println("Match found at " + i);
count=count+1;
result=true;
}
}
if(result==true)
{
list2.add(count);
result=false;
count=0;
}
else 
{

list2.add(0);
}

}
return list2; 
}

}


import java.util.ArrayList;
import java.util.Collections;

class Student2 implements Comparable
{
	private String name;
	private int mark;
	private float avg;
	public Student2(String name, int mark, float avg) 
	{
		this.name = name;
		this.mark = mark;
		this.avg = avg;
	}
	public String getName() 
	{
		return name;
	}
	public int getMark() 
	{
		return mark;
	}
	public float getAvg()
	{
		return avg;
	}
	@Override
	public String toString() 
	{
		return "Student [name=" + name + ", mark=" + mark + ", avg=" + avg + "]";
	}
	@Override
	public int compareTo(Object o) 
	{
		if(this.avg>((Student2)(o)).avg)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}

}
public class implements1
{
	public static void main(String[] args) 
	{
		Student2 s1=new Student2("Farid",99,77.5f);
		Student2 s2=new Student2("Robinson",88,88.5f);
		Student2 s3=new Student2("Lamnganba",77,80.5f);
		
		
		ArrayList<Student2> al=new ArrayList<Student2>();
		al.add(s1);
		al.add(s2);
		al.add(s3);
		System.out.println(al);
		
		Collections.sort(al);
		System.out.println(al);
		
	}
}

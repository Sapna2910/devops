package net.guides.springboot2.persist.depersist;

public class InheritenceExample {
	
	public static void main(String[] args)
	{
		B b = new B();
		C c = new C();
		D d = new D();
		b.printMsg();
		c.printMsg();
		c.printGeneric();
		d.main(null);
		
	}
	
	public void printMsg() 
	{
		System.out.println("In Super");
	}
	
	public void printGeneric() 
	{
		System.out.println("Generic");
	}
}

class B extends InheritenceExample
{
	public static void main(String[] args)
	{
		System.out.println("Executing main() of B");
		B b = new B();
		b.printMsg();
		b.printGeneric();
	}
	public void printMsg() 
	{
		System.out.println("In B");
	}
}

class C extends InheritenceExample
{
	public void printMsg() 
	{
		System.out.println("In C");
	}
}

class D
{
	public static void main(String[] args)
	{
		System.out.println("Executing main() of D");
		B b = new B();
		C c = new C();
		b.printMsg();
		c.printMsg();
		b.printGeneric();
	}
}


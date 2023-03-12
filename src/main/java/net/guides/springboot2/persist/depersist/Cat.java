package net.guides.springboot2.persist.depersist;

public class Cat implements Animal{

	public void Cat()
	{
		System.out.println("Object of Cat created");
	}
	
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.properties();

	}

	@Override
	public void properties() {
		System.out.println("Family is : "+this.family);
		System.out.println("Sound is : "+this.sound);
	}

}

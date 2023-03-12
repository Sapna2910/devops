package net.guides.springboot2.persist.depersist;

public class TestInterface {

	public static void main(String[] args) {
		Animal animal = new Animal() {
			@Override
			public void properties() {
				System.out.println("properties() method implemented in TestInterface class");
			}
		};
		
		animal.properties();
		System.out.println("Family "+animal.family);

	}

}

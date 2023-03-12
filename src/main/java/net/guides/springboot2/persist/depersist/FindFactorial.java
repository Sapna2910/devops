package net.guides.springboot2.persist.depersist;

public class FindFactorial {
	static Integer factorial(int n) {
		if (n == 0)
			return 1;
		else
			return (n * factorial(n - 1));
	}

	public static void main(String args[]) {
		System.out.println("hello.html" instanceof String);
		int i, fact = 1;
		Integer number = 150;// It is the number to calculate factorial
		fact = factorial(number);
		System.out.println("Factorial of " + number + " is: " + fact);
	}
}

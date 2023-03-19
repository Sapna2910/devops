package net.guides.springboot2.persist.depersist;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Depersist {
	public static void main(String args[]) {
		String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\ObjectByteStream.txt";
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			Student student = (Student) inputStream.readObject();
			System.out.println("Student Id is : " + student.getId());
			System.out.println("Student Name is : " + student.getName());
			System.out.println("Student Subject is : " + student.getSubject());
			inputStream.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

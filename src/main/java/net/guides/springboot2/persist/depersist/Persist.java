package net.guides.springboot2.persist.depersist;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Persist {
	public static void main(String args[]) {
		Student student = new Student(1, "Alisha","Trignometry");
		String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\ObjectByteStream.txt";
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(filePath);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(student);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package net.guides.springboot2.persist.depersist;

import java.io.Serializable;

public class Student implements Serializable{

	private String name ;
	private int id ;
	private transient String subject = "Philosophy";
	
	public Student(int id, String name, String subject)
	{
		this.id = id;
		this.name = name;
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

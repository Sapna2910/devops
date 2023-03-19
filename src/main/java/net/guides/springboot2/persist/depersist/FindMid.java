package net.guides.springboot2.persist.depersist;

public class FindMid {
	public static void main(String[] args)
	{
		//int start = Integer.MAX_VALUE, end = Integer.MAX_VALUE;
		int start = 8, end = 20;
		System.out.println("Start ="+start);
		System.out.println("End ="+end);
		int mid1 = (start + end)/2; 
		System.out.println("mid using (start + end)/2 ="+mid1);
		int mid2 = start + (end-start)/2;
		System.out.println("mid using start + (end-start) / 2 ="+mid2);
		int mid3 = (start + 1)/2;
		System.out.println("mid using (start + 1)/2 ="+mid3);
	}
}

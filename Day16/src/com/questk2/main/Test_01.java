package com.questk2.main;

class MyThread extends Thread{
	@Override
	public void run() {
		String name = getName();
		System.out.println(name + "run start");
		
		for (int i=1;i<=20;i++) {
			System.out.println(name +"run:"+i);
		}
		System.out.println(name+"run end");
	}
}

public class Test_01 {
 public static void main(String[] args) {
	System.out.println("main start");
	MyThread thread1= new MyThread();
	MyThread thread2= new MyThread();
	
	System.out.println("thread1:"+thread1.getPriority());
	System.out.println("thread2:"+thread2.getPriority());
	
	thread1.setPriority(4);
	thread2.setPriority(7);
	
	System.out.println("thread1:"+thread1.getPriority());
	System.out.println("thread2:"+thread2.getPriority());
	
	thread1.start();
	thread2.start();
	
	System.out.println("main end");
}
}

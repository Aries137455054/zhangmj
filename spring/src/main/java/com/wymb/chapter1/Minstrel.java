package com.wymb.chapter1;

import java.io.PrintStream;

public class Minstrel {

	private PrintStream printStream;

	public Minstrel(PrintStream printStream) {
		this.printStream = printStream;
	}
	
	public void singBeforeQuest(){
		System.out.println("singBeforeQuest");
		printStream.println("singBeforeQuest");
	}
	
	public void singAfterQuest(){
		System.out.println("singAfterQuest");
		printStream.println("singAfterQuest");
	}
}

package com.wymb.chapter1;

import java.io.PrintStream;

public class SalyDragonQuest implements Quest {

	private PrintStream printStream;
	
	public SalyDragonQuest(PrintStream printStream){
		this.printStream = printStream;
	}
	
	public void embark() {
		System.out.println("Embarking on quest to saly the dargon!");
		printStream.print("Embarking on quest to saly the dargon!");
	}

}

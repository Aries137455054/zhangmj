package com.wymb.chapter2;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {

	private String title = "月半小夜曲";
	private String artist = "李克勤";
	
	public void play() {
		System.out.println("Playing "+title+" by "+artist);
	}

}

package com.wymb.chapter1;

public class DamselRescuingKnight implements Knight {

	private RescueDamselQuest quest;
	
	public DamselRescuingKnight(){
		quest = new RescueDamselQuest();
	}
	
	public void embarkOnQuest() {
		quest.embark();
	}

	
}

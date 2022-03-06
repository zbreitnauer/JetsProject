package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model , int speed , int range , double price) {
		super(model , speed , range , price);
	}
	
	
	@Override
	public void fight() {
		System.err.println("MISSLES LOCKED....FIRING....FOX2....FOX2");
	}
	@Override
	public String toString() {
		return "Fighter" + " Model:"+ getModel() + " Speed:" + getSpeed() + " Range:" + getRange() + " Price:" + getPrice();
				
	}
}

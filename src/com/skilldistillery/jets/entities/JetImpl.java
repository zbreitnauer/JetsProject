package com.skilldistillery.jets.entities;

public class JetImpl extends Jet {

public JetImpl(String model, int speed, int range, double price) {
	super(model,speed,range,price);
}

@Override
public String toString() {
	return "JetImpl" + " Model:"+ getModel() + " Speed:" + getSpeed() + " Range:" + getRange() + " Price:" + getPrice();
			
}

}

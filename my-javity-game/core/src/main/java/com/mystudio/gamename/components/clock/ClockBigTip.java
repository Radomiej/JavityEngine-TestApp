package com.mystudio.gamename.components.clock;

import java.util.Calendar;

import org.javity.engine.JComponent;

public class ClockBigTip extends JComponent{
	private Calendar calendar = Calendar.getInstance();
	private final float degressOnUnit = 360f / 12;
	
	@Override
	public void start() {
	}
	
	@Override
	public void update() {
		calendar.setTimeInMillis(System.currentTimeMillis());
		int hours = calendar.get(Calendar.HOUR);
		hours = hours % 12;
		
		getTransform().setRotation(360 - degressOnUnit * hours);
	}
}

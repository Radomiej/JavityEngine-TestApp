package com.mystudio.gamename.components.clock;

import java.util.Calendar;

import org.javity.engine.JComponent;

public class ClockLittleTip extends JComponent{
	private Calendar calendar = Calendar.getInstance();
	private final float degressOnUnit = 360f / 60;
	
	@Override
	public void start() {
	}
	
	@Override
	public void update() {
		calendar.setTimeInMillis(System.currentTimeMillis());
		int minutes = calendar.get(Calendar.MINUTE);
		
		getTransform().setRotation(360 - degressOnUnit * minutes);
	}
}

package com.mystudio.gamename.components.clock;

import java.util.Calendar;

import org.javity.engine.JComponent;

public class ClockSecondTip extends JComponent{
	private Calendar calendar = Calendar.getInstance();
	private final float degressOnUnit = 6f;
	
	@Override
	public void update() {
		calendar.setTimeInMillis(System.currentTimeMillis());
		int seconds = calendar.get(Calendar.SECOND);
		int milis = calendar.get(Calendar.MILLISECOND);
		float units = seconds + (milis / 1000f);
		
		getTransform().setRotation(360 - degressOnUnit * units);
		
	}
}

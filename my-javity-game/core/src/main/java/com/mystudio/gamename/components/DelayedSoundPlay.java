package com.mystudio.gamename.components;

import org.javity.components.SoundPlayer;
import org.javity.engine.JComponent;
import org.javity.engine.JTime;
import org.javity.engine.timer.Task;

public class DelayedSoundPlay extends JComponent{
	
	private float timeToInvoke =  0;
	
	public DelayedSoundPlay(float timeToInvoke) {
		this.timeToInvoke = timeToInvoke;
	}

	@Override
	public void start() {
		JTime.INSTANCE.addTimer(new Task() {
			@Override
			public void invoke() {
				getGameObject().getComponent(SoundPlayer.class).play();
				System.out.println("Play");
			}
		}, timeToInvoke);
	}
}

package com.mystudio.gamename.components;

import org.javity.components.SpineRenderer;
import org.javity.engine.JComponent;
import org.javity.engine.resources.SpineResource;

public class PlayAnimation extends JComponent {


	private String animation; 
	public PlayAnimation(String animation) {
		this.animation = animation;
	}

	@Override
	public void start() {
		getGameObject().getComponent(SpineRenderer.class).play(animation, true);
	}
}

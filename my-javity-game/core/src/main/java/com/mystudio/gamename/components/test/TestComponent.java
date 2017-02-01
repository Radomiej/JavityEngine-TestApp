package com.mystudio.gamename.components.test;

import org.javity.engine.JComponent;

import com.badlogic.gdx.Gdx;

public class TestComponent extends JComponent {
	protected void isTrue(boolean value){
		if(value == true) return;
		Gdx.app.error(this.getClass().getSimpleName(), "value isn`t true");
		throw new RuntimeException("value isn`t true");
	}
	
	protected void isFalse(boolean value){
		if(value == false) return;
		Gdx.app.error(this.getClass().getSimpleName(), "value isn`t false");
		throw new RuntimeException("value isn`t false");
	}
}

package com.mystudio.gamename.components;

import org.javity.engine.JCamera;
import org.javity.engine.JComponent;
import org.javity.engine.JGUI;
import org.javity.engine.JInput;

import com.badlogic.gdx.math.Vector2;

public class GoToMouseClickComponent extends JComponent{
	
	public float draggedSpeed = 1;
	
	@Override
	public void update() {
//		if(!JInput.isTouch()) return;
		
		Vector2 mousePosition = JInput.getMousePosition();
		mousePosition = JCamera.getMain().screenToWorldPoint(mousePosition);
		getTransform().setPosition(mousePosition);
		
	}
	
	
	
	
}

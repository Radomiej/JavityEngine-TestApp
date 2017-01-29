package com.mystudio.gamename.components;

import org.javity.engine.JCamera;
import org.javity.engine.JComponent;
import org.javity.engine.JGUI;
import org.javity.engine.JInput;

import com.badlogic.gdx.math.Vector2;

public class CameraControllerComponent extends JComponent{
	
	public float draggedSpeed = 1;
	
	@Override
	public void update() {
		if(JInput.isTouch()) onMouseDragged(JInput.getMouseDragged());
	}
	
	@Override
	public void onMouseDragged(Vector2 draggedDelta) {
		if (JGUI.INSTANCE.isStageHandleInput()) {//GUI elements consumed Input Event
			return;
		}
		
		Vector2 position = JCamera.getMain().getPosition();
		position.add(-draggedDelta.x * draggedSpeed, draggedDelta.y * draggedSpeed);
		JCamera.getMain().setPosition(position);
	}
}

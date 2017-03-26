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
		int deltaScroll = JInput.getMouseWheelDelta();
		
		if(deltaScroll < 0){
			System.out.println("delta:" + deltaScroll);
			JCamera.getMain().setZoom(JCamera.getMain().getZoom() / 2);
			draggedSpeed = JCamera.getMain().getZoom();
		}else if(deltaScroll > 0){
			JCamera.getMain().setZoom(JCamera.getMain().getZoom() * 2);
			draggedSpeed = JCamera.getMain().getZoom();
		}
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

package com.mystudio.gamename.components.solar;

import org.javity.engine.JComponent;
import org.javity.engine.JTime;

import com.badlogic.gdx.math.Vector2;

public class PlanetComponent extends JComponent {

	private Vector2 startPoint;
	private float sunRotationSpeed = 1;
	private float planetRotationSpeed = 1;
	private float currentSunRotation;

	public PlanetComponent(Vector2 startPoint, float sunRotationSpeed, float planetRotationSpeed) {
		this.startPoint = startPoint.cpy();
		this.sunRotationSpeed = sunRotationSpeed;
		this.planetRotationSpeed = planetRotationSpeed;
	}
	
	@Override
	public void update() {
		
		currentSunRotation += sunRotationSpeed * JTime.INSTANCE.getDelta();
		Vector2 newPosition = startPoint.cpy().rotate(currentSunRotation);
		getTransform().setLocalPosition(newPosition);
		getTransform().setRotation(getTransform().getRotation() + planetRotationSpeed * JTime.INSTANCE.getDelta());
	}

}

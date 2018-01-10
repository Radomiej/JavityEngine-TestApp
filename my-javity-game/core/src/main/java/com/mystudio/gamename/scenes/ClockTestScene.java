package com.mystudio.gamename.scenes;

import org.javity.components.LineRenderer;
import org.javity.components.SpriteRenderer;
import org.javity.engine.JGameObject;
import org.javity.engine.JScene;
import org.javity.engine.SceneBuilder;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.mystudio.gamename.components.BackComponent;
import com.mystudio.gamename.components.clock.ClockBigTip;
import com.mystudio.gamename.components.clock.ClockLittleTip;
import com.mystudio.gamename.components.clock.ClockSecondTip;

public class ClockTestScene implements SceneBuilder {

	@Override
	public void buildScene(JScene scene) {
		JGameObject back = scene.instantiateGameObject(new Vector2(0, 0));
		back.addComponent(new BackComponent());
		
		JGameObject clock = scene.instantiateGameObject(new Vector2(300, 250));
		clock.addComponent(new SpriteRenderer("clock/clock.png"));
		clock.getTransform().setScale(0.15f, 0.15f);
		
		JGameObject bigTip = scene.instantiateGameObject(new Vector2(0, 0));
		LineRenderer lineBigRenderer = new LineRenderer(new Vector2(), new Vector2(0, 100));
		lineBigRenderer.setWidth(14);
		lineBigRenderer.setColor(Color.GOLD);
		bigTip.addComponent(lineBigRenderer);
		bigTip.getTransform().setParent(clock);
		bigTip.getTransform().setLocalPosition(new Vector2());
		bigTip.addComponent(new ClockBigTip());

		JGameObject littleTip = scene.instantiateGameObject(new Vector2(300, 250));
		LineRenderer lineLittleRenderer = new LineRenderer(new Vector2(), new Vector2(0, 150));
		lineLittleRenderer.setWidth(8);
		lineLittleRenderer.setColor(Color.GREEN);
		littleTip.addComponent(lineLittleRenderer);
		littleTip.getTransform().setParent(clock);
		littleTip.addComponent(new ClockLittleTip());
		
		JGameObject secondTip = scene.instantiateGameObject(new Vector2(300, 250));
		LineRenderer lineSecondRenderer = new LineRenderer(new Vector2(), new Vector2(0, 180));
		lineSecondRenderer.setWidth(4);
		lineSecondRenderer.setColor(Color.FIREBRICK);
		secondTip.addComponent(lineSecondRenderer);
		secondTip.getTransform().setParent(clock);
		secondTip.addComponent(new ClockSecondTip());
	}

}

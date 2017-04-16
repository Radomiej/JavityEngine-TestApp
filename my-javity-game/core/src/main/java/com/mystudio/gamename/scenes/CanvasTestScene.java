package com.mystudio.gamename.scenes;

import org.javity.components.SpriteRenderer;
import org.javity.engine.JGameObject;
import org.javity.engine.JScene;
import org.javity.engine.SceneBulider;

import com.badlogic.gdx.math.Vector2;
import com.mystudio.gamename.components.BackComponent;
import com.mystudio.gamename.components.CameraControllerComponent;
import com.mystudio.gamename.components.canvas.MyTestCanvasDrawer;

import pl.silver.canvas.javity.JavityCanvasComponent;

public class CanvasTestScene implements SceneBulider {

	@Override
	public void buildScene(JScene scene) {
		JGameObject back = scene.instantiateGameObject(new Vector2(0, 0));
		back.addComponent(new BackComponent());
		back.addComponent(new CameraControllerComponent());
		
		JGameObject canvas = scene.instantiateGameObject(new Vector2(0, 0));
		canvas.addComponent(new JavityCanvasComponent());
		canvas.addComponent(new MyTestCanvasDrawer());
		
		JGameObject sun = scene.instantiateGameObject(new Vector2(300, 250));
		sun.addComponent(new SpriteRenderer("planets/sun_shiny.png"));
	}

}

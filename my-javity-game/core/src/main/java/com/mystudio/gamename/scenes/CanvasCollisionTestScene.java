package com.mystudio.gamename.scenes;

import org.javity.components.SpriteRenderer;
import org.javity.engine.JGameObject;
import org.javity.engine.JScene;
import org.javity.engine.SceneBuilder;

import com.badlogic.gdx.math.Vector2;
import com.mystudio.gamename.components.BackComponent;
import com.mystudio.gamename.components.CameraControllerComponent;
import com.mystudio.gamename.components.GoToMouseClickComponent;
import com.mystudio.gamename.components.canvas.CollisionCanvasDrawer;
import com.mystudio.gamename.components.canvas.MyTestCanvasDrawer;
import com.mystudio.gamename.components.canvas.SmallRectangleCanvasDrawer;

import pl.silver.canvas.javity.JavityCanvasComponent;

public class CanvasCollisionTestScene implements SceneBuilder {

	@Override
	public void buildScene(JScene scene) {
		JGameObject back = scene.instantiateGameObject(new Vector2(0, 0));
		back.addComponent(new BackComponent());
		back.addComponent(new CameraControllerComponent());
		
		SmallRectangleCanvasDrawer collisionDrawer = new SmallRectangleCanvasDrawer();
		JGameObject canvas = scene.instantiateGameObject(new Vector2(0, 0));
		canvas.addComponent(new JavityCanvasComponent());
		canvas.addComponent(collisionDrawer);
		
		JGameObject canvas2 = scene.instantiateGameObject(new Vector2(200, 0));
		canvas2.addComponent(new JavityCanvasComponent());
		canvas2.addComponent(new CollisionCanvasDrawer(collisionDrawer));
		canvas2.addComponent(new GoToMouseClickComponent());
		
		
		JGameObject sun = scene.instantiateGameObject(new Vector2(300, 250));
		sun.addComponent(new SpriteRenderer("planets/sun_shiny.png"));
	}

}

package com.mystudio.gamename.scenes;

import org.javity.components.CircleCollider;
import org.javity.components.RectangleCollider;
import org.javity.components.Rigidbody;
import org.javity.components.SpriteRenderer;
import org.javity.engine.JGameObject;
import org.javity.engine.JScene;
import org.javity.engine.SceneBulider;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.mystudio.gamename.components.BackComponent;
import com.mystudio.gamename.components.MyComponent;

public class PhysicTestScene implements SceneBulider {

	@Override
	public void buildScene(JScene scene) {
		JGameObject back = scene.instantiateGameObject(new Vector2(0, 0));
		back.addComponent(new BackComponent());
		
		scene.getSettings().setClearColor(Color.BLACK);
		
		for(int x = 25; x < 400; x += 10){
			JGameObject circle = scene.instantiateGameObject(new Vector2(x, 400));
			circle.addComponent(new SpriteRenderer("pixels/FFFFFF-0.8.png", Color.GRAY));
			circle.addComponent(new Rigidbody(false));
			circle.addComponent(new CircleCollider(4));
			circle.getTransform().setScale(new Vector2(8, 8));
		}
		
		for(int x = 27; x < 400; x += 10){
			JGameObject box = scene.instantiateGameObject(new Vector2(x, 500));
			box.addComponent(new SpriteRenderer("pixels/FFFFFF-0.8.png", Color.BROWN));
			box.addComponent(new Rigidbody(false));
			box.addComponent(new RectangleCollider(8, 8));
			box.getTransform().setScale(new Vector2(8, 8));
		}
		
		JGameObject ground = scene.instantiateGameObject(new Vector2(250, 0));
		ground.addComponent(new SpriteRenderer("pixels/FFFFFF-0.8.png", Color.GREEN));
		ground.addComponent(new Rigidbody(true));
		ground.addComponent(new RectangleCollider(1000000, 10));
		ground.getTransform().setScale(new Vector2(100000, 10f));
		ground.addComponent(new MyComponent());

	}

}

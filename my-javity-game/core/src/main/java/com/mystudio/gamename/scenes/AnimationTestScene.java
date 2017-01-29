package com.mystudio.gamename.scenes;

import org.javity.components.Camera;
import org.javity.components.RectangleCollider;
import org.javity.components.Rigidbody;
import org.javity.components.SpineRenderer;
import org.javity.components.SpriteRenderer;
import org.javity.engine.JGameObject;
import org.javity.engine.Scene;
import org.javity.engine.SceneBulider;

import com.badlogic.gdx.math.Vector2;
import com.mystudio.gamename.components.BackComponent;
import com.mystudio.gamename.components.CameraControllerComponent;
import com.mystudio.gamename.components.PlayAnimation;

public class AnimationTestScene implements SceneBulider {

	@Override
	public void buildScene(Scene scene) {
		JGameObject back = scene.instantiateGameObject(new Vector2(0, 0));
		back.addComponent(new BackComponent());
		back.addComponent(new CameraControllerComponent());

		JGameObject sun = scene.instantiateGameObject(new Vector2(0, 0));
		sun.addComponent(new SpriteRenderer("planets/sun_shiny.png"));
		
		JGameObject man1 = scene.instantiateGameObject(new Vector2(250, 200));
		man1.addComponent(new SpineRenderer("animations/skeleton.json#arrow", new Vector2(100, -120)));
		man1.addComponent(new PlayAnimation("run"));
		man1.getTransform().setScale(0.5f, 0.5f);
		man1.getTransform().setRotation(90);
		
		
		JGameObject man2 = scene.instantiateGameObject(new Vector2(0, 0));
		man2.addComponent(new SpineRenderer("animations/skeleton.json#arrow"));
		man2.addComponent(new PlayAnimation("walk"));

		
	}

}

package com.mystudio.gamename.scenes;

import java.io.IOException;

import org.javity.components.SpriteRenderer;
import org.javity.engine.JGameObject;
import org.javity.engine.JRandom;
import org.javity.engine.Scene;
import org.javity.engine.SceneBulider;
import org.javity.engine.utilities.NameGenerator;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.mystudio.gamename.components.BackComponent;
import com.mystudio.gamename.components.CameraControllerComponent;
import com.mystudio.gamename.components.solar.PlanetComponent;
import com.mystudio.gamename.components.test.OrderMethodsTest;
import com.mystudio.gamename.components.test.SceneBehaviorTest;

/**
 * tiles source: http://opengameart.org/content/20-planet-sprites
 * http://opengameart.org/content/shiny-sun
 * 
 * @author Radomiej
 *
 */
public class CoreTestScene implements SceneBulider {

	@Override
	public void buildScene(Scene scene) {
		scene.getSettings().setClearColor(Color.BLACK);

		JGameObject back = scene.instantiateGameObject(new Vector2(0, 0));
		back.addComponent(new BackComponent());
		back.addComponent(new CameraControllerComponent());

		JGameObject test1 = scene.instantiateGameObject(new Vector2(0, 0));
		test1.addComponent(new OrderMethodsTest());


		JGameObject test2 = scene.instantiateGameObject(new Vector2(0, 0));
		test2.setName(JRandom.INSTANCE.randomName(6));
		System.out.println("name: " + test2.getName());
		test2.setTag("One");
		
		JGameObject test3 = scene.instantiateGameObject(new Vector2(0, 0));
		test3.setName(JRandom.INSTANCE.randomName(6));
		System.out.println("name: " + test3.getName());
		test3.setTag("One");
		
		JGameObject test4 = scene.instantiateGameObject(new Vector2(0, 0));
		test4.setName(JRandom.INSTANCE.randomName(6));
		System.out.println("name: " + test4.getName());
		test4.setTag("Two");
		test4.addComponent(new SceneBehaviorTest());

	}

}

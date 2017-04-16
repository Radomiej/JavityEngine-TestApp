package com.mystudio.gamename.scenes;

import org.javity.components.SpriteRenderer;
import org.javity.engine.JGameObject;
import org.javity.engine.JScene;
import org.javity.engine.SceneBulider;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.mystudio.gamename.components.BackComponent;
import com.mystudio.gamename.components.CameraControllerComponent;
import com.mystudio.gamename.components.solar.PlanetComponent;

/**
 * tiles source: 
 * http://opengameart.org/content/20-planet-sprites
 * http://opengameart.org/content/shiny-sun
 * @author Radomiej
 *
 */
public class SolarTestScene implements SceneBulider {

	@Override
	public void buildScene(JScene scene) {
		scene.getSettings().setClearColor(Color.BLACK);
		
		JGameObject back = scene.instantiateGameObject(new Vector2(0, 0));
		back.addComponent(new BackComponent());
		back.addComponent(new CameraControllerComponent());
		
		
		JGameObject sun = scene.instantiateGameObject(new Vector2(300, 250));
		sun.addComponent(new SpriteRenderer("planets/sun_shiny.png"));
		
		JGameObject singlePlanet = scene.instantiateGameObject(new Vector2());
		singlePlanet.addComponent(new SpriteRenderer("planets/planet14.png"));
		singlePlanet.addComponent(new PlanetComponent(new Vector2(0, 140), 30, 60));
		singlePlanet.getTransform().setParent(sun);
		singlePlanet.getTransform().setLocalPosition(new Vector2(0, 140));
		singlePlanet.getTransform().setLocalScale(0.15f,  0.15f);
		
		JGameObject monPlanet = scene.instantiateGameObject(new Vector2());
		monPlanet.addComponent(new SpriteRenderer("planets/planet15.png"));
		monPlanet.addComponent(new PlanetComponent(new Vector2(70, 200), 10, 40));
		monPlanet.getTransform().setParent(sun);
		monPlanet.getTransform().setLocalPosition(new Vector2(0, 200));
		monPlanet.getTransform().setLocalScale(0.25f,  0.25f);
		
		JGameObject mon = scene.instantiateGameObject(new Vector2());
		mon.addComponent(new SpriteRenderer("planets/planet6.png"));
		mon.addComponent(new PlanetComponent(new Vector2(0, 200), 30, 10));
		mon.getTransform().setParent(monPlanet);
		mon.getTransform().setLocalPosition(new Vector2(0, 200));
		mon.getTransform().setLocalScale(0.5f,  0.5f);
		
		
		JGameObject gasPlanet = scene.instantiateGameObject(new Vector2());
		gasPlanet.addComponent(new SpriteRenderer("planets/planet1.png"));
		gasPlanet.addComponent(new PlanetComponent(new Vector2(0, 580), 3, 30));
		gasPlanet.getTransform().setParent(sun);
		gasPlanet.getTransform().setLocalPosition(new Vector2(0, 580));
		gasPlanet.getTransform().setLocalScale(0.9f,  0.9f);
		
		JGameObject monGas1 = scene.instantiateGameObject(new Vector2());
		monGas1.addComponent(new SpriteRenderer("planets/planet6.png"));
		monGas1.addComponent(new PlanetComponent(new Vector2(0, 180), 60, 10));
		monGas1.getTransform().setParent(gasPlanet);
		monGas1.getTransform().setLocalPosition(new Vector2(0, 180));
		monGas1.getTransform().setLocalScale(0.11f,  0.11f);
		
		JGameObject monGas2 = scene.instantiateGameObject(new Vector2());
		monGas2.addComponent(new SpriteRenderer("planets/planet6.png"));
		monGas2.addComponent(new PlanetComponent(new Vector2(0, -250), 35, 10));
		monGas2.getTransform().setParent(gasPlanet);
		monGas2.getTransform().setLocalPosition(new Vector2(0, -250));
		monGas2.getTransform().setLocalScale(0.1f,  0.1f);
		
		JGameObject monGas3 = scene.instantiateGameObject(new Vector2());
		monGas3.addComponent(new SpriteRenderer("planets/planet6.png"));
		monGas3.addComponent(new PlanetComponent(new Vector2(220, 0), 25, 10));
		monGas3.getTransform().setParent(gasPlanet);
		monGas3.getTransform().setLocalPosition(new Vector2(220, 0));
		monGas3.getTransform().setLocalScale(0.15f,  0.15f);
		
	}

}

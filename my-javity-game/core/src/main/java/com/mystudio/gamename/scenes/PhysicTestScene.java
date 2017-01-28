package com.mystudio.gamename.scenes;

import org.javity.components.Camera;
import org.javity.components.CircleCollider;
import org.javity.components.PolygonCollider;
import org.javity.components.RectangleCollider;
import org.javity.components.Rigidbody;
import org.javity.components.SpineRenderer;
import org.javity.components.SpriteRenderer;
import org.javity.engine.JGameObject;
import org.javity.engine.JPhysic;
import org.javity.engine.Scene;
import org.javity.engine.SceneBulider;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.mystudio.gamename.components.MyComponent;

public class PhysicTestScene implements SceneBulider {

	@Override
	public void buildScene(Scene scene) {
		JPhysic.setDebugRender(true);
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
//		
		JGameObject ground = scene.instantiateGameObject(new Vector2(250, 0));
		ground.addComponent(new SpriteRenderer("pixels/FFFFFF-0.8.png", Color.GREEN));
		ground.addComponent(new Rigidbody(true));
		ground.addComponent(new RectangleCollider(1000000, 10));
		ground.getTransform().setScale(new Vector2(100000, 10f));
		ground.addComponent(new MyComponent());
//
//		JGameObject polygonPhysicObject = scene.instantiateGameObject(new Vector2(200, 280));
//		polygonPhysicObject.addComponent(new SpriteRenderer("atlas/images.atlas#babel"));
//		polygonPhysicObject.addComponent(new Rigidbody());
//		polygonPhysicObject.addComponent(new PolygonCollider(new Vector2(-50, -50), new Vector2(-25, 50),new Vector2(0, 50),new Vector2(25, 0),new Vector2(50, -50), new Vector2(-50, -50)));
////		
//		JGameObject circlePhysicObject = scene.instantiateGameObject(new Vector2(100, 200));
//		circlePhysicObject.addComponent(new SpriteRenderer("atlas/images.atlas#babel"));
//		circlePhysicObject.addComponent(new Rigidbody());
//		circlePhysicObject.addComponent(new CircleCollider());
////		logo.addComponent(new ChangeScene());
////
//		JGameObject rectamgPhysicObject = scene.instantiateGameObject(new Vector2(50, 250));
//		rectamgPhysicObject.addComponent(new SpineRenderer("animations/skeleton.json#arrow"));
//		rectamgPhysicObject.addComponent(new Rigidbody());
//		rectamgPhysicObject.addComponent(new RectangleCollider());
////		logo3.addComponent(new TransformTest());
//		rectamgPhysicObject.addComponent(new Camera());
////
//		JGameObject logo2 = scene.instantiateGameObject(new Vector2(250, 100));
//		logo2.addComponent(new SpriteRenderer("javity.png"));
//		logo2.addComponent(new Rigidbody(true));
//		logo2.addComponent(new RectangleCollider());
//		MyComponent myComponent = new MyComponent();
////		 myComponent.parent = logo;
//		logo2.addComponent(myComponent);
//		logo2.getTransform().setParent(rectamgPhysicObject);
	}

}

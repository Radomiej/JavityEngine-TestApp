package com.mystudio.gamename.components.test;

import java.util.List;

import org.javity.engine.JGameObject;
import org.javity.engine.JSceneManager;

public class SceneBehaviorTest extends TestComponent {
	
	@Override
	public void start() {
		List<JGameObject> ones = JSceneManager.current.findGameObjectsWithTag("One");
		isTrue(ones.size() == 2);
		/**
		 * Names are provided from JRandom singleton and must be always repeatable. This is test for JRandom.
		 */
		isTrue(ones.get(0).getName().equals("Anbulius")); 
		isTrue(ones.get(1).getName().equals("Eubigutin")); 
		
		List<JGameObject> twices = JSceneManager.current.findGameObjectsWithTag("Two");
		isTrue(twices.size() == 1);
		isTrue(twices.get(0) == getGameObject());
		isTrue(twices.get(0).getName().equals("Anes")); 
	}
	
}

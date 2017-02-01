package com.mystudio.gamename.components.test;

import org.javity.engine.JSceneManager;

public class OrderMethodsTest extends TestComponent {
	
	public boolean awake, start, update, lateUpdate, preRender, postRender, preGuiRender, postGuiRender, enableMethod, disabled;
	
	@Override
	public void awake() {
		System.out.println("Awake");
		awake = true;
		
		isFalse(start);
		isFalse(update);
		isFalse(lateUpdate);
		isFalse(preRender);
		isFalse(postRender);
		isFalse(preGuiRender);
		isFalse(postGuiRender);
		isFalse(enableMethod);
		isFalse(disabled);
		isTrue(isEnabled());
		isTrue(getTransform() != null);
		isTrue(getGameObject() != null);
	}
	
	@Override
	public void start() {
		System.out.println("start");
		start = true;
		
		isTrue(awake);
		isTrue(start);
		isFalse(update);
		isFalse(lateUpdate);
		isFalse(preRender);
		isFalse(postRender);
		isFalse(preGuiRender);
		isFalse(postGuiRender);
		isFalse(enableMethod);
		isFalse(disabled);
		isTrue(isEnabled());
		isTrue(getTransform() != null);
		isTrue(getGameObject() != null);
	}
	
	@Override
	public void onEnabled() {
		System.out.println("onEnabled");
		enableMethod = true;
		
		isTrue(awake);
		isTrue(start);
		isFalse(update);
		isFalse(lateUpdate);
		isFalse(preRender);
		isFalse(postRender);
		isFalse(preGuiRender);
		isFalse(postGuiRender);
		isTrue(enableMethod);
		isFalse(disabled);
		isTrue(isEnabled());
		isTrue(getTransform() != null);
		isTrue(getGameObject() != null);
	}

	@Override
	public void update() {
		System.out.println("update");
		update = true;
		
		isTrue(awake);
		isTrue(start);
		isTrue(update);
		isFalse(lateUpdate);
		isFalse(preRender);
		isFalse(postRender);
		isFalse(preGuiRender);
		isFalse(postGuiRender);
		isTrue(enableMethod);
		isFalse(disabled);
		isTrue(isEnabled());
		isTrue(getTransform() != null);
		isTrue(getGameObject() != null);
	}
	
	@Override
	public void lateUpdate() {
		System.out.println("lateUpdate");
		lateUpdate = true;
		
		isTrue(awake);
		isTrue(start);
		isTrue(update);
		isTrue(lateUpdate);
		isFalse(preRender);
		isFalse(postRender);
		isFalse(preGuiRender);
		isFalse(postGuiRender);
		isTrue(enableMethod);
		isFalse(disabled);
		isTrue(isEnabled());
		isTrue(getTransform() != null);
		isTrue(getGameObject() != null);
	}
	
	@Override
	public void preRender() {
		System.out.println("preRender");
		preRender = true;
		
		isTrue(awake);
		isTrue(start);
		isTrue(update);
		isTrue(lateUpdate);
		isTrue(preRender);
		isFalse(postRender);
		isFalse(preGuiRender);
		isFalse(postGuiRender);
		isTrue(enableMethod);
		isFalse(disabled);
		isTrue(isEnabled());
		isTrue(getTransform() != null);
		isTrue(getGameObject() != null);
	}
	
	@Override
	public void postRender() {
		System.out.println("postRender");
		postRender = true;
		
		isTrue(awake);
		isTrue(start);
		isTrue(update);
		isTrue(lateUpdate);
		isTrue(preRender);
		isTrue(postRender);
		isFalse(preGuiRender);
		isFalse(postGuiRender);
		isTrue(enableMethod);
		isFalse(disabled);
		isTrue(isEnabled());
		isTrue(getTransform() != null);
		isTrue(getGameObject() != null);
	}
	
	@Override
	public void preGuiRender() {
		System.out.println("preGuiRender");
		preGuiRender = true;
		
		isTrue(awake);
		isTrue(start);
		isTrue(update);
		isTrue(lateUpdate);
		isTrue(preRender);
		isTrue(postRender);
		isTrue(preGuiRender);
		isFalse(postGuiRender);
		isTrue(enableMethod);
		isFalse(disabled);
		isTrue(isEnabled());
		isTrue(getTransform() != null);
		isTrue(getGameObject() != null);
		
	}
	
	@Override
	public void postGuiRender() {
		System.out.println("postGuiRender");
		postGuiRender = true;
		
		isTrue(awake);
		isTrue(start);
		isTrue(update);
		isTrue(lateUpdate);
		isTrue(preRender);
		isTrue(postRender);
		isTrue(preGuiRender);
		isTrue(postGuiRender);
		isTrue(enableMethod);
		isFalse(disabled);
		isTrue(isEnabled());
		isTrue(getTransform() != null);
		isTrue(getGameObject() != null);
		
		setEnabled(false);
	}
	
	@Override
	public void onDisable() {
		System.out.println("onDisable");
		disabled = true;
		
		isTrue(awake);
		isTrue(start);
		isTrue(update);
		isTrue(lateUpdate);
		isTrue(preRender);
		isTrue(postRender);
		isTrue(preGuiRender);
		isTrue(postGuiRender);
		isTrue(enableMethod);
		isTrue(disabled);
		isFalse(isEnabled());
		isTrue(getTransform() != null);
		isTrue(getGameObject() != null);
		
		JSceneManager.current.destroyGameObject(getGameObject());
	}
	
	@Override
	public void remove() {
		System.out.println("remove");
		
		isTrue(awake);
		isTrue(start);
		isTrue(update);
		isTrue(lateUpdate);
		isTrue(preRender);
		isTrue(postRender);
		isTrue(preGuiRender);
		isTrue(postGuiRender);
		isTrue(enableMethod);
		isTrue(disabled);
		isFalse(isEnabled());
		isTrue(getTransform() != null);
		isTrue(getGameObject() != null);
	}
}

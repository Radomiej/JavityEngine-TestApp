package com.mystudio.gamename.components;

import org.javity.engine.JComponent;
import org.javity.engine.JSceneManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mystudio.gamename.scenes.ScenesChooserScene;

public class BackComponent extends JComponent{
	
	@Override
	public void update() {
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			JSceneManager.loadScene(new ScenesChooserScene());
		}
	}
}

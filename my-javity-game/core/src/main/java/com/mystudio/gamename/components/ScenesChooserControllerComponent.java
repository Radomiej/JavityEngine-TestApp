package com.mystudio.gamename.components;

import org.javity.engine.JCamera;
import org.javity.engine.JComponent;
import org.javity.engine.JSceneManager;
import org.javity.engine.gui.JCanvas;
import org.javity.ui.JXmlUi;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mystudio.gamename.scenes.PhysicTestScene;

public class ScenesChooserControllerComponent extends JComponent {
	private JXmlUi xmlUi;
	
	@Override
	public void start() {
		xmlUi = getGameObject().getComponent(JXmlUi.class);
		xmlUi.getActor("physicTestButton").addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				JSceneManager.loadScene(new PhysicTestScene());
			}
		});
	};
}

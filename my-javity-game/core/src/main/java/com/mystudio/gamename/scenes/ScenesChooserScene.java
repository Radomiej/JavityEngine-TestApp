package com.mystudio.gamename.scenes;

import org.javity.engine.JGameObject;
import org.javity.engine.JScene;
import org.javity.engine.SceneBuilder;
import org.javity.ui.JXmlUi;

import com.badlogic.gdx.math.Vector2;
import com.mystudio.gamename.components.ScenesChooserControllerComponent;

public class ScenesChooserScene implements SceneBuilder {
	@Override
	public void buildScene(JScene scene) {
		JGameObject uIGameObject = scene.instantiateGameObject(new Vector2(0, 0));
		JXmlUi xmlUiComponent = new JXmlUi("views/scene-chooser-view.xml");
		uIGameObject.addComponent(xmlUiComponent);

		ScenesChooserControllerComponent sccc = new ScenesChooserControllerComponent();
		uIGameObject.addComponent(sccc);
	}
}

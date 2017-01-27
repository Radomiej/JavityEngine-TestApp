package com.mystudio.gamename.scenes;

import org.javity.engine.JGameObject;
import org.javity.engine.Scene;
import org.javity.engine.SceneBulider;
import org.javity.ui.JXmlUi;
import org.javity.ui.SkinsManager;

import com.badlogic.gdx.math.Vector2;
import com.mystudio.gamename.components.ScenesChooserControllerComponent;

public class ScenesChooserScene implements SceneBulider {
	@Override
	public void buildScene(Scene scene) {
		JGameObject uIGameObject = scene.instantiateGameObject(new Vector2(0, 0));
		JXmlUi xmlUiComponent = new JXmlUi("views/scene-chooser-view.xml");
		uIGameObject.addComponent(xmlUiComponent);

		ScenesChooserControllerComponent sccc = new ScenesChooserControllerComponent();
		uIGameObject.addComponent(sccc);
	}
}

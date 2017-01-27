package com.mystudio.gamename.scenes;

import org.javity.engine.JGameObject;
import org.javity.engine.Scene;
import org.javity.engine.SceneBulider;
import org.javity.ui.JXmlUi;
import org.javity.ui.SkinsManager;

import com.badlogic.gdx.math.Vector2;

public class MyJavityGameScene implements SceneBulider {
	@Override
	public void buildScene(Scene scene) {
//		SmartFontGenerator.prepareForCurrentDisplay(SkinsManager.INSTANCE.getDefaultSkin());
		JGameObject canvas = scene.instantiateGameObject(new Vector2(0, 0));
//		JXmlUi jCanvas = new JXmlUi("views/test-view.xml", "gdx-skins-master/cloud-form/skin/cloud-form-ui.json");
		JXmlUi jCanvas = new JXmlUi("views/test-view.xml");
		canvas.addComponent(jCanvas);

	}
}

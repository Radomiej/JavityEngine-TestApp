package com.mystudio.gamename.desktop;

import org.javity.engine.ext.JavityApplication;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mystudio.gamename.scenes.ScenesChooserScene;

import pl.radomiej.citizen.CitizenCrawderScene;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		config.samples = 8;
//		new LwjglApplication(new JavityApplication(new ScenesChooserScene()), config);
//		new LwjglApplication(new SilverGdxCanvasApp(), config);
		new LwjglApplication(new JavityApplication(new CitizenCrawderScene()), config);
		
		
	}
}

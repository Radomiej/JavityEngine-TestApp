package com.mystudio.gamename.desktop;

import org.javity.engine.ext.JavityApplication;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mystudio.gamename.scenes.MyJavityGameScene;
import com.mystudio.gamename.scenes.ScenesChooserScene;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new JavityApplication(new ScenesChooserScene()), config);
	}
}

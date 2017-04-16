package com.mystudio.gamename.components;

import org.javity.engine.JCamera;
import org.javity.engine.JComponent;
import org.javity.engine.JSceneManager;
import org.javity.engine.gui.JCanvas;
import org.javity.ui.JXmlUi;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mystudio.gamename.scenes.CanvasTestScene;
import com.mystudio.gamename.scenes.ClockTestScene;
import com.mystudio.gamename.scenes.CoreTestScene;
import com.mystudio.gamename.scenes.MapCanvasTestScene;
import com.mystudio.gamename.scenes.MusicTestScene;
import com.mystudio.gamename.scenes.PhysicTestScene;
import com.mystudio.gamename.scenes.SolarTestScene;

import pl.radomiej.map.demo.MapScene;

public class ScenesChooserControllerComponent extends JComponent {
	private JXmlUi xmlUi;
	
	@Override
	public void start() {
		xmlUi = getGameObject().getComponent(JXmlUi.class);
		
		xmlUi.getActor("coreTestButton").addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				JSceneManager.loadScene(new CoreTestScene());
			}
		});
		xmlUi.getActor("physicTestButton").addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				JSceneManager.loadScene(new PhysicTestScene());
			}
		});
		xmlUi.getActor("musicTestButton").addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				JSceneManager.loadScene(new MusicTestScene());
			}
		});
		xmlUi.getActor("mapTestButton").addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				JSceneManager.loadScene(new MapScene());
			}
		});
		xmlUi.getActor("clockTestButton").addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				JSceneManager.loadScene(new ClockTestScene());
			}
		});
		xmlUi.getActor("solarTestButton").addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				JSceneManager.loadScene(new SolarTestScene());
			}
		});
		xmlUi.getActor("canvasTestButton").addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				JSceneManager.loadScene(new CanvasTestScene());
			}
		});
		xmlUi.getActor("mapCanvasTestButton").addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				JSceneManager.loadScene(new MapCanvasTestScene());
			}
		});
	};
}

package com.mystudio.gamename.scenes;

import org.javity.components.SoundPlayer;
import org.javity.engine.JGameObject;
import org.javity.engine.JScene;
import org.javity.engine.SceneBuilder;

import com.badlogic.gdx.math.Vector2;
import com.mystudio.gamename.components.BackComponent;
import com.mystudio.gamename.components.DelayedSoundPlay;
import com.mystudio.gamename.components.DelayedSoundStop;

public class MusicTestScene implements SceneBuilder {

	@Override
	public void buildScene(JScene scene) {
		JGameObject back = scene.instantiateGameObject(new Vector2(0, 0));
		back.addComponent(new BackComponent());
		
		
		//source: http://soundimage.org/fantasywonder/
		JGameObject music = scene.instantiateGameObject(new Vector2(0, 0));
		music.addComponent(new SoundPlayer("music/Fantasy_Game_Background.mp3", true).setLooping(true));
		music.addComponent(new DelayedSoundPlay(5));

		//source: http://soundimage.org/sfx-scifi/
		JGameObject sound = scene.instantiateGameObject(new Vector2(0, 0));
		sound.addComponent(new SoundPlayer("music/Space-Cannon.mp3", false).setLooping(true));
		sound.addComponent(new DelayedSoundPlay(0));
		sound.addComponent(new DelayedSoundStop(4.5f));
		
	}

}

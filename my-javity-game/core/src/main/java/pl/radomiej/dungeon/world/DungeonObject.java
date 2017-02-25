package pl.radomiej.dungeon.world;

import com.badlogic.gdx.math.Vector2;

public class DungeonObject {

	private final Vector2 position;
	
	public DungeonObject(Vector2 position) {
		this.position = position.cpy();
	}
	
	public Vector2 setPosition(Vector2 position) {
		return position.set(position);
	}
	
	public Vector2 getPosition() {
		return position.cpy();
	}

}

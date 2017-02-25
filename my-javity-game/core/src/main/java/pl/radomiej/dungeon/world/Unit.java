package pl.radomiej.dungeon.world;

import java.util.List;

import com.badlogic.gdx.math.Vector2;

public class Unit extends DungeonObject {
	private DungeonWorld world;
	private List<Vector2> path;
	private Room currentRoom;

	public Unit(Vector2 position, DungeonWorld world) {
		super(position);
		this.world = world;
		currentRoom = world.getCurrentRoom(this);
	}

	public void goTo(Room targetRoom) {
		path = world.getPath(currentRoom, targetRoom);
	}

	public DungeonWorld getWorld() {
		return world;
	}

	public void setWorld(DungeonWorld world) {
		this.world = world;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public List<Vector2> getPath() {
		return path;
	}

	public void setPath(List<Vector2> path) {
		this.path = path;
	}

}

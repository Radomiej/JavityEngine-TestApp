package pl.radomiej.citizen.world;

import java.util.List;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MovableGraphElement extends GraphElement {
	private GraphWorld world;
	private List<Vector2> path;
	private GraphNode currentRoom;

	public MovableGraphElement(Vector2 position, GraphWorld world) {
		super(position, new Vector2(64, 64));
		this.world = world;
		currentRoom = world.getCurrentRoom(this);
	}
	
	public MovableGraphElement(Vector2 position, Vector2 size, GraphWorld world) {
		super(position, size);
		this.world = world;
		currentRoom = world.getCurrentRoom(this);
	}

	public void goTo(GraphNode targetRoom) {
		path = world.getPath(currentRoom, targetRoom);
	}

	public GraphWorld getWorld() {
		return world;
	}

	public void setWorld(GraphWorld world) {
		this.world = world;
	}

	public GraphNode getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(GraphNode currentRoom) {
		this.currentRoom = currentRoom;
	}

	public List<Vector2> getPath() {
		return path;
	}

	public void setPath(List<Vector2> path) {
		this.path = path;
	}

}

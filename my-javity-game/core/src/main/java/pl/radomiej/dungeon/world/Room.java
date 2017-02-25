package pl.radomiej.dungeon.world;

import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.math.Vector2;

import pl.radomiej.dungeon.world.ai.FlatTiledNode;

public class Room extends DungeonObject {

	private Set<RoomConnection> connections = new HashSet<RoomConnection>();
	private FlatTiledNode node;

	public Room(Vector2 position) {
		super(position);
	}

	public Set<RoomConnection> getConnections() {
		return connections;
	}

	public void setConnections(Set<RoomConnection> connections) {
		this.connections = connections;
	}

	public FlatTiledNode getNode() {
		return node;
	}

	public void setNode(FlatTiledNode node) {
		this.node = node;
	}

}

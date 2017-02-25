package pl.radomiej.dungeon.world;

import pl.radomiej.dungeon.world.ai.FlatTiledConnection;

public class RoomConnection {
	public final Room roomA, roomB;

	private FlatTiledConnection connection;
	
	public RoomConnection(Room roomA, Room roomB) {
		super();
		this.roomA = roomA;
		this.roomB = roomB;
		roomA.getConnections().add(this);
		roomB.getConnections().add(this);
	}

	public FlatTiledConnection getConnection() {
		return connection;
	}

	public void setConnection(FlatTiledConnection connection) {
		this.connection = connection;
	}
}

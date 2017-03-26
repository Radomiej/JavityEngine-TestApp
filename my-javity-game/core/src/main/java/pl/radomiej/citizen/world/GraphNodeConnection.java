package pl.radomiej.citizen.world;

import pl.radomiej.citizen.world.ai.FlatTiledConnection;

public class GraphNodeConnection {
	public final GraphNode roomA, roomB;

	private FlatTiledConnection connection;
	
	public GraphNodeConnection(GraphNode roomA, GraphNode roomB) {
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

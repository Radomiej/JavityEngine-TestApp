package pl.radomiej.dungeon.world.ai;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.utils.Array;

import pl.radomiej.dungeon.world.Room;
import pl.radomiej.dungeon.world.RoomConnection;

/**
 * A random generated graph representing a flat tiled map.
 * 
 * @author davebaol
 */
public class FlatTiledGraph implements TiledGraph<FlatTiledNode> {
	protected Array<FlatTiledNode> nodes;
	private Map<FlatTiledNode, Integer> nodeToIndexMap = new HashMap<FlatTiledNode, Integer>();
	
	public boolean diagonal;
	public FlatTiledNode startNode;

	public FlatTiledGraph() {
		this.nodes = new Array<FlatTiledNode>(256);
		this.diagonal = false;
		this.startNode = null;
	}

	public void init(List<Room> rooms, List<RoomConnection> roomConnections) {
		System.out.println("init rooms: " + rooms.size() + " connections: " + roomConnections.size());
		nodes.setSize(rooms.size());
		for (Room room : rooms) {
			FlatTiledNode n = new FlatTiledNode(room.getPosition().x, room.getPosition().y, 1,
					room.getConnections().size());
			nodes.add(n);
			nodeToIndexMap.put(n, n.getIndex());
			room.setNode(n);		
		}
		
		for (Room room : rooms) {
			for (RoomConnection connection : room.getConnections()) {
				FlatTiledNode target = connection.roomA == room ? connection.roomB.getNode() : connection.roomA.getNode();
				addConnection(room.getNode(), target);
				System.out.println("add Connection source: " + room.getNode() + " target: " + target);
			}
		}
	}

	@Override
	public int getNodeCount() {
		return nodes.size;
	}

	@Override
	public Array<Connection<FlatTiledNode>> getConnections(FlatTiledNode fromNode) {
		return fromNode.getConnections();
	}

	private void addConnection(FlatTiledNode source, FlatTiledNode target) {
		source.getConnections().add(new FlatTiledConnection(this, source, target));
	}

	@Override
	public int getIndex(FlatTiledNode node) {
		return nodeToIndexMap.get(node);
	}
	
	


}

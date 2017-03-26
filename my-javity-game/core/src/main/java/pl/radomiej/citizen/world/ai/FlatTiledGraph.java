package pl.radomiej.citizen.world.ai;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.utils.Array;

import pl.radomiej.citizen.world.GraphNode;
import pl.radomiej.citizen.world.GraphNodeConnection;

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

	public void init(List<GraphNode> rooms, List<GraphNodeConnection> roomConnections) {
		System.out.println("init rooms: " + rooms.size() + " connections: " + roomConnections.size());
		nodes.setSize(rooms.size());
		for (GraphNode room : rooms) {
			FlatTiledNode n = new FlatTiledNode(room.getPosition().x, room.getPosition().y, 1,
					room.getConnections().size());
			nodes.add(n);
			nodeToIndexMap.put(n, n.getIndex());
			room.setNode(n);		
		}
		
		for (GraphNode room : rooms) {
			for (GraphNodeConnection connection : room.getConnections()) {
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

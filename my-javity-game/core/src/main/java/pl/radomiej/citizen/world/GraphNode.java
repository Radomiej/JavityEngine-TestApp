package pl.radomiej.citizen.world;

import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.math.Vector2;

import pl.radomiej.citizen.world.ai.FlatTiledNode;

public class GraphNode extends GraphElement {

	private Set<GraphNodeConnection> connections = new HashSet<GraphNodeConnection>();
	private FlatTiledNode node;

	
	public GraphNode(Vector2 position) {
		this(position, new Vector2(64, 64));
	}
	
	public GraphNode(Vector2 position, Vector2 size) {
		super(position, size);
	}

	public Set<GraphNodeConnection> getConnections() {
		return connections;
	}

	public void setConnections(Set<GraphNodeConnection> connections) {
		this.connections = connections;
	}

	public FlatTiledNode getNode() {
		return node;
	}

	public void setNode(FlatTiledNode node) {
		this.node = node;
	}

}

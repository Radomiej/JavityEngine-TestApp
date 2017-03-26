package pl.radomiej.citizen.world.ai;

import java.util.List;

import com.badlogic.gdx.ai.pfa.indexed.IndexedGraph;

import pl.radomiej.citizen.world.GraphNode;
import pl.radomiej.citizen.world.GraphNodeConnection;

public interface TiledGraph<N extends TiledNode<N>> extends IndexedGraph<N> {

	public void init(List<GraphNode> rooms, List<GraphNodeConnection> roomConnections);

}

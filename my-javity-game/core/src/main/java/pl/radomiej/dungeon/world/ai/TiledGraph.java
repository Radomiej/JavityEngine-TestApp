package pl.radomiej.dungeon.world.ai;

import java.util.List;

import com.badlogic.gdx.ai.pfa.indexed.IndexedGraph;

import pl.radomiej.dungeon.world.Room;
import pl.radomiej.dungeon.world.RoomConnection;

public interface TiledGraph<N extends TiledNode<N>> extends IndexedGraph<N> {

	public void init(List<Room> rooms, List<RoomConnection> roomConnections);

}

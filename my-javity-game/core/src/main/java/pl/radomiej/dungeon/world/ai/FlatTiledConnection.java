package pl.radomiej.dungeon.world.ai;

import com.badlogic.gdx.ai.pfa.DefaultConnection;
import com.badlogic.gdx.math.Vector2;

/** A connection for a {@link FlatTiledGraph}.
 * 
 * @author davebaol */
public class FlatTiledConnection extends DefaultConnection<FlatTiledNode> {

	FlatTiledGraph worldMap;

	public FlatTiledConnection (FlatTiledGraph worldMap, FlatTiledNode fromNode, FlatTiledNode toNode) {
		super(fromNode, toNode);
		this.worldMap = worldMap;
	}

	@Override
	public float getCost () {
		return Vector2.dst(fromNode.x, fromNode.y, toNode.x, toNode.y);
	}
}
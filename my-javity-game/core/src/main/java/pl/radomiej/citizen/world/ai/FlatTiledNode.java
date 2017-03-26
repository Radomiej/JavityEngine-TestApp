package pl.radomiej.citizen.world.ai;

import java.util.concurrent.atomic.AtomicInteger;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.utils.Array;

public class FlatTiledNode extends TiledNode<FlatTiledNode> {

	private static AtomicInteger indexGenerator = new AtomicInteger(0);

	private final int index = indexGenerator.getAndIncrement();

	public FlatTiledNode(float x, float y, int type, int connectionCapacity) {
		super(x, y, type, new Array<Connection<FlatTiledNode>>(connectionCapacity));
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public String toString() {
		return "FlatTiledNode [index=" + index + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlatTiledNode other = (FlatTiledNode) obj;
		if (index != other.index)
			return false;
		return true;
	}

}
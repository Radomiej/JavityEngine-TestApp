package pl.radomiej.citizen.components;

import java.util.List;

import org.javity.engine.JComponent;
import org.javity.engine.utilities.MoveOnPathAlgorithms;

import com.badlogic.gdx.math.Vector2;

import pl.radomiej.citizen.world.MovableGraphElement;

public class MovableElementComponent extends JComponent {

	private final MovableGraphElement unit;
	private MoveOnPathAlgorithms moveOnPathAlgorithms;

	public MovableElementComponent(MovableGraphElement unit) {
		this.unit = unit;
	}

	@Override
	public void start() {
		if(unit.getPath() != null) moveOnPathAlgorithms = new MoveOnPathAlgorithms(unit.getPath());
	}

	@Override
	public void update() {
		if(unit.getPath() == null) return;
		
		Vector2 nextPosition = moveOnPathAlgorithms.getNextPosition();
		unit.setPosition(nextPosition);
		getTransform().setPosition(nextPosition);
	}
}

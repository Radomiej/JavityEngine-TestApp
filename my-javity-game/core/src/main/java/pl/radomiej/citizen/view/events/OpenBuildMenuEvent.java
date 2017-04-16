package pl.radomiej.citizen.view.events;

import galaxy.rapid.event.RapidEvent;
import pl.radomiej.citizen.components.GameField;

public class OpenBuildMenuEvent implements RapidEvent {
	public final GameField gameField;

	public OpenBuildMenuEvent(GameField gameField) {
		this.gameField = gameField;
	}
	
	
}

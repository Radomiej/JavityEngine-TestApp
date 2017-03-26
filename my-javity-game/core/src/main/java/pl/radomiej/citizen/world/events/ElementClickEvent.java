package pl.radomiej.citizen.world.events;

import galaxy.rapid.event.RapidEvent;
import pl.radomiej.citizen.world.GraphElement;
import pl.radomiej.citizen.world.MovableGraphElement;

public class ElementClickEvent implements RapidEvent {
	public final GraphElement element;
	public final int clickCount;

	public ElementClickEvent(GraphElement element, int clickedCount) {
		this.clickCount = clickedCount;
		this.element = element;
	}

}

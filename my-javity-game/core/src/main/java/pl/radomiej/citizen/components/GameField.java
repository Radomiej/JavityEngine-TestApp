package pl.radomiej.citizen.components;

import org.javity.engine.JComponent;

import pl.radomiej.citizen.world.GraphNode;

public class GameField extends JComponent {

	private int population;
	private GraphNode room;

	public GameField(GraphNode room) {
		this.room = room;
	}

	public String getName(){
		return room.getName();
	}
	
	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

}

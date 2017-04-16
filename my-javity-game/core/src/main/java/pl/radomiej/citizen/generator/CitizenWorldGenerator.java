package pl.radomiej.citizen.generator;

import com.badlogic.gdx.math.Vector2;

import pl.radomiej.citizen.world.GraphNode;
import pl.radomiej.citizen.world.GraphNodeConnection;
import pl.radomiej.citizen.world.GraphWorld;
import pl.radomiej.citizen.world.MovableGraphElement;

public class CitizenWorldGenerator {

	public GraphWorld generate() {
		GraphWorld world = new GraphWorld();
		generateStartRooms(world);
		return world;
	}

	private void generateStartRooms(GraphWorld world) {
		//Create rooms
		GraphNode city0Room = new GraphNode(new Vector2(250, 250));
		city0Room.setName("Roma");
		world.getNodes().add(city0Room);
		
		GraphNode city1Room = new GraphNode(new Vector2(500, 320));
		city1Room.setName("Mediolano");
		world.getNodes().add(city1Room);
		
		GraphNode city2Room = new GraphNode(new Vector2(200, 480));
		city2Room.setName("Kappua");
		world.getNodes().add(city2Room);
		
		GraphNode city3Room = new GraphNode(new Vector2(280, 780));
		city3Room.setName("Sapporo");
		world.getNodes().add(city3Room);
		
		//Create connections
		GraphNodeConnection roomConnection = new GraphNodeConnection(city0Room, city1Room); 
		world.getRoomConnections().add(roomConnection);
		
		GraphNodeConnection roomConnection2 = new GraphNodeConnection(city0Room, city2Room); 
		world.getRoomConnections().add(roomConnection2);
		
		GraphNodeConnection roomConnection3 = new GraphNodeConnection(city2Room, city3Room); 
		world.getRoomConnections().add(roomConnection3);
		
		//Prepare AI
		world.generateAi();		
	}

}

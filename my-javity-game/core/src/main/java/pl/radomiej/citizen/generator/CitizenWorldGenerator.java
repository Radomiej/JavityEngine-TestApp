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
		GraphNode startRoom = new GraphNode(new Vector2(250, 250));
		world.getNodes().add(startRoom);
		
		GraphNode minerRoom = new GraphNode(new Vector2(500, 320));
		world.getNodes().add(minerRoom);
		
		GraphNode barrackRoom = new GraphNode(new Vector2(200, 480));
		world.getNodes().add(barrackRoom);
		
		GraphNode banditRoom = new GraphNode(new Vector2(280, 780));
		world.getNodes().add(banditRoom);
		
		//Create connections
		GraphNodeConnection roomConnection = new GraphNodeConnection(startRoom, minerRoom); 
		world.getRoomConnections().add(roomConnection);
		
		GraphNodeConnection roomConnection2 = new GraphNodeConnection(startRoom, barrackRoom); 
		world.getRoomConnections().add(roomConnection2);
		
		GraphNodeConnection roomConnection3 = new GraphNodeConnection(barrackRoom, banditRoom); 
		world.getRoomConnections().add(roomConnection3);
		
		//Prepare AI
		world.generateAi();		
	}

}
